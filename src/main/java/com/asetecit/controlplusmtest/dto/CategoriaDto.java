package com.asetecit.controlplusmtest.dto;

import com.asetecit.controlplusmtest.core.Categoria;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class CategoriaDto {

	public int id;
	public String nombre = "";

	public CategoriaDto() {
	}

	public CategoriaDto(Categoria cat) {
		id = cat.getId();
		nombre = cat.getNombre();
	}

	@JsonIgnore
	public Categoria toEntity() {

		return new Categoria(id, nombre);
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		return "CategoriaDto [id=" + id + ", nombre=" + nombre + "]";
	}

}
