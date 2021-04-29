package guia05.Jaime;


public class Personalizado extends Servicio {

	
	private Double costoMat;
	private Double costoTrans;
	private Double presupuesto;
	
	public Personalizado(Double presupuesto, Double costoMat, Double costoTrans, Oficio oficio) {
		this.costoMat = costoMat;
		this.costoTrans = costoTrans;
		this.presupuesto = presupuesto;
		this.oficio = oficio;
	}
	
	
	public Double getCostoMat() {
		return costoMat;
	}

	public void setCostoMat(Double costoMat) {
		this.costoMat = costoMat;
	}

	public Double getCostoTrans() {
		return costoTrans;
	}

	public void setCostoTrans(Double costoTrans) {
		this.costoTrans = costoTrans;
	}

	public Double getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(Double presupuesto) {
		this.presupuesto = presupuesto;
	}

	public Double calcularCosto() {
		return presupuesto + costoMat + costoTrans;
	}

}