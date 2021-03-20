package com.mauricioTequita.libreriaApp.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mauricioTequita.libreriaApp.domain.Usuario;
import com.mauricioTequita.libreriaApp.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Usuario> lista(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> getById(int id){
        return usuarioRepository.findById(id);
    }

    public Optional<Usuario> getByCorreo(String correo){
        return usuarioRepository.findByCorreo(correo); 
    }
    
    public void save(Usuario usuario){
        usuarioRepository.save(usuario);
    }

    public boolean existsById(int id){
        return usuarioRepository.existsById(id);
    }

    public boolean existsByCorreo(String correo){
        return usuarioRepository.existsByCorreo(correo);
    }
}
