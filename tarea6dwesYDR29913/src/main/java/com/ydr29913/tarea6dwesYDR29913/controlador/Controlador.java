package com.ydr29913.tarea6dwesYDR29913.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controlador {
	
//	@Autowired
//	private final ServiciosPlanta servplanta;
	

	//Controlador para ver la pagina del Index
		@GetMapping({"/", "/mostrarIndex"})
		public String mostrarIndex() {
			return "index";
		}
}