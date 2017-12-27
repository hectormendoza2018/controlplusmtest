package com.asetecit.controlplusmtest.core;

import org.junit.Test;

public class SucursalTest {

	@Test(expected = RuntimeException.class)
	public void nombreIfNull() {

		new Sucursal.Build().withNombre(null).build();
	}

	@Test(expected = RuntimeException.class)
	public void nombreIfEmpty() {

		new Sucursal.Build().withNombre("").build();

	}

	@Test(expected = RuntimeException.class)
	public void nombreIfOnlyWhiteSpace() {

		new Sucursal.Build().withNombre("      ").build();

	}

	@Test(expected = RuntimeException.class)
	public void direccionIfNull() {

		new Sucursal.Build().withDireccion(null).build();
	}

	@Test(expected = RuntimeException.class)
	public void direccionIfEmpty() {

		new Sucursal.Build().withDireccion("").build();

	}

	@Test(expected = RuntimeException.class)
	public void direccionIfOnlyWhiteSpace() {

		new Sucursal.Build().withDireccion("      ").build();

	}

	@Test(expected = RuntimeException.class)
	public void telefonoIfNull() {

		new Sucursal.Build().withTelefono(null).build();
	}

	@Test(expected = RuntimeException.class)
	public void telefonoIfEmpty() {

		new Sucursal.Build().withTelefono("").build();

	}

	@Test(expected = RuntimeException.class)
	public void telefonoIfOnlyWhiteSpace() {

		new Sucursal.Build().withTelefono("      ").build();

	}
}
