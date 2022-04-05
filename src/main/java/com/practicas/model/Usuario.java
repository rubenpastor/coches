package com.practicas.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Usuario") 
public class Usuario implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "cod_usuario")
    private String codUsuario;
    
    @Column(name = "password")
    private String password;
    
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<HT_Usuario> historial;

	public Usuario() {}

	public Usuario(String codUsuario, String password) {
		this.codUsuario = codUsuario;
		this.password = password;
	}

	public String getCodUsuario() {
		return codUsuario;
	}
	public void setCodUsuario(String codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<HT_Usuario> getHistorial() {
		return historial;
	}

	public void setHistorial(List<HT_Usuario> historial) {
		this.historial = historial;
	}
}

