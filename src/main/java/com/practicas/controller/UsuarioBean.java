package com.practicas.controller;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;

import com.practicas.model.Paciente;
import com.practicas.model.Usuario;
import com.practicas.service.UsuarioService;
 
@Named
@ViewScoped
public class UsuarioBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioService usuarioService;
	private Usuario usuario;
	private Paciente paciente;
	private String codUsuarioLogin;
	private String passwordLogin;

	@PostConstruct
	public void init() {
		passwordLogin = null;
		codUsuarioLogin = null;
	}
	
	public boolean validarFormulario() {
		if(!this.codUsuarioLogin.isEmpty() && !this.passwordLogin.isEmpty()) {
			FacesContext.getCurrentInstance().addMessage("formulario:password", new FacesMessage("Debe rellenar los campos"));
			return true;
		} else {
			if(this.passwordLogin.isEmpty()) {
				FacesContext.getCurrentInstance().addMessage("formulario:password", new FacesMessage("La contraseña es obligatoria"));

			}
			if(this.codUsuarioLogin.isEmpty()) {
				FacesContext.getCurrentInstance().addMessage("formulario:username", new FacesMessage("El usuario es obligatorio"));
			}
			return false;
		}
	}
	
	public void acceder() {
		if(validarFormulario()) {
			Usuario w_usuario = usuarioService.EncontrarUsuarioPorCodUsuario(codUsuarioLogin);
			
			if(w_usuario == null) {
				FacesContext.getCurrentInstance().addMessage("formulario:username", new FacesMessage("Usuario incorrecto"));
			} else {
				if(passwordLogin.equals(w_usuario.getPassword())) {
					usuario = w_usuario;
					paciente = usuarioService.encontrarPaciente(usuario);
					
					Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
					sessionMap.put("paciente", paciente);
					sessionMap.put("usuario", usuario);
				} else {
					FacesContext.getCurrentInstance().addMessage("formulario:password", new FacesMessage("La contraseña es incorrecta"));
				}
			}
			
		} 
	}
	
	public String salir() {
		usuario = null;
		paciente = null;
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.remove("usuario");
		sessionMap.remove("paciente");
		return "/faces/index.xhtml";
	}
	
	public void buscarUsuario(String codUsuario) {
		usuario = usuarioService.EncontrarUsuarioPorCodUsuario(codUsuario);
	}
 
	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getCodUsuarioLogin() {
		return codUsuarioLogin;
	}

	public void setCodUsuarioLogin(String codUsuarioLogin) {
		this.codUsuarioLogin = codUsuarioLogin;
	}

	public String getPasswordLogin() {
		return passwordLogin;
	}

	public void setPasswordLogin(String passwordLogin) {
		this.passwordLogin = passwordLogin;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
 
}
