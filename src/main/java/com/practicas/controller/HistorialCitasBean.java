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

import com.practicas.model.Cita;
import com.practicas.model.Diagnostico;
import com.practicas.model.Paciente;
import com.practicas.service.CitaService;
import com.practicas.service.PacienteService;
 
@Named
@ViewScoped
public class historialCitasBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	  private CitaService citaService;

	  private List<Cita> listaCitas;
	  private List<Cita> listaCitasProximas;
	  private Paciente paciente;

	  @PostConstruct
	  public void init() {
		  Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		  Paciente paciente = (Paciente) sessionMap.get("paciente");
		  setListaCitas(citaService.obtenerCitas(paciente));
		  this.setListaCitasProximas(citaService.obtenerCitasProximas(paciente));
	  }
	  
	  public String verDiagnostico(Diagnostico diagnostico) {
		  Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		  sessionMap.put("diagnostico", diagnostico);
		  
		  return "/faces/diagnostico.xhtml";
	  }

	public List<Cita> getListaCitas() {
		return listaCitas;
	}

	public void setListaCitas(List<Cita> listaCitas) {
		this.listaCitas = listaCitas;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public List<Cita> getListaCitasProximas() {
		return listaCitasProximas;
	}

	public void setListaCitasProximas(List<Cita> listaCitasProximas) {
		this.listaCitasProximas = listaCitasProximas;
	}
 


	


}
