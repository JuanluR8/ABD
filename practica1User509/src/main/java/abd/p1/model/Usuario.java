package abd.p1.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Usuario {
	@Id
	@Column (length = 50)
	private String email;
	
	@Column (length = 50)
	private String nombre;
	
	@Column (length = 20, nullable = false)
	private String password;
	
	@Temporal (TemporalType.DATE)
	private Date f_nacimiento;
	
	@Lob
	private byte[] avatar;
	
	@Column (length = 500)
	private String descripcion;
//	private float latitud;
//	private float longitud;
	
	@Enumerated(EnumType.STRING)
	@Column
	private Genero genero;

	@Enumerated(EnumType.STRING)
	@Column 
	private Genero generoAmigo;
	
	@Transient
	@OneToMany (mappedBy = "Mensaje")
	private List <Mensaje> mensajes;
	
	@ElementCollection
	@ManyToMany 
	private List <Usuario> listaAmigos;
	
	@ElementCollection (fetch = FetchType.EAGER)
	private List<String> aficiones;
	
	public Usuario (){
		
	}
	
	public Usuario(String nombre, String email, String password,
			Date f_nacimiento, byte[] avatar, String descripcion, /*float latitud,
			float longitud,*/ Genero genero, Genero generoAmigo) {
		
		this.nombre = nombre;
		this.email = email;
		this.password = password;
		this.f_nacimiento = f_nacimiento;
		this.avatar = avatar;
		this.descripcion = descripcion;
//		this.latitud = latitud;
//		this.longitud = longitud;
		this.genero = genero;
		this.generoAmigo = generoAmigo;
		this.aficiones = new ArrayList<String> ();
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Date getF_nacimiento() {
		return f_nacimiento;
	}


	public void setF_nacimiento(Date f_nacimiento) {
		this.f_nacimiento = f_nacimiento;
	}


	public byte[] getAvatar() {
		return avatar;
	}


	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


//	public float getLatitud() {
//		return latitud;
//	}
//
//
//	public void setLatitud(float latitud) {
//		this.latitud = latitud;
//	}
//
//
//	public float getLongitud() {
//		return longitud;
//	}
//
//
//	public void setLongitud(float longitud) {
//		this.longitud = longitud;
//	}

	public Genero getGenero() {
		return this.genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Genero getGeneroAmigo() {
		return generoAmigo;
	}

	public void setGeneroAmigo(Genero generoAmigo) {
		this.generoAmigo = generoAmigo;
	}
	
	public List<String> getAficiones() {
		return aficiones;
	}

	public void setAficiones(List<String> aficiones) {
		this.aficiones = aficiones;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", email=" + email + ", password="
				+ password + ", f_nacimiento=" + f_nacimiento + ", avatar="
				+ avatar + ", descripcion=" + descripcion + ", genero=" + genero
				+ ", generoAmigo=" + generoAmigo + "]";
	}
	
}
