package excepciones;

public class NoEntregaAlquiler extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoEntregaAlquiler() {
		super("El usuario tiene dos alquileres sin devolver");
	}
}
