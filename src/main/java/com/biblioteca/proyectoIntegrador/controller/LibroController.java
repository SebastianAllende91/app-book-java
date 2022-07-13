package com.biblioteca.proyectoIntegrador.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.proyectoIntegrador.models.Libro;
import com.biblioteca.proyectoIntegrador.models.DTO.LibroAutor;
import com.biblioteca.proyectoIntegrador.service.LibroService;

@RestController
public class LibroController {
	@Autowired
	private LibroService libroService;

	@GetMapping("/libros")
	public List<Libro> listar(){
		return this.libroService.listar();
	}

	@GetMapping(path = "libros/{id}" )
	public Libro obtenerLibro( @PathVariable("id") int id) {
		return libroService.listarId(id);
	}
	
	
	 @PostMapping(path={"/libros"})
	 public Libro agregarLibro(@RequestBody Libro libro) {
		 return this.libroService.agregar(libro);
	 }
	 
	// servicio creado para cuando se da de alta un libro que no tiene autor.
	 @PostMapping(path={"/libroAutor"})
	 public Libro agregarLibro(@RequestBody LibroAutor libroAutor) {
		 return this.libroService.agregarLibroAutor(libroAutor);
	 }
	 

	 @PutMapping(path={"libros/{id}"})
	 public Libro editarLibro(@RequestBody Libro libro,@PathVariable("id") int id) {
		 libro.setId(id);
		 return this.libroService.editar(libro); 
	 }
	 
	 @DeleteMapping(path={"libros/{id}"})
	 public void borrarLibro(@PathVariable("id") int id) {
		 this.libroService.borrar(id);
	 }
	
}
