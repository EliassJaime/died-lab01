package guia05.Jaime;

public class Oficio {
	private String nombre;
	private Integer id;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Oficio(String nombre, Integer id) {
		this.nombre = nombre;
		this.id = id;
	}
	
	
}
