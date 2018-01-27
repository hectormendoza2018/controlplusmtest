package com.asetecit.controlplusmtest.core;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sucursal")
public class Sucursal implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "direccion")
	private String direccion;

	@Column(name = "telefono")
	private String telefono;

	protected Sucursal() {
		nombre = "";
		direccion = "";
		telefono = "";
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public static class Builder {

		private int id;
		private String nombre = "";
		private String direccion = "";
		private String telefono = "";

		public Builder(String nombre) {
			withNombre(nombre);
		}

		protected Builder(Sucursal su) {
			this.id = su.id;
			this.nombre = su.nombre;
			this.direccion = su.direccion;
			this.telefono = su.telefono;
		}

		public Builder withNombre(String nombre) {
			this.nombre = nombre;
			return this;
		}

		public Builder withDireccion(String direccion) {
			this.direccion = direccion;
			return this;
		}

		public Builder withTelefono(String telefono) {
			this.telefono = telefono;
			return this;
		}

		public Sucursal build() {
			return new Sucursal(this);
		}
	}

	public Builder builder() {
		return new Builder(this);
	}

	@Override
	public String toString() {
		return "Sucursal [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono
				+ "]";
	}

	private Sucursal(Builder b) {
		this.id = b.id;
		setNombre(b.nombre).setDireccion(b.direccion).setTelefono(b.telefono);
	}

	private Sucursal setNombre(String nombre) {
		if ((nombre == null) || nombre.trim().isEmpty()) {
			throw new RuntimeException("El nombre no es válido.");
		}
		this.nombre = nombre;
		return this;
	}

	private Sucursal setDireccion(String direccion) {
		if ((direccion == null)) {
			throw new RuntimeException("La dirección no es válida.");
		}
		this.direccion = direccion;
		return this;
	}

	private Sucursal setTelefono(String telefono) {
		if ((telefono == null)) {
			throw new RuntimeException("El número de teléfono no es válido.");
		}
		this.telefono = telefono;
		return this;
	}

}
