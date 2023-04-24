package com.ibmshop.userapi.service;

import com.ibmshop.userapi.domain.entities.Pais;
import com.ibmshop.userapi.rest.dto.PaisDTO;

public interface PaisService {
	Pais salvar(PaisDTO paisDto);
}
