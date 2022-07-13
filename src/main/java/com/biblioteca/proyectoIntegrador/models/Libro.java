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
@Table(name = "libros")
public class Libro implements Serializable{


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 50, nullable = false)
	private String titulo;
	
	@Enumerated(EnumType.STRING)
	private TipoLibro tipo;
	
	@Column(nullable = false)
	private String editorial;
	
	@Column(nullable = false)
	private Integer anio;
	
	@OneToOne
	private Autor autor;
	

	public Libro() {}

	public Libro(Integer id, String titulo, TipoLibro tipo, String editorial, Integer anio,Autor autor) {
		this.id = id;
		this.titulo = titulo;
		this.tipo = tipo;
		this.editorial = editorial;
		this.anio = anio;
		this.autor=autor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public TipoLibro getTipo() {
		return tipo;
	}

	public void setTipo(TipoLibro tipo) {
		this.tipo = tipo;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}


}
