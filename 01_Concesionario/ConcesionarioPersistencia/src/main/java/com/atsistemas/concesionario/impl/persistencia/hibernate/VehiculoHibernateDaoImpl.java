package com.atsistemas.concesionario.impl.persistencia.hibernate;

import java.util.Collection;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.atsistemas.concesionario.entidadesHibernate.VehiculoHibernate;
import com.atsistemas.concesionario.persistencia.hibernate.VehiculoHibernateDao;

// La etiqueta component no necesita de ningún repositorio en especial ya que está incluida dentro de Spring
// de modos que es spring quien reconoce este bean
@Component
public class VehiculoHibernateDaoImpl implements VehiculoHibernateDao{
	
	// Dentro del repositorio de Hibernate
	private SessionFactory sessionFactory;
	
	// Autoinyeccion del SesionFactory --> irá en el configurador 
	@Autowired
	public VehiculoHibernateDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	
	
	public void insertar(VehiculoHibernate vehiculo) {
		// Actualiza el valor del Id en el vehiculo o hay que hacerlo??
		sessionFactory.getCurrentSession().persist(vehiculo);	
		sessionFactory.getCurrentSession().flush();
	}
	
	public void modificar(VehiculoHibernate vehiculo) {
		sessionFactory.getCurrentSession().update(vehiculo);
		sessionFactory.getCurrentSession().flush();
	}
	
	public void eliminar(VehiculoHibernate vehiculo) {
		sessionFactory.getCurrentSession().delete(vehiculo);
		sessionFactory.getCurrentSession().flush();
	}
	
	
	@Override
	public VehiculoHibernate consultarPorId(Integer id) {
		VehiculoHibernate vehiculo = sessionFactory.getCurrentSession().find(VehiculoHibernate.class, id);
		return vehiculo;
	}

	@Override
	public Collection<VehiculoHibernate> buscarTodos() {
		return sessionFactory.getCurrentSession().createQuery("from FACTURAS", VehiculoHibernate.class).getResultList();
	}
	

}
