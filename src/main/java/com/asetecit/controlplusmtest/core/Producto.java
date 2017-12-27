package com.asetecit.controlplusmtest.core;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Producto implements Serializable {

	private static final long serialVersionUID = 1L;

	private int codigo;
	private String cup;
	private String nombre;
	private Categoria categoria;
	private Set<Precio> precios;

	public int getCodigo() {
		return codigo;
	}

	public String getCup() {
		return cup;
	}

	public String getNombre() {
		return nombre;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public Set<Precio> getPrecios() {
		return precios;
	}

	public static class Build {

		private String cup = "";
		private String nombre = "";
		private Categoria categoria;
		private Set<Precio> precios;

		public Build() {
			this.precios = new HashSet<>();
		}

		public Build withCup(String cup) {
			if ((cup == null) || cup.trim().isEmpty()) {
				throw new RuntimeException("no ha ingresado un valor correcto para el cup");
			}
			this.cup = cup;
			return this;
		}

		public Build withNombre(String nombre) {
			if ((cup == null) || cup.trim().isEmpty()) {
				throw new RuntimeException("no ha ingresado un valor correcto para el cup");
			}
			this.nombre = nombre;
			return this;
		}

		public Build withCategoria(Categoria categoria) {
			if (categoria == null) {
				throw new RuntimeException("La categoría no es válida.");
			}
			this.categoria = categoria;
			return this;
		}

		public Build withPrecios(Set<Precio> precios) {
			if ((precios == null) || precios.isEmpty()) {
				throw new RuntimeException("el precio ingresado no es válido");
			}
			this.precios = precios;
			return this;
		}

		public Producto build() {
			return new Producto(this);
		}
	}

	private Producto(Build b) {
		this.cup = b.cup;
		this.nombre = b.nombre;
		this.categoria = b.categoria == null ? new Categoria() : b.categoria;
		this.precios = b.precios == null ? Collections.emptySet() : b.precios;
	}

}
