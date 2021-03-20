package com.mauricioTequita.libreriaApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mauricioTequita.libreriaApp.domain.Autor;
import com.mauricioTequita.libreriaApp.repository.AutorRepository;

@Service
public class AutorService {

	@Autowired
	private AutorRepository autorRepository;

	public List<Autor> buscarTodos(){
		return autorRepository.findAll();
	}
}
