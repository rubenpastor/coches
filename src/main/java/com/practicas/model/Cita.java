package com.practicas.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

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
@Table(name="Cita") 
public class Cita implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_cita")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCita;
	
	@Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @Column(name = "codigo_cita")
    private String codigoCita;

    @ManyToOne
    @JoinColumn(name = "id_diagnostico", nullable = true, updatable = false)
    private Diagnostico diagnostico;

    @ManyToOne
    @JoinColumn(name = "id_medico", nullable = false, updatable = false)
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false, updatable = false)
    private Paciente paciente;

    public Cita() {}

	public Cita(Date fecha) {
        this.fecha = fecha;
    }

    public String generarCodigoCita() {
        Random randomService = new Random();
        StringBuilder w_codigo = new StringBuilder();
        while (w_codigo.length() < 6) {
            w_codigo.append(Integer.toHexString(randomService.nextInt()));
        }
        w_codigo.setLength(6);

        return w_codigo.toString().toUpperCase();
    }

    public Integer getIdCita() {
        return idCita;
    }
    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
    }

    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCodigoCita() {
        return codigoCita;
    }
    public void setCodigoCita(String codigoCita) {
        this.codigoCita = codigoCita;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }
    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Medico getMedico() {
        return medico;
    }
    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}

