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

import com.biblioteca.proyectoIntegrador.models.Lector;
import com.biblioteca.proyectoIntegrador.service.LectorService;

@RestController
public class LectorController {
	
	@Autowired
	private LectorService lectorService;
	
	@GetMapping("/usuarios")
	public List<Lector>obtenerUsuarios(){
		return lectorService.listarLectores();
	}
	
	@GetMapping("usuarios/{id}")
	public Lector obtenerLector(@PathVariable("id") int id) {
		return lectorService.listarId(id);	
	}
	
	 @PostMapping(path={"/usuarios"})
	 public Lector agregarLector(@RequestBody Lector lector) {
		 return this.lectorService.agregar(lector);
	 }
	 

	 @PutMapping(path={"usuarios/{id}"})
	 public Lector editarLector(@RequestBody Lector lector,@PathVariable("id") int id) {
		 lector.setNum_socio(id);
		 return this.lectorService.editar(lector); 
	 }
	 
	 @DeleteMapping(path={"usuarios/{id}"})
	 public void borrarLector(@PathVariable("id") int id) {
		 this.lectorService.borrar(id);
	 }
	 

	 
}
