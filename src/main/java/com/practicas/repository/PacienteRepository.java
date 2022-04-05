package com.practicas.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.practicas.model.Paciente;


@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
	
	//List<Paciente> findByUsuario(String usuario);
	
	Paciente findById(int id);
	
	
	@Query("select e FROM Paciente e WHERE e.idPaciente =(:id)")
	Paciente encontrarPorId(@Param("id") int id);
	
	@Query("SELECT c FROM Paciente c")
	List<Paciente> obtenerPacientes();
	
	
		 
}