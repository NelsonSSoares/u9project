package com.ibmshop.userapi.unittest.usuario;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibmshop.userapi.domain.repository.Usuarios;
import com.ibmshop.userapi.service.impl.UsuarioServiceImpl;;

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
		
		/*	
        when(usuarioRepository.findById(anyInt())).thenReturn(Optional.of(USUARIO));
        
        Optional<Usuario> sut = usuarioService.buscarPorId(1);
        
        assertThat(sut).isNotEmpty();
        assertThat(sut.buscarPorId()).isEqualTo(PLANET);
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
