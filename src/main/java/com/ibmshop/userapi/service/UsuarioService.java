package com.ibmshop.userapi.service;

import com.ibmshop.userapi.domain.entities.Usuario;
import com.ibmshop.userapi.rest.dto.EnderecoDTO;
import com.ibmshop.userapi.rest.dto.PaisDTO;
import com.ibmshop.userapi.rest.dto.UsuarioDTO;

public interface UsuarioService {
	Usuario salvar (UsuarioDTO dto, EnderecoDTO endDto, PaisDTO paisDto);
}
