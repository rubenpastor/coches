package com.practicas.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.practicas.model.Medico;


@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {
	
	//List<Medico> findByUsuario(String usuario);
	
	Medico findById(int id);
	
	
	@Query("select e FROM Medico e WHERE e.idMedico =(:id)")
	Medico encontrarPorId(@Param("id") int id);
	
	@Query("SELECT c FROM Medico c")
	List<Medico> obtenerMedicos();
	
	
		 
}