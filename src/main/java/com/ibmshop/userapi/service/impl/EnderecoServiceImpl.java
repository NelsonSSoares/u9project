package com.ibmshop.userapi.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ibmshop.userapi.domain.dto.EnderecoDTO;
import com.ibmshop.userapi.domain.entities.Endereco;
import com.ibmshop.userapi.service.EnderecoService;

@Service
public class EnderecoServiceImpl implements EnderecoService {

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
