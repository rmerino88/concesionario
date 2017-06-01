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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.FetchMode;
import org.hibernate.annotations.Fetch;

import com.atsistemas.concesionario.dtos.ClienteDto;
import com.atsistemas.concesionario.dtos.ComercialDto;
import com.atsistemas.concesionario.dtos.PedidoDto;
import com.atsistemas.concesionario.interfaces.entidades.Persona;
import com.atsistemas.concesionario.utils.entidades.Perfil;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(schema="APP",name="COMERCIALES")
//TODO @Access(AccessType.FIELD)
public class ComercialJPA implements Persona,Serializable {

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
	
	@Column(name="PEDIDOS")
	// @OneToMany Si lleva mappedBy no puede llevar @JoinColumn ni @JoinTable
	@OneToMany(fetch = FetchType.EAGER, mappedBy="comercial")
	//@Fetch(value = FetchMode.SUBSELECT)
	//@JoinColumn(name="ID_PEDIDO", unique=true)
	private List<PedidoJPA> pedidos;
	
	@Column(name="CLIENTES")
	// @OneToMany Si lleva mappedBy no puede llevar @JoinColumn ni @JoinTable
	@OneToMany(fetch = FetchType.EAGER, mappedBy="comercial")
	//@JoinColumn(name="ID_PEDIDO", unique=true)
	@JsonBackReference
	private List<ClienteJPA> clientes;
	
	public ComercialJPA() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ComercialJPA(Integer id, String nombre, String telefono, String correo, Perfil perfil,
			List<PedidoJPA> pedidos, List<ClienteJPA> clientes) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
		this.perfil = perfil;
		this.pedidos = pedidos;
		this.clientes = clientes;
	}

	public ComercialJPA(ComercialDto comercial) {
		super();
		this.id = comercial.getId();
		this.nombre = comercial.getNombre();
		this.telefono = comercial.getTelefono();
		this.correo = comercial.getCorreo();
		this.perfil = comercial.getPerfil();
		
		ArrayList<PedidoDto> pedidosListDto = comercial.getPedidos();
		ArrayList<PedidoJPA> pedidosListJPA = new ArrayList<PedidoJPA>();
		for (PedidoDto pedidoDto : pedidosListDto) {
			pedidosListJPA.add(new PedidoJPA(pedidoDto));
		}
		this.pedidos = pedidosListJPA;
		
		ArrayList<ClienteDto> clientesListDto = comercial.getClientes();
		ArrayList<ClienteJPA> clientesListJPA = new ArrayList<ClienteJPA>();
		for (ClienteDto pedidoDto : clientesListDto) {
			clientesListJPA.add(new ClienteJPA(pedidoDto));
		}
		this.clientes = clientesListJPA;
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

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public List<PedidoJPA> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<PedidoJPA> pedidos) {
		this.pedidos = pedidos;
	}

	public List<ClienteJPA> getClientes() {
		return clientes;
	}

	public void setClientes(List<ClienteJPA> clientes) {
		this.clientes = clientes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clientes == null) ? 0 : clientes.hashCode());
		result = prime * result + ((correo == null) ? 0 : correo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((pedidos == null) ? 0 : pedidos.hashCode());
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
		ComercialJPA other = (ComercialJPA) obj;
		if (clientes == null) {
			if (other.clientes != null)
				return false;
		} else if (!clientes.equals(other.clientes))
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
		return "ComercialJPA [id=" + id + ", nombre=" + nombre + ", telefono=" + telefono + ", correo=" + correo
				+ ", perfil=" + perfil + ", pedidos=" + pedidos + ", clientes=" + clientes + "]";
	}
	
}
