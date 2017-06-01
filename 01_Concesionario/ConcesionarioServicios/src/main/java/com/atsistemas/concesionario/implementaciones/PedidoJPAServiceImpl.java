package com.atsistemas.concesionario.implementaciones;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.atsistemas.concesionario.dtos.PedidoDto;
import com.atsistemas.concesionario.entidadesJPA.PedidoJPA;
import com.atsistemas.concesionario.persistencia.jpa.PedidoJpaDao;
import com.atsistemas.concesionario.servicio.jpa.PedidosService;

@Component
public class PedidoJPAServiceImpl implements PedidosService {
	
	PedidoJpaDao pedidoJpaDao;
	
	// Si no realizamos este Autowired el elemento PedidoJpaDao = null
	@Autowired
	public PedidoJPAServiceImpl(PedidoJpaDao pedidoJpaDao) {
		super();
		this.pedidoJpaDao = pedidoJpaDao;
	}

	@Override
	public PedidoDto alta(PedidoDto pedido) {
		PedidoJPA pedidoJPA = new PedidoJPA(pedido);
		pedidoJPA = pedidoJpaDao.save(pedidoJPA);
		pedido.setId(pedidoJPA.getId());
		return pedido;
	}

	@Override
	public void baja(PedidoDto pedido) {
		pedidoJpaDao.delete(pedido.getId());	
	}

	@Override
	public PedidoDto modificacion(PedidoDto pedido) {
		PedidoJPA pedidoJPA = new PedidoJPA(pedido);
		pedidoJPA = pedidoJpaDao.save(pedidoJPA);
		return pedido;
	}

	@Override
	public PedidoDto buscarPedido(Integer idPedido) {
		PedidoJPA pedidoJPA = pedidoJpaDao.findOne(idPedido);
		PedidoDto pedido = new PedidoDto(pedidoJPA);
		return pedido;
	}

	@Override
	public List<PedidoDto> buscarPedidos() {
		List<PedidoJPA> listaPedidos = pedidoJpaDao.findAll();
		List<PedidoDto> listaPedidosDto = new ArrayList<PedidoDto>();
		for (PedidoJPA pedidoJPA : listaPedidos) {
			PedidoDto pedido = new PedidoDto(pedidoJPA);
			listaPedidosDto.add(pedido);
		}
		return listaPedidosDto;
	}

}
