package com.atsistemas.concesionario.entidadesHibernate;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.atsistemas.concesionario.interfaces.entidades.Persona;
import com.atsistemas.concesionario.utils.entidades.Perfil;

@Entity
@Table(schema="APP",name="COMERCIALES")
//TODO @Access(AccessType.FIELD)
public class ComercialHibernate implements Persona,Serializable {

	private static final long serialVersionUID = 2579288119715021313L;

	/**
	 * Para la inclusión de las anotaciones de JPA @Entity y @Id 
	 * es necesario añadir en el pom.xml la librería hibernate-core
	 */
	
	@Id
	@Column(name="ID_COMERCIAL")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="TELEFONO")
	private String telefono;
	
	@Column(name="CORREO")
	private String correo;
	
	@Column(name="PERFIL")
	private Perfil perfil;
	
	public ComercialHibernate(Integer id, String nombre, String telefono, String correo, Perfil perfil) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
		this.perfil = perfil;
	}

	// Por que al usar Hibernate, este nos lo exige, 
	// es el unico que es capaz de emplear
	public ComercialHibernate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((correo == null) ? 0 : correo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((perfil == null) ? 0 : perfil.hashCode());
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComercialHibernate other = (ComercialHibernate) obj;
		if (correo == null) {
			if (other.correo != null)
				return false;
		} else if (!correo.equals(other.correo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (perfil != other.perfil)
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comercial [id=" + id + ", nombre=" + nombre + ", telefono=" + telefono + ", correo=" + correo
				+ ", perfil=" + perfil + "]";
	}
	
}
