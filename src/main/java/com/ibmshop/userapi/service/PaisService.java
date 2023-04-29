package com.ibmshop.userapi.service;

import com.ibmshop.userapi.domain.dto.PaisDTO;
import com.ibmshop.userapi.domain.entities.Pais;

public interface PaisService {
	Pais salvar(PaisDTO paisDto);
}
