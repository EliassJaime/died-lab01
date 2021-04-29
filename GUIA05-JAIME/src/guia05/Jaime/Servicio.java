package guia05.Jaime;


public abstract class Servicio {

	protected Oficio oficio;
	
	public abstract Double calcularCosto();

	public Oficio getOficio() {
		return oficio;
	}

	public void setOficio(Oficio oficio) {
		this.oficio = oficio;
	}
	
}
