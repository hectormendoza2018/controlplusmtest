package com.asetecit.controlplusmtest.core;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class ExistenciaTest {

	@Test(expected = RuntimeException.class)
	public void productoIfNull() {
		new Existencia(null, 0);
	}

	@Test
	public void unidadesNoNegative() {

		Producto pro = new Producto.Builder().withCup("A14").withNombre("Acetaminofen").withActivo(true)
				.withPrecio(new BigDecimal(5)).withCategoria(new Categoria()).build();
		Existencia sut = new Existencia(pro, -10);

		Assert.assertEquals(0, sut.getUnidades());
	}

}
