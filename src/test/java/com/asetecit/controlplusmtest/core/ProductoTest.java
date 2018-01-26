package com.asetecit.controlplusmtest.core;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ProductoTest {

	Producto sut;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void before() {
		sut = new Producto.Builder().withCup("A14").withNombre("Acetaminofen").withActivo(true)
				.withPrecio(new BigDecimal(5)).withCategoria(new Categoria()).build();
	}

	@Test
	public void cupIfNull() {
		thrown.expectMessage("no ha ingresado un valor correcto para el cup");

		sut.builder().withCup(null).build();
	}

	@Test
	public void cupIfEmpty() {
		thrown.expectMessage("no ha ingresado un valor correcto para el cup");

		sut.builder().withCup("").build();
	}

	@Test
	public void cupIfOnlyWhiteSpace() {
		thrown.expectMessage("no ha ingresado un valor correcto para el cup");

		sut.builder().withCup("           ").build();
	}

	@Test
	public void nombreIfNull() {
		thrown.expectMessage("no ha ingresado un valor correcto para el nombre");

		sut.builder().withNombre(null).build();
	}

	@Test
	public void nombreIfEmpty() {
		thrown.expectMessage("no ha ingresado un valor correcto para el nombre");

		sut.builder().withNombre("").build();
	}

	@Test
	public void nombreIfOnlyWhiteSpace() {
		thrown.expectMessage("no ha ingresado un valor correcto para el nombre");

		sut.builder().withNombre("           ").build();
	}

	@Test
	public void categoriaIfNull() {
		thrown.expectMessage("La categoría no es válida.");

		sut.builder().withCategoria(null).build();
	}

	@Test
	public void precioIfNull() {
		new Producto.Builder().withPrecio(null).build();
	}

	@Test
	public void precioNotZero() {
		sut.builder().withPrecio(new BigDecimal(0)).build();
	}
}
