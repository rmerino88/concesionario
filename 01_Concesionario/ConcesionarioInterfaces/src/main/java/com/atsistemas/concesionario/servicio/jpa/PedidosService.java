package com.atsistemas.concesionario.servicio.jpa;

import java.util.List;

import com.atsistemas.concesionario.dtos.PedidoDto;

public interface PedidosService {

	PedidoDto alta(PedidoDto pedido);
	
	void baja(PedidoDto pedido);
	
	PedidoDto modificacion(PedidoDto pedido);
	
	//Buscar pedido por id
	PedidoDto buscarPedido(Integer idPedido);
	
	// Buscar todos los pedidos
	List<PedidoDto> buscarPedidos();
	
}
