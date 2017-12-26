package com.asetecit.controlplusmtest.core;

import org.junit.Assert;
import org.junit.Test;

public class CategoriaTest {

	@Test
	public void generalifNotParam() {

		Categoria sut = new Categoria();

		Assert.assertEquals(Categoria.GENERAL, sut.getNombre());
	}

	@Test
	public void generalIfNull() {

		Categoria sut = new Categoria(null);

		Assert.assertEquals(Categoria.GENERAL, sut.getNombre());
	}

	@Test
	public void normalIfEmpty() {

		Categoria sut = new Categoria("");

		Assert.assertEquals(Categoria.GENERAL, sut.getNombre());
	}

	@Test
	public void normalIfOnlyWhiteSpace() {

		Categoria sut = new Categoria("      ");

		Assert.assertEquals(Categoria.GENERAL, sut.getNombre());
	}
}
