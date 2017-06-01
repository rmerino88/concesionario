package com.atsistemas.concesionario.servicio.jpa;

import java.util.List;

import com.atsistemas.concesionario.dtos.ComercialDto;

public interface ComercialService {
	
	ComercialDto alta(ComercialDto comercial);
	
	void baja(ComercialDto comercial);
	
	ComercialDto modificacion(ComercialDto comercial);
	
	// Buscar por idCliente
	ComercialDto buscarComercial(Integer idComercial);
	
	// Buscar todos los clientes
	List<ComercialDto> buscarComerciales();
}