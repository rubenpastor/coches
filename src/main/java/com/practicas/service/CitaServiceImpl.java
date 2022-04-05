package com.practicas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practicas.model.Cita;
import com.practicas.model.Paciente;
import com.practicas.model.Usuario;
import com.practicas.repository.CitaRepository;
import com.practicas.repository.UsuarioRepository;;


@Service
public class CitaServiceImpl implements CitaService{

	@Autowired
	private CitaRepository citaRepository;
	
	@Autowired 
	public CitaServiceImpl(CitaRepository repositorio) {
	    
	    this.citaRepository=repositorio;
	    
	}
	
	@Override
	public List<Cita> obtenerCitas(Paciente paciente) {
		return citaRepository.obtenerCitas(paciente);
	}
	
	@Override
	public List<Cita> obtenerCitasProximas(Paciente paciente) {
		return citaRepository.obtenerCitasProximas(paciente);
	}
}
