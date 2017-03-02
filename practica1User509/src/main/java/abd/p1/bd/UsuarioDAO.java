package abd.p1.bd;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import abd.p1.model.Genero;
import abd.p1.model.Usuario;

public class UsuarioDAO {
	private SessionFactory sf;
	
	public UsuarioDAO (SessionFactory sf){
		this.sf = sf;
	}
	
	public boolean emailUsado(String email){
		Session s = null;
		try{
			s = sf.openSession();
			Usuario u = s.get(Usuario.class, email);
			if (u != null)
				return true;
			else
				return false;
			//el usuario existes
		} catch (Exception e){
			return false;
		} finally {
			s.close();
		}
	}
	
	public Usuario loguear(String email, String pass){
		Session s = null;
		try{
			s = sf.openSession();
			Usuario u = (Usuario) s.get(Usuario.class, email);
			if (u.getPassword().equals(pass))
				return u;
			else
				return null;
		} catch (Exception e){
			return null;
		} finally {
			s.close();
		}
	}
	
	public Usuario saveUser(Usuario u){
		Session s = null;
		try{
			s = sf.openSession();
			Transaction tr = s.beginTransaction();
			Usuario busqueda = (Usuario) s.get(Usuario.class, u.getEmail());
			if (busqueda != null)
				u = (Usuario) s.merge(u);
			else
				s.save(u);
			tr.commit();
		} catch (HibernateException e){
			System.out.println("ERROR!");
		} finally {
			s.close();
		}
		return u;
	}
	
	
	public List<Usuario> getAllUsers(String email) {
		Session s = null;
		List <Usuario> listaUsuarios = null;
		try{
			s = sf.openSession();
			String sql = "SELECT u FROM Usuario AS u WHERE u.email <> '" + email + "'";
			Query query = s.createQuery(sql);
			listaUsuarios = query.list();
			return listaUsuarios;
		}
		catch(Exception e){
			return null;
		}
		finally {
			s.close();
		}
	}

	public Usuario recuperarUsuario(String email) {
		Session s = null;
		try{
			s = sf.openSession();
			Usuario u = s.get(Usuario.class, email);
			return u;
			//el usuario existe
		} catch (Exception e){
			return null;
		} finally {
			s.close();
		}
	}

	public List<Usuario> searchByName(String nombre, String email, Genero generoAmigo) {
		Session s = null;
		List <Usuario> listaUsuarios = null;
		try{
			s = sf.openSession();
			String sql = "";
			if(generoAmigo == Genero.AMBOS){
					sql = "SELECT u FROM Usuario AS u "
					+ "WHERE u.nombre LIKE '%" + nombre + "%' "
					+ "AND u.email <> '" + email + "'";
			}
			else{
				sql = "SELECT u FROM Usuario AS u "
						+ "WHERE u.nombre LIKE '%" + nombre + "%' "
						+ "AND u.email <> '" + email + "'"
						+ "AND u.genero = '" + generoAmigo + "'" ;
			}
				
			Query query = s.createQuery(sql);
			listaUsuarios = query.list();
			return listaUsuarios;
		}
		catch(Exception e){
			return null;
		}
		finally {
			s.close();
		}
		
	}
}
