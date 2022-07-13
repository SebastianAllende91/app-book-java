package com.biblioteca.proyectoIntegrador.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "lectores")
public class Lector implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer num_socio;
	
	private String nombre;
	
	private String telefono;
	
	private String direccion;	

	public Lector() {}
	
	public Lector(Integer num_socio, String nombre, String telefono, String direccion) {
		this.num_socio = num_socio;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
	}


	public Lector(Integer num_socio, String nombre, String telefono, String direccion, Prestamo prestamos) {
		this.num_socio = num_socio;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	public Integer getNum_socio() {
		return num_socio;
	}

	public void setNum_socio(Integer num_socio) {
		this.num_socio = num_socio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
}
