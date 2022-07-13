package com.biblioteca.proyectoIntegrador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.proyectoIntegrador.models.Prestamo;
import com.biblioteca.proyectoIntegrador.service.PrestamoService;

@RestController
public class PrestamoController {

	@Autowired
	private PrestamoService prestamoService;
	
	@GetMapping("/prestamos")
	public List<Prestamo> listar(){
		return prestamoService.listarPrestamos();
	}

	@GetMapping(path = "prestamos/{id}" )
	public Prestamo obtenerPrestamo( @PathVariable("id") int id) {
		return prestamoService.listarId(id);
	}
	
	 @PostMapping(path={"/prestamos"})
	 public Prestamo agregarPrestamo(@RequestBody Prestamo prestamo) {
		 return this.prestamoService.agregar(prestamo);
	 }	 

	 @PutMapping(path={"prestamos/{id}"})
	 public Prestamo editarLibro(@RequestBody Prestamo prestamo,@PathVariable("id") int id) {
		 prestamo.setIdPrestamo(id);
		 return this.prestamoService.editar(prestamo); 
	 }
	 
	 @DeleteMapping(path={"prestamos/{id}"})
	 public void borrarPrestamo(@PathVariable("id") int id) {
		 this.prestamoService.borrar(id);
	 }
	 
	 @GetMapping("obtenerPrestamos/{id}")
	 public List<Prestamo>obtenerPrestamos(@PathVariable("id") int id){
		 return prestamoService.obtenerPrestamos(id);
	 }
	
	
}
