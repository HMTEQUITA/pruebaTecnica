package com.mauricioTequita.libreriaApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mauricioTequita.libreriaApp.domain.Tarifa;
import com.mauricioTequita.libreriaApp.repository.TarifaRepository;

@Service
public class TarifaService {

	@Autowired
	private TarifaRepository tarifaRepository;
	
    public Tarifa obtenerTarifa(int tarifaId){
        return tarifaRepository.findById(tarifaId);
    }
	
	public List<Tarifa> buscarTodos(){
        return tarifaRepository.findAll();
    }
	
    public void save(Tarifa tarifa){
    	tarifaRepository.save(tarifa);
    }
    
}
