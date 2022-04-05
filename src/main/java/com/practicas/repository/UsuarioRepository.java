package com.practicas.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.practicas.model.Paciente;
import com.practicas.model.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
	
	
	Optional<Usuario> findById(String codUsuario);
	
	
	@Query("select e FROM Usuario e WHERE e.codUsuario =(:codUsuario)")
	Usuario encontrarPorCodUsuario(@Param("codUsuario") String codUsuario);
	
	@Query("SELECT c FROM Usuario c")
	List<Usuario> obtenerUsuarios();
	
	@Query("select p FROM Paciente p WHERE p.usuario =(:codUsuario)")
	Paciente encontrarPaciente(@Param("codUsuario") Usuario codUsuario);
		 
}