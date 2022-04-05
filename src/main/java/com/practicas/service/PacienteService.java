package com.practicas.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practicas.model.Paciente;

@Service
@Transactional
public interface PacienteService {
	public Boolean GuardarPaciente(Paciente paciente);
	
	//public Boolean EncontrarUsuario(String usuario, String clave );
	
	public Paciente EncontrarPacientePorID(int id);
	
	public List<Paciente> obtenerPacientes();
	
	public Boolean eliminarPaciente(int id);
	
}
