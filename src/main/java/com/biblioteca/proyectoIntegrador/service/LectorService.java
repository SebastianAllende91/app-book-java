package com.biblioteca.proyectoIntegrador.service;

import java.util.List;

import com.biblioteca.proyectoIntegrador.models.Lector;


public interface LectorService {
	List<Lector>listarLectores();
	//List<>
	Lector listarId(int id);
	Lector agregar(Lector lector);
	Lector editar(Lector lector);
	void borrar(int id);
}
