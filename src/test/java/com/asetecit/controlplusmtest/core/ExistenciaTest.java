package com.asetecit.controlplusmtest.core;

import org.junit.Assert;
import org.junit.Test;

public class ExistenciaTest {

	@Test(expected = RuntimeException.class)
	public void productoIfNull() {
		new Existencia.Build().withProducto(null).build();
	}

	@Test
	public void unidadesNoNegative() {

		Existencia sut = new Existencia.Build().withUnidades(-10).build();

		Assert.assertEquals(0, sut.getUnidades());
	}

}
