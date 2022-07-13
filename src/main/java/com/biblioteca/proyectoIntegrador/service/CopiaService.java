package com.biblioteca.proyectoIntegrador.service;

import java.util.List;

import com.biblioteca.proyectoIntegrador.models.Copia;

public interface CopiaService {
	List<Copia> listarCopias();
	List<Copia>listarDisponibles();
	Copia listarId(int id);
	Copia agregar(Copia copia);
	Copia editar(Copia copia);
	void borrar(int id);

}
