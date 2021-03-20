package com.mauricioTequita.libreriaApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mauricioTequita.libreriaApp.domain.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer>{

}
