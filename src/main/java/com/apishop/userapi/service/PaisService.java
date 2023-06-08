package com.apishop.userapi.service;

import com.apishop.userapi.domain.dto.PaisDTO;
import com.apishop.userapi.domain.entities.Pais;

public interface PaisService {
	Pais salvar(PaisDTO paisDto);
}
