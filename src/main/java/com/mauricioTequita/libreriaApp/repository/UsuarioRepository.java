package com.mauricioTequita.libreriaApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mauricioTequita.libreriaApp.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	Optional<Usuario> findByCorreo(String correo);	
		
	boolean existsByCorreo(String correo);

}
