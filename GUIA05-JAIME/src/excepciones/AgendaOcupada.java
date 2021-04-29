package excepciones;

public class AgendaOcupada extends AgregarTrabajo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public AgendaOcupada() {
		super("El trabajador ya tiene un trabajo asignado esa fecha");
	}	

}

