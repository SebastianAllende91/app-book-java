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

import com.biblioteca.proyectoIntegrador.models.Autor;
import com.biblioteca.proyectoIntegrador.service.AutorService;


@RestController
public class AutorController {

	@Autowired
	private AutorService autorService;
	
	
	@GetMapping("/autores")
	public List<Autor> listar(){
		return this.autorService.listarAutores();
	}

	@GetMapping(path = "autores/{id}" )
	public Autor obtenerLibro( @PathVariable("id") int id) {
		return autorService.listarId(id);
	}
	
	 @PostMapping(path={"/autores"})
	 public Autor agregarAutor(@RequestBody Autor autor) {
		 return this.autorService.agregar(autor);
	 }
	 

	 @PutMapping(path={"autores/{id}"})
	 public Autor editarLibro(@RequestBody Autor autor,@PathVariable("id") int id) {
		 autor.setId(id);
		 return this.autorService.editar(autor); 
	 }
	 
	 @DeleteMapping(path={"autores/{id}"})
	 public void borrarAutor(@PathVariable("id") int id) {
		 this.autorService.borrar(id);
	 }
	
	
	
}
