package com.atsistemas.concesionario.aplicacion.rest;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AplicacionREST implements WebApplicationInitializer  {

	public void onStartup(ServletContext servletContext) throws ServletException {
		//Se define el contexto de spring mediante clases anotadas
		AnnotationConfigWebApplicationContext context 
				= new AnnotationConfigWebApplicationContext();
		
		// Creo que con la configuracion de la parte web es suficiente, mis mas etiquetas
		//context.setConfigLocation("com.atsistemas.concesionario.aplicacion.rest");
		context.setConfigLocation("com.atsistemas.concesionario.aplicacion.rest");
		
		//Conectamos el servlet de entrada con el contexto de spring
		DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
		
		//Interfaz que cumple un servlet que nos permite añadir mapeos
		//ServletRegistration.Dynamic addServlet = servletContext.addServlet("ds",dispatcherServlet);
		ServletRegistration.Dynamic addServlet = servletContext.addServlet("dispatcherServlet",dispatcherServlet);
		
		//Lo mapeamos
		addServlet.setLoadOnStartup(0);
		//al cambiar la URl ayudamos a diferenciar la aplicacion Rest y la Web
		addServlet.addMapping("/api/*");
		
	}

}
