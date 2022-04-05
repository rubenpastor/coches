package com.practicas.service;

import java.util.List;

import com.practicas.model.Medico;


public interface MedicoService {
	public Boolean GuardarMedico(Medico medico);
	
	//public Boolean EncontrarUsuario(String usuario, String clave );
	
	public Medico EncontrarMedicoPorID(int id);
	
	public List<Medico> obtenerMedicos();
	
	public Boolean eliminarMedico(int id);
	
}
