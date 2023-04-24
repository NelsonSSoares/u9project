package com.ibmshop.userapi.rest.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ibmshop.userapi.domain.entities.Usuario;
import com.ibmshop.userapi.rest.dto.UsuarioDTO;
import com.ibmshop.userapi.service.UsuarioService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("ibm/usuarios")
public class UsuarioController {
	
	
	//POSSIVEL USAR RESPONSEENTITY PARA RETONAR HTTPSTATUS E HEADERS
	/*REFATORAR CLASSE*/
	
	
	private final UsuarioService service;
	
		
	@GetMapping
	public List<Usuario> findAll(){
		return service.buscarTodos();
	}
	
	@GetMapping("{id}")
	public Usuario findById(@PathVariable Integer id) {
		return service
				.buscarPorId(id);
	}
	
	//METODO FALHANDO
	@GetMapping("/name/{nome}")
	public List<Usuario> findByName(@PathVariable String nome) {
		return service.encontrarPorNome(nome);
				
	}
	
	@GetMapping("/cpf/{cpf}")
	public Usuario findByCpf(@PathVariable String cpf) {
		return service.encontrarPorCpf(cpf);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario save(@RequestBody @Valid UsuarioDTO userDto) {
		Usuario usuario = service.salvar(userDto); 
		return usuario;
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		service.deletarUsuario(id);
		
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable Integer id, @RequestBody @Valid UsuarioDTO userDto) {
		service.atualizarUsuario(id, userDto);
		//.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario Não encontrado"));
	}
	
		
}
