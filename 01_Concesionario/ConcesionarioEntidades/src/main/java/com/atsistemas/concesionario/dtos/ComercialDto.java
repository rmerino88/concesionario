package com.atsistemas.concesionario.dtos;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import com.atsistemas.concesionario.entidadesJPA.ClienteJPA;
import com.atsistemas.concesionario.entidadesJPA.ComercialJPA;
import com.atsistemas.concesionario.entidadesJPA.PedidoJPA;
import com.atsistemas.concesionario.utils.entidades.Perfil;

@XmlRootElement
public class ComercialDto implements Serializable {
	
	private static final long serialVersionUID = 9167274025563404904L;

	private Integer id;

	private String nombre;

	private String telefono;

	private String correo;

	private Perfil perfil;
	
	private ArrayList<PedidoDto> pedidos;

	private ArrayList<ClienteDto> clientes;

	public ComercialDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ComercialDto(Integer id, String nombre, String telefono, String correo, Perfil perfil,
			ArrayList<PedidoDto> pedidos, ArrayList<ClienteDto> clientes) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
		this.perfil = perfil;
		this.pedidos = pedidos;
		this.clientes = clientes;
	}

	public ComercialDto(ComercialJPA comercialJPA) {
		super();
		this.id = comercialJPA.getId();
		this.nombre = comercialJPA.getNombre();
		this.telefono = comercialJPA.getTelefono();
		this.correo = comercialJPA.getCorreo();
		this.perfil = comercialJPA.getPerfil();
		
		ArrayList<PedidoJPA> pedidosListJPA = comercialJPA.getPedidos().isEmpty() ? new ArrayList<PedidoJPA>():(ArrayList<PedidoJPA>) comercialJPA.getPedidos();
		ArrayList<PedidoDto> pedidosListDto = new ArrayList<PedidoDto>();
		for (PedidoJPA pedidoJPA : pedidosListJPA) {
			pedidosListDto.add(new PedidoDto(pedidoJPA));
		}
		this.pedidos = pedidosListDto;
		
		ArrayList<ClienteJPA> clientesListJPA = comercialJPA.getClientes().isEmpty() ? new ArrayList<ClienteJPA>():(ArrayList<ClienteJPA>) comercialJPA.getClientes();
		ArrayList<ClienteDto> clientesListDto = new ArrayList<ClienteDto>();
		for (ClienteJPA clienteJPA : clientesListJPA) {
			clientesListDto.add(new ClienteDto(clienteJPA));
		}
		this.clientes = clientesListDto;
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

	public ArrayList<PedidoDto> getPedidos() {
		return pedidos;
	}

	public void setPedidos(ArrayList<PedidoDto> pedidos) {
		this.pedidos = pedidos;
	}

	public ArrayList<ClienteDto> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<ClienteDto> clientes) {
		this.clientes = clientes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
		ComercialDto other = (ComercialDto) obj;
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
		return "ComercialDto [id=" + id + ", nombre=" + nombre + ", telefono=" + telefono + ", correo=" + correo
				+ ", perfil=" + perfil + ", pedidos=" + pedidos + ", clientes=" + clientes + "]";
	}
	
}
