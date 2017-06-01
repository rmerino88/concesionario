package com.atsistemas.concesionario.implementaciones;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.atsistemas.concesionario.dtos.ComercialDto;
import com.atsistemas.concesionario.entidadesJPA.ComercialJPA;
import com.atsistemas.concesionario.persistencia.jpa.ComercialJpaDao;
import com.atsistemas.concesionario.servicio.jpa.ComercialService;

@Component
public class ComercialJPAServiceImpl implements ComercialService {
	
	ComercialJpaDao comercialJpaDao;
	
	// Si no realizamos este Autowired el elemento ClienteJpaDao = null
	@Autowired
	public ComercialJPAServiceImpl(ComercialJpaDao comercialJpaDao) {
		super();
		this.comercialJpaDao = comercialJpaDao;
	}
	
	@Override
	public ComercialDto alta(ComercialDto comercial) {
		ComercialJPA comercialJPA = new ComercialJPA(comercial);
		comercialJPA = comercialJpaDao.save(comercialJPA);
		comercial.setId(comercialJPA.getId());
		return comercial;
	}

	@Override
	public void baja(ComercialDto comercial) {
		comercialJpaDao.delete(comercial.getId());	
	}

	@Override
	public ComercialDto modificacion(ComercialDto comercial) {
		ComercialJPA comercialJPA = new ComercialJPA(comercial);
		comercialJPA = comercialJpaDao.save(comercialJPA);
		return comercial;
	}

	@Override
	public ComercialDto buscarComercial(Integer idComercial) {
		ComercialJPA comercialJPA = comercialJpaDao.findOne(idComercial);
		// TODO mirar que devuelve en caso de no encontrar nada
		ComercialDto comercial = comercialJPA != null ? new ComercialDto(comercialJPA) : null;
		return comercial;
	}

	@Override
	public List<ComercialDto> buscarComerciales() {
		List<ComercialJPA> listaComercial = comercialJpaDao.findAll();
		List<ComercialDto> listaComercialDto = new ArrayList<ComercialDto>();
		for (ComercialJPA comercialJPA : listaComercial) {
			ComercialDto comercial = comercialJPA != null ? new ComercialDto(comercialJPA) : null;
			if(comercial!=null){
				listaComercialDto.add(comercial);
			}
		}
		return listaComercialDto;
	}



}
