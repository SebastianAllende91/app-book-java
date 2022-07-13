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
@Table(name = "multas")
public class Multa implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMulta;

	@Column(nullable = false)
	private LocalDate fechaInicio = LocalDate.now();

	@Column(nullable = false)
	private LocalDate fechaFin;
	
	@OneToOne
	@JoinColumn(name = "num_socio")
	private Lector lector;

	public Multa() {}
	
	public Multa(Integer idMulta, LocalDate fechaFin, Lector lector) {
		this.idMulta = idMulta;
		this.fechaFin = fechaFin;
		this.lector = lector;
	}

	public Integer getIdMulta() {
		return idMulta;
	}

	public void setIdMulta(Integer idMulta) {
		this.idMulta = idMulta;
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

	public Lector getLector() {
		return lector;
	}

	public void setLector(Lector lector) {
		this.lector = lector;
	}
	
	
	
}
