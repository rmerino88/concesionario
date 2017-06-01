package com.atsistemas.concesionario.implementaciones;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.atsistemas.concesionario.dtos.VehiculoDto;
import com.atsistemas.concesionario.entidadesJPA.VehiculoJPA;
import com.atsistemas.concesionario.persistencia.jpa.VehiculoJpaDao;
import com.atsistemas.concesionario.servicio.jpa.VehiculosService;

@Component
public class VehiculoJPAServiceImpl implements VehiculosService {
	
	VehiculoJpaDao vehiculoJpaDao;
	
	// Si no realizamos este Autowired el elemento VehiculoJpaDao = null
	@Autowired
	public VehiculoJPAServiceImpl(VehiculoJpaDao vehiculoJpaDao) {
		super();
		this.vehiculoJpaDao = vehiculoJpaDao;
	}

	@Override
	public VehiculoDto alta(VehiculoDto vehiculo) {
		VehiculoJPA vehiculoJPA = new VehiculoJPA(vehiculo);
		vehiculoJPA = vehiculoJpaDao.save(vehiculoJPA);
		vehiculo.setId(vehiculoJPA.getId());
		return vehiculo;
	}

	@Override
	public void baja(VehiculoDto vehiculo) {
		vehiculoJpaDao.delete(vehiculo.getId());	
	}

	@Override
	public VehiculoDto modificacion(VehiculoDto vehiculo) {
		VehiculoJPA vehiculoJPA = new VehiculoJPA(vehiculo);
		vehiculoJPA = vehiculoJpaDao.save(vehiculoJPA);
		return vehiculo;
	}

	@Override
	public VehiculoDto buscarVehiculo(Integer idVehiculo) {
		VehiculoJPA vehiculoJPA = vehiculoJpaDao.findOne(idVehiculo);
		VehiculoDto vehiculo = new VehiculoDto(vehiculoJPA);
		return vehiculo;
	}

	@Override
	public List<VehiculoDto> buscarVehiculos() {
		List<VehiculoJPA> listaVehiculos = vehiculoJpaDao.findAll();
		List<VehiculoDto> listaVehiculosDto = new ArrayList<VehiculoDto>();
		for (VehiculoJPA vehiculoJPA : listaVehiculos) {
			VehiculoDto vehiculo = new VehiculoDto(vehiculoJPA);
			listaVehiculosDto.add(vehiculo);
		}
		return listaVehiculosDto;
	}

}
