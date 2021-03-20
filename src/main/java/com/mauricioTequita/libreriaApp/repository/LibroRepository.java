package com.mauricioTequita.libreriaApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mauricioTequita.libreriaApp.domain.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer>{

	List<Libro> findByAutorIdOrderByNombreAsc(int autorId);

    List<Libro> findByCategoriaIdOrderByNombreAsc(int categoriaId);

    Libro findById(int productoId);
}
