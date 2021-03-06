package abd.p1.model;
import javax.persistence.*;

@Entity
public class Opcion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne 
	private Pregunta preguntaMadre;
	
	private int numeroOrden;

	private String texto;
	
	public Opcion() {
		
	}

	public Pregunta getPreguntaMadre() {
		return preguntaMadre;
	}

	public void setPreguntaMadre(Pregunta preguntaMadre) {
		this.preguntaMadre = preguntaMadre;
	}

	public int getNumeroOrden() {
		return numeroOrden;
	}

	public void setNumeroOrden(int numeroOrden) {
		this.numeroOrden = numeroOrden;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public int getId (){
		return this.id;
	}
	
	public void setId (int id){
		this.id = id;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "(" + numeroOrden + ") " + texto;
	}
}
