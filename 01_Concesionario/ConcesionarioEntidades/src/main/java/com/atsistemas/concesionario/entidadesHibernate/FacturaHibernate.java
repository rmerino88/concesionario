package com.atsistemas.concesionario.entidadesHibernate;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.atsistemas.concesionario.utils.entidades.EstadoFactura;

@Entity
@Table(schema="APP",name="FACTURAS")
// TODO @Access(AccessType.FIELD)
public class FacturaHibernate implements Serializable {
	
	private static final long serialVersionUID = 4900824688324325741L;
	
	/**
	 * Para la inclusión de las anotaciones de JPA @Entity y @Id 
	 * es necesario añadir en el pom.xml la librería hibernate-core
	 */
	
	@Id
	@Column(name="ID_FACTURA")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="FECHA_ALTA")
	private Date fecha;
	
	@Column(name="TOTAL")
	private BigDecimal total;
	
	@Column(name="ID_PEDIDO")
	private Integer idPedido;

	@Column(name="ESTADO")
	private EstadoFactura estado;

	public FacturaHibernate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FacturaHibernate(Integer id, Date fecha, BigDecimal total, Integer idPedido, EstadoFactura estado) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.total = total;
		this.idPedido = idPedido;
		this.estado = estado;
	}

	// Por que al usar Hibernate, este nos lo exige, 
	// es el unico que es capaz de emplear
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public EstadoFactura getEstado() {
		return estado;
	}

	public void setEstado(EstadoFactura estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idPedido == null) ? 0 : idPedido.hashCode());
		result = prime * result + ((total == null) ? 0 : total.hashCode());
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
		FacturaHibernate other = (FacturaHibernate) obj;
		if (estado != other.estado)
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
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
		if (total == null) {
			if (other.total != null)
				return false;
		} else if (!total.equals(other.total))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Factura [id=" + id + ", fecha=" + fecha + ", total=" + total + ", idPedido=" + idPedido + ", estado="
				+ estado + "]";
	}
	
}
