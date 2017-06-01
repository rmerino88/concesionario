package com.atsistemas.concesionario.persistencia.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atsistemas.concesionario.entidadesJPA.ClienteJPA;

public interface ClienteJpaDao extends JpaRepository<ClienteJPA, Integer>{
	
}

