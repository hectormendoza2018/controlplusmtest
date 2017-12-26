package com.asetecit.controlplusmtest.repository;

import java.util.Collection;

import com.asetecit.controlplusmtest.core.Categoria;

public interface CategoriaRepository {

	Collection<Categoria> listar();

	Categoria agregar(Categoria cat);

	Categoria actualizar(Categoria cat);

}
