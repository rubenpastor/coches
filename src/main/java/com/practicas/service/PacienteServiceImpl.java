package com.practicas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practicas.model.Paciente;
import com.practicas.repository.PacienteRepository;


@Service
public class PacienteServiceImpl implements PacienteService{

	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Autowired 
	public PacienteServiceImpl(PacienteRepository repositorio) {
	    
	    this.pacienteRepository=repositorio;
	    
	}

	@Override
	public Boolean GuardarPaciente(Paciente paciente) {	
		try {
			pacienteRepository.save(paciente);
			return true;
		} catch (Exception e) {
			return false;
		}	
	}
	
	/// eliminar paciente
	@Override
	public Boolean eliminarPaciente(int id) {
		try {
			Paciente w_paciente = pacienteRepository.encontrarPorId(id);
			pacienteRepository.delete(w_paciente);
			return true;
		} catch (Exception e) {
			return false;
		}	
	}
	
	/*
	@Override
	public Boolean EncontrarUsuario(String usuario, String clave ) {
		
		return false;
	}*/


	@Override
	public Paciente EncontrarPacientePorID(int id) {
		return pacienteRepository.encontrarPorId(id);
	}
	
	@Override
	public List<Paciente> obtenerPacientes() {
		return pacienteRepository.obtenerPacientes();
	}
}
