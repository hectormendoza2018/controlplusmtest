package com.asetecit.controlplusmtest.core;

import java.io.Serializable;

public class Sucursal implements Serializable {

	private static final long serialVersionUID = 1L;

	private int codigo;
	private String nombre;
	private String direccion;
	private String telefono;

	public int getCodigo() {
		return codigo;
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
