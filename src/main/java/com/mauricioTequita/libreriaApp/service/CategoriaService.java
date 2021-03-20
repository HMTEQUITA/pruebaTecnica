package com.mauricioTequita.libreriaApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mauricioTequita.libreriaApp.domain.Categoria;
import com.mauricioTequita.libreriaApp.repository.CategoriaRepository;

@Service
public class CategoriaService {

	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
    public List<Categoria> buscarTodos(){
        return categoriaRepository.findAll();
    }
}
