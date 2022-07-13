package com.biblioteca.proyectoIntegrador.service;

import java.util.List;

import com.biblioteca.proyectoIntegrador.models.Multa;


public interface MultaService {
	List<Multa>listarMultas();
	Multa listarId(int id);
	Multa agregar(Multa multa);
	Multa editar(Multa multa);
	void borrar(int id);
}
