package com.biblioteca.proyectoIntegrador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.proyectoIntegrador.models.Lector;
import com.biblioteca.proyectoIntegrador.models.Multa;
import com.biblioteca.proyectoIntegrador.repository.LectorRepository;
import com.biblioteca.proyectoIntegrador.repository.MultaRepository;

@Service
public class MultaServiceImpl implements MultaService{
	
	@Autowired
	private MultaRepository multaRepo;
	
	@Autowired
	private LectorRepository lectorRepo;

	@Override
	public List<Multa> listarMultas() {
		return this.multaRepo.findAll();
	}

	@Override
	public Multa listarId(int id) {

		Optional<Multa>optionalMulta =  multaRepo.findById(id);
		Multa multa=null;
		
		if(optionalMulta.isPresent()) {
			multa= optionalMulta.get();
		}else {
			throw new RuntimeException("Multa no encontrada para el id : " + id);
		}
		
		return multa;
	}

	@Override
	public Multa agregar(Multa multa) {
		Multa multaDto=new Multa();
		Optional<Lector>lectorOptional;
		
		multaDto=multaRepo.save(multa);
		
		lectorOptional = lectorRepo.findById(multaDto.getLector().getNum_socio());
		
			
		Optional<Multa>multaOptional= multaRepo.findById(multaDto.getIdMulta());
		
		multaDto= multaOptional.get();
		multaDto.setLector(lectorOptional.get());
		
		return multaDto;
	}

	@Override
	public Multa editar(Multa multa) {
		return this.multaRepo.save(multa);
	}

	@Override
	public void borrar(int id) {
		this.multaRepo.deleteById(id);
	}

}
