package com.atsistemas.concesionario.entidadesJPA;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.atsistemas.concesionario.dtos.FacturaDto;
import com.atsistemas.concesionario.utils.entidades.EstadoFactura;

@Entity
@Table(schema="APP",name="FACTURAS")
// TODO @Access(AccessType.FIELD)
public class FacturaJPA implements Serializable {
	
	private static final long serialVersionUID = 4900824688324325741L;
	
	/**
	 * Para la inclusi�n de las anotaciones de JPA @Entity y @Id 
	 * es necesario a�adir en el pom.xml la librer�a hibernate-core
	 */
	
	@Id
	@Column(name="ID_FACTURA")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="FECHA_ALTA")
	private Date fecha;
	
	@Column(name="TOTAL")
	private BigDecimal total;
	
	// No permite meter column en un @OneToOne
	// pone el nombre por defecto
	//@Column(name="PEDIDO")
	@OneToOne
	@JoinColumn(name="ID_PEDIDO")
	private PedidoJPA pedido;

	@Column(name="ESTADO")
	private EstadoFactura estado;

	public FacturaJPA() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FacturaJPA(Integer id, Date fecha, BigDecimal total, PedidoJPA pedido, EstadoFactura estado) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.total = total;
		this.pedido = pedido;
		this.estado = estado;
	}
	
	public FacturaJPA(FacturaDto facturaDto) {
		super();
		this.id = facturaDto.getId();
		this.fecha = facturaDto.getFecha();
		this.total = facturaDto.getTotal();
		this.pedido = new PedidoJPA(facturaDto.getPedido());
		this.estado = facturaDto.getEstado();
	}

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

	public PedidoJPA getPedido() {
		return pedido;
	}

	public void setIdPedido(PedidoJPA pedido) {
		this.pedido = pedido;
	}

	public EstadoFactura getEstado() {
		return estado;
	}

	public void setEstado(EstadoFactura estado) {
		this.estado = estado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "FacturaJPA [id=" + id + ", fecha=" + fecha + ", total=" + total + ", pedido=" + pedido + ", estado="
				+ estado + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
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
		FacturaJPA other = (FacturaJPA) obj;
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
		if (pedido == null) {
			if (other.pedido != null)
				return false;
		} else if (!pedido.equals(other.pedido))
			return false;
		if (total == null) {
			if (other.total != null)
				return false;
		} else if (!total.equals(other.total))
			return false;
		return true;
	}
	
}
