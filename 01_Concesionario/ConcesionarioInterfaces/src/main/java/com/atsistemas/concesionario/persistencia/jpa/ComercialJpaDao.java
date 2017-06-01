package com.atsistemas.concesionario.persistencia.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atsistemas.concesionario.entidadesJPA.ComercialJPA;

public interface ComercialJpaDao extends JpaRepository<ComercialJPA, Integer>{
	
}

