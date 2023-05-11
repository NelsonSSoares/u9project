package com.ibmshop.userapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibmshop.userapi.domain.entities.Endereco;

@Repository
public interface Enderecos extends JpaRepository<Endereco, Integer> {
	
	
}
