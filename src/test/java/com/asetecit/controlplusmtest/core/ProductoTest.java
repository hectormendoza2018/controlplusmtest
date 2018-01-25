package com.asetecit.controlplusmtest.core;

import java.math.BigDecimal;

import org.junit.Test;

public class ProductoTest {

	@Test(expected = RuntimeException.class)
	public void cupIfNull() {

		new Producto.Builder().withCup(null);
	}

	@Test(expected = RuntimeException.class)
	public void cupIfEmpty() {

		new Producto.Builder().withCup("").build();
	}

	@Test(expected = RuntimeException.class)
	public void cupIfOnlyWhiteSpace() {

		new Producto.Builder().withCup("           ").build();
	}

	@Test(expected = RuntimeException.class)
	public void nombreIfNull() {

		new Producto.Builder().withNombre(null);
	}

	@Test(expected = RuntimeException.class)
	public void nombreIfEmpty() {

		new Producto.Builder().withNombre("").build();
	}

	@Test(expected = RuntimeException.class)
	public void nombreIfOnlyWhiteSpace() {

		new Producto.Builder().withNombre("           ").build();
	}

	@Test(expected = RuntimeException.class)
	public void categoriaIfNull() {
		new Producto.Builder().withCategoria(null).build();
	}

	@Test(expected = RuntimeException.class)
	public void precioIfNull() {
		new Producto.Builder().withPrecio(null).build();
	}

	@Test(expected = RuntimeException.class)
	public void precioNotZero() {
		new Producto.Builder().withPrecio(new BigDecimal(0)).build();
	}
}
