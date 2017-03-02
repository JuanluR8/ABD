package abd.p1.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)
public class Mensaje {
	@Id
	//@GeneratedValue(strategy = GenerationType.TABLE)
	private Integer id_msj;
	
	@ManyToOne
	private Usuario emisor;
	
	@ManyToOne
	private Usuario receptor;
	 
	private boolean leido;
	
	@Temporal (TemporalType.DATE)
	private Date fecha;

	public Mensaje (){
		this.leido = false;
		//this.fecha = fecha.getDate();
	}
	
	public Integer getId_msj() {
		return id_msj;
	}

	public void setId_msj(Integer id_msj) {
		this.id_msj = id_msj;
	}
	public boolean isLeido() {
		return leido;
	}
	public void setLeido(boolean leido) {
		this.leido = leido;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Mensaje [id_msj=" + id_msj + ", email_emisor=" + emisor
				+ ", email_receptor=" + receptor + ", leido=" + leido
				+ ", fecha=" + fecha + "]";
	}

}
