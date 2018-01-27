package com.asetecit.controlplusmtest.core;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExistenciaTest {

	private Producto pro;
	private Sucursal su;

	@Before
	public void before() {
		pro = new Producto.Builder().withCup("A14").withNombre("Acetaminofen").withActivo(true)
				.withPrecio(new BigDecimal(5)).withCategoria(new Categoria()).build();
		su = new Sucursal.Builder("Central").build();
	}

	@Test(expected = RuntimeException.class)
	public void productoIfNull() {
		new Existencia(su, null, 0);
	}

	@Test(expected = RuntimeException.class)
	public void sucursalIfNull() {
		new Existencia(null, pro, 0);
	}

	@Test
	public void unidadesNoNegative() {

		Existencia sut = new Existencia(su, pro, -10);

		Assert.assertEquals(0, sut.getUnidades());
	}

}
