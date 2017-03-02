package abd.p1.controller;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListModel;

import abd.p1.bd.UsuarioDAO;
import abd.p1.model.Genero;
import abd.p1.model.Usuario;
import abd.p1.view.*;
public class Controlador {
	
	private UsuarioDAO udao;
	private Usuario u;
	
	public Controlador(UsuarioDAO udao, Usuario u){
		this.udao = udao;
		this.u = u;
	}

	public Usuario getU() {
		return u;
	}

	public void setU(Usuario u) {
		this.u = u;
	}

	public boolean existeUsuario (String email){ 
		if (udao.emailUsado(email))
			//Si existe ese usuario
			return true;
		else
			//no existe ese usuario
			return false;
	}
	
	public boolean loguear(String correo, String pass) {
		Usuario u = udao.loguear(correo, pass);
		if (u != null){
			this.setU(u);
			this.getU().setEmail(correo);
			this.getU().setPassword(pass);
			new DialogPrincipal(null, true, this);
			return true;
		}
		else{
			JOptionPane.showMessageDialog(new JPanel(), "Usuario incorrecto", "ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

	public void nuevoUsuario(String email, String pass) {
		this.u = new Usuario();
		this.u.setEmail(email);
		this.u.setPassword(pass);
		new DialogMyProfile(null, true, this);
	}
	
	public void guardarCambios(Usuario u){
		this.setU(u);
		this.u = udao.saveUser(this.u);
	}

	public DefaultListModel<Usuario> cargarListaUsuarios() {
		List <Usuario> lista = this.udao.getAllUsers(this.getU().getEmail());
		DefaultListModel<Usuario> model = new DefaultListModel<Usuario>();
		if (lista != null)
			for (Usuario u : lista){
				model.addElement(u);
			}
		return model;
	}

	public Usuario recuperarUsuario(String email) {
		return udao.recuperarUsuario(email);
	}

	public DefaultListModel<Usuario> searchByName(String s, String email, Genero generoAmigo) {
		List <Usuario> lista = this.udao.searchByName(s, email, generoAmigo);
		DefaultListModel model = new DefaultListModel();
		if (lista != null)
			for (Usuario u : lista){
				model.addElement(u);
			}
		return model;
		
	}

}
