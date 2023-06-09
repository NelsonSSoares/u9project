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

import com.apishop.userapi.domain.dto.UsuarioDTO;
import com.apishop.userapi.domain.entities.Usuario;
import com.apishop.userapi.service.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Tag(name = "Shop - User API")
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "api/usuarios")
public class UsuarioController {
	

	private final UsuarioService service;
	
	@Operation(summary = "Busca todos os Usuários cadastrados", method = "GET")	
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Busca realizada com sucesso!"),
			@ApiResponse(responseCode = "404", description = "Usuário não encontrado!"),
			@ApiResponse(responseCode = "500", description = "Erro ao buscar usuário!")
	})
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> findAll(){
		return service.buscarTodos();
	}
	@Operation(summary = "Busca usuario cadastrado por ID", method = "GET")	
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Busca realizada com sucesso!"),
			@ApiResponse(responseCode = "404", description = "Usuário não encontrado!"),
			@ApiResponse(responseCode = "500", description = "Erro ao buscar usuário!")
	})
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable("id") Integer id) {
		return service
				.buscarPorId(id);
	}
	
	//METODO FALHANDO
	@Operation(summary = "Busca usuarios cadastrados por Nome", method = "GET")	
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Busca realizada com sucesso!"),
			@ApiResponse(responseCode = "404", description = "Usuário não encontrado!"),
			@ApiResponse(responseCode = "500", description = "Erro ao buscar usuário!")
	})
	@GetMapping("/name/{nome}")
	public ResponseEntity<List<Usuario>> findByName(@PathVariable("nome") String nome) {
		return service.encontrarPorNome(nome);
				
	}
	
	@Operation(summary = "Busca usuario cadastrado por CPF", method = "GET")	
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Busca realizada com sucesso!"),
			@ApiResponse(responseCode = "404", description = "Usuário não encontrado!"),
			@ApiResponse(responseCode = "500", description = "Erro ao buscar usuário!")
	})
	@GetMapping("/cpf/{cpf}")
	public ResponseEntity<Usuario> findByCpf(@PathVariable("cpf") String cpf) {
		return service.encontrarPorCpf(cpf);
	}
	
	@Operation(summary = "Metodo para cadastrar novo usuário", method = "POST")	
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Usuário atualizado com sucesso!!"),
			@ApiResponse(responseCode = "400", description = "Parametros inválidos!"),
			@ApiResponse(responseCode = "401", description = "Usuário não autenticado!"),
			@ApiResponse(responseCode = "422", description = "Dados de requisição inválido"),
			@ApiResponse(responseCode = "500", description = "Erro ao atualizar usuário!"),
	})
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Usuario> save(@RequestBody @Valid UsuarioDTO userDto) { 
		return service.salvar(userDto);
	}
	
	@Operation(summary = "Metodo para excluir usuário existente", method = "DELETE")	
	@ApiResponses(value = {
			@ApiResponse(responseCode = "204", description = "Usuário excluido com sucesso!!"),
			@ApiResponse(responseCode = "400", description = "Parametros inválidos!"),
			@ApiResponse(responseCode = "401", description = "Usuário não autenticado!"),
	})
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Usuario> delete(@PathVariable("id") Integer id) {
		return service.deletarUsuario(id);
		
	}
	
	@Operation(summary = "Metodo para atualizar usuário existente", method = "PUT")	
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Usuário atualizado com sucesso!!"),
			@ApiResponse(responseCode = "400", description = "Parametros inválidos!"),
			@ApiResponse(responseCode = "401", description = "Usuário não autenticado!"),
			@ApiResponse(responseCode = "422", description = "Dados de requisição inválido"),
			@ApiResponse(responseCode = "500", description = "Erro ao atualizar usuário!"),
	})
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Usuario> update(@PathVariable Integer id, @RequestBody @Valid UsuarioDTO userDto) {
		return service.atualizarUsuario(id, userDto);
	}
	@Operation(summary = "Metodo para reativar usuário", method = "PUT")	
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Usuário reativado com sucesso!!"),
			@ApiResponse(responseCode = "401", description = "Usuário não autenticado!"),
			@ApiResponse(responseCode = "409", description = "Usuário já ativo!"),
			@ApiResponse(responseCode = "500", description = "Erro ao atualizar usuário!"),
	})
	@PutMapping("enable/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Usuario> reactivateUser(@PathVariable("id") Integer id){
		return service.reativarUsuario(id);
	}
	
		
}
