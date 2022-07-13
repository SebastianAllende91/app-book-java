package com.biblioteca.proyectoIntegrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.proyectoIntegrador.models.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer>{

}
