package com.ibmshop.userapi.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ibmshop.userapi.domain.entities.Usuario;

@Repository
public interface Usuarios extends JpaRepository<Usuario, Integer> {
	
	
	
	@Query(value = "select * from usuario u where u.cpf = :cpf", nativeQuery = true)
	Usuario findByCpf(@Param("cpf") String cpf);
	
	@Query(value = "select * from usuario u where u.nome like '%nome%'  ", nativeQuery = true)
	List<Usuario> findByNome(@Param("nome") String nome);
	

}
