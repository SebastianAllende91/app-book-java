package com.biblioteca.proyectoIntegrador.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.proyectoIntegrador.models.Copia;
import com.biblioteca.proyectoIntegrador.models.EstadoCopia;
import com.biblioteca.proyectoIntegrador.models.Libro;
import com.biblioteca.proyectoIntegrador.repository.CopiaRepository;
import com.biblioteca.proyectoIntegrador.repository.LibroRepository;

@Service
public class CopiaServiceImpl implements CopiaService{
	@Autowired
	private CopiaRepository copiaRepo;
	
	@Autowired
	private LibroRepository libroRepo;

	@Override
	public List<Copia> listarCopias() {
		return copiaRepo.findAll();
	}

	@Override
	public Copia listarId(int id) {
		Optional<Copia>optionalCopia= copiaRepo.findById(id);
		Copia copia=null;
		
		if(optionalCopia.isPresent()) {
			copia = optionalCopia.get();
		}else {
			throw new RuntimeException("Copia no encontrado para el id : " + id);
		}
		
		return copia;
	}
	
	@Override
	public List<Copia> listarDisponibles() {

			List<Copia> copias = copiaRepo.findAll();
			List<Copia> dtos = new ArrayList<>();
			
			for(Copia cop:copias) {
				if(EstadoCopia.BIBLIOTECA.equals(cop.getEstado())) {
					Copia copy = new Copia();
					BeanUtils.copyProperties(cop, copy);
					dtos.add(copy);
				}
			}
			
			return dtos;
		}
	

	@Override
	public Copia agregar(Copia copia) {
		Copia copiaDto = new Copia();
		Optional<Libro>optionalLibro;
		
		copiaDto = copiaRepo.save(copia);
		
		optionalLibro = libroRepo.findById(copiaDto.getLibro().getId());
		
		Optional<Copia>optionalCopia = copiaRepo.findById(copiaDto.getIdCopia());
		copiaDto = optionalCopia.get();
		copiaDto.setLibro(optionalLibro.get());
	
		return copiaDto;
	}

	@Override
	public Copia editar(Copia copia) {
		return copiaRepo.save(copia);
	}

	@Override
	public void borrar(int id) {
		copiaRepo.deleteById(id);
	}

	
}
