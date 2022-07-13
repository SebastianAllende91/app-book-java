package com.biblioteca.proyectoIntegrador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.proyectoIntegrador.models.Autor;
import com.biblioteca.proyectoIntegrador.repository.AutorRepository;
import com.biblioteca.proyectoIntegrador.repository.LibroRepository;

@Service
public class AutorServiceImpl implements AutorService{

	@Autowired
	private AutorRepository autorRepo;
	
	@Autowired
	LibroRepository libroRepo;
	
	@Override
	public List<Autor> listarAutores() {
		return this.autorRepo.findAll();
	}

	@Override
	public Autor listarId(int id) {

		Optional<Autor> optionalAutor=autorRepo.findById(id);
		Autor autor=null;
		
		if(optionalAutor.isPresent()) {
			autor= optionalAutor.get();
		}else {
			throw new RuntimeException("Autor no encontrado para el id : " + id);

		}
		
		return autor;
	}

	@Override
	public Autor agregar(Autor autor) {
		return autorRepo.save(autor);
	}

	@Override
	public Autor editar(Autor autor) {
		return autorRepo.save(autor);
	}

	@Override
	public void borrar(int id) {
		this.autorRepo.deleteById(id);
		
	}

}
