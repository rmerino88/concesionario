package com.atsistemas.concesionario.impl.persistencia.hibernate;

import java.util.Collection;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.atsistemas.concesionario.entidadesHibernate.ClienteHibernate;
import com.atsistemas.concesionario.persistencia.hibernate.ClienteHibernateDao;

// La etiqueta component no necesita de ningún repositorio en especial ya que está incluida dentro de Spring
// de modos que es spring quien reconoce este bean
@Component
@Transactional
public class ClienteHibernateDaoImpl implements ClienteHibernateDao{
	
	// Dentro del repositorio de Hibernate
	private SessionFactory sessionFactory;
	
	// Autoinyeccion del SesionFactory --> irá en el configurador 
	@Autowired
	public ClienteHibernateDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	
	
	public void insertar(ClienteHibernate cliente) {
		// Actualiza el valor del Id en el cliente o hay que hacerlo??
		sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().save(cliente);	
		sessionFactory.getCurrentSession().flush();
	}
	
	public void modificar(ClienteHibernate cliente) {
		sessionFactory.getCurrentSession().update(cliente);
		sessionFactory.getCurrentSession().flush();
	}
	
	public void eliminar(ClienteHibernate cliente) {
		sessionFactory.getCurrentSession().delete(cliente);
		sessionFactory.getCurrentSession().flush();
	}
	
	
	@Override
	public ClienteHibernate consultarPorId(Integer id) {
		ClienteHibernate cliente = sessionFactory.getCurrentSession().find(ClienteHibernate.class, id);
		return cliente;
	}

	@Override
	public Collection<ClienteHibernate> buscarTodos() {
		return sessionFactory.getCurrentSession().createQuery("select c from ClienteHibernate c",ClienteHibernate.class).getResultList();

	}
	

}
