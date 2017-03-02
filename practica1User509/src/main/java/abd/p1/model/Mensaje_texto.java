package abd.p1.model;
import javax.persistence.*;

@Entity
public class Mensaje_texto extends Mensaje{
	@Column (length = 140)
	private String texto_msj;
	
	public Mensaje_texto (){
		
	}

	public Mensaje_texto(String s){
		this.texto_msj = s;
	}

	public String getTexto_msj() {
		return texto_msj;
	}

	public void setTexto_msj(String texto_msj) {
		this.texto_msj = texto_msj;
	}

	@Override
	public String toString() {
		return "Mensaje_texto [texto_msj=" + texto_msj + "]";
	}
}
