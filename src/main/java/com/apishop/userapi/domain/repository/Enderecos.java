package com.apishop.userapi.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apishop.userapi.domain.entities.Endereco;

@Repository
public interface Enderecos extends JpaRepository<Endereco, Integer> {
	
	List<Endereco> findByUsuarioId(Integer usuarioId);
}
