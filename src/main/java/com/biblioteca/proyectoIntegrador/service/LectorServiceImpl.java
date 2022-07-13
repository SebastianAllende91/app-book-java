package com.biblioteca.proyectoIntegrador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.proyectoIntegrador.models.Lector;
import com.biblioteca.proyectoIntegrador.repository.LectorRepository;

@Service
public class LectorServiceImpl implements LectorService{
	
	@Autowired
	private LectorRepository lectorRepo;

	@Override
	public List<Lector> listarLectores() {
		return this.lectorRepo.findAll();
	}

	@Override
	public Lector listarId(int id) {
		Optional<Lector>optionalLector= this.lectorRepo.findById(id);
		Lector lector=null;
		
		if(optionalLector.isPresent()) {
			lector=optionalLector.get();
		}else {
			throw new RuntimeException("Lector no encontrado para el id : " + id);

		}
		
		return lector;
	}

	@Override
	public Lector agregar(Lector lector) {
		return this.lectorRepo.save(lector);
	}

	@Override
	public Lector editar(Lector lector) {
		return this.lectorRepo.save(lector);

	}

	@Override
	public void borrar(int id) {
		this.lectorRepo.deleteById(id);
	}



}
