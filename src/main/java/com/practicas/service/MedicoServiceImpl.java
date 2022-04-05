package com.practicas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practicas.model.Medico;
import com.practicas.repository.MedicoRepository;


@Service
public class MedicoServiceImpl implements MedicoService{

	@Autowired
	private MedicoRepository medicoRepository;

	@Override
	public Boolean GuardarMedico(Medico medico) {	
		try {
			medicoRepository.save(medico);
			return true;
		} catch (Exception e) {
			return false;
		}	
	}
	
	/// eliminar medico
	@Override
	public Boolean eliminarMedico(int id) {
		try {
			Medico w_medico = medicoRepository.encontrarPorId(id);
			medicoRepository.delete(w_medico);
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
	public Medico EncontrarMedicoPorID(int id) {
		return medicoRepository.encontrarPorId(id);
	}
	
	@Override
	public List<Medico> obtenerMedicos() {
		return medicoRepository.obtenerMedicos();
	}
}
