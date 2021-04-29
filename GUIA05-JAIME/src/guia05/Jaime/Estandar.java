package guia05.Jaime;


public class Estandar extends Servicio{

	private Double costo;
	public Estandar(Double costo,Oficio oficio) {
		this.costo = costo;
		this.oficio=oficio;
	}
	
	public void setCosto(Double costo) {
		this.costo = costo;
	}

	@Override
	public Double calcularCosto() {
		return costo;
	}

	
}