package com.ibmshop.userapi.domain.dto;

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
	
	private String telefone;
	
	private String email;
	
	private String password;
}
