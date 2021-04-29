package guia05.Jaime;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import excepciones.AgendaOcupada;
import excepciones.AgregarTrabajo;
import excepciones.OficioNoCoincide;

public class Trabajador {

	private String nombre;
	private String correoElectronico;
	private Oficio oficio;
	private Double costoPH;
	private Double comision;
	private List<Trabajo> trabajos;
	
	public Trabajador(String nombre, String correoElectronico, Oficio oficio, Double costoPH, Double comision) {
		this.nombre = nombre;
		this.correoElectronico = correoElectronico;
		this.oficio = oficio;
		this.costoPH = costoPH;
		this.comision = comision;
		trabajos=new ArrayList<>();
		
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public Oficio getOficio() {
		return oficio;
	}
	public void setOficio(Oficio oficio) {
		this.oficio = oficio;
	}
	public Double getCostoPH() {
		return costoPH;
	}
	public void setCostoPH(Double costoPH) {
		this.costoPH = costoPH;
	}
	public Double getComision() {
		return comision;
	}
	public void setComision(Double comision) {
		this.comision = comision;
	}
	
	public List<Trabajo> getTrabajos(){
		return trabajos;
	}
	public void addTrabajo(Trabajo t) throws AgregarTrabajo {
		
		if(!(t.getServicio().getOficio().getId().equals(oficio.getId()))) {
			throw new OficioNoCoincide();
		}
		if(this.agendaOcupada(t)) {
			throw new AgendaOcupada();
		}
			
		this.trabajos.add(t);
		
	}
	
	public Boolean agendaOcupada(Trabajo t) {

		for(Trabajo p:trabajos) {
			if(Duration.between(p.getFechaInicio(), t.getFechaInicio()).toDays()==0) {
				return true;
			}
		}
		return false;
	}
	
	
	
	
	
}