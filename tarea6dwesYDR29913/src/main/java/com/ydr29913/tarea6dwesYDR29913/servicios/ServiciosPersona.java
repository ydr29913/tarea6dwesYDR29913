package com.ydr29913.tarea6dwesYDR29913.servicios;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ydr29913.tarea6dwesYDR29913.modelo.Persona;
import com.ydr29913.tarea6dwesYDR29913.repositorios.PersonaRepository;

@Service
public class ServiciosPersona {

	@Autowired
	private PersonaRepository personarepo;
	
	
	public void insertarPersona(Persona persona) {
		personarepo.saveAndFlush(persona);
	}
	
	//Sirve para validar que el email esta introducido correctamente
	public boolean validarEmail(String email) {
	    String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
	    Pattern pattern = Pattern.compile(regex);
	    Matcher matcher = pattern.matcher(email);
	    
	    return matcher.matches() && personarepo.findByEmail(email).isEmpty();
	}
}