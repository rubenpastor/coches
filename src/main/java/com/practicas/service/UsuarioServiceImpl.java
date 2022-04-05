package com.practicas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practicas.model.Paciente;
import com.practicas.model.Usuario;
import com.practicas.repository.UsuarioRepository;;


@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired 
	public UsuarioServiceImpl(UsuarioRepository repositorio) {
	    
	    this.usuarioRepository=repositorio;
	    
	}

	@Override
	public Boolean GuardarUsuario(Usuario usuario) {	
		try {
			usuarioRepository.save(usuario);
			return true;
		} catch (Exception e) {
			return false;
		}	
	}
	
	/// eliminar Usuario
	@Override
	public Boolean eliminarUsuario(String codUsuario) {
		try {
			Usuario w_usuario = usuarioRepository.encontrarPorCodUsuario(codUsuario);
			usuarioRepository.delete(w_usuario);
			return true;
		} catch (Exception e) {
			return false;
		}	
	}

	@Override
	public Usuario EncontrarUsuarioPorCodUsuario(String codUsuario) {
		return usuarioRepository.encontrarPorCodUsuario(codUsuario);
	}
	
	@Override
	public List<Usuario> obtenerUsuarios() {
		return usuarioRepository.obtenerUsuarios();
	}
	
	@Override
	public Paciente encontrarPaciente(Usuario codUsuario) {
		return usuarioRepository.encontrarPaciente(codUsuario);
	}
}
