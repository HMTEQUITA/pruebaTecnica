package com.mauricioTequita.libreriaApp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mauricioTequita.libreriaApp.domain.DetalleReserva;
import com.mauricioTequita.libreriaApp.domain.Reserva;
import com.mauricioTequita.libreriaApp.domain.Usuario;
import com.mauricioTequita.libreriaApp.service.ReservaService;
import com.mauricioTequita.libreriaApp.service.UsuarioService;

@Controller
@RequestMapping("/reserva")
public class ReservaController {

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private ReservaService reservaService;
	
	@RequestMapping("/realizarReserva")
	public ModelAndView guardarReserva(HttpSession session) {
		ModelAndView mv = new ModelAndView();
	
		//Se obtiene el usuario de la sesion
		Usuario usuario = usuarioService.getByCorreo(SecurityContextHolder.getContext().getAuthentication().getName()).get();
		
		@SuppressWarnings("unchecked")
		List<DetalleReserva> listaDetalle = (List<DetalleReserva>) session.getAttribute("ListaCarro");	
		
		if(!listaDetalle.isEmpty()) {
			Reserva reserva = new Reserva();
			reserva.setUsuario(usuario);
			reserva.setDetalleReserva(listaDetalle);
			
			reservaService.guardarReserva(reserva);
			session.removeAttribute("ListaCarro");
			mv.setViewName("redirect:/reserva/listarReservas");
		}else {
			mv.setViewName("/carro/carro");
			mv.addObject("error", "Sin libros para realizar reserva.");
            return mv;
		}

		return mv;
	}
	
	@RequestMapping("/listarReservas")
	public ModelAndView listarReservas(HttpSession session) {
		ModelAndView mv = new ModelAndView();
	
		//Se obtiene el usuario de la sesion
		Usuario usuario = usuarioService.getByCorreo(SecurityContextHolder.getContext().getAuthentication().getName()).get();
		
		mv.setViewName("/reserva/reservas");
		mv.addObject("usuario", usuario);

		return mv;
	}
	
	@RequestMapping("/detalleReserva")
	public ModelAndView detalleFactura(int id){
		ModelAndView mv = new ModelAndView();

		mv.setViewName("/reserva/detalleReserva");
		mv.addObject("reserva", reservaService.buscarReserva(id));
		return mv;
	}
	
}
