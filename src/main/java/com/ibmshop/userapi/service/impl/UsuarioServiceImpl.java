	package com.ibmshop.userapi.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibmshop.userapi.domain.dto.EnderecoDTO;
import com.ibmshop.userapi.domain.dto.UsuarioDTO;
import com.ibmshop.userapi.domain.entities.Endereco;
import com.ibmshop.userapi.domain.entities.Pais;
import com.ibmshop.userapi.domain.entities.Usuario;
import com.ibmshop.userapi.domain.enums.Pergunta;
import com.ibmshop.userapi.domain.repository.Enderecos;
import com.ibmshop.userapi.domain.repository.Paises;
import com.ibmshop.userapi.domain.repository.Usuarios;
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
	public ResponseEntity<Usuario> salvar(UsuarioDTO userDto) {
		
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
		

	    return ResponseEntity.ok(usuario);		

	}

	@Override
	public ResponseEntity<List<UsuarioDTO>> buscarTodos() {
		
		List<Usuario> usuarios = usuarioRepository.findAll();
		
		if(usuarios.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		List<UsuarioDTO> usuariosDto = usuarios.stream()
				.map(usuario -> objectMapper.convertValue(usuario, UsuarioDTO.class))
				.collect(Collectors.toList());
		
		return ResponseEntity.ok(usuariosDto);
		
	}
	
	@Override
	public ResponseEntity<Usuario> buscarPorId(Integer id) {
		
		Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
		
		if(usuarioOpt.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Usuario usuario = usuarioOpt.get();
		
		return ResponseEntity.ok(usuario);
	}
	
	//METODO SÓ TRAZ DADOS DO USUARIO, TALVEZ PQ AINDA NÃO CONSIGO LOCALIZAR
	//A CHAVE ESTRANGEIRA DE USUARIO EM ENDERECO.
	@Transactional
	@Override 
	public ResponseEntity<Usuario> atualizarUsuario(Integer id, UsuarioDTO userDto) {
		
		Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
		
		if(usuarioOpt.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Usuario usuario = usuarioOpt.get();
		usuario = objectMapper.convertValue(userDto, Usuario.class);
		usuario.setDataCriacao(usuarioOpt.get().getDataCriacao());
		usuario.setId(usuarioOpt.get().getId());
		usuario.setAtivo(Pergunta.SIM);
		usuario.setDataModificacao(LocalDate.now());
		
		usuarioRepository.save(usuario);
		 return ResponseEntity.ok(usuario);
	}

	@Override
	public ResponseEntity<Usuario> deletarUsuario(Integer id) {
		
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		
		if(usuario.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.noContent().build();
	}
	
	
	//METODO FALHANDO, NÃO TRAZ OS NOMES PASSADOS POR PARAMETRO, APARECEM SOMENTE USUARIO DE EXEMPLO EX: nome = Nome
	@Override
	public ResponseEntity<List<Usuario>> encontrarPorNome(String nome) {
		List<Usuario> usuario = usuarioRepository.findByNome(nome);
		
		if(usuario.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(usuario);
		
	}

	//PASSAR CPF COM PONTUAÇÃO
	@Override
	public ResponseEntity<Usuario> encontrarPorCpf(String cpf) {
		
		Optional<Usuario> usuarioOpt = usuarioRepository.findByCpf(cpf);
		
		if(usuarioOpt.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Usuario usuario = usuarioOpt.get();
		
		return ResponseEntity.ok(usuario);
		
	}





}
