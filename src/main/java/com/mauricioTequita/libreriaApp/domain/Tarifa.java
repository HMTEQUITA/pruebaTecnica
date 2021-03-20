package com.mauricioTequita.libreriaApp.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Tarifa implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty
	@Size(min = 4, max = 12)
	private String nombre;
	
	@Min(1000)
	@Max(9000)
	private int valorTarifa;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getValorTarifa() {
		return valorTarifa;
	}
	public void setValorTarifa(int valorTarifa) {
		this.valorTarifa = valorTarifa;
	}

	private static final long serialVersionUID = 1L;

}
