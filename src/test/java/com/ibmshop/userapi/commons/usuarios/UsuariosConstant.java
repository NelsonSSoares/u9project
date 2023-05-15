package com.ibmshop.userapi.commons.usuarios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.ibmshop.userapi.domain.dto.EnderecoDTO;
import com.ibmshop.userapi.domain.dto.UsuarioDTO;
import com.ibmshop.userapi.domain.entities.Endereco;
import com.ibmshop.userapi.domain.entities.Usuario;
import com.ibmshop.userapi.domain.enums.Pergunta;

public class UsuariosConstant {
	static List<EnderecoDTO> enderecoDto = new ArrayList<>();
	static List<Endereco> endereco = new ArrayList<>();
	public static final Usuario USUARIO = new Usuario(28,"Nelson","Soares","420.197.488-00","+055 (11) 97959-3152",LocalDate.now(),LocalDate.now(),Pergunta.SIM,endereco);
	public static final UsuarioDTO USUARIODTO = new UsuarioDTO("Nelson","Soares","420.197.488-00",enderecoDto,"+055 (11) 97959-3152");
	public static final UsuarioDTO INVALID_USUARIODTO = new UsuarioDTO();
	
}
/*
TIPO USUARIO 
	this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.dataCriacao = dataCriacao;
		this.dataModificacao = dataModificacao;
		this.ativo = ativo;
		this.endereco = endereco;
*/