package com.asetecit.controlplusmtest.dto;

import javax.validation.Valid;

import com.asetecit.controlplusmtest.core.Existencia;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class ExistenciaDto {

	public int id;

	@Valid
	public ProductoDto producto;

	public int unidades;

	public ExistenciaDto() {
	}

	public ExistenciaDto(Existencia existence) {
		id = existence.getId();
		producto = new ProductoDto(existence.getProducto());
		unidades = existence.getUnidades();
	}

	@JsonIgnore
	public Existencia toEntity() {
		return new Existencia.Build().withId(id).withProducto(producto.toEntity()).withUnidades(unidades).build();
	}

	public int getId() {
		return id;
	}

	public ProductoDto getProducto() {
		return producto;
	}

	public int getUnidades() {
		return unidades;
	}

	@Override
	public String toString() {
		return "ExistenciaDto [id=" + id + ", producto=" + producto + ", unidades=" + unidades + "]";
	}

}
