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

	private Sucursal() {
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if ((nombre == null) || nombre.trim().isEmpty()) {
			throw new RuntimeException("El nombre no es válido.");
		}
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public static class Build {

		private String nombre = "";
		private String direccion = "";
		private String telefono = "";

		public Build withNombre(String nombre) {
			if ((nombre == null) || nombre.trim().isEmpty()) {
				throw new RuntimeException("El nombre no es válido.");
			}
			this.nombre = nombre;
			return this;
		}

		public Build withDireccion(String direccion) {
			if ((direccion == null) || direccion.trim().isEmpty()) {
				throw new RuntimeException("La dirección no es válida.");
			}
			this.direccion = direccion;
			return this;
		}

		public Build withTelefono(String telefono) {
			if ((telefono == null) || telefono.trim().isEmpty()) {
				throw new RuntimeException("El número de teléfono no es válido.");
			}
			this.telefono = telefono;
			return this;
		}

		public Sucursal build() {
			return new Sucursal(this);
		}
	}

	private Sucursal(Build b) {
		this.nombre = b.nombre;
		this.direccion = b.direccion;
		this.telefono = b.telefono;
	}

}
