package com.biblioteca.proyectoIntegrador.repository;

import java.util.List;
//import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.biblioteca.proyectoIntegrador.models.Prestamo;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Integer>{

}
