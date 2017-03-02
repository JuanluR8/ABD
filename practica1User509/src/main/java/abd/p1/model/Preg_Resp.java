package abd.p1.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Preg_Resp implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	private Pregunta p;
	
	@Id
	@ManyToOne
	private Opcion o;
	
	@Id
	@ManyToOne
	private Usuario u;
	
	@Column (length = 2)
	private Integer relevancia;
	
	
	public Preg_Resp(){
		
	}

	public Usuario getUsuario() {
		return u;
	}

	public void setUsuario(Usuario email) {
		this.u = email;
	}
	
	public Pregunta getP() {
		return p;
	}

	public void setP(Pregunta p) {
		this.p = p;
	}

	public Opcion getO() {
		return o;
	}

	public void setO(Opcion o) {
		this.o = o;
	}

	public Integer getRelevancia() {
		return relevancia;
	}

	public void setRelevancia(Integer relevancia) {
		this.relevancia = relevancia;
	}

	
	@Override
	public String toString() {
		return "Preg_Resp [id_preg=" + p + ", id_resp=" + o + "]";
	}
}
