package com.asetecit.controlplusmtest.core;

import java.io.Serializable;

public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String GENERAL = "General";

	private int codigo;
	private String nombre;

	public Categoria() {
		this(GENERAL);
	}

	public Categoria(String nombre) {
		this.nombre = nombre;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

}
