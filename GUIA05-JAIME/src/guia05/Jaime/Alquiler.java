package guia05.Jaime;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;


public class Alquiler implements Contratable {
private Herramienta herramienta;
	
	private Instant fechaInicio;
	
	private Instant fechaFin;
	
	private Instant fechaDevolucion;
	
	public Alquiler(Herramienta herramienta, Instant fechaInicio, Instant fechaFin) {
		this.herramienta = herramienta;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
	

	public Instant getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(Instant fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}
	
	@Override
	public Double calcularCosto(){
		return herramienta.getCostoDia()*(Duration.between(fechaInicio, fechaFin).toDays());
	}
	
	public Boolean enMora() {
		
		if(fechaDevolucion!=null) {
		if(fechaDevolucion.isAfter(fechaFin)) {
			return true;
		}
		}
		else {
			Instant hoy=Instant.now();
			
			if(hoy.isAfter(fechaFin)) {return true;}	
		}
		
		return false;
	
	}

	@Override
	public Boolean finalizado() {
		return fechaDevolucion!=null;
	}

	@Override
	public String toString() {
		SimpleDateFormat sf= new SimpleDateFormat("dd/MM/yyyy");
		String fecha1=sf.format(Date.from(fechaInicio));
		String fecha2=sf.format(Date.from(fechaFin));
		
		return "ALQUILER DE: \n" + 
	"Herramienta: " + herramienta.getNombre() + "\n" 
	+"Fecha de inicio: " + fecha1 + "\n" 
	+"Fecha de entrega " + fecha2+ "\n"
	+"Costo total del alquiler " + this.calcularCosto() ;
	}


}