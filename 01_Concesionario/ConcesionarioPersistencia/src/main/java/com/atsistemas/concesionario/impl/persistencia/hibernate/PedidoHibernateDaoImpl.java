package com.atsistemas.concesionario.impl.persistencia.hibernate;

import java.util.Collection;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.atsistemas.concesionario.entidadesHibernate.PedidoHibernate;
import com.atsistemas.concesionario.persistencia.hibernate.PedidoHibernateDao;

// La etiqueta component no necesita de ningún repositorio en especial ya que está incluida dentro de Spring
// de modos que es spring quien reconoce este bean
@Component
public class PedidoHibernateDaoImpl implements PedidoHibernateDao{
	
	// Dentro del repositorio de Hibernate
	private SessionFactory sessionFactory;
	
	// Autoinyeccion del SesionFactory --> irá en el configurador 
	@Autowired
	public PedidoHibernateDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	
	
	public void insertar(PedidoHibernate pedido) {
		// Actualiza el valor del Id en el pedido o hay que hacerlo??
		sessionFactory.getCurrentSession().persist(pedido);	
		sessionFactory.getCurrentSession().flush();
	}
	
	public void modificar(PedidoHibernate pedido) {
		sessionFactory.getCurrentSession().update(pedido);
		sessionFactory.getCurrentSession().flush();
	}
	
	public void eliminar(PedidoHibernate pedido) {
		sessionFactory.getCurrentSession().delete(pedido);
		sessionFactory.getCurrentSession().flush();
	}
	
	
	@Override
	public PedidoHibernate consultarPorId(Integer id) {
		PedidoHibernate pedido = sessionFactory.getCurrentSession().find(PedidoHibernate.class, id);
		return pedido;
	}

	@Override
	public Collection<PedidoHibernate> buscarTodos() {
		return sessionFactory.getCurrentSession().createQuery("from FACTURAS", PedidoHibernate.class).getResultList();
	}
	

}
