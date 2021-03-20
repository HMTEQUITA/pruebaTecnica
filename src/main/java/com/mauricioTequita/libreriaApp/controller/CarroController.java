package com.mauricioTequita.libreriaApp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mauricioTequita.libreriaApp.domain.DetalleReserva;
import com.mauricioTequita.libreriaApp.domain.Libro;
import com.mauricioTequita.libreriaApp.service.LibroService;
import com.mauricioTequita.libreriaApp.utils.DateUtils;

@Controller
@RequestMapping("/carro")
public class CarroController {

	@Autowired
	private LibroService libroService;

	@RequestMapping("/verCarro")
	public ModelAndView verCarro(HttpSession session) {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("/carro/carro");
		return mv;
	}

	@PostMapping("/agregarAlCarro")
	public ModelAndView agragarAlCarrito(HttpSession session, int id, String fechaDevolucion, String cantidad) {
		ModelAndView mv = new ModelAndView();

		@SuppressWarnings("unchecked")
		List<DetalleReserva> listaDetalle = (List<DetalleReserva>) session.getAttribute("ListaCarro");

		int cantidadLibros = Integer.valueOf(cantidad).intValue();
		
		
		if (listaDetalle == null) {
			listaDetalle = new ArrayList<DetalleReserva>();
		}

		Libro libro = libroService.obtenerLibro(id);

		if (libro.getCantidadDisponible() > 0 && libro.getCantidadDisponible() > cantidadLibros) {

			DetalleReserva detalle = new DetalleReserva();
			detalle.setNombre(libro.getNombre());
			detalle.setCantidadReservada(cantidadLibros);
			detalle.setFechaDevolucion(DateUtils.convertirStringDate(fechaDevolucion));
			detalle.setTarifaPagada(libro.getTarifa().getValorTarifa());
			listaDetalle.add(detalle);

			session.setAttribute("ListaCarro", listaDetalle);
			mv.setViewName("/carro/carro");
			return mv;
		} else {
			
			String mensajeError = libro.getCantidadDisponible() == 0 ? "Lo sentimos sin unidades disponibles."
					: "La cantidad de libros solicitados supera las unidades disponibles.";
			
			mv.setViewName("/libro/detalle");
			mv.addObject("libro", libro);
			mv.addObject("fechaMinimaDevolucion", fechaDevolucion);
			mv.addObject("error", mensajeError);
			return mv;
		}
	}

	@RequestMapping("/eliminarLibroCarro")
	public ModelAndView eliminarLibroCarro(HttpSession session, String nombre) {
		ModelAndView mv = new ModelAndView();
		@SuppressWarnings("unchecked")
		List<DetalleReserva> listaDetalle = (List<DetalleReserva>) session.getAttribute("ListaCarro");

		for (DetalleReserva detalle : listaDetalle) {
			if (detalle.getNombre().equals(nombre)) {
				if(detalle.getCantidadReservada() == 1) {
					listaDetalle.remove(detalle);
				}else {
					detalle.setCantidadReservada(detalle.getCantidadReservada()-1);
				}			
				break;
			}
		}

		session.setAttribute("ListaCarro", listaDetalle);
		mv.setViewName("/carro/carro");
		return mv;
	}

}
