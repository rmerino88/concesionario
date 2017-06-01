package com.atsistemas.concesionario.servicio.jpa;

import java.util.List;

import com.atsistemas.concesionario.dtos.VehiculoDto;

public interface VehiculosService {
	
	VehiculoDto alta(VehiculoDto vehiculo);
	
	void baja(VehiculoDto vehiculo);
	
	VehiculoDto modificacion(VehiculoDto vehiculo);
	
	// Buscar vehiculo por id
	VehiculoDto buscarVehiculo(Integer idVehiculo);
	
	// Buscar todos los vehiculos
	List<VehiculoDto> buscarVehiculos();
}
