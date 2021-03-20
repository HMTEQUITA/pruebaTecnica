package com.mauricioTequita.libreriaApp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Autor extends Persona{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return getPrimerNombre().concat(" ").concat(getSegundoNombre()).concat(" ").concat(getPrimerApellido()).concat(" ").concat(getSegundoApellido()).replace("  ", " ");		
	} 

}
