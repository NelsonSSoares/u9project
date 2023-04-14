package com.ibmshop.userapi.service.impl;

import org.springframework.stereotype.Service;

import com.ibmshop.userapi.domain.entities.Endereco;
import com.ibmshop.userapi.domain.entities.Pais;
import com.ibmshop.userapi.domain.entities.Usuario;
import com.ibmshop.userapi.domain.repository.Enderecos;
import com.ibmshop.userapi.domain.repository.Paises;
import com.ibmshop.userapi.domain.repository.Usuarios;
import com.ibmshop.userapi.rest.dto.EnderecoDTO;
import com.ibmshop.userapi.rest.dto.PaisDTO;
import com.ibmshop.userapi.rest.dto.UsuarioDTO;
import com.ibmshop.userapi.service.UsuarioService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	private final Usuarios usuarioRepository;
	private final Enderecos enderecoRepository;
	private final Paises	paisRepository;
	
	@Override
	@Transactional
	public Usuario salvar(UsuarioDTO userDto, EnderecoDTO endDto, PaisDTO paisDto) {
		
		// --> USUARIO
		Usuario usuario = new Usuario();
		
		usuario.setNome(userDto.getNome());
		usuario.setSobrenome(userDto.getSobrenome());
		usuario.setCpf(userDto.getCpf());
		usuario.setTelefone(userDto.getTelefone());
		
		//--> ENDERECO
		Endereco endereco = new Endereco();
		endereco.setRua(endDto.getRua());
		endereco.setNumero(endDto.getNumero());
		endereco.setComplemento(endDto.getComplemento());
		endereco.setCep(endDto.getCep());
		endereco.setBairro(endDto.getBairro());
		endereco.setCidade(endDto.getCidade());
		endereco.setEstado(endDto.getEstado());
//		if(endDto.getEnderecoPadrao()) {
//			
//		}
		//--> PAIS
		Pais pais = new Pais();
		pais.setCodigo(paisDto.getCodigo());
		pais.setNome(paisDto.getNome());
		
		
		
		
		
		
		return null;
	} 
	  
}
