package com.asetecit.controlplusmtest.core;

import java.util.Collections;

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
	public void preciosIfEmpty() {
		new Producto.Build().withPrecios(Collections.emptySet()).build();
	}

	@Test(expected = RuntimeException.class)
	public void preciosIfNull() {
		new Producto.Build().withPrecios(null).build();
	}
}
