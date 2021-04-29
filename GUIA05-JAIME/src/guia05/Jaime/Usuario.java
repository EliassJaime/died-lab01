package guia05.Jaime;

import java.util.ArrayList;
import java.util.List;

import excepciones.NoEntregaAlquiler;

public class Usuario {

	private String nombre;
	private String email;
	
	

	private List<Contratable> serviciosContratados;

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
	
	
	
	
	
	public List<Contratable> getServiciosContratados() {
		return serviciosContratados;
	}

	public Usuario(String nombre, String email) {

		this.nombre = nombre;
		this.email = email;
		this.serviciosContratados=new ArrayList<>();

	}

	public void contratar(Contratable c) throws NoEntregaAlquiler{
		
		if(c instanceof Alquiler && this.alquileresNoDevueltos()) {
			throw new NoEntregaAlquiler();	
		}
		
		serviciosContratados.add(c);
	}
	
public Boolean alquileresNoDevueltos() {
	Integer contador=0;
	
	for(Contratable p:serviciosContratados) {
		if(p instanceof Alquiler && ((Alquiler)p).getFechaDevolucion()==null) {
			contador++;
		}
		
		if(contador==2) {return true;}
		
		
	}
	return false;
	
}

}
