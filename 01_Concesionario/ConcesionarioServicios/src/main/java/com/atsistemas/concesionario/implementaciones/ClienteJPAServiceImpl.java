package com.atsistemas.concesionario.implementaciones;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.atsistemas.concesionario.dtos.ClienteDto;
import com.atsistemas.concesionario.entidadesJPA.ClienteJPA;
import com.atsistemas.concesionario.persistencia.jpa.ClienteJpaDao;
import com.atsistemas.concesionario.servicio.jpa.ClienteService;

@Component
public class ClienteJPAServiceImpl implements ClienteService {
	
	ClienteJpaDao clienteJpaDao;
	
	// Si no realizamos este Autowired el elemento ClienteJpaDao = null
	@Autowired
	public ClienteJPAServiceImpl(ClienteJpaDao clienteJpaDao) {
		super();
		this.clienteJpaDao = clienteJpaDao;
	}

	@Override
	public ClienteDto alta(ClienteDto cliente) {
		ClienteJPA clienteJPA = new ClienteJPA(cliente);
		clienteJPA = clienteJpaDao.save(clienteJPA);
		cliente.setId(clienteJPA.getId());
		return cliente;
	}

	@Override
	public void baja(ClienteDto cliente) {
		clienteJpaDao.delete(cliente.getId());	
	}

	@Override
	public ClienteDto modificacion(ClienteDto cliente) {
		ClienteJPA clienteJPA = new ClienteJPA(cliente);
		clienteJPA = clienteJpaDao.save(clienteJPA);
		return cliente;
	}

	@Override
	public ClienteDto buscarCliente(Integer idCliente) {
		ClienteJPA clienteJPA = clienteJpaDao.findOne(idCliente);
		// TODO mirar que devuelve en caso de no encontrar nada
		ClienteDto cliente = clienteJPA != null ? new ClienteDto(clienteJPA) : null;
		return cliente;
	}

	@Override
	public List<ClienteDto> buscarClientes() {
		List<ClienteJPA> listaClientes = clienteJpaDao.findAll();
		List<ClienteDto> listaClientesDto = new ArrayList<ClienteDto>();
		for (ClienteJPA clienteJPA : listaClientes) {
			ClienteDto cliente = clienteJPA != null ? new ClienteDto(clienteJPA) : null;
			if(cliente!=null){
				listaClientesDto.add(cliente);
			}
		}
		return listaClientesDto;
	}

}
