package com.atsistemas.concesionario.dtos;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

import com.atsistemas.concesionario.entidadesJPA.VehiculoJPA;

@XmlRootElement(name="vehiculo")
public class VehiculoDto implements Serializable {

	private static final long serialVersionUID = -6032415338402909341L;

	private Integer id;

	private String descripcion;

	private String modelo;

	private String color;

	private String motor;

	private BigDecimal precio;

	private PedidoDto pedido;

	public VehiculoDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VehiculoDto(Integer id, String descripcion, String modelo, String color, String motor, BigDecimal precio,
			PedidoDto pedido) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.modelo = modelo;
		this.color = color;
		this.motor = motor;
		this.precio = precio;
		this.pedido = pedido;
	}

	public VehiculoDto(VehiculoJPA vehiculoJPA) {
		super();
		this.id = vehiculoJPA.getId();
		this.descripcion = vehiculoJPA.getDescripcion();
		this.modelo = vehiculoJPA.getModelo();
		this.color = vehiculoJPA.getColor();
		this.motor = vehiculoJPA.getMotor();
		this.precio = vehiculoJPA.getPrecio();
		this.pedido = new PedidoDto(vehiculoJPA.getPedido());
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public PedidoDto getPedido() {
		return pedido;
	}

	public void setPedido(PedidoDto pedido) {
		this.pedido = pedido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		result = prime * result + ((motor == null) ? 0 : motor.hashCode());
		result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
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
		VehiculoDto other = (VehiculoDto) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		if (motor == null) {
			if (other.motor != null)
				return false;
		} else if (!motor.equals(other.motor))
			return false;
		if (pedido == null) {
			if (other.pedido != null)
				return false;
		} else if (!pedido.equals(other.pedido))
			return false;
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!precio.equals(other.precio))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VehiculoDto [id=" + id + ", descripcion=" + descripcion + ", modelo=" + modelo + ", color=" + color
				+ ", motor=" + motor + ", precio=" + precio + ", pedido=" + pedido + "]";
	}

	
	
}
