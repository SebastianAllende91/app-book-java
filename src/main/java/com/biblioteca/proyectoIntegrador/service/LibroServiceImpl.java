package com.biblioteca.proyectoIntegrador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.proyectoIntegrador.models.Autor;
import com.biblioteca.proyectoIntegrador.models.Copia;
import com.biblioteca.proyectoIntegrador.models.EstadoCopia;
import com.biblioteca.proyectoIntegrador.models.Libro;
import com.biblioteca.proyectoIntegrador.models.DTO.LibroAutor;
import com.biblioteca.proyectoIntegrador.repository.AutorRepository;
import com.biblioteca.proyectoIntegrador.repository.CopiaRepository;
import com.biblioteca.proyectoIntegrador.repository.LibroRepository;

@Service
public class LibroServiceImpl implements LibroService{
	
	@Autowired
	private LibroRepository libroRepo;
	@Autowired
	private AutorRepository autorRepo;
	
	@Autowired
	private CopiaRepository copiaRepo;

	@Override
	public List<Libro> listar() {
		return this.libroRepo.findAll();
	}

	@Override
	public Libro listarId(int id) {
		Optional<Libro> optionalLibro = libroRepo.findById(id);
		Libro libro = null;
		
		if(optionalLibro.isPresent()) {
			libro = optionalLibro.get();
		}else {
			throw new RuntimeException("Libro no encontrado para el id : " + id);
		}
		
		return libro;
	}

	@Override
	public Libro agregar(Libro libro) {
		Libro libroDto=new Libro();
		
		
		Optional<Autor> autorOptional;

		libroDto = libroRepo.save(libro);
		
		autorOptional = autorRepo.findById(libroDto.getAutor().getId());

		Optional<Libro> optionalLibro = libroRepo.findById(libroDto.getId());
		
		libroDto = optionalLibro.get();	
		libroDto.setAutor(autorOptional.get());

		
		Copia copia = new Copia(EstadoCopia.BIBLIOTECA,libroDto);
		copiaRepo.save(copia);
		return  libroDto;
	}

	@Override
	public Libro editar(Libro libro) {
		return libroRepo.save(libro) ;
	}

	@Override
	public void borrar(int id) {
		this.libroRepo.deleteById(id);
	}

	@Override
	public Libro agregarLibroAutor(LibroAutor libroAutor) {
		Libro libroDto=new Libro();
		Autor autorDto = null;
				
		autorDto= autorRepo.save(libroAutor.getAutor());	
		Optional<Autor> optionaAutor = autorRepo.findById(autorDto.getId());

		libroDto= libroAutor.getLibro();
		libroDto.setAutor(optionaAutor.get());
		libroDto = libroRepo.save(libroDto);		
		
		Optional<Libro> optionalLibro = libroRepo.findById(libroDto.getId());
		
		libroDto = optionalLibro.get();
		libroDto.setAutor(autorDto);
		
		Copia copia = new Copia(EstadoCopia.BIBLIOTECA,libroDto);
		copiaRepo.save(copia);
		return libroDto;
	}

}
