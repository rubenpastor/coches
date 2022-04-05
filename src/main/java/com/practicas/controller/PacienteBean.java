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

import com.practicas.model.Paciente;
import com.practicas.service.PacienteService;
 
@Named
@ViewScoped
public class PacienteBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	  private PacienteService pacienteService;

	  private List<Paciente> listaPacientes;

	  @PostConstruct
	  public void init() {
		  setListaPacientes(pacienteService.obtenerPacientes());
	  }
 


	public List<Paciente> getListaPacientes() {
		return listaPacientes;
	}



	public void setListaPacientes(List<Paciente> listaPacientes) {
		this.listaPacientes = listaPacientes;
	}



public String nuevo() {
	 Paciente c = new Paciente();
  Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
  sessionMap.put("paciente", c);
  return "/faces/nuevo.xhtml";
 }
 
 public String guardar(Paciente paciente) {
  pacienteService.GuardarPaciente(paciente);
  return "/faces/index.xhtml";
 }
 
 public List<Paciente> obtenerPacientes() {
	 return pacienteService.obtenerPacientes();
 }
 
 public String editar(int id) {
  Paciente c = new Paciente();
  c = pacienteService.EncontrarPacientePorID(id);
  System.out.println("******************************************");
  System.out.println(c);
 
  Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
  sessionMap.put("paciente", c);
  return "/faces/editar.xhtml";
 }
 
 public String actualizar(Paciente paciente) {
  pacienteService.GuardarPaciente(paciente);
  return "/faces/index.xhtml";
 }
 
 // eliminar un paciente
 public String eliminar(int id) {
	 pacienteService.eliminarPaciente(id);
  System.out.println("Paciente eliminado..");
  return "/faces/index.xhtml";
 }
 
}
