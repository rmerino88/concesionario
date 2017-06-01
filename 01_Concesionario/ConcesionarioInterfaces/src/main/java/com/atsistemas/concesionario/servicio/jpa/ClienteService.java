package com.atsistemas.concesionario.servicio.jpa;

import java.util.List;

import com.atsistemas.concesionario.dtos.ClienteDto;

public interface ClienteService {
	
	ClienteDto alta(ClienteDto cliente);
	
	void baja(ClienteDto cliente);
	
	ClienteDto modificacion(ClienteDto cliente);
	
	// Buscar por idCliente
	ClienteDto buscarCliente(Integer idCliente);
	
	// Buscar todos los clientes
	List<ClienteDto> buscarClientes();
}
