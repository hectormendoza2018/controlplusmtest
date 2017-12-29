package com.asetecit.controlplusmtest.core;

import java.io.Serializable;
import java.math.BigDecimal;

public class Producto implements Serializable {

	private static final long serialVersionUID = 1L;

	private int codigo;
	private String cup;
	private String nombre;
	private Categoria categoria;
	private BigDecimal precio;

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

	public BigDecimal getPrecio() {
		return precio;
	}

	public static class Build {

		private String cup = "";
		private String nombre = "";
		private Categoria categoria;
		private BigDecimal precio;

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

		public Build withPrecio(BigDecimal precio) {

			if ((precio == null) || (precio.signum() == 0)) {
				throw new RuntimeException("el precio ingresado no es válido");
			}
			this.precio = precio;
			return this;
		}

		public Producto build() {
			return new Producto(this);
		}
	}

	private Producto(Build b) {
		this.cup = b.cup;
		this.nombre = b.nombre;
		this.categoria = b.categoria;
		this.precio = b.precio;
	}

}
