package com.apishop.userapi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.apishop.userapi.domain.dto.EnderecoDTO;
import com.apishop.userapi.domain.entities.Endereco;
import com.apishop.userapi.domain.entities.Pais;
import com.apishop.userapi.domain.repository.Enderecos;
import com.apishop.userapi.domain.repository.Paises;
import com.apishop.userapi.domain.repository.Usuarios;
import com.apishop.userapi.service.EnderecoService;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "ENDERECO_SERVICE")
@AllArgsConstructor
@Service
public class EnderecoServiceImpl implements EnderecoService {

	private final Enderecos enderecoRepository;
	private final Usuarios usuarioRepositoty;
	private final Paises paisRepository;
	private final ObjectMapper objectMapper;
	
	@Override
	public ResponseEntity<List<Endereco>> obterTodos() {
		List<Endereco> endereco = enderecoRepository.findAll();
		return ResponseEntity.ok(endereco);
	}
	@Override
	public ResponseEntity<EnderecoDTO> buscarPorId(Integer id) {
		Optional<Endereco> enderecoOpt = enderecoRepository.findById(id);
		if(enderecoOpt.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Endereco endereco = enderecoOpt.get();
		EnderecoDTO endDto = objectMapper.convertValue(endereco, EnderecoDTO.class);
		return ResponseEntity.ok(endDto);
	}
	@Transactional
	@Override
	public ResponseEntity<Endereco> salvar(EnderecoDTO endDto) {
		
		Endereco endereco = objectMapper.convertValue(endDto, Endereco.class);
		Pais pais = objectMapper.convertValue(endereco.getPais(), Pais.class); 
		paisRepository.save(pais);
		endereco.setPais(pais);
		System.out.println(endereco);
		log.info("ENDERECO ANTES DE SALVAR: " + endereco);
		if(usuarioRepositoty.findById(endereco.getUsuarioId()) == null) {
			
			return ResponseEntity.notFound().build();
		}
		enderecoRepository.save(endereco);
		return ResponseEntity.status(HttpStatus.CREATED).body(endereco);
	}
	
	@Transactional
	@Override
	public ResponseEntity<Endereco> atualizar(Integer id, EnderecoDTO endDto) {
		Optional<Endereco> enderecoOpt = enderecoRepository.findById(id);
		if(enderecoOpt.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Endereco endereco = enderecoOpt.get();
		endereco.setId(id);
		endereco = objectMapper.convertValue(endDto, Endereco.class);
		Pais pais = objectMapper.convertValue(endereco.getPais(), Pais.class);
		endereco.setPais(pais);
		paisRepository.save(pais);
		enderecoRepository.save(endereco);
		return ResponseEntity.ok(endereco);
	}
	@Transactional
	@Override
	public ResponseEntity<Endereco> deletar(Integer id) {
		Optional<Endereco> enderecoOpt = enderecoRepository.findById(id);
		
		if(enderecoOpt.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		enderecoRepository.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	
	
	@Override
	public ResponseEntity<List<Endereco>> obterPorUsuarioId(Integer id) {
		List<Endereco> enderecos = enderecoRepository.findByUsuarioId(id);
		return ResponseEntity.ok(enderecos);
	}


	
}
