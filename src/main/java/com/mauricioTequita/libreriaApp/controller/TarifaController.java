package com.mauricioTequita.libreriaApp.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mauricioTequita.libreriaApp.domain.Tarifa;
import com.mauricioTequita.libreriaApp.service.TarifaService;

@Controller
@RequestMapping("admin/tarifa")
public class TarifaController {

	@Autowired
	private TarifaService tarifaService;
	
	@RequestMapping("/listarTarifas")
	public ModelAndView listarTarifas() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/admin/tarifas");
		mv.addObject("tarifas", tarifaService.buscarTodos());
		return mv;
	}
	
	@RequestMapping("/form")
	public String crear(Map<String, Object> model) {
		
		Tarifa tarifa = new Tarifa(); 
		model.put("tarifa", tarifa);
		model.put("titulo", "Crear Tarifa");

		return "/admin/formularioTarifa";
	}
	
	@RequestMapping("/form/{id}")
	public String editar(@PathVariable(value="id") Integer id, Model model) {
		
		Tarifa tarifa = null;
		
		if(id > 0){
			tarifa = tarifaService.obtenerTarifa(id.intValue());
		}else {
			return "redirect:/admin/tarifa/listarTarifas";
		}
		model.addAttribute("tarifa", tarifa);
		model.addAttribute("titulo", "Editar Tarifa");
		return "/admin/formularioTarifa";
	}
	
	@PostMapping("/form")
	public String guardar(@Valid Tarifa tarifa, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Crear Tarifa");
			return "/admin/formularioTarifa";
		}	
		
		tarifaService.save(tarifa);
		return "redirect:/admin/tarifa/listarTarifas";
	}
	
	
}
