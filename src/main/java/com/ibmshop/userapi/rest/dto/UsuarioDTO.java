package com.ibmshop.userapi.rest.dto;

import java.util.List;

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
	
	private List<EnderecoDTO> endereco;
	
	private String telefone;
}
