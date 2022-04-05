package com.practicas.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practicas.model.Medico;
import com.practicas.model.Paciente;
import com.practicas.service.MedicoService;
import com.practicas.service.PacienteService;
 
@Named
@ViewScoped
public class MedicoBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	  private MedicoService medicoService;

	  private List<Medico> listaMedicos;

	  @PostConstruct
	  public void init() {
		  setListaMedicos(medicoService.obtenerMedicos());
	  }
 


	public List<Medico> getListaMedicos() {
		return listaMedicos;
	}



	public void setListaMedicos(List<Medico> listaMedicos) {
		this.listaMedicos = listaMedicos;
	}


	/*
	 public List<Paciente> obtenerPacientes() {
		 return medicoService.obtenerPacientes();
	 }*/
 
 
}
