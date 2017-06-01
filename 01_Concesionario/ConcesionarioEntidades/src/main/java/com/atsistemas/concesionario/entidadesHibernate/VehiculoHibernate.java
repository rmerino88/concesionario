package com.atsistemas.concesionario.entidadesHibernate;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="APP",name="VEHICULOS")
//TODO @Access(AccessType.FIELD)
public class VehiculoHibernate implements Serializable {

	private static final long serialVersionUID = -3925687879399745210L;

	/**
	 * Para la inclusión de las anotaciones de JPA @Entity y @Id 
	 * es necesario añadir en el pom.xml la librería hibernate-core
	 */
	
	@Id
	@Column(name="ID_VEHICULO")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="ID_PEDIDO")
	private Integer idPedido;

	@Column(name="DESCRIPCION")
	private String descripcion;
	
	@Column(name="MODELO")
	private String modelo;
	
	@Column(name="COLOR")
	private String color;

	@Column(name="MOTOR")
	private String motor;
	
	@Column(name="PRECIO")
	private BigDecimal precio;

	// Por que al usar Hibernate, este nos lo exige, 
	// es el unico que es capaz de emplear
	public VehiculoHibernate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VehiculoHibernate(Integer id, Integer idPedido, String descripcion, String modelo, String color, String motor,
			BigDecimal precio) {
		super();
		this.id = id;
		this.idPedido = idPedido;
		this.descripcion = descripcion;
		this.modelo = modelo;
		this.color = color;
		this.motor = motor;
		this.precio = precio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}	
	
	
	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idPedido == null) ? 0 : idPedido.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		result = prime * result + ((motor == null) ? 0 : motor.hashCode());
		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
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
		VehiculoHibernate other = (VehiculoHibernate) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idPedido == null) {
			if (other.idPedido != null)
				return false;
		} else if (!idPedido.equals(other.idPedido))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		if (motor == null) {
			if (other.motor != null)
				return false;
		} else if (!motor.equals(other.motor))
			return false;
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!precio.equals(other.precio))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vehiculo [id=" + id + ", idPedido=" + idPedido + ", descripcion=" + descripcion + ", modelo=" + modelo
				+ ", color=" + color + ", motor=" + motor + ", precio=" + precio + "]";
	}
	
}
