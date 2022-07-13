package com.biblioteca.proyectoIntegrador.service;

import java.time.LocalDate;
import java.util.List;

import com.biblioteca.proyectoIntegrador.models.Prestamo;


public interface PrestamoService {
	List<Prestamo>listarPrestamos();
	Prestamo listarId(int id);
	List<Prestamo>obtenerPrestamos(int id);
	Prestamo agregar(Prestamo prestamo);
	Prestamo editar(Prestamo prestamo);
	void borrar(int id);
}
