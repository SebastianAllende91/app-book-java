package com.biblioteca.proyectoIntegrador.service;

import java.util.List;

import com.biblioteca.proyectoIntegrador.models.Libro;
import com.biblioteca.proyectoIntegrador.models.DTO.LibroAutor;

public interface LibroService {

	List<Libro> listar();
	Libro listarId(int id);
	Libro agregar(Libro libro);
	Libro agregarLibroAutor(LibroAutor libroAutor);
	Libro editar(Libro libro);
	void borrar(int id);
}
