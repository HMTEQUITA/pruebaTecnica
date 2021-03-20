package com.mauricioTequita.libreriaApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mauricioTequita.libreriaApp.domain.Libro;
import com.mauricioTequita.libreriaApp.service.LibroService;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired 
	private LibroService libroService;
	
	@GetMapping(value = { "/", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}

	@ModelAttribute("libros")
	public List<Libro> listadoLibros(){
		return libroService.buscarTodos();
	}
}
