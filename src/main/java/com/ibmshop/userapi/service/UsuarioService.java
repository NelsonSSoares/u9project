package com.ibmshop.userapi.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ibmshop.userapi.domain.dto.UsuarioDTO;
import com.ibmshop.userapi.domain.entities.Usuario;

public interface UsuarioService {
	ResponseEntity<Usuario> salvar (UsuarioDTO dto);
	
	ResponseEntity<List<UsuarioDTO>> buscarTodos();
	
	ResponseEntity<Usuario> buscarPorId(Integer id);
	
	ResponseEntity<Usuario> atualizarUsuario(Integer id, UsuarioDTO userDTO);
	
	ResponseEntity<Usuario> deletarUsuario(Integer id);
	
	ResponseEntity<List<Usuario>> encontrarPorNome(String nome);
	
	ResponseEntity<Usuario> encontrarPorCpf(String cpf);
	
	ResponseEntity<Usuario> reativarUsuario(Integer id);
}
