package com.ydr29913.tarea6dwesYDR29913.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controlador {
	
	@GetMapping({"/", "/mostrarIndex"})
	public String mostrarIndex(@RequestParam(name="nombre", required=false, defaultValue="Mundo") String nombre, Model model) {
		model.addAttribute("nombre", nombre);
		
		return "index";
	}
}