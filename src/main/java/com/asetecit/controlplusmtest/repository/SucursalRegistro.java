package com.asetecit.controlplusmtest.repository;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asetecit.controlplusmtest.core.BusinessException;
import com.asetecit.controlplusmtest.core.Sucursal;
import com.google.common.collect.Lists;

@Repository
public class SucursalRegistro implements SucursalRepository {

	SucursalJpaRepository repository;

	@Autowired
	public SucursalRegistro(SucursalJpaRepository repository) {
		this.repository = repository;
	}

	@Override
	public Collection<Sucursal> listar() {
		return Lists.newArrayList(repository.findAll());
	}

	@Override
	public Sucursal agregar(Sucursal sucursal) {
		if (null == sucursal) {
			throw new BusinessException("La sucursal no es válida.");
		}
		return repository.save(sucursal);
	}

	@Override
	public Sucursal actualizar(Sucursal sucursal) {
		return agregar(sucursal);
	}

}
