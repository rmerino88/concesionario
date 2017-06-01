package com.atsistemas.concesionario.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.atsistemas.concesionario.entidadesJPA.PedidoJPA;
import com.atsistemas.concesionario.entidadesJPA.VehiculoJPA;
import com.atsistemas.concesionario.utils.entidades.EstadoPedido;

@XmlRootElement
public class PedidoDto implements Serializable {

	private static final long serialVersionUID = -509332404256245293L;

	private Integer id;
	
	private ClienteDto cliente;
	
	private ComercialDto comercial;

	private Date fecha;

	private EstadoPedido estado;

	private FacturaDto factura;
	
	private ArrayList<VehiculoDto> vehiculos;

	public PedidoDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PedidoDto(Integer id, ClienteDto cliente, ComercialDto comercial, Date fecha, EstadoPedido estado,
			FacturaDto factura, ArrayList<VehiculoDto> vehiculos) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.comercial = comercial;
		this.fecha = fecha;
		this.estado = estado;
		this.factura = factura;
		this.vehiculos = vehiculos;
	}
	
	public PedidoDto(PedidoJPA pedidoJPA) {
		super();
		this.id = pedidoJPA.getId();
		this.cliente = new ClienteDto(pedidoJPA.getCliente());
		this.comercial = new ComercialDto(pedidoJPA.getComercial());
		this.fecha = pedidoJPA.getFecha();
		this.estado = pedidoJPA.getEstado();
		this.factura = new FacturaDto(pedidoJPA.getFactura());
		
		ArrayList<VehiculoJPA> vehiculosListJPA = (ArrayList<VehiculoJPA>) pedidoJPA.getVehiculos();
		ArrayList<VehiculoDto> vehiculosListDto = new ArrayList<VehiculoDto>();
		for (VehiculoJPA vehiculoJPA : vehiculosListJPA) {
			vehiculosListDto.add(new VehiculoDto(vehiculoJPA));
		}
		this.vehiculos = vehiculosListDto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ClienteDto getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDto cliente) {
		this.cliente = cliente;
	}

	public ComercialDto getComercial() {
		return comercial;
	}

	public void setComercial(ComercialDto comercial) {
		this.comercial = comercial;
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

	public FacturaDto getFactura() {
		return factura;
	}

	public void setFactura(FacturaDto factura) {
		this.factura = factura;
	}

	public ArrayList<VehiculoDto> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(ArrayList<VehiculoDto> vehiculos) {
		this.vehiculos = vehiculos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((comercial == null) ? 0 : comercial.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((factura == null) ? 0 : factura.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((vehiculos == null) ? 0 : vehiculos.hashCode());
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
		PedidoDto other = (PedidoDto) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (comercial == null) {
			if (other.comercial != null)
				return false;
		} else if (!comercial.equals(other.comercial))
			return false;
		if (estado != other.estado)
			return false;
		if (factura == null) {
			if (other.factura != null)
				return false;
		} else if (!factura.equals(other.factura))
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
		if (vehiculos == null) {
			if (other.vehiculos != null)
				return false;
		} else if (!vehiculos.equals(other.vehiculos))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PedidoDto [id=" + id + ", cliente=" + cliente + ", comercial=" + comercial + ", fecha=" + fecha
				+ ", estado=" + estado + ", factura=" + factura + ", vehiculos=" + vehiculos + "]";
	}
	
	
	
}
