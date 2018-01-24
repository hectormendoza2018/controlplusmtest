package com.asetecit.controlplusmtest.core;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String GENERAL = "General";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "nombre")
	private String nombre;

	public Categoria() {
		this(GENERAL);
	}

	public Categoria(String nombre) {
		this(0, nombre);
	}

	public Categoria(int id, String nombre) {
		this.id = id;
		this.nombre = validateName(nombre);
	}

	private String validateName(String nombre) {
		return nombre == null || nombre.trim().isEmpty() ? GENERAL : nombre;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = validateName(nombre);
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nombre=" + nombre + "]";
	}
}
