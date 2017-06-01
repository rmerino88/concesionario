package com.atsistemas.concesionario.persistencia.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atsistemas.concesionario.entidadesJPA.FacturaJPA;

public interface FacturaJpaDao extends JpaRepository<FacturaJPA, Integer>{
	
}
