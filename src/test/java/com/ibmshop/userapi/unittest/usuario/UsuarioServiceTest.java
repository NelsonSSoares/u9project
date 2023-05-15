package com.ibmshop.userapi.unittest.usuario;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Optional;
import com.ibmshop.userapi.domain.dto.UsuarioDTO;
import com.ibmshop.userapi.domain.entities.Usuario;
import com.ibmshop.userapi.domain.enums.Pergunta;
import com.ibmshop.userapi.domain.repository.Usuarios;
import com.ibmshop.userapi.service.UsuarioService;
import com.ibmshop.userapi.service.impl.UsuarioServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import static com.ibmshop.userapi.commons.usuarios.UsuariosConstant.USUARIO;
import static com.ibmshop.userapi.commons.usuarios.UsuariosConstant.USUARIODTO;
import static com.ibmshop.userapi.commons.usuarios.UsuariosConstant.INVALID_USUARIODTO;;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest {
	
	@InjectMocks
	private UsuarioServiceImpl usuarioService;
	@InjectMocks
	private ObjectMapper objectMapper;
	@Mock
	private Usuarios usuarioRepository;
	
	@Test
	public void createUsuario_WithValidData_ReturnsUsuario() {
		/*PROBLEMA COM A CONVERSÃO DE DADOS 
		 * USUARIODTO -> USUARIO
		 * USUARIO SERVICE ACEITA APENAS USUARIODTO COMO PARAMETRO,
		 * E USUARIO REPOSITORY ACEITA APENAS TIPO USUARIO
		*/

	}

	
	@Test
    public void createUsuario_WithInValidData_ThrowsException(){
       	/*PROBLEMA COM A CONVERSÃO DE DADOS 
		 * USUARIODTO -> USUARIO
		 * USUARIO SERVICE ACEITA APENAS USUARIODTO COMO PARAMETRO,
		 * E USUARIO REPOSITORY ACEITA APENAS TIPO USUARIO
		*/
    }
	@Test
    public void getUsuario_ByExistingId_ReturnsPlanet(){
	/*	
        when(usuarioRepository.findById(anyInt())).thenReturn(Optional.of(USUARIO));
        
        Optional<Usuario> sut = usuarioService.buscarPorId(1);
        
        assertThat(sut).isNotEmpty();
        assertThat(sut.buscarPorId()).isEqualTo(PLANET);
	*/
    }   

    @Test
    public void getPlanet_ByUnexistingId_ReturnsEmpty(){
	/*
        when(planetRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<Planet> sut = planetService.get(1L);

        assertThat(sut).isEmpty();
	*/
    }


	
}
