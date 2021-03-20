package com.mauricioTequita.libreriaApp.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mauricioTequita.libreriaApp.domain.Autor;
import com.mauricioTequita.libreriaApp.domain.Categoria;
import com.mauricioTequita.libreriaApp.domain.Libro;
import com.mauricioTequita.libreriaApp.domain.Tarifa;
import com.mauricioTequita.libreriaApp.service.AutorService;
import com.mauricioTequita.libreriaApp.service.CategoriaService;
import com.mauricioTequita.libreriaApp.service.LibroService;
import com.mauricioTequita.libreriaApp.service.TarifaService;
import com.mauricioTequita.libreriaApp.utils.DateUtils;

@Controller
@RequestMapping("/libro")
public class LibroController {

	@Autowired
	private LibroService libroService;
	
	@Autowired
	private TarifaService tarifaService;
	
	@Autowired
	private AutorService autorService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping("/detalle")
	public ModelAndView detallelibro(int id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/libro/detalle");
		mv.addObject("fechaMinimaDevolucion", DateUtils.sumarDiasFecha(1));
		mv.addObject("fechaMaximaDevolucion", DateUtils.sumarDiasFecha(31));
		mv.addObject("libro", libroService.obtenerLibro(id));
		return mv;
	}
	
	@RequestMapping("/listarLibros")
	public String listadoLibros(Model model){
		model.addAttribute("libros", libroService.buscarTodos());
		model.addAttribute("/admin/tarifas");
		return "/admin/inventario";
	}
	
	
	@RequestMapping("/form")
	public String crear(Map<String, Object> model) {
		
		Libro libro = new Libro(); 
		model.put("libro", libro);
		model.put("titulo", "Crear Libro");

		return "/admin/formularioLibroCrear";
	}
	
	
	
	@RequestMapping("/form/{id}")
	public String editar(@PathVariable(value="id") Integer id, Model model) {
		
		Libro libro = null;
		
		if(id > 0){
			libro = libroService.obtenerLibro(id.intValue());
		}else {
			return "redirect:/libro/listarLibros";
		}
		model.addAttribute("libro", libro);
		model.addAttribute("titulo", "Editar Libro");
		return "/admin/formularioLibro";
	}
	
	
	@PostMapping("/form")
	public String guardar(@Valid Libro libro, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			if(libro.getId() != null) {
				return "/admin/formularioLibro";
			}else {
				return "/admin/formularioLibroCrear";
			}
			
		}	
		
		libroService.save(libro);
		return "redirect:/libro/listarLibros/";
	}
	
	
	
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Integer id, Model model) {
		
		Libro libro = null;
		
		if(id > 0){
			libro = libroService.obtenerLibro(id.intValue());
			libroService.delete(libro);
		}
			
		return "redirect:/libro/listarLibros";
	}
	
	
	
	
	
	@ModelAttribute("tarifas")
	public List<Tarifa> listadoLibros(){
		return tarifaService.buscarTodos();
	}
	
	
	@ModelAttribute("autores")
	public List<Autor> listarAutores(){
		return autorService.buscarTodos();
	}
	
	@ModelAttribute("categorias")
	public List<Categoria> listarCategorias(){
		return categoriaService.buscarTodos();
	}
	
	
}