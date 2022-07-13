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

import com.biblioteca.proyectoIntegrador.models.Multa;
import com.biblioteca.proyectoIntegrador.service.MultaService;

@RestController
public class MultaController {
	
	@Autowired
	private MultaService multaService;
	
	
	@GetMapping("/multas")
	public List<Multa> listar(){
		return this.multaService.listarMultas();
	}

	@GetMapping(path = "multas/{id}" )
	public Multa obtenerMultas( @PathVariable("id") int id) {
		return this.multaService.listarId(id);
	}
	
	
	 @PostMapping(path={"/multas"})
	 public Multa agregarLibro(@RequestBody Multa multa) {
		 return this.multaService.agregar(multa);
	 }	 

	 @PutMapping(path={"multas/{id}"})
	 public Multa editarMulta(@RequestBody Multa multa,@PathVariable("id") int id) {
		 multa.setIdMulta(id);
		 return this.multaService.editar(multa); 
	 }
	 
	 @DeleteMapping(path={"multas/{id}"})
	 public void borrarMulta(@PathVariable("id") int id) {
		 this.multaService.borrar(id);
	 }
	
}
