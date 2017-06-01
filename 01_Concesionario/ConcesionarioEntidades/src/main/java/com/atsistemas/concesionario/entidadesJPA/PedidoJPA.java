package com.atsistemas.concesionario.entidadesJPA;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.atsistemas.concesionario.dtos.PedidoDto;
import com.atsistemas.concesionario.dtos.VehiculoDto;
import com.atsistemas.concesionario.utils.entidades.EstadoPedido;

@Entity
@Table(schema="APP",name="PEDIDOS")
//TODO @Access(AccessType.FIELD)
public class PedidoJPA implements Serializable {
	
	private static final long serialVersionUID = -5232617058066404043L;

	/**
	 * Para la inclusión de las anotaciones de JPA @Entity y @Id 
	 * es necesario añadir en el pom.xml la librería hibernate-core
	 */
	
	@Id
	@Column(name="ID_PEDIDO")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	// No permite meter column en un @ManyToOne
	// pone el nombre por defecto
	//@Column(name="CLIENTE")
	@ManyToOne
	//@JoinColumn(name="ID_CLIENTE", unique=true, nullable=false)
	private ClienteJPA cliente;
	
	// No permite meter column en un @ManyToOne
	// pone el nombre por defecto
	// @Column(name="COMERCIAL")
	@ManyToOne
	//@JoinColumn(name="ID_COMERCIAL", unique=true,nullable=false)
	private ComercialJPA comercial;
	
	@Column(name="VEHICULO")
	@OneToMany(fetch = FetchType.EAGER, mappedBy="pedido")
	private List<VehiculoJPA> vehiculos;
	
	@Column(name="FECHA_ALTA")
	private Date fecha;
	
	@Column(name="ESTADO")
	private EstadoPedido estado;
	
	// No permite meter column en un @OneToOne
	// pone el nombre por defecto
	// @Column(name="FACTURA")
	@OneToOne
	@JoinColumn(name="ID_FACTURA")
	private FacturaJPA factura;

	public PedidoJPA() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PedidoJPA(Integer id, ClienteJPA cliente, ComercialJPA comercial, List<VehiculoJPA> vehiculos, Date fecha,
			EstadoPedido estado, FacturaJPA factura) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.comercial = comercial;
		this.vehiculos = vehiculos;
		this.fecha = fecha;
		this.estado = estado;
		this.factura = factura;
	}
	
	public PedidoJPA(PedidoDto pedido) {
		super();
		this.id = pedido.getId();
		this.cliente = new ClienteJPA(pedido.getCliente());
		this.comercial = new ComercialJPA(pedido.getComercial());
		this.fecha = pedido.getFecha();
		this.estado = pedido.getEstado();
		this.factura = new FacturaJPA(pedido.getFactura());
		
		ArrayList<VehiculoDto> vehiculosListDto = pedido.getVehiculos();
		ArrayList<VehiculoJPA> vehiculosListJPA = new ArrayList<VehiculoJPA>();
		for (VehiculoDto pedidoDto : vehiculosListDto) {
			vehiculosListJPA.add(new VehiculoJPA(pedidoDto));
		}
		this.vehiculos = vehiculosListJPA;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ClienteJPA getCliente() {
		return cliente;
	}

	public void setCliente(ClienteJPA cliente) {
		this.cliente = cliente;
	}

	public ComercialJPA getComercial() {
		return comercial;
	}

	public void setComercial(ComercialJPA comercial) {
		this.comercial = comercial;
	}

	public List<VehiculoJPA> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(List<VehiculoJPA> vehiculos) {
		this.vehiculos = vehiculos;
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

	public FacturaJPA getFactura() {
		return factura;
	}

	public void setFactura(FacturaJPA factura) {
		this.factura = factura;
	}

	@Override
	public String toString() {
		return "PedidoJPA [id=" + id + ", cliente=" + cliente + ", comercial=" + comercial + ", vehiculos=" + vehiculos
				+ ", fecha=" + fecha + ", estado=" + estado + ", factura=" + factura + "]";
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
		PedidoJPA other = (PedidoJPA) obj;
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
	
	
}
