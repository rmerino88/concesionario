package com.atsistemas.concesionario.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.atsistemas.concesionario.entidadesJPA.FacturaJPA;
import com.atsistemas.concesionario.utils.entidades.EstadoFactura;

@XmlRootElement
public class FacturaDto implements Serializable {

	private static final long serialVersionUID = 6810323553027566885L;

	private Integer id;

	private Date fecha;

	private BigDecimal total;

	// private PedidoDto pedido;
	private PedidoDto pedido;

	private EstadoFactura estado;

	public FacturaDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FacturaDto(Integer id, Date fecha, BigDecimal total, PedidoDto pedido, EstadoFactura estado) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.total = total;
		this.pedido = pedido;
		this.estado = estado;
	}
	
	public FacturaDto(FacturaJPA facturaJPA) {
		super();
		this.id = facturaJPA.getId();
		this.fecha = facturaJPA.getFecha();
		this.total = facturaJPA.getTotal();
		this.pedido =  new PedidoDto(facturaJPA.getPedido());
		this.estado = facturaJPA.getEstado();
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

	public PedidoDto getPedido() {
		return pedido;
	}

	public void setPedido(PedidoDto pedido) {
		this.pedido = pedido;
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
		FacturaDto other = (FacturaDto) obj;
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

	@Override
	public String toString() {
		return "FacturaDto [id=" + id + ", fecha=" + fecha + ", total=" + total + ", pedido=" + pedido + ", estado="
				+ estado + "]";
	}


	
}
