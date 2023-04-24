package com.ibmshop.userapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibmshop.userapi.domain.entities.Pais;

@Repository
public interface Paises extends JpaRepository<Pais, Integer> {

}
