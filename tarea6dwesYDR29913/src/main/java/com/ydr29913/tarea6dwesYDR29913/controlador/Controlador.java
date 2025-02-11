package com.ydr29913.tarea6dwesYDR29913.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ydr29913.tarea6dwesYDR29913.modelo.Credenciales;
import com.ydr29913.tarea6dwesYDR29913.modelo.Planta;
import com.ydr29913.tarea6dwesYDR29913.servicios.ServiciosCredenciales;
import com.ydr29913.tarea6dwesYDR29913.servicios.ServiciosPlanta;

@Controller
public class Controlador {
	
	@Autowired
	private ServiciosPlanta servplanta;
	
	@Autowired
	private ServiciosCredenciales servcredenciales;
	

	//Controlador para ver la pagina del Index
	@GetMapping({"/", "/mostrarIndex"})
	public String mostrarIndex() {
		return "index";
	}
	
	
	//Metodo para ver la pagina de las Plantas
	@GetMapping("/mostrarVerPlantas")
    public String mostrarVerPlantas(Model model) {
        List<Planta> plantas = servplanta.obtenerPlantasOrdenadasAlfabeticamente();
        model.addAttribute("plantas", plantas);
        return "ver-plantas";
    }
	
	
	//Controlador para ver la pagina del Login
	@GetMapping("/mostrarLogin")
	public String mostrarLogin() {
		return "login";
	}
	
	//Metodo para verificar las credenciales y mandarte a una pagina en funcion del perfil del usuario autenticado
	@PostMapping("/login")
    public String login(@RequestParam String usuario, @RequestParam String contraseña, Model model) {
        Credenciales credenciales = servcredenciales.autenticarUsuario(usuario, contraseña);
        if (credenciales != null) {
            if ("Admin".equals(credenciales.getPerfil())) {
                return "redirect:/mostrarMenuAdmin";
            } else if ("Personal".equals(credenciales.getPerfil())) {
                return "redirect:/mostrarMenuPersonal";
            }
        } 
        model.addAttribute("error", "Usuario o contraseña incorrectos.");
        return "login";
    }
	
	
	//Metodo para ver la pagina del Menu del Admin
	@GetMapping("/mostrarMenuAdmin")
    public String mostrarMenuAdmin(Model model) {
        List<Planta> plantas = servplanta.obtenerPlantasOrdenadasAlfabeticamente();
        model.addAttribute("plantas", plantas);
        return "menu-admin";
    }
	
	
	//Metodo para ver la pagina del Menu del Personal
	@GetMapping("/mostrarMenuPersonal")
    public String mostrarMenuPersonal(Model model) {
        List<Planta> plantas = servplanta.obtenerPlantasOrdenadasAlfabeticamente();
        model.addAttribute("plantas", plantas);
        return "menu-personal";
    }
}