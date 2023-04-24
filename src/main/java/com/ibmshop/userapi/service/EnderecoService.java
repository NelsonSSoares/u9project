package com.ibmshop.userapi.service;

import com.ibmshop.userapi.domain.entities.Endereco;
import com.ibmshop.userapi.rest.dto.EnderecoDTO;

public interface EnderecoService {
	Endereco salvar(EnderecoDTO endDto);
	
	
}
