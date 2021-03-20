package com.mauricioTequita.libreriaApp.security.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mauricioTequita.libreriaApp.domain.Usuario;

public class UsuarioPrincipal implements UserDetails{

	private Integer id;
	private String correo;
	private String clave;
	private Collection<? extends GrantedAuthority> authorities;
	
	public UsuarioPrincipal(Integer id, String correo, String clave,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.correo = correo;
		this.clave = clave;
		this.authorities = authorities;
	}

    public static UsuarioPrincipal build(Usuario usuario){
        List<GrantedAuthority> authorities =
        		usuario.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol.getRolNombre().name())).collect(Collectors.toList());
        return new UsuarioPrincipal(usuario.getId(), usuario.getCorreo(), usuario.getPassword(), authorities);
    }
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return clave;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return correo;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	private static final long serialVersionUID = 1L;
}
