package com.ibmshop.userapi.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibmshop.userapi.domain.entities.Endereco;
import com.ibmshop.userapi.domain.entities.Pais;
import com.ibmshop.userapi.domain.entities.Usuario;
import com.ibmshop.userapi.domain.enums.Pergunta;
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
	private final ObjectMapper objectMapper;
	
	@Override
	@Transactional
	public Usuario salvar(UsuarioDTO userDto, EnderecoDTO endDto, PaisDTO paisDto) {
		
		Usuario usuario = objectMapper.convertValue(paisDto, Usuario.class);
		Endereco endereco = objectMapper.convertValue(endDto, Endereco.class);
		Pais pais = objectMapper.convertValue(paisDto, Pais.class);
		
		//--> USUARIO
		usuario.setDataCriacao(LocalDate.now());
		usuario.setDataModificacao(LocalDate.now());
		usuario.setAtivo(Pergunta.SIM);
		
		//---> ENDERECO
		
		if(endDto.getEnderecoPadrao().equals(Pergunta.NAO) ) {
			endereco.setEnderecoPadrao(Pergunta.SIM);   
		}
		
		//--> FINALIZACAO METODO
		
	    paisRepository.save(pais);

	    endereco.setPaisId(pais);

	    enderecoRepository.save(endereco);

	    List<Endereco> enderecos = new ArrayList<Endereco>();
	    enderecos.add(endereco);
	    usuario.setEndereco(enderecos);

	    return usuarioRepository.save(usuario);

		
//		// --> USUARIO
//		Usuario usuario = new Usuario();
//		
//		usuario.setNome(userDto.getNome());
//		usuario.setSobrenome(userDto.getSobrenome());
//		usuario.setCpf(userDto.getCpf());
//		usuario.setTelefone(userDto.getTelefone());
//		usuario.setDataCriacao(LocalDate.now());
//		usuario.setDataModificacao(LocalDate.now());
//		usuario.setAtivo(Pergunta.SIM);
//		//--> ENDERECO
//		Endereco endereco = new Endereco();
//		endereco.setRua(endDto.getRua());
//		endereco.setNumero(endDto.getNumero());
//		endereco.setComplemento(endDto.getComplemento());
//		endereco.setCep(endDto.getCep());
//		endereco.setBairro(endDto.getBairro());
//		endereco.setCidade(endDto.getCidade());
//		endereco.setEstado(endDto.getEstado());
//		if(endDto.getEnderecoPadrao().equals(Pergunta.NAO) ) {
//			endereco.setEnderecoPadrao(Pergunta.SIM);   
//		}
//			
//		//--> PAIS
//		Pais pais = new Pais();
//		pais.setCodigo(paisDto.getCodigo());
//		pais.setNome(paisDto.getNome());
//		
//		//-----------------------------------
//		endereco.setPaisId(pais);
//		List<Endereco> enderecos = new ArrayList<Endereco>();
//		enderecos.add(endereco);
//		usuario.setEndereco(enderecos);
//		
//		
//		
//		
//		return usuario;
	} 
	  
}
