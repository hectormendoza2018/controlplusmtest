package com.asetecit.controlplusmtest.dto;

import java.math.BigDecimal;

import com.asetecit.controlplusmtest.core.Producto;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class ProductoDto {

	public int id;
	public String cup = "";
	public String nombre = "";
	public BigDecimal precio;
	public boolean activo;
	public CategoriaDto categoria;

	public ProductoDto() {
		precio = new BigDecimal(0);
		categoria = new CategoriaDto();
	}

	public ProductoDto(Producto pro) {
		id = pro.getId();
		cup = pro.getCup();
		nombre = pro.getNombre();
		precio = pro.getPrecio();
		activo = pro.getActivo();
		categoria = new CategoriaDto(pro.getCategoria());
	}

	@JsonIgnore
	public Producto toEntity() {
		return new Producto.Build().withId(id).withCup(cup).withNombre(nombre).withPrecio(precio).withActivo(activo)
				.withCategoria(categoria.toEntity()).build();
	}

	public int getId() {
		return id;
	}

	public String getCup() {
		return cup;
	}

	public String getNombre() {
		return nombre;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public boolean isActivo() {
		return activo;
	}

	public CategoriaDto getCategoria() {
		return categoria;
	}

	@Override
	public String toString() {
		return "ProductoDto [id=" + id + ", cup=" + cup + ", nombre=" + nombre + ", precio=" + precio + ", activo="
				+ activo + ", categoria=" + categoria + "]";
	}

}
