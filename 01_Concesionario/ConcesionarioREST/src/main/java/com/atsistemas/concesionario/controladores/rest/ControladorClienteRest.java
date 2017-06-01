package com.atsistemas.concesionario.controladores.rest;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atsistemas.concesionario.dtos.ClienteDto;
import com.atsistemas.concesionario.servicio.jpa.ClienteService;


@RestController
@RequestMapping(
		path="/cliente", 
		//La respuesta, el @ResponseBody
		produces= {
				MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE
		},
		consumes={
				MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE
		}
)
public class ControladorClienteRest {

	// Es necesario autoinyectar el servicio para que llame al metodo deseado
	private ClienteService clienteService;

	@Autowired
	public ControladorClienteRest(ClienteService clienteService) {
		super();
		this.clienteService = clienteService;
	}
	
	@RequestMapping(path="/all", method=RequestMethod.GET, consumes=MediaType.ALL_VALUE)
	public ResponseEntity<List<ClienteDto>> consultar(@RequestParam(required=false) Integer edad){
		
		LinkedList<ClienteDto> clientes = new LinkedList<ClienteDto>(clienteService.buscarClientes());
		
		if(edad!= null){
			// TODO Consultar por edad
			System.out.println("El valor edad es iguas a "+ edad.toString());
		} else {
			// TODO Consultar Todos
		}
		
		return new ResponseEntity<>(clientes, HttpStatus.OK);
}
	
//	@RequestMapping(path="/{id}", method=RequestMethod.GET, consumes=MediaType.ALL_VALUE)
//	@RequestMapping(path="/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
//	@RequestMapping(path="/{id}", method=RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_VALUE)

//	@RequestMapping(path="/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<ClienteDto> consultarPorId(@PathVariable("id") Integer id){
//		// TODO retornar codigos de respuesta
//		ClienteDto clienteDto = clienteService.buscarCliente(new Integer(106));
//		return new ResponseEntity<>(clienteDto, HttpStatus.OK);
//	}
}