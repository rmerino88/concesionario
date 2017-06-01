package com.atsistemas.concesionario.aplicacion.rest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan({"com.atsistemas.concesionario.controladores.rest","com.atsistemas.concesionario.implementaciones"})
public class ConfiguracionREST {

}
