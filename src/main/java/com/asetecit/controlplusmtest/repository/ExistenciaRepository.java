package com.asetecit.controlplusmtest.repository;

import java.util.Collection;

import com.asetecit.controlplusmtest.core.Existencia;

public interface ExistenciaRepository {

	Collection<Existencia> listar();

	Existencia agregar(Existencia existencia);

	Existencia actualizar(Existencia existencia);

	Collection<Existencia> listarEqualZero();

}
