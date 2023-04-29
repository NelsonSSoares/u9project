package com.ibmshop.userapi.service;

import com.ibmshop.userapi.domain.dto.EnderecoDTO;
import com.ibmshop.userapi.domain.entities.Endereco;

public interface EnderecoService {
	Endereco salvar(EnderecoDTO endDto);
	
	
}
