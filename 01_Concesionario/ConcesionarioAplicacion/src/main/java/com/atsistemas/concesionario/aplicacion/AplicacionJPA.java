package com.atsistemas.concesionario.aplicacion;

import java.util.ArrayList;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.atsistemas.concesionario.configuracion.ConfiguracionJPA;
import com.atsistemas.concesionario.entidadesJPA.ClienteJPA;
import com.atsistemas.concesionario.entidadesJPA.ComercialJPA;
import com.atsistemas.concesionario.entidadesJPA.PedidoJPA;
import com.atsistemas.concesionario.persistencia.jpa.ClienteJpaDao;
import com.atsistemas.concesionario.persistencia.jpa.ComercialJpaDao;
import com.atsistemas.concesionario.utils.entidades.Perfil;

public class AplicacionJPA {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfiguracionJPA.class);

		ClienteJpaDao clienteJpaDao = context.getBean(ClienteJpaDao.class);
		
		ComercialJpaDao comericalJpaDao = context.getBean(ComercialJpaDao.class);

		
		ComercialJPA comercialJPA = new ComercialJPA(new Integer(01),"Comercial 1","944380535","comercial1@gmail.com",Perfil.COMERCIAL,new ArrayList<PedidoJPA>(),new ArrayList<ClienteJPA>());

		comericalJpaDao.save(comercialJPA);
		
		System.out.println("El número de elementos en BBDD en la tabla Comercial es: " + comericalJpaDao.findAll().size());

		ClienteJPA clienteJPA = new ClienteJPA(new Integer(01), new ArrayList<PedidoJPA>(), "Cliente 1", "685700482", "cliente1@atsistemas.com",comercialJPA);

		clienteJpaDao.save(clienteJPA);
		
		System.out.println("El número de elementos en BBDD en la tabla Clientes es: " + clienteJpaDao.findAll().size());

		clienteJPA = new ClienteJPA(new Integer(02), new ArrayList<PedidoJPA>(), "Cliente 2", "685700482", "cliente2@atsistemas.com",comercialJPA);
		
		clienteJpaDao.save(clienteJPA);
		
		clienteJPA = new ClienteJPA(new Integer(03), new ArrayList<PedidoJPA>(), "Cliente 3", "685700482", "cliente2@atsistemas.com",comercialJPA);
		
		clienteJpaDao.save(clienteJPA);

		System.out.println("El número de elementos en BBDD en la tabla Clientes es: " + clienteJpaDao.findAll().size());

		System.out.println("El nombre del Cliente con id 1 es: " + clienteJpaDao.findOne(new Integer(1)).getNombre());
		comercialJPA = clienteJpaDao.findOne(new Integer(1)).getComercial();
		System.out.println("El nombre del Comercial del Cliente con id 1 es: " + clienteJpaDao.findOne(new Integer(1)).getComercial().getNombre());
		System.out.println("El nombre del Cliente con id 2 es: " + clienteJpaDao.findOne(new Integer(2)).getNombre());
		System.out.println("El nombre del Cliente con id 3 es: " + clienteJpaDao.findOne(new Integer(3)).getNombre());
		
		System.out.println("Finaliza aplicacion");
	}
	
}
