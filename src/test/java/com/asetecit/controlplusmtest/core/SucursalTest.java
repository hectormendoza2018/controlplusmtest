package com.asetecit.controlplusmtest.core;

import org.junit.Test;

public class SucursalTest {

	@Test(expected = RuntimeException.class)
	public void nombreIfNull() {

		new Sucursal.Builder().withNombre(null).build();
	}

	@Test(expected = RuntimeException.class)
	public void nombreIfEmpty() {

		new Sucursal.Builder().withNombre("").build();

	}

	@Test(expected = RuntimeException.class)
	public void nombreIfOnlyWhiteSpace() {

		new Sucursal.Builder().withNombre("      ").build();

	}

	@Test(expected = RuntimeException.class)
	public void direccionIfNull() {

		new Sucursal.Builder().withDireccion(null).build();
	}

	@Test(expected = RuntimeException.class)
	public void direccionIfEmpty() {

		new Sucursal.Builder().withDireccion("").build();

	}

	@Test(expected = RuntimeException.class)
	public void direccionIfOnlyWhiteSpace() {

		new Sucursal.Builder().withDireccion("      ").build();

	}

	@Test(expected = RuntimeException.class)
	public void telefonoIfNull() {

		new Sucursal.Builder().withTelefono(null).build();
	}

	@Test(expected = RuntimeException.class)
	public void telefonoIfEmpty() {

		new Sucursal.Builder().withTelefono("").build();

	}

	@Test(expected = RuntimeException.class)
	public void telefonoIfOnlyWhiteSpace() {

		new Sucursal.Builder().withTelefono("      ").build();

	}

	@Test(expected = RuntimeException.class)
	public void setSucursalIfNull() {

		Sucursal sut = new Sucursal.Builder().build();
		sut.setNombre(null);
	}
}
