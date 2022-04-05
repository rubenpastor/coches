package com.practicas.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="Paciente") 
public class Paciente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "id_paciente")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPaciente;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "apellido1")
    private String apellido1;
    
    @Column(name = "apellido2")
    private String apellido2;
    
    @Column(name = "nif")
    private String nif;
    
    @Column(name = "email")
    private String email;
   
    
    @Column(name = "telefono")
    private Integer telefono;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    
    @ManyToMany
    @JoinTable(name = "Medico_Paciente",
        joinColumns = @JoinColumn(name = "id_paciente"), 
        inverseJoinColumns = @JoinColumn(name = "id_medico") 
    )
	private List<Medico> medicos;
	
	@ManyToOne
    @JoinColumn(name = "codusuario")
	private Usuario usuario;
	
	@Column(name = "num_sip")
	private Integer numSip;
	
	@Column(name = "num_seg_social")
	private Integer numSegSocial;
	
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "paciente")
    private List<Cita> listaCitas;
	
	public Paciente() {}

	public Paciente(String nombre, String apellido1, String apellido2) {
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
	}

    @Override
    public String toString() {
        return "Paciente [id=" + idPaciente + ", nombre=" + nombre + " " + apellido1 + " "
                + apellido2 + "]";
    }


	public Integer getNumSip() {
		return numSip;
	}



	public void setNumSip(Integer numSip) {
		this.numSip = numSip;
	}

	public Integer getNumSegSocial() {
		return numSegSocial;
	}



	public void setNumSegSocial(Integer numSegSocial) {
		this.numSegSocial = numSegSocial;
	}

	public String getApellido1() {
		return apellido1;
	}



	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}



	public String getApellido2() {
		return apellido2;
	}



	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}



	public String getNif() {
		return nif;
	}



	public void setNif(String nif) {
		this.nif = nif;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Integer getTelefono() {
		return telefono;
	}



	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}



	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}



	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}



	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}

	public Integer getIdPaciente()
    {
        return idPaciente;
    }
    

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}

	public List<Cita> getListaCitas() {
		return listaCitas;
	}

	public void setListaCitas(List<Cita> listaCitas) {
		this.listaCitas = listaCitas;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
    
}

