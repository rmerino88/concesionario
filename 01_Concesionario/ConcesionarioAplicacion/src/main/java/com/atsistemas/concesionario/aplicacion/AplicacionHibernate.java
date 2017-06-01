package com.atsistemas.concesionario.aplicacion;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.atsistemas.concesionario.configuracion.ConfiguracionHibernate;
import com.atsistemas.concesionario.entidadesHibernate.ClienteHibernate;
import com.atsistemas.concesionario.impl.persistencia.hibernate.ClienteHibernateDaoImpl;

public class AplicacionHibernate {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfiguracionHibernate.class);

		ClienteHibernateDaoImpl clienteHibDao = context.getBean(ClienteHibernateDaoImpl.class);
		
		ClienteHibernate clienteHib = new ClienteHibernate(new Integer(99),"Raul Merino","685700482","rmerino@atsistemas.com");
		
		clienteHibDao.insertar(clienteHib);

		System.out.println("El número de elementos en BBDD en la tabla Clientes es: " + clienteHibDao.buscarTodos().size());
		
		System.out.println("El resultado cuando buscamos el elemento insertado es: " + clienteHibDao.consultarPorId(new Integer(1)).getNombre());
		
		System.out.println("Finaliza aplicacion");
	}
	
}
