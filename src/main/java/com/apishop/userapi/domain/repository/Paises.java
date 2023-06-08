package com.apishop.userapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apishop.userapi.domain.entities.Pais;

@Repository
public interface Paises extends JpaRepository<Pais, Integer> {

}
