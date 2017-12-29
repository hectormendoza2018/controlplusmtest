package com.asetecit.controlplusmtest.core;

import java.math.BigDecimal;

import org.junit.Test;

public class ProductoTest {

	@Test(expected = RuntimeException.class)
	public void cupIfNull() {

		new Producto.Build().withCup(null);
	}

	@Test(expected = RuntimeException.class)
	public void cupIfEmpty() {

		new Producto.Build().withCup("").build();
	}

	@Test(expected = RuntimeException.class)
	public void cupIfOnlyWhiteSpace() {

		new Producto.Build().withCup("           ").build();
	}

	@Test(expected = RuntimeException.class)
	public void nombreIfNull() {

		new Producto.Build().withNombre(null);
	}

	@Test(expected = RuntimeException.class)
	public void nombreIfEmpty() {

		new Producto.Build().withNombre("").build();
	}

	@Test(expected = RuntimeException.class)
	public void nombreIfOnlyWhiteSpace() {

		new Producto.Build().withNombre("           ").build();
	}

	@Test(expected = RuntimeException.class)
	public void categoriaIfNull() {
		new Producto.Build().withCategoria(null).build();
	}

	@Test(expected = RuntimeException.class)
	public void precioIfNull() {
		new Producto.Build().withPrecio(null).build();
	}

	@Test(expected = RuntimeException.class)
	public void precioNotZero() {
		new Producto.Build().withPrecio(new BigDecimal(0)).build();
	}
}
