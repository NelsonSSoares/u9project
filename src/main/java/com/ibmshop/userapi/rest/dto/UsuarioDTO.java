package com.ibmshop.userapi.rest.dto;

import java.util.List;

import com.ibmshop.userapi.domain.entities.Endereco;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

	private String nome;
	
	private String sobrenome;
	
	private String cpf;
	
	private List<Endereco> endereco;
	
	private String telefone;
}
