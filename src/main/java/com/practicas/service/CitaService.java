package com.practicas.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practicas.model.Cita;
import com.practicas.model.Paciente;
import com.practicas.model.Usuario;

@Service
@Transactional
public interface CitaService {
	
	public List<Cita> obtenerCitas(Paciente paciente);

	public List<Cita> obtenerCitasProximas(Paciente paciente);
}
