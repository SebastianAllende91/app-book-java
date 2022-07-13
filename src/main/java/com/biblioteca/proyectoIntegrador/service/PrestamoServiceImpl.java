package com.biblioteca.proyectoIntegrador.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.biblioteca.proyectoIntegrador.models.Copia;
import com.biblioteca.proyectoIntegrador.models.EstadoCopia;
import com.biblioteca.proyectoIntegrador.models.Lector;
import com.biblioteca.proyectoIntegrador.models.Prestamo;
import com.biblioteca.proyectoIntegrador.repository.CopiaRepository;
import com.biblioteca.proyectoIntegrador.repository.LectorRepository;
import com.biblioteca.proyectoIntegrador.repository.PrestamoRepository;

@Service
public class PrestamoServiceImpl implements PrestamoService{

	@Autowired
	private PrestamoRepository prestamosRepo;
	
	@Autowired
	private LectorRepository lectorRepo;
	
	@Autowired
	private CopiaRepository copiaRepo;
	
	@Override
	public List<Prestamo> listarPrestamos() {
		return this.prestamosRepo.findAll();
	}

	@Override
	public Prestamo listarId(int id) {
		Optional<Prestamo>optionalPrestamo = prestamosRepo.findById(id);
		Prestamo prestamo=null;
		
		if(optionalPrestamo.isPresent()) {
			prestamo = optionalPrestamo.get();
		}else {
			throw new RuntimeException("Prestamo no encontrado para el id : " + id);
		}
		
		return prestamo;
	}

	@Override
	public Prestamo agregar(Prestamo prestamo) {
		int cantidadPrestamos = obtenerPrestamos(prestamo.getLector().getNum_socio()).size();
		
		if(cantidadPrestamos > 2) {
			throw new RuntimeException("********** PRESTAMOS AGOTADOS **********");		
		}
		
		Prestamo pDto= new Prestamo();	
		Optional<Lector>lectorOptional;
		pDto = prestamosRepo.save(prestamo);
		lectorOptional = lectorRepo.findById(pDto.getLector().getNum_socio());
		
		Optional<Copia>copiaOptional;
		copiaOptional = copiaRepo.findById(pDto.getCopia().getIdCopia());
	    copiaOptional.get().setEstado(EstadoCopia.PRESTADO);
	    copiaRepo.save(copiaOptional.get());
		
		Optional<Prestamo>prestamoOptional = prestamosRepo.findById(pDto.getIdPrestamo());
		pDto = prestamoOptional.get();
		pDto.setLector(lectorOptional.get());
		pDto.setCopia(copiaOptional.get());
		
		
		return pDto;
	}

	@Override
	public Prestamo editar(Prestamo prestamo) {
		return this.prestamosRepo.save(prestamo);
	}

	@Override
	public void borrar(int id) {
		this.prestamosRepo.deleteById(id);
	}

	@Override
	public List<Prestamo> obtenerPrestamos(int id) {
		List<Prestamo> copias = prestamosRepo.findAll();
		List<Prestamo> copiaDto = new ArrayList<>();
		
		for(Prestamo p:copias) {
			
			if(p.getLector().getNum_socio() == id ) {
				Prestamo pres = new Prestamo();
				BeanUtils.copyProperties(p, pres);
				copiaDto.add(pres);
			}
		}
				
		return copiaDto;
	}
	
}
