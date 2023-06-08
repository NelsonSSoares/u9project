package com.apishop.userapi.rest.controller;

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

import com.apishop.userapi.domain.dto.EnderecoDTO;
import com.apishop.userapi.domain.entities.Endereco;
import com.apishop.userapi.service.EnderecoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Tag(name = "Shop - User - Enderecos API")
@RequiredArgsConstructor
@RestController
@RequestMapping("api/usuarios/enderecos")
public class EnderecoController {
	
	private final EnderecoService service;
	
	@Operation(summary = "Busca todos os Enderecos cadastrados", method = "GET")	
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Busca realizada com sucesso!"),
			@ApiResponse(responseCode = "404", description = "endereco não encontrado!"),
			@ApiResponse(responseCode = "500", description = "Erro ao buscar endereço!")
	})
	@GetMapping
	public ResponseEntity<List<Endereco>> getAll(){
		return service.obterTodos();
	}
	@Operation(summary = "Busca endereco cadastrado por ID", method = "GET")	
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Busca realizada com sucesso!"),
			@ApiResponse(responseCode = "404", description = "Endereço não encontrado!"),
			@ApiResponse(responseCode = "500", description = "Erro ao buscar Endereço!")
	})
	@GetMapping("/{id}")
	public ResponseEntity<EnderecoDTO> getBydId(@PathVariable("id") Integer id){
		return service.buscarPorId(id);
	}
	
	@Operation(summary = "Busca endereco  por ID de Usuario", method = "GET")	
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Busca realizada com sucesso!"),
			@ApiResponse(responseCode = "404", description = "Usuário não encontrado!"),
			@ApiResponse(responseCode = "500", description = "Erro ao buscar usuário!")
	})
	@GetMapping("byUser/{id}")
	public ResponseEntity<List<Endereco>> getAddressByUserId(@PathVariable("id")Integer id){
		return service.obterPorUsuarioId(id);
	}

	@Operation(summary = "Metodo para cadastrar novo Endereco", method = "POST")	
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Endereco cadastrado com sucesso!!"),
			@ApiResponse(responseCode = "400", description = "Parametros inválidos!"),
			@ApiResponse(responseCode = "401", description = "Usuário não autenticado!"),
			@ApiResponse(responseCode = "422", description = "Dados de requisição inválido"),
			@ApiResponse(responseCode = "500", description = "Erro ao cadastrar Endereco!"),
	})
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Endereco> save(@RequestBody @Valid EnderecoDTO endDto) {
		return service.salvar(endDto);
	}
	
	@Operation(summary = "Metodo para cadastrar novo Endereco", method = "POST")	
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Endereco cadastrado com sucesso!!"),
			@ApiResponse(responseCode = "400", description = "Parametros inválidos!"),
			@ApiResponse(responseCode = "401", description = "Usuário não autenticado!"),
			@ApiResponse(responseCode = "422", description = "Dados de requisição inválido"),
			@ApiResponse(responseCode = "500", description = "Erro ao cadastrar Endereco!"),
	})
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Endereco> update(@PathVariable("id") Integer id,@RequestBody @Valid EnderecoDTO endDto) {
		return service.atualizar(id, endDto);
	}
	
	@Operation(summary = "Metodo para excluir usuário existente", method = "DELETE")	
	@ApiResponses(value = {
			@ApiResponse(responseCode = "204", description = "Endereco excluido com sucesso!!"),
			@ApiResponse(responseCode = "400", description = "Parametros inválidos!"),
			@ApiResponse(responseCode = "401", description = "Usuário não autenticado!"),
	})
	@DeleteMapping("/{id}")
	public ResponseEntity<Endereco> delete(@PathVariable("id") Integer id) {
		return service.deletar(id);
	}
	
	

	
}
