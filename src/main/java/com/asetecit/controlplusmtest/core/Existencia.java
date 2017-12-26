package com.asetecit.controlplusmtest.core;

import java.io.Serializable;

public class Existencia implements Serializable {

	private static final long serialVersionUID = 1L;

	private int codigo;
	private Producto producto;
	private int unidades;

	public int getCodigo() {
		return codigo;
	}

	public Producto getProducto() {
		return producto;
	}

	public int getUnidades() {
		return unidades;
	}

	public static class Build {

		private Producto producto;
		private int unidades;

		public Build withProducto(Producto producto) {
			if (producto == null) {
				throw new RuntimeException("El producto no es valido.");
			}
			this.producto = producto;
			return this;
		}

		public Build withUnidades(int unidades) {
			this.unidades = unidades < 0 ? 0 : unidades;
			return this;
		}

		public Existencia build() {
			return new Existencia(this);
		}
	}

	public Existencia(Build b) {
		this.producto = b.producto;
		this.unidades = b.unidades;
	}

}
