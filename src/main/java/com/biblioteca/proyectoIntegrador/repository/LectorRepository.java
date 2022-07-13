package com.biblioteca.proyectoIntegrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.proyectoIntegrador.models.Lector;

@Repository
public interface LectorRepository extends JpaRepository<Lector, Integer>{
}
