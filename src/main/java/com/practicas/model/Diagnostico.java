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
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Diagnostico") 
public class Diagnostico implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_diagnostico")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDiagnostico;
	
	@Column(name = "nombre_diagnostico")
    private String nombreDiagnostico;
    
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "tratamiento")
    private String tratamiento;

   
    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "diagnostico")
    private List<Cita> listaCitas;

    public Diagnostico() {}

	public Diagnostico(String nombreDiagnostico, String descripcion, String tratamiento) {
        this.nombreDiagnostico = nombreDiagnostico;
        this.descripcion = descripcion;
        this.tratamiento = tratamiento;
    }
    
    public Integer getIdDiagnostico() {
        return idDiagnostico;
    }
    public void setIdDiagnostico(Integer idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

    public String getNombreDiagnostico() {
        return nombreDiagnostico;
    }
    public void setNombreDiagnostico(String nombreDiagnostico) {
        this.nombreDiagnostico = nombreDiagnostico;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTratamiento() {
        return tratamiento;
    }
    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public List<Cita> getListaCitas() {
        return listaCitas;
    }
    public void setListaCitas(List<Cita> listaCitas) {
        this.listaCitas = listaCitas;
    }
}

