package com.mauricioTequita.libreriaApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mauricioTequita.libreriaApp.domain.Tarifa;

@Repository
public interface TarifaRepository extends JpaRepository<Tarifa, Integer>{

	Tarifa findById(int productoId);
}
