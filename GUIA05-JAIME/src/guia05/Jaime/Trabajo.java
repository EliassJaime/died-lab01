package guia05.Jaime;

import java.time.Instant;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import excepciones.AgregarTrabajo;

public class Trabajo implements Contratable {

	private Trabajador trabajador;
	private Servicio servicio;
	private Boolean urgente;
	private Double horasTrabajo;
	private Instant fechaInicio;
	private Instant fechaFin;
	
	public static Trabajo crearTrabajo(Trabajador trabajador, Servicio servicio, Boolean urgente, Instant fechaInicio) {
		
		Trabajo t= new Trabajo(trabajador, servicio, urgente, fechaInicio);
		
		try {
			trabajador.addTrabajo(t);
		} catch (AgregarTrabajo e) {
			System.out.println(e.getMessage());
			t=null;
		}
		
		return t;
	}


	public Trabajo(Trabajador trabajador, Servicio servicio, Boolean urgente, Instant fechaInicio) {
		this.trabajador = trabajador;
		this.servicio = servicio;
		this.urgente = urgente;
		this.fechaInicio = fechaInicio;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public Trabajador getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}

	public Boolean getUrgente() {
		return urgente;
	}

	public void setUrgente(Boolean urgente) {
		this.urgente = urgente;
	}

	public Instant getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Instant fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Double getHorasTrabajo() {
		return horasTrabajo;
	}

	public void setHorasTrabajo(Double horasTrabajo) {
		this.horasTrabajo = horasTrabajo;
	}

	public Instant getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Instant fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	@Override
	public Double calcularCosto() {
		Double agregado = 0.0;
		Double costoServicio = servicio.calcularCosto();
		Double costoTrabajador = trabajador.getCostoPH() * this.horasTrabajo
				+ (trabajador.getCostoPH() * this.horasTrabajo) * trabajador.getComision();

		if (urgente) {
			agregado = (costoServicio + costoTrabajador) + (costoServicio + costoTrabajador) * 0.5;
		}

		return costoServicio + costoTrabajador + agregado;
	}

	@Override
	public Boolean finalizado() {
		return fechaFin != null;
	}


	@Override
	public String toString() {
		return "TRABAJO:\n" + "Trabajador: " + trabajador.getNombre() + "\n"
				+ servicio.getClass().getName() +" de: " + servicio.getOficio().getNombre() + "\n"
						+ "Urgente? " + urgente +"\n"
						+ "Costo total: " + this.calcularCosto();
	}

	
	
	
}
