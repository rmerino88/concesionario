package com.atsistemas.concesionario.impl.persistencia.hibernate;

import java.util.Collection;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.atsistemas.concesionario.entidadesHibernate.FacturaHibernate;
import com.atsistemas.concesionario.persistencia.hibernate.FacturaHibernateDao;

// La etiqueta component no necesita de ningún repositorio en especial ya que está incluida dentro de Spring
// de modos que es spring quien reconoce este bean
@Component
public class FacturaHibernateDaoImpl implements FacturaHibernateDao{
	
	// Dentro del repositorio de Hibernate
	private SessionFactory sessionFactory;
	
	// Autoinyeccion del SesionFactory --> irá en el configurador 
	@Autowired
	public FacturaHibernateDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	
	
	public void insertar(FacturaHibernate factura) {
		// Actualiza el valor del Id en el factura o hay que hacerlo??
		sessionFactory.getCurrentSession().persist(factura);	
		sessionFactory.getCurrentSession().flush();
	}
	
	public void modificar(FacturaHibernate factura) {
		sessionFactory.getCurrentSession().update(factura);
		sessionFactory.getCurrentSession().flush();
	}
	
	public void eliminar(FacturaHibernate factura) {
		sessionFactory.getCurrentSession().delete(factura);
		sessionFactory.getCurrentSession().flush();
	}
	
	
	@Override
	public FacturaHibernate consultarPorId(Integer id) {
		FacturaHibernate factura = sessionFactory.getCurrentSession().find(FacturaHibernate.class, id);
		return factura;
	}

	@Override
	public Collection<FacturaHibernate> buscarTodos() {
		return sessionFactory.getCurrentSession().createQuery("from FACTURAS", FacturaHibernate.class).getResultList();
	}
	

}
