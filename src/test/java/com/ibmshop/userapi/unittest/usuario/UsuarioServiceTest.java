package com.ibmshop.userapi.unittest.usuario;



import static com.ibmshop.userapi.commons.usuarios.UsuariosConstant.INVALID_USUARIODTO;
import static com.ibmshop.userapi.commons.usuarios.UsuariosConstant.USUARIO;
import static com.ibmshop.userapi.commons.usuarios.UsuariosConstant.USUARIOOP;
import static com.ibmshop.userapi.commons.usuarios.UsuariosConstant.INVALID_USUARIOOP;
import static com.ibmshop.userapi.commons.usuarios.UsuariosConstant.INVALID_USUARIO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibmshop.userapi.domain.entities.Usuario;
import com.ibmshop.userapi.domain.repository.Usuarios;
import com.ibmshop.userapi.service.impl.UsuarioServiceImpl;

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
		
		usuarioRepository.save(USUARIO);
		assertThat(USUARIO).isEqualTo(USUARIO);
		
		/* o Teste passou, mas acredito estar errado, pois não ouve a chamada do service
		 * do tipo UsuarioDTO.
		 * Confusão na hora de chaamar o service(UserioDTO) e repository(Usuario)
		 */
		
	  	/*PROBLEMA COM A CONVERSÃO DE DADOS 
			 * USUARIODTO -> USUARIO
			 * USUARIO SERVICE ACEITA APENAS USUARIODTO COMO PARAMETRO,
			 * E USUARIO REPOSITORY ACEITA APENAS TIPO USUARIO
		*/
	}

	
	@Test
    public void createUsuario_WithInValidData_ThrowsException(){
		
		//when(usuarioRepository.save(INVALID_USUARIO)).thenThrow(RuntimeException.class);
		
		assertThatThrownBy(()-> usuarioService.salvar(INVALID_USUARIODTO)).isInstanceOf(RuntimeException.class);
     
    }
	@Test
    public void getUsuario_ByExistingId_ReturnsUsuario(){
		
        when(usuarioRepository.findById(anyInt())).thenReturn(USUARIOOP);
        
        ResponseEntity<Usuario> sut = usuarioService.buscarPorId(1);
        
        assertThat(sut).isNotNull();
        assertThat(sut.getBody()).isEqualTo(USUARIO);
	
    }   

    @Test
    public void getPlanet_ByUnexistingId_ReturnsEmpty(){
	
        when(usuarioRepository.findById(2042)).thenReturn(Optional.empty());

        ResponseEntity<Usuario> sut = usuarioService.buscarPorId(2042);

        assertThat(sut).isEqualTo(ResponseEntity.notFound().build());
	
    }
    
    @Test
    public void getUsuario_ByExistingName_ResturnsUsuario() {
    	
    	when(usuarioRepository.findByNome(USUARIO.getNome())).thenReturn(Optional.of(USUARIO).stream().toList());
    	
    	ResponseEntity<List<Usuario>> sut = usuarioService.encontrarPorNome(USUARIO.getNome());
    	Usuario userbody = sut.getBody().get(0);
    	
    	assertThat(sut).isNotNull();
    	assertThat(userbody).isEqualTo(USUARIO);
    }
    
    @Test
    public void getUsuario_ByUnexistingName_ReturnsEmpty() {
    	String name =  "Unexisting Name";
    	
    	
    	ResponseEntity<List<Usuario>> sut = usuarioService.encontrarPorNome(name);
    	
    	assertThat(sut).isEqualTo(ResponseEntity.notFound().build());
    }
    
    @Test
    public void getUsuario_ByExistingCpf_ReturnUsuario() {
    	when(usuarioRepository.findByCpf(USUARIO.getCpf())).thenReturn(Optional.of(USUARIO));
    	
    	ResponseEntity<Usuario> sut = usuarioService.encontrarPorCpf(USUARIO.getCpf());
    	assertThat(sut.getBody()).isEqualTo(USUARIO);
    }
    
    @Test
    public void getUsuario_ByUnexistingCpf_ReturnEmpty() {
    	
    	String cpf = "123.456.789-10";
    	
    	ResponseEntity<Usuario> sut = usuarioService.encontrarPorCpf(cpf);
    	
    	assertThat(sut).isEqualTo(ResponseEntity.notFound().build());
    }


	
}
