package com.ibmshop.userapi.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibmshop.userapi.constraints.SomenteUserAtivo;
import com.ibmshop.userapi.domain.dto.UsuarioDTO;
import com.ibmshop.userapi.domain.entities.Usuario;
import com.ibmshop.userapi.domain.enums.Pergunta;
import com.ibmshop.userapi.domain.repository.Usuarios;
import com.ibmshop.userapi.service.UsuarioService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	private final Usuarios usuarioRepository;
	private final ObjectMapper objectMapper;
	
	@Override
	@Transactional
	public ResponseEntity<Usuario> salvar(UsuarioDTO userDto){
		
	Usuario usuario = objectMapper.convertValue(userDto, Usuario.class);
	
	usuario.setAtivo(Pergunta.SIM);
	usuario.setDataCriacao(LocalDate.now());
	usuario.setDataModificacao(LocalDate.now());
	usuario.setRole("USER");
	usuarioRepository.save(usuario);
	return ResponseEntity.ok(usuario); 

	}

	@Override
	public ResponseEntity<List<UsuarioDTO>> buscarTodos() {
		
		List<Usuario> usuarios = usuarioRepository.findAll();
		
		if(usuarios.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		List<Usuario> usuariosAtivos = SomenteUserAtivo.usuariosAtivosList(usuarios);
		
	    List<UsuarioDTO> usuariosDto = new ArrayList<>();
	    
	    for (Usuario usuario : usuariosAtivos) {
	        UsuarioDTO usuarioDto = objectMapper.convertValue(usuario, UsuarioDTO.class);
	        usuariosDto.add(usuarioDto);
	    }
		
		return ResponseEntity.ok(usuariosDto);
		
	}
	
	@Override
	public ResponseEntity<Usuario> buscarPorId(Integer id) {
		
		Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
		
		if(usuarioOpt.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Usuario usuario = usuarioOpt.get();
		
		if(usuario.getAtivo().equals(Pergunta.NAO)) {
			return ResponseEntity.notFound().build();
		}
		
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
		
		System.out.println(usuario);
		
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
		
		Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
		
		if(usuarioOpt.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Usuario usuario = usuarioOpt.get();
		if(usuario.getAtivo().equals(Pergunta.NAO)) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		usuario.setAtivo(Pergunta.NAO);
		usuarioRepository.save(usuario);
		return ResponseEntity.noContent().build();
		
	}
	
	
	//METODO FALHANDO, NÃO TRAZ OS NOMES PASSADOS POR PARAMETRO, APARECEM SOMENTE USUARIO DE EXEMPLO EX: nome = Nome
	@Override
	public ResponseEntity<List<Usuario>> encontrarPorNome(String nome) {
		List<Usuario> usuarios = usuarioRepository.findByNome(nome);
		
		if(usuarios.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		List<Usuario> usuariosAtivos = SomenteUserAtivo.usuariosAtivosList(usuarios);
		
		return ResponseEntity.ok(usuariosAtivos);
		
	}

	//PASSAR CPF COM PONTUAÇÃO
	@Override
	public ResponseEntity<Usuario> encontrarPorCpf(String cpf) {
		
		Optional<Usuario> usuarioOpt = usuarioRepository.findByCpf(cpf);
		
		if(usuarioOpt.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else if(usuarioOpt.get().getAtivo().equals(Pergunta.NAO)) {
			return ResponseEntity.notFound().build();
		}
		Usuario usuario = usuarioOpt.get();
		
		return ResponseEntity.ok(usuario);
		
	}

	@Override
	public ResponseEntity<Usuario> reativarUsuario(Integer id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		
		if(usuario.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else if(usuario.get().getAtivo().equals(Pergunta.SIM)) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		
		Usuario usuarioAtivo = usuario.get();
		usuarioAtivo.setAtivo(Pergunta.SIM);
		usuarioRepository.save(usuarioAtivo);
		
		return ResponseEntity.ok(usuarioAtivo);
	}





}
