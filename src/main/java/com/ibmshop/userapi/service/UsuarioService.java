package com.ibmshop.userapi.service;

import java.util.List;

import com.ibmshop.userapi.domain.entities.Usuario;
import com.ibmshop.userapi.rest.dto.UsuarioDTO;

public interface UsuarioService {
	Usuario salvar (UsuarioDTO dto);
	
	List<Usuario> buscarTodos();
	
	Usuario buscarPorId(Integer id);
	
	void atualizarUsuario(Integer id, UsuarioDTO userDTO);
	
	void deletarUsuario(Integer id);
	
	List<Usuario> encontrarPorNome(String nome);
	
	Usuario encontrarPorCpf(String cpf);
}
