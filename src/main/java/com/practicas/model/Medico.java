package com.practicas.model;

import java.util.ArrayList;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.practicas.model.Paciente;

@Entity
@Table(name="Medico") 
public class Medico {

	    @Id
	    @Column(name = "idMedico")
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int idMedico;
	    
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
	    private int telefono;
	    
	    @Column(name = "especialidad")
		private String especialidad;
		
		@Column(name = "num_colegiado")
		private int numColegiado;
		
	    
	    @ManyToMany
	    @JoinTable(name = "Medico_Paciente",
	        joinColumns =  @JoinColumn(name = "id_medico"), 
	        inverseJoinColumns = @JoinColumn(name = "id_paciente")
	    )
		private List<Paciente> pacientes;
		
		@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "medico")
    	private List<Cita> listaCitas;
		
		public Medico() {}

		public Medico(String nombre, String apellido1, String apellido2) {
			this.nombre = nombre;
			this.apellido1 = apellido1;
			this.apellido2 = apellido2;
		}
	    
	    @Override
	    public String toString() {
	        return "Paciente [id=" + idMedico + ", nombre=" + nombre + " " + apellido1 + " "
	                + apellido2 + "]";
	    }
	    
		public Integer getIdMedico() {
			return idMedico;
		}
		public void setIdMedico(Integer idMedico) {
			this.idMedico = idMedico;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
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
		public String getEspecialidad() {
			return especialidad;
		}
		public void setEspecialidad(String especialidad) {
			this.especialidad = especialidad;
		}
		public Integer getNumColegiado() {
			return numColegiado;
		}
		public void setNumColegiado(Integer numColegiado) {
			this.numColegiado = numColegiado;
		}

		public List<Paciente> getPacientes() {
			return pacientes;
		}

		public void setPacientes(List<Paciente> pacientes) {
			this.pacientes = pacientes;
		}

		public List<Cita> getListaCitas() {
			return listaCitas;
		}

		public void setListaCitas(List<Cita> listaCitas) {
			this.listaCitas = listaCitas;
		}
}
