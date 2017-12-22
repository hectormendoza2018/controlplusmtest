package com.asetecit.controlplusmtest.core;

import java.io.Serializable;
import java.math.BigDecimal;

public class Precio implements Serializable {

	public static String NORMAL = "Normal";

	private static final long serialVersionUID = 1L;

	private int codigo;
	private String nombre;
	private BigDecimal monto;

	public int getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public static class Build {

		private String nombre = NORMAL;
		private BigDecimal monto = new BigDecimal(0);

		public Build withNombre(String nombre) {
			this.nombre = nombre;
			return this;
		}

		public Build withMonto(BigDecimal monto) {
			this.monto = monto;
			return this;
		}

		public Precio build() {
			return new Precio(this);
		}
	}

	private Precio(Build b) {
		this.nombre = b.nombre;
		this.monto = b.monto;
	}
}
