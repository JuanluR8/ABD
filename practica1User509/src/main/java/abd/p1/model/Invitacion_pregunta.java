package abd.p1.model;
import javax.persistence.*;

@Entity
public class Invitacion_pregunta extends Mensaje {
	//@Id
	@OneToOne //(mappedBy = "id")
	private Pregunta p;
	
	public Invitacion_pregunta(){
		
	}
	
	public Pregunta getP() {
		return p;
	}

	public void setP(Pregunta p) {
		this.p = p;
	}



	@Override
	public String toString() {
		return "Invitacion_pregunta [id_preg=" + p + "]";
	}
	
	
	
}
