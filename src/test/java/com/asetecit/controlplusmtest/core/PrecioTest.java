package com.asetecit.controlplusmtest.core;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class PrecioTest {

	@Test
	public void normalIfNull() {

		Precio sut = new Precio.Build().withNombre(null).build();

		Assert.assertEquals(Precio.NORMAL, sut.getNombre());
	}

	@Test
	public void normalIfEmpty() {

		Precio sut = new Precio.Build().withNombre("").build();

		Assert.assertEquals(Precio.NORMAL, sut.getNombre());
	}

	@Test
	public void normalIfOnlyWhiteSpace() {

		Precio sut = new Precio.Build().withNombre("   ").build();

		Assert.assertEquals(Precio.NORMAL, sut.getNombre());
	}

	@Test
	public void montoNoNegative() {

		Precio sut = new Precio.Build().withMonto(new BigDecimal(-5)).build();

		Assert.assertEquals(new BigDecimal(0), sut.getMonto());
	}
}
