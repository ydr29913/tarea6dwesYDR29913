package com.ydr29913.tarea6dwesYDR29913.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ydr29913.tarea6dwesYDR29913.modelo.Planta;
import com.ydr29913.tarea6dwesYDR29913.repositorios.PlantaRepository;

@Service
public class ServiciosPlanta {
	
	@Autowired
	private PlantaRepository plantarepo;
	
	
	public List<Planta> obtenerPlantasOrdenadasAlfabeticamente() {
        return plantarepo.findAllByOrderByNombreComunAsc();
    }
}