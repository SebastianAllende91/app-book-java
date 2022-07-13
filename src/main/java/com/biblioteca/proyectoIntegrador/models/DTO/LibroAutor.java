package com.biblioteca.proyectoIntegrador.models.DTO;

import java.io.Serializable;

import com.biblioteca.proyectoIntegrador.models.Autor;
import com.biblioteca.proyectoIntegrador.models.Libro;

public class LibroAutor implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Libro libro;
	
	private Autor autor;

	public LibroAutor() {}
	
	public LibroAutor(Libro libro, Autor autor) {
		this.libro = libro;
		this.autor = autor;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	
	
}
