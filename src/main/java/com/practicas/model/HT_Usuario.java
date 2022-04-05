package com.practicas.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="HT_Usuario") 
public class HT_Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_ht")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idHistorialUsuario;
	
	@ManyToOne
    @JoinColumn(name = "cod_usuario", nullable = true, updatable = false)
    private Usuario usuario;
	
    @Column(name = "fecha_conexion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    
    public HT_Usuario() {}

	public HT_Usuario(String codUsuario, Date fechaNacimiento) {
		//this.usuario = Usuario.buscarUsuario(codUsuario);
		this.fechaNacimiento = fechaNacimiento;
	}

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getIdHistorialUsuario() {
        return idHistorialUsuario;
    }
    public void setIdHistorialUsuario(Integer idHistorialUsuario) {
        this.idHistorialUsuario = idHistorialUsuario;
    }
}

