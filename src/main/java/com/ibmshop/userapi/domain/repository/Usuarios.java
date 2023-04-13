package com.ibmshop.userapi.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ibmshop.userapi.domain.entities.Usuario;

public interface Usuarios extends JpaRepository<Usuario, Integer> {
	
	@Query(value = "select u from usuario where u.cpf = :cpf", nativeQuery = true)
	List<Usuario> findByCpf(@Param("cpf") String cpf);
	
	@Query(value = "select * from usuario where nome like %nome%  ", nativeQuery = true)
	Optional<Usuario> findByNome(@Param("nome") String nome);
	
	
	
	// void deleteByNome(String nome);
}
