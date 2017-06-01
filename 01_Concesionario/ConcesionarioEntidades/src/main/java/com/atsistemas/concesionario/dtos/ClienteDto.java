package com.atsistemas.concesionario.dtos;

import java.io.Serializable;
import java.util.ArrayList;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import com.atsistemas.concesionario.entidadesJPA.ClienteJPA;
import com.atsistemas.concesionario.entidadesJPA.PedidoJPA;

@XmlRootElement(name="cliente")
public class ClienteDto implements Serializable{
	
	private static final long serialVersionUID = -7844403541457942723L;

	private Integer id;
	@NotNull
	private String nombre;
	@NotNull
	private String telefono;
	@NotNull
	private String correo;
	
	private ArrayList<PedidoDto> pedidos;
	
	private ComercialDto comercial;

	public ClienteDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClienteDto(Integer id, String nombre, String telefono, String correo, ArrayList<PedidoDto> pedidos, ComercialDto comercial) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
		this.pedidos = pedidos;
		this.comercial=comercial;
	}
	
	public ClienteDto(ClienteJPA clienteJPA) {
		super();
		this.id = clienteJPA.getId();
		this.nombre = clienteJPA.getNombre();
		this.telefono = clienteJPA.getTelefono();
		this.correo = clienteJPA.getCorreo();

		ArrayList<PedidoJPA> pedidosListJPA = clienteJPA.getPedidos().isEmpty() ? new ArrayList<PedidoJPA>():(ArrayList<PedidoJPA>) clienteJPA.getPedidos();
		ArrayList<PedidoDto> pedidosListDto = new ArrayList<PedidoDto>();
		for (PedidoJPA pedidoJPA : pedidosListJPA) {
			pedidosListDto.add(new PedidoDto(pedidoJPA));
		}
		this.pedidos = pedidosListDto;
		this.comercial=new ComercialDto(clienteJPA.getComercial());
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

	public ArrayList<PedidoDto> getPedidos() {
		return pedidos;
	}

	public void setPedidos(ArrayList<PedidoDto> pedidos) {
		this.pedidos = pedidos;
	}

	public ComercialDto getComercial() {
		return comercial;
	}

	public void setComercial(ComercialDto comercial) {
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
		ClienteDto other = (ClienteDto) obj;
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
		return "ClienteDto [id=" + id + ", nombre=" + nombre + ", telefono=" + telefono + ", correo=" + correo
				+ ", pedidos=" + pedidos + ", comercial=" + comercial + "]";
	}
	
}
