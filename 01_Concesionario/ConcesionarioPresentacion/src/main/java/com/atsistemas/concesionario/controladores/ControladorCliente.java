package com.atsistemas.concesionario.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atsistemas.concesionario.dtos.ClienteDto;
import com.atsistemas.concesionario.servicio.jpa.ClienteService;

@Controller
//Para poder incluir esta anotacion es necesario incluir el repositorio  spring-mvc
@RequestMapping("/cliente")
public class ControladorCliente {
	
	// Es necesario autoinyectar el servicio para que llame al metodo deseado
	// pero no en la constructora
	private ClienteService clienteService;

	@Autowired
	public ControladorCliente(ClienteService clienteService) {
		super();
		this.clienteService = clienteService;
	}

	@RequestMapping(path = "/alta" , method = RequestMethod.GET)
	public String altaCliente(Model model){	
		model.addAttribute("cliente", new ClienteDto());
		model.addAttribute("accion","ALTA");
		return "detalleCliente";
	}
	
	@RequestMapping(path = "/alta" , method = RequestMethod.POST)
	public String procesarAltaCliente(@ModelAttribute @Valid ClienteDto cliente,Model model){	
		ClienteDto newCliente = clienteService.alta(cliente);
		model.addAttribute("cliente", newCliente);
		model.addAttribute("accion","ALTACLIENTE");
		return "mensajeOK";
	}

	@RequestMapping(path = "/modificacion" , method = RequestMethod.GET)
	public String modificacionCliente(Integer idCliente, Model model){	
		ClienteDto cliente = clienteService.buscarCliente(idCliente);
		model.addAttribute("cliente",cliente);
		model.addAttribute("accion","MODIFICACION");
		return "detalleCliente";
	}
	
	@RequestMapping(path = "/modificacion" , method = RequestMethod.POST)
	public String procesarModificacionCliente(@ModelAttribute @Valid ClienteDto cliente, Model model){	
		clienteService.modificacion(cliente);
		model.addAttribute("cliente",cliente);
		model.addAttribute("accion","MODIFICACIONCLIENTE");
		return "mensajeOK";
	}
	
	@RequestMapping(path = "/baja" , method = RequestMethod.GET)
	public String bajaCliente(Integer idCliente, Model model){	
		ClienteDto cliente = clienteService.buscarCliente(idCliente);
		model.addAttribute("cliente",cliente);
		model.addAttribute("accion","BAJA");
		return "detalleCliente";
	}
	
	@RequestMapping(path = "/baja" , method = RequestMethod.POST)
	public String procesarBajaCliente(@ModelAttribute @Valid ClienteDto cliente,Model model){	
		clienteService.baja(cliente);
		model.addAttribute("cliente",cliente);
		model.addAttribute("accion","BAJACLIENTE");
		return "mensajeOK";
	}
	

	@RequestMapping(path = "/buscar" , method = RequestMethod.POST)
	public String procesarBajaCliente(Integer idCliente, Model model){	
		ClienteDto clienteEncontrado = clienteService.buscarCliente(idCliente);
		model.addAttribute("accion","CONSULTA");
		//No se si lo devuelve null o devuelve un elemento vacío
		if(clienteEncontrado!=null){
			return "listadoClientes";
		}else{
			model.addAttribute("cliente");
			return "noEncontrado";
		}
	}
}
