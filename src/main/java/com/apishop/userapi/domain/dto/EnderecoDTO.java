package com.apishop.userapi.domain.dto;

import com.apishop.userapi.domain.enums.Pergunta;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO {
	
	private Integer usuarioId;
	
	private String apelido;
	
	private String rua;
	
	private String numero;
	
	private String complemento;
	
	private String cep;
	
	private String bairro;
	
	private String cidade;
	
	private String Estado;
	
	private PaisDTO pais;
	
	//colocar padrao SIM = 0 ou 1 primeiro parametro
	@Enumerated(EnumType.ORDINAL)
	private Pergunta enderecoPadrao;
}
