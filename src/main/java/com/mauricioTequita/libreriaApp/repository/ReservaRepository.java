package com.mauricioTequita.libreriaApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mauricioTequita.libreriaApp.domain.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer>{
	
	List<Reserva> findByUsuarioId(int usuarioId);
	
	Reserva findByid(int idFactura);
}
