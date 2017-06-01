package com.atsistemas.concesionario.persistencia.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atsistemas.concesionario.entidadesJPA.VehiculoJPA;

public interface VehiculoJpaDao extends JpaRepository<VehiculoJPA, Integer>{
	
}
