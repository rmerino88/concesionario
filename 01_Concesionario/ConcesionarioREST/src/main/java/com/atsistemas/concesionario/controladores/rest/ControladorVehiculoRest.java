package com.atsistemas.concesionario.controladores.rest;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.atsistemas.concesionario.dtos.VehiculoDto;
import com.atsistemas.concesionario.servicio.jpa.VehiculosService;

@RestController
@RequestMapping(
		path="/vehiculo", 
		//La respuesta, el @ResponseBody
		produces= {
				MediaType.APPLICATION_JSON_VALUE
		},
		consumes={
				MediaType.APPLICATION_JSON_VALUE
		}
)
public class ControladorVehiculoRest {

	// Es necesario autoinyectar el servicio para que llame al metodo deseado
	private VehiculosService vehiculosServiceRest;

	@Autowired
	public ControladorVehiculoRest(VehiculosService vehiculoServiceRest) {
		super();
		this.vehiculosServiceRest = vehiculoServiceRest;
	}
	
	@RequestMapping(path="/todos", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<VehiculoDto> buscarTodos(){

		LinkedList<VehiculoDto> vehiculos = new LinkedList<>(vehiculosServiceRest.buscarVehiculos());
		return vehiculos;
	}
}