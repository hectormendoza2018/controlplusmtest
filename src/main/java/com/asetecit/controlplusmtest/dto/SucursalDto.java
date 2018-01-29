package com.asetecit.controlplusmtest.dto;

import javax.validation.constraints.NotEmpty;

import com.asetecit.controlplusmtest.core.Sucursal;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class SucursalDto {

	public int id;

	@NotEmpty(message = "El nombre no debe estar vacio")
	public String nombre = "";

	public String direccion = "";
	public String telefono = "";

	public SucursalDto() {
	}

	public SucursalDto(Sucursal su) {
		id = su.getId();
		nombre = su.getNombre();
	}

	@JsonIgnore
	public Sucursal toEntity() {
		return new Sucursal.Builder(nombre).withId(id).withDireccion(direccion).withTelefono(telefono).build();
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

	@Override
	public String toString() {
		return "SucursalDto [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono
				+ "]";
	}

}
