package com.biblioteca.proyectoIntegrador.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "prestamos")
public class Prestamo implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPrestamo;

	@Column(nullable = false)
	private LocalDate fechaInicio = LocalDate.now();

	@Column(nullable = false)
	private LocalDate fechaFin;
	
	@OneToOne
	@JoinColumn(name = "copia_id")
	private Copia copia;

	@OneToOne
	@JoinColumn(name = "num_soc")
	private Lector lector;
	
	public Prestamo() {}
	

	public Prestamo(Integer idPrestamo, LocalDate fechaFin, Copia copia, Lector lector) {
		this.idPrestamo = idPrestamo;
		this.fechaFin = fechaFin;
		this.copia = copia;
		this.lector = lector;
	}


	public Integer getIdPrestamo() {
		return idPrestamo;
	}

	public void setIdPrestamo(Integer idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Copia getCopia() {
		return copia;
	}

	public void setCopia(Copia copia) {
		this.copia = copia;
	}

	public Lector getLector() {
		return lector;
	}

	public void setLector(Lector lector) {
		this.lector = lector;
	}


}
