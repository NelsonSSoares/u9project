package com.ibmshop.userapi.rest.controller;

import java.util.Optional;

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
import org.springframework.web.server.ResponseStatusException;

import com.ibmshop.userapi.domain.entities.Endereco;
import com.ibmshop.userapi.domain.entities.Usuario;
import com.ibmshop.userapi.domain.repository.Usuarios;
import com.ibmshop.userapi.rest.dto.EnderecoDTO;
import com.ibmshop.userapi.rest.dto.PaisDTO;
import com.ibmshop.userapi.rest.dto.UsuarioDTO;
import com.ibmshop.userapi.service.UsuarioService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("ibm/usuarios")
public class UsuarioController {
	
	
	/*REFATORAR CLASSE*/
	
	
	
	
	private final Usuarios usuarios;
	private final UsuarioService service;
	
	@GetMapping("{id}")
	public Usuario findById(@PathVariable Integer id) {
		return usuarios
				.findById(id)
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Usuario não encontrado"));
	}
	
	@GetMapping("{nome}")
	public Optional<Usuario> findByName(@PathVariable String nome) {
		return Optional.of(usuarios.findByNome(nome)
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Usuario não encontrado")));
	}
	

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Integer salvar(@RequestBody UsuarioDTO userDto) {
		
		System.out.println(userDto);

		
		Usuario usuario = service.salvar(userDto); //MUDAR PARAMETROS DO SERVICE E SERVICEIMPL
		System.out.println(usuario);
		return usuario.getId();
	}
	
//	@PostMapping
//	@ResponseStatus(HttpStatus.CREATED)
//	public Usuario salvar(@RequestBody @Valid Usuario usuario) {
//		return usuarios.save(usuario);
//	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		usuarios.findById(id)
		.map(usuario -> {
			usuarios.delete(usuario);
			return usuario;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario Não encontrado"));
	}
	
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable Integer id, @RequestBody @Valid Usuario usuario) {
		usuarios.findById(id)
		.map(usuarioExistente -> {
			usuario.setId(usuarioExistente.getId());
			usuarios.save(usuario);
			return usuarioExistente;
		}).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario Não encontrado"));
	}
	
	
}
