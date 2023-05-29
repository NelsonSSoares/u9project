package com.ibmshop.userapi.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ibmshop.userapi.domain.dto.EnderecoDTO;
import com.ibmshop.userapi.domain.entities.Endereco;
import com.ibmshop.userapi.service.EnderecoService;


import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Tag(name = "IBM Shop - Shopping API")
@RequiredArgsConstructor
@RestController
@RequestMapping("ibm/enderecos")
public class EnderecoController {
	
	private final EnderecoService service;
	
	@GetMapping
	public ResponseEntity<List<Endereco>> getAll(){
		return null;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Endereco> save(@RequestBody @Valid EnderecoDTO endDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Endereco> update(@PathVariable("id") Integer id,@RequestBody @Valid EnderecoDTO endDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Endereco> delete(@PathVariable("id") Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	
}
