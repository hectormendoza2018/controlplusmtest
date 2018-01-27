package com.asetecit.controlplusmtest.dto;

import javax.validation.Valid;

import com.asetecit.controlplusmtest.core.Existencia;
import com.asetecit.controlplusmtest.core.Sucursal;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class ExistenciaDto {

	public int id;

	@Valid
	public ProductoDto producto;

	public Sucursal sucursal;

	public int unidades;

	public ExistenciaDto() {
	}

	public ExistenciaDto(Existencia existence) {
		id = existence.getId();
		producto = new ProductoDto(existence.getProducto());
		sucursal = existence.getSucursal();
		unidades = existence.getUnidades();
	}

	@JsonIgnore
	public Existencia toEntity() {
		return new Existencia(id, sucursal, producto.toEntity(), unidades);
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
		return "ExistenciaDto [id=" + id + ", producto=" + producto + ", sucursal=" + sucursal + ", unidades="
				+ unidades + "]";
	}

}
