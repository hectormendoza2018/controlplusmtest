package com.asetecit.controlplusmtest.core;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SucursalTest {

	Sucursal sut;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void before() {
		sut = new Sucursal.Builder().withNombre("Central").withDireccion("Ciudad").withTelefono("77754923").build();
	}

	@Test
	public void nombreIfNull() {
		thrown.expectMessage("El nombre no es válido.");

		sut.builder().withNombre(null).build();
	}

	@Test
	public void nombreIfEmpty() {
		thrown.expectMessage("El nombre no es válido.");

		sut.builder().withNombre("").build();
	}

	@Test
	public void nombreIfOnlyWhiteSpace() {
		thrown.expectMessage("El nombre no es válido.");

		sut.builder().withNombre("      ").build();
	}

	@Test
	public void direccionIfNull() {
		thrown.expectMessage("La dirección no es válida.");

		sut.builder().withDireccion(null).build();
	}

	@Test
	public void direccionIfEmpty() {
		thrown.expectMessage("La dirección no es válida.");

		sut.builder().withDireccion("").build();
	}

	@Test
	public void direccionIfOnlyWhiteSpace() {
		thrown.expectMessage("La dirección no es válida.");

		sut.builder().withDireccion("      ").build();
	}

	@Test
	public void telefonoIfNull() {
		thrown.expectMessage("El número de teléfono no es válido.");

		sut.builder().withTelefono(null).build();
	}

	@Test
	public void telefonoIfEmpty() {
		thrown.expectMessage("El número de teléfono no es válido.");

		sut.builder().withTelefono("").build();
	}

	@Test
	public void telefonoIfOnlyWhiteSpace() {
		thrown.expectMessage("El número de teléfono no es válido.");

		sut.builder().withTelefono("      ").build();
	}
}
