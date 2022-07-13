 package com.biblioteca.proyectoIntegrador.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "copias")
public class Copia implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "copia_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCopia;

	@Enumerated(EnumType.STRING)
	private EstadoCopia estado;
	
	@OneToOne
	private Libro libro;
	

	public Copia() {}

	public Copia(EstadoCopia estado,Libro libro) {
		this.estado = estado;
		this.libro=libro;
	}

	public Copia(Integer idCopia, EstadoCopia estado,Libro libro) {
		this.idCopia = idCopia;
		this.estado = estado;
		this.libro=libro;
	}


	public Integer getIdCopia() {
		return idCopia;
	}


	public void setIdCopia(Integer idCopia) {
		this.idCopia = idCopia;
	}


	public EstadoCopia getEstado() {
		return estado;
	}


	public void setEstado(EstadoCopia estado) {
		this.estado = estado;
	}


	public Libro getLibro() {
		return libro;
	}


	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	
	
}
