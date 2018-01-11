package com.asetecit.controlplusmtest.repository;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asetecit.controlplusmtest.core.BusinessException;
import com.asetecit.controlplusmtest.core.Existencia;
import com.google.common.collect.Lists;

@Repository
public class ExistenciaRegistro implements ExistenciaRepository {

	ExistenciaJpaRepository repository;

	@Autowired
	public ExistenciaRegistro(ExistenciaJpaRepository repository) {
		this.repository = repository;
	}

	@Override
	public Collection<Existencia> listar() {
		return Lists.newArrayList(repository.findAll());
	}

	@Override
	public Existencia agregar(Existencia existencia) {
		if (null == existencia) {
			throw new BusinessException("La existencia no es válida.");
		}
		return repository.save(existencia);
	}

	@Override
	public Existencia actualizar(Existencia existencia) {
		return agregar(existencia);
	}

	@Override
	public Collection<Existencia> listarEqualZero() {

		return repository.findByUnidades(0);
	}

}
