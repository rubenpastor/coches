package com.practicas.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.practicas.model.Cita;
import com.practicas.model.Paciente;
import com.practicas.model.Usuario;


@Repository
public interface CitaRepository extends JpaRepository<Cita, Integer> {
	
	
	Optional<Cita> findById(int id);
	
	
	
	@Query("select p FROM Cita p WHERE p.paciente =(:paciente) order by p.fecha asc")
	List<Cita> obtenerCitas(@Param("paciente") Paciente paciente);


	@Query("select p FROM Cita p WHERE p.paciente =(:paciente) and p.fecha >= current_date order by p.fecha asc")
	List<Cita> obtenerCitasProximas(@Param("paciente") Paciente paciente);
		 
}