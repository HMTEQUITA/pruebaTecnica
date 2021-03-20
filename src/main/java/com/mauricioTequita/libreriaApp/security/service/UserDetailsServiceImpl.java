package com.mauricioTequita.libreriaApp.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mauricioTequita.libreriaApp.domain.Usuario;
import com.mauricioTequita.libreriaApp.service.UsuarioService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UsuarioService usuarioService;

	@Override
	public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
		Usuario usuario = usuarioService.getByCorreo(correo).orElseThrow(()-> new UsernameNotFoundException(correo));
        return UsuarioPrincipal.build(usuario);
	}
}
