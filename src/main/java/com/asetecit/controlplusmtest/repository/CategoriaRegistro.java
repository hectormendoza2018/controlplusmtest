package com.asetecit.controlplusmtest.repository;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asetecit.controlplusmtest.core.BusinessException;
import com.asetecit.controlplusmtest.core.Categoria;
import com.google.common.collect.Lists;

@Repository
public class CategoriaRegistro implements CategoriaRepository {

	CategoriaJpaRepository repository;

	@Autowired
	public CategoriaRegistro(CategoriaJpaRepository repository) {
		this.repository = repository;
	}

	@Override
	public Collection<Categoria> listar() {
		return Lists.newArrayList(repository.findAll());
	}

	@Override
	public Categoria agregar(Categoria cat) {
		if (null == cat) {
			throw new BusinessException("La categoria no es valida.");
		}
		return repository.save(cat);
	}

	@Override
	public Categoria actualizar(Categoria cat) {

		return agregar(cat);
	}

}
