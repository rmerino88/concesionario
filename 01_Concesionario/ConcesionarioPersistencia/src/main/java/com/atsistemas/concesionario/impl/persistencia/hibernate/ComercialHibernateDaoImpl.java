package com.atsistemas.concesionario.impl.persistencia.hibernate;

import java.util.Collection;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.atsistemas.concesionario.entidadesHibernate.ComercialHibernate;
import com.atsistemas.concesionario.persistencia.hibernate.ComercialHibernateDao;

// La etiqueta component no necesita de ningún repositorio en especial ya que está incluida dentro de Spring
// de modos que es spring quien reconoce este bean
@Component
public class ComercialHibernateDaoImpl implements ComercialHibernateDao{
	
	// Dentro del repositorio de Hibernate
	private SessionFactory sessionFactory;
	
	// Autoinyeccion del SesionFactory --> irá en el configurador 
	@Autowired
	public ComercialHibernateDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	
	
	public void insertar(ComercialHibernate comercial) {
		// Actualiza el valor del Id en el comercial o hay que hacerlo??
		sessionFactory.getCurrentSession().persist(comercial);	
		sessionFactory.getCurrentSession().flush();
	}
	
	public void modificar(ComercialHibernate comercial) {
		sessionFactory.getCurrentSession().update(comercial);
		sessionFactory.getCurrentSession().flush();
	}
	
	public void eliminar(ComercialHibernate comercial) {
		sessionFactory.getCurrentSession().delete(comercial);
		sessionFactory.getCurrentSession().flush();
	}
	
	
	@Override
	public ComercialHibernate consultarPorId(Integer id) {
		ComercialHibernate comercial = sessionFactory.getCurrentSession().find(ComercialHibernate.class, id);
		return comercial;
	}

	@Override
	public Collection<ComercialHibernate> buscarTodos() {
		return sessionFactory.getCurrentSession().createQuery("from COMERCIALES", ComercialHibernate.class).getResultList();
	}
	

}
