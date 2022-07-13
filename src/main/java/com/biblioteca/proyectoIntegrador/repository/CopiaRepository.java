package com.biblioteca.proyectoIntegrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.proyectoIntegrador.models.Copia;

@Repository
public interface CopiaRepository extends JpaRepository<Copia, Integer>{
}
