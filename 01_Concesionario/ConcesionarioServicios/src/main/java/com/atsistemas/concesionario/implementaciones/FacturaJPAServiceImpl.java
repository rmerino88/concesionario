package com.atsistemas.concesionario.implementaciones;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.atsistemas.concesionario.dtos.FacturaDto;
import com.atsistemas.concesionario.entidadesJPA.FacturaJPA;
import com.atsistemas.concesionario.persistencia.jpa.FacturaJpaDao;
import com.atsistemas.concesionario.servicio.jpa.FacturasService;

@Component
public class FacturaJPAServiceImpl implements FacturasService {
	
	FacturaJpaDao facturaJpaDao;
	
	// Si no realizamos este Autowired el elemento FacturaJpaDao = null
	@Autowired
	public FacturaJPAServiceImpl(FacturaJpaDao facturaJpaDao) {
		super();
		this.facturaJpaDao = facturaJpaDao;
	}

	@Override
	public FacturaDto alta(FacturaDto factura) {
		FacturaJPA facturaJPA = new FacturaJPA(factura);
		facturaJPA = facturaJpaDao.save(facturaJPA);
		factura.setId(facturaJPA.getId());
		return factura;
	}

	@Override
	public void baja(FacturaDto factura) {
		facturaJpaDao.delete(factura.getId());	
	}

	@Override
	public FacturaDto modificacion(FacturaDto factura) {
		FacturaJPA facturaJPA = new FacturaJPA(factura);
		facturaJPA = facturaJpaDao.save(facturaJPA);
		return factura;
	}

	@Override
	public FacturaDto buscarFactura(Integer idFactura) {
		FacturaJPA facturaJPA = facturaJpaDao.findOne(idFactura);
		FacturaDto factura = new FacturaDto(facturaJPA);
		return factura;
	}

	@Override
	public List<FacturaDto> buscarFacturas() {
		List<FacturaJPA> listaFacturas = facturaJpaDao.findAll();
		List<FacturaDto> listaFacturasDto = new ArrayList<FacturaDto>();
		for (FacturaJPA facturaJPA : listaFacturas) {
			FacturaDto factura = new FacturaDto(facturaJPA);
			listaFacturasDto.add(factura);
		}
		return listaFacturasDto;
	}

}
