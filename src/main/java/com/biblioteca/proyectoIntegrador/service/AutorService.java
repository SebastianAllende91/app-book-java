package com.biblioteca.proyectoIntegrador.service;

import java.util.List;

import com.biblioteca.proyectoIntegrador.models.Autor;

public interface AutorService {
	List<Autor>listarAutores();
	Autor listarId(int id);
	Autor agregar(Autor autor);
	Autor editar(Autor autor);
	void borrar(int id);

}
