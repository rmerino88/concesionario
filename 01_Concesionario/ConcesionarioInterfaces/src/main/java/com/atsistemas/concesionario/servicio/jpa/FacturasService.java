package com.atsistemas.concesionario.servicio.jpa;

import java.util.List;

import com.atsistemas.concesionario.dtos.FacturaDto;

public interface FacturasService {

	FacturaDto alta(FacturaDto factura);
	
	void baja(FacturaDto factura);
	
	FacturaDto modificacion(FacturaDto factura);
	
	// Buscar por idFactura
	FacturaDto buscarFactura(Integer idFactura);
	
	// Buscar todas las facturas
	List<FacturaDto> buscarFacturas();
}
