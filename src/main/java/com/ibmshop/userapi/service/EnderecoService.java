package com.ibmshop.userapi.service;

import org.springframework.http.ResponseEntity;

import com.ibmshop.userapi.domain.dto.EnderecoDTO;
import com.ibmshop.userapi.domain.entities.Endereco;

public interface EnderecoService {
	
	ResponseEntity<Endereco> salvar(EnderecoDTO endDto);
	
	ResponseEntity<Endereco> atualizar(Integer id, EnderecoDTO endDto);
	
	ResponseEntity<Endereco> deletar(Integer id);
	
	
}
