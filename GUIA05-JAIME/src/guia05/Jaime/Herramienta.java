package guia05.Jaime;


public class Herramienta {
	
	private String nombre;
	private Double costoDia;
	
	public Herramienta(String nombre, Double costoPorDia) {
		this.nombre = nombre;
		this.costoDia = costoPorDia;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getCostoDia() {
		return costoDia;
	}
	public void setCostoDia(Double costo) {
		this.costoDia = costo;
	}
	
}