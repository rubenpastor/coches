package com.practicas.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practicas.model.Paciente;
import com.practicas.model.Usuario;

@Service
@Transactional
public interface UsuarioService {
	public Boolean GuardarUsuario(Usuario usuario);
		
	public Usuario EncontrarUsuarioPorCodUsuario(String codUsuario);
	
	public List<Usuario> obtenerUsuarios();
	
	public Boolean eliminarUsuario(String codUsuario);
	
	public Paciente encontrarPaciente(Usuario codUsuario);
}
