package com.biblioteca.proyectoIntegrador.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.proyectoIntegrador.models.Copia;
import com.biblioteca.proyectoIntegrador.models.EstadoCopia;
import com.biblioteca.proyectoIntegrador.models.Libro;
import com.biblioteca.proyectoIntegrador.models.TipoLibro;
import com.biblioteca.proyectoIntegrador.service.CopiaService;

@RestController
public class CopiaController {

	@Autowired
	private CopiaService copiaService;
	
	@GetMapping("/copias")
	public List<Copia>listar(){
		return this.copiaService.listarCopias();
	}
	
	@GetMapping("libros/disponibles")
	public List<Copia>librosDisponibles(){
		return this.copiaService.listarDisponibles();

	}
	
	@GetMapping("copias/{id}")
	public Copia obtenerCopia(@PathVariable("id") int id) {
		return copiaService.listarId(id);
	}

	 @PostMapping(path={"/copias"})
	 public Copia agregarCopia(@RequestBody Copia copia) {
		 return this.copiaService.agregar(copia);
	 }
	 

	 @PutMapping(path={"copias/{id}"})
	 public Copia editarCopia(@RequestBody Copia copia,@PathVariable("id") int id) {
		 copia.setIdCopia(id);
		 return this.copiaService.editar(copia); 
	 }
	 
	 @DeleteMapping(path={"copias/{id}"})
	 public void borrarCopia(@PathVariable("id") int id) {
		 this.copiaService.borrar(id);
	 }
}
