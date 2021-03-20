package com.mauricioTequita.libreriaApp.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mauricioTequita.libreriaApp.domain.Rol;
import com.mauricioTequita.libreriaApp.enums.RolNombre;
import com.mauricioTequita.libreriaApp.repository.RolRepository;

@Service
@Transactional
public class RolService {

	@Autowired
	private RolRepository rolRepository;

	public void save(Rol rol){
        rolRepository.save(rol);
    }

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }

    public boolean existsByRolNombre(RolNombre rolNombre){
        return rolRepository.existsByRolNombre(rolNombre);
    }	
}
