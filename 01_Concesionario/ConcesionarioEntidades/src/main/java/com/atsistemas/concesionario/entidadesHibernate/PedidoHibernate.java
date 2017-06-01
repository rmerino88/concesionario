package com.atsistemas.concesionario.entidadesHibernate;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.atsistemas.concesionario.utils.entidades.EstadoPedido;

@Entity
@Table(schema="APP",name="PEDIDOS")
//TODO @Access(AccessType.FIELD)
public class PedidoHibernate implements Serializable {
	
	private static final long serialVersionUID = -5232617058066404043L;

	/**
	 * Para la inclusión de las anotaciones de JPA @Entity y @Id 
	 * es necesario añadir en el pom.xml la librería hibernate-core
	 */
	
	@Id
	@Column(name="ID_PEDIDO")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="ID_CLIENTE")
	private Integer idCliente;
	
	@Column(name="ID_COMERCIAL")
	private Integer idComercial;
	
	@Column(name="ID_VEHICULO")
	private Integer idVehiculo;
	
	@Column(name="FECHA_ALTA")
	private Date fecha;
	
	@Column(name="ESTADO")
	private EstadoPedido estado;
	
	@Column(name="ID_FACTURA")
	private Integer idFactura;

	// Por que al usar Hibernate, este nos lo exige, 
	// es el unico que es capaz de emplear
	public PedidoHibernate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PedidoHibernate(Integer id, Integer idCliente, Integer idComercial, Integer idVehiculo, Date fecha,
			EstadoPedido estado, Integer idFactura) {
		super();
		this.id = id;
		this.idCliente = idCliente;
		this.idComercial = idComercial;
		this.idVehiculo = idVehiculo;
		this.fecha = fecha;
		this.estado = estado;
		this.idFactura = idFactura;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Integer getIdComercial() {
		return idComercial;
	}

	public void setIdComercial(Integer idComercial) {
		this.idComercial = idComercial;
	}

	public Integer getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(Integer idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public EstadoPedido getEstado() {
		return estado;
	}

	public void setEstado(EstadoPedido estado) {
		this.estado = estado;
	}

	public Integer getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCliente == null) ? 0 : idCliente.hashCode());
		result = prime * result + ((idComercial == null) ? 0 : idComercial.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((idFactura == null) ? 0 : idFactura.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idVehiculo == null) ? 0 : idVehiculo.hashCode());
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
		PedidoHibernate other = (PedidoHibernate) obj;
		if (idCliente == null) {
			if (other.idCliente != null)
				return false;
		} else if (!idCliente.equals(other.idCliente))
			return false;
		if (idComercial == null) {
			if (other.idComercial != null)
				return false;
		} else if (!idComercial.equals(other.idComercial))
			return false;
		if (estado != other.estado)
			return false;
		if (idFactura == null) {
			if (other.idFactura != null)
				return false;
		} else if (!idFactura.equals(other.idFactura))
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
		if (idVehiculo == null) {
			if (other.idVehiculo != null)
				return false;
		} else if (!idVehiculo.equals(other.idVehiculo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", idCliente=" + idCliente + ", idComercial=" + idComercial + ", idVehiculo="
				+ idVehiculo + ", fecha=" + fecha + ", estado=" + estado + ", idFactura=" + idFactura + "]";
	}
	
}
