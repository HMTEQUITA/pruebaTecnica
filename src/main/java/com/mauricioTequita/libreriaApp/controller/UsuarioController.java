package com.mauricioTequita.libreriaApp.controller;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mauricioTequita.libreriaApp.domain.Rol;
import com.mauricioTequita.libreriaApp.domain.Usuario;
import com.mauricioTequita.libreriaApp.enums.RolNombre;
import com.mauricioTequita.libreriaApp.service.RolService;
import com.mauricioTequita.libreriaApp.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private RolService rolService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	

	 @PostMapping("/registrar")
	    public ModelAndView registrar(String correoUsuario, String password, String primerApellido, String segundoApellido,
	    		String primerNombre, String segundoNombre, String celular, String direccion){
	        ModelAndView mv = new ModelAndView();
	        
	        if(usuarioService.existsByCorreo(correoUsuario)){
	            mv.setViewName("/registro");
	            mv.addObject("error", "el correo ya existe");
	            return mv;
	        }
	        Usuario usuario = new Usuario();
	        usuario.setCorreo(correoUsuario);
	        usuario.setPassword(passwordEncoder.encode(password));
	        usuario.setPrimerApellido(primerApellido);
	        usuario.setSegundoApellido(segundoApellido);
	        usuario.setPrimerNombre(primerNombre);
	        usuario.setSegundoNombre(segundoNombre);
	        usuario.setDireccion(direccion);
	        usuario.setTelefono(celular);
	        Rol rolUser = rolService.getByRolNombre(RolNombre.ROLE_USER).get();
	        Set<Rol> roles = new HashSet<>();
	        roles.add(rolUser);
	        usuario.setRoles(roles);
	        usuarioService.save(usuario);
	        mv.setViewName("/usuario/login");
	        mv.addObject("registroOK", "Cuenta creada, "+ usuario.getCorreo() + ", ya puedes iniciar sesión");
	        return mv;
	    }

	@GetMapping("/registro")
	public String registro() {
		return "/usuario/registro";
	}
	
	
	@GetMapping("/login")
	public String login() {
		return "/usuario/login";
	}
	
	 @RequestMapping("/default")
	    public String defaultAfterLogin(HttpServletRequest request) {
	        if (request.isUserInRole("ROLE_ADMIN")) {
	            return "redirect:/libro/listarLibros";
	        }
	        return "redirect:/index/";
	    }
}
