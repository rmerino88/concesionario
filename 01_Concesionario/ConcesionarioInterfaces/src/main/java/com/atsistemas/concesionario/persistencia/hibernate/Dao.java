package com.atsistemas.concesionario.persistencia.hibernate;

import java.util.Collection;

public interface Dao<E> {
		
	E consultarPorId(Integer id);
	
	Collection<E> buscarTodos();
}
