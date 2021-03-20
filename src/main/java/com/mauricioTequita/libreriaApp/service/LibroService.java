package com.mauricioTequita.libreriaApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mauricioTequita.libreriaApp.domain.Libro;
import com.mauricioTequita.libreriaApp.repository.LibroRepository;

@Service
@Transactional
public class LibroService {

	@Autowired
	private LibroRepository libroRepository;
	

    public Libro obtenerLibro(int libroId){
        return libroRepository.findById(libroId);
    }
	
	public List<Libro> buscarTodos(){
        return libroRepository.findAll();
    }

    public List<Libro> buscarPorAutor(int autorId){
        return libroRepository.findByAutorIdOrderByNombreAsc(autorId);
    }

    public List<Libro> buscarPorCategoria(int categoriaId){
        return libroRepository.findByCategoriaIdOrderByNombreAsc(categoriaId);
    }
    
    public void save(Libro libro){
    	libroRepository.save(libro);
    }
    
    public void delete(Libro libro){
    	libroRepository.delete(libro);
    }
    
}
