package com.atsistemas.concesionario.aplicacion.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AplicacionWeb implements WebApplicationInitializer  {

	public void onStartup(ServletContext servletContext) throws ServletException {
		//Se define el contexto de spring mediante clases anotadas
		AnnotationConfigWebApplicationContext context 
				= new AnnotationConfigWebApplicationContext();
		
		context.setConfigLocation("com.atsistemas.concesionario.aplicacion.web");
		
		//Conectamos el servlet de entrada con el contexto de spring
		DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
		
		//Interfaz que cumple un servlet que nos permite añadir mapeos
		//ServletRegistration.Dynamic addServlet = servletContext.addServlet("ds",dispatcherServlet);
		ServletRegistration.Dynamic addServlet = servletContext.addServlet("dispatcherServlet",dispatcherServlet);
		
		//Lo mapeamos
		addServlet.setLoadOnStartup(0);
		addServlet.addMapping("/");
		
	}	
}
