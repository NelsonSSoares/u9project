package com.ibmshop.userapi.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibmshop.userapi.domain.entities.Endereco;
import com.ibmshop.userapi.domain.entities.Pais;
import com.ibmshop.userapi.domain.entities.Usuario;
import com.ibmshop.userapi.domain.enums.Pergunta;
import com.ibmshop.userapi.domain.repository.Enderecos;
import com.ibmshop.userapi.domain.repository.Paises;
import com.ibmshop.userapi.domain.repository.Usuarios;
import com.ibmshop.userapi.rest.dto.EnderecoDTO;
import com.ibmshop.userapi.rest.dto.UsuarioDTO;
import com.ibmshop.userapi.service.UsuarioService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	private final Usuarios usuarioRepository;
	private final Enderecos enderecoRepository;
	private final Paises paisRepository;
	private final ObjectMapper objectMapper;
	
	@Override
	@Transactional
	public Usuario salvar(UsuarioDTO userDto) {
		
		System.out.println("USERDTO PARAM: " + userDto);
		
		List<Endereco> enderecos = new ArrayList<Endereco>();
		
		for (EnderecoDTO enderecoDto : userDto.getEndereco()) {
			
			System.out.println("USERDTO.GETEND: " +userDto.getEndereco());
			Endereco endereco = objectMapper.convertValue(enderecoDto, Endereco.class);
			System.out.println("ENDERECO MAPPER: " +endereco);
			Pais pais = objectMapper.convertValue(endereco.getPais(), Pais.class); 
			System.out.println("PAIS MAPPER: " +pais);
			paisRepository.save(pais);
			System.out.println(pais);
			endereco.setPais(pais);
			
			if(endereco.getEnderecoPadrao().equals(Pergunta.NAO) ) {
				endereco.setEnderecoPadrao(Pergunta.SIM);   
			}
			enderecos.add(endereco);
		}
		
		enderecoRepository.saveAll(enderecos);
		
		Usuario usuario = objectMapper.convertValue(userDto, Usuario.class);	
		
		usuario.setEndereco(enderecos);
		usuario.setDataCriacao(LocalDate.now());
		usuario.setDataModificacao(LocalDate.now());
		usuario.setAtivo(Pergunta.SIM);
		//CRIAR METODO POSTERIORMENTE PARA VERIFICAR SE A RESPOSTA É NEGATIVA NA HORA DA CRIACAO DE USER
//		if(usuario.getAtivo().equals(Pergunta.NAO)) {
//			usuario.setAtivo(Pergunta.SIM);
//		}
		System.out.println(usuario.getEndereco());
		System.out.println(usuario);
		
		usuarioRepository.save(usuario);
		

	    return usuario;		

	}

	@Override
	public List<Usuario> buscarTodos() {
		return usuarioRepository.findAll();
		
	}
	
	@Override
	public Usuario buscarPorId(Integer id) {
		return usuarioRepository.findById(id)
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario não encontrado"));
		
	}
	
	//METODO SÓ TRAZ DADOS DO USUARIO, TALVEZ PQ AINDA NÃO CONSIGO LOCALIZAR
	//A CHAVE ESTRANGEIRA DE USUARIO EM ENDERECO.
	@Transactional
	@Override 
	public void atualizarUsuario(Integer id, UsuarioDTO userDto) {
		
		Usuario usuario = objectMapper.convertValue(userDto, Usuario.class);
		System.out.println(usuario);
		 usuarioRepository.findById(id)
				.map(usuarioExistente -> {
					usuario.setId(usuarioExistente.getId());
					usuario.setDataCriacao(usuarioExistente.getDataCriacao());
					usuario.setEndereco(usuarioExistente.getEndereco());
					usuario.setDataModificacao(LocalDate.now());
					usuario.setAtivo(Pergunta.SIM);
					System.out.println(usuario);
					usuarioRepository.save(usuario);
					return usuarioExistente;
				}).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario Não encontrado"));
	}

	@Override
	public void deletarUsuario(Integer id) {
		usuarioRepository.findById(id)
		.map(usuario -> {
			usuarioRepository.delete(usuario);
			return usuario;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario não encontrado"));
		
	}
	
	
	//METODO FALHANDO, NÃO TRAZ OS NOMES PASSADOS POR PARAMETRO, APARECEM SOMENTE USUARIO DE EXEMPLO EX: nome = Nome
	@Override
	public List<Usuario> encontrarPorNome(String nome) {
		List<Usuario> usuario = usuarioRepository.findByNome(nome);
//		if(usuario.isEmpty()) {
//			return (List<Usuario>) ResponseEntity.notFound().build();
//		}
		return usuario;
		
	}

	//PASSAR CPF COM PONTUAÇÃO
	@Override
	public Usuario encontrarPorCpf(String cpf) {
		
		return usuarioRepository.findByCpf(cpf);
		
	}





}
