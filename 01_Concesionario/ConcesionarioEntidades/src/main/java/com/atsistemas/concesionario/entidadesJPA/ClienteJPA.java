package com.atsistemas.concesionario.entidadesJPA;

import java.io.Serializable;
import java.util.ArrayList;
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
import javax.persistence.Table;

import com.atsistemas.concesionario.dtos.ClienteDto;
import com.atsistemas.concesionario.dtos.PedidoDto;
import com.atsistemas.concesionario.interfaces.entidades.Persona;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(schema="APP",name="CLIENTES")
// TODO @Access(AccessType.FIELD)
public class ClienteJPA implements Persona,Serializable {

	private static final long serialVersionUID = 6306144555841288130L;

	/**
	 * Para la inclusión de las anotaciones de JPA @Entity y @Id 
	 * es necesario añadir en el pom.xml la librería hibernate-core
	 */
	
	@Id
	@Column(name="ID_CLIENTE")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="PEDIDOS")
	// @OneToMany Si lleva mappedBy no puede llevar @JoinColumn ni @JoinTable
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="ID_PEDIDO")
	private List<PedidoJPA> pedidos;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="TELEFONO")
	private String telefono;
	
	@Column(name="CORREO")
	private String correo;
	
	@ManyToOne
	@JoinColumn(name = "ID_COMERCIAL")
	@JsonManagedReference
	private ComercialJPA comercial;

	public ClienteJPA() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ClienteJPA(Integer id, List<PedidoJPA> pedidos, String nombre, String telefono, String correo,
			ComercialJPA comercial) {
		super();
		this.id = id;
		this.pedidos = pedidos;
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
		this.comercial = comercial;
	}

	public ClienteJPA(ClienteDto clienteDto) {
		super();
		this.id = clienteDto.getId();
		this.nombre = clienteDto.getNombre();
		this.telefono = clienteDto.getTelefono();
		this.correo = clienteDto.getCorreo();
		
		ArrayList<PedidoDto> pedidosListDto = clienteDto.getPedidos();
		ArrayList<PedidoJPA> pedidosListJPA = new ArrayList<PedidoJPA>();
		for (PedidoDto pedidoDto : pedidosListDto) {
			pedidosListJPA.add(new PedidoJPA(pedidoDto));
		}
		this.pedidos = pedidosListJPA;
		this.comercial = new ComercialJPA(clienteDto.getComercial());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<PedidoJPA> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<PedidoJPA> pedidos) {
		this.pedidos = pedidos;
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

	public ComercialJPA getComercial() {
		return comercial;
	}

	public void setComercial(ComercialJPA comercial) {
		this.comercial = comercial;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comercial == null) ? 0 : comercial.hashCode());
		result = prime * result + ((correo == null) ? 0 : correo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((pedidos == null) ? 0 : pedidos.hashCode());
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
		ClienteJPA other = (ClienteJPA) obj;
		if (comercial == null) {
			if (other.comercial != null)
				return false;
		} else if (!comercial.equals(other.comercial))
			return false;
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
		if (pedidos == null) {
			if (other.pedidos != null)
				return false;
		} else if (!pedidos.equals(other.pedidos))
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
		return "ClienteJPA [id=" + id + ", pedidos=" + pedidos + ", nombre=" + nombre + ", telefono=" + telefono
				+ ", correo=" + correo + ", comercial=" + comercial + "]";
	}
	
}
