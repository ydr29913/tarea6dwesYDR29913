package com.ydr29913.tarea6dwesYDR29913.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ydr29913.tarea6dwesYDR29913.modelo.Planta;
import com.ydr29913.tarea6dwesYDR29913.servicios.ServiciosPlanta;

@Controller
public class Controlador {
	
	@Autowired
	private ServiciosPlanta servplanta;
	

	//Controlador para ver la pagina del Index
	@GetMapping({"/", "/mostrarIndex"})
	public String mostrarIndex() {
		return "index";
	}
	
	
	//Controlador para ver la pagina del Login
	@GetMapping("/mostrarLogin")
	public String mostrarLogin() {
		return "login";
	}
	
	
	//Metodo para ver la pagina de las Plantas
	@GetMapping("/mostrarVerPlantas")
    public String mostrarVerPlantas(Model model) {
        List<Planta> plantas = servplanta.obtenerPlantasOrdenadasAlfabeticamente();
        model.addAttribute("plantas", plantas);
        return "ver-plantas";
    }
}