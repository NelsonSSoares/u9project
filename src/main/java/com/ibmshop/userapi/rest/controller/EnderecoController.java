package com.ibmshop.userapi.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibmshop.userapi.domain.dto.EnderecoDTO;
import com.ibmshop.userapi.domain.entities.Endereco;
import com.ibmshop.userapi.service.EnderecoService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "IBM Shop - Shopping API")
@RequiredArgsConstructor
@RestController
@RequestMapping("ibm/enderecos")
public class EnderecoController implements EnderecoService {
	
	@Override
	public ResponseEntity<Endereco> salvar(EnderecoDTO endDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Endereco> atualizar(Integer id, EnderecoDTO endDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Endereco> deletar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	
}
