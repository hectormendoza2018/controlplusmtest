package com.asetecit.controlplusmtest.repository;

import java.util.Collection;

import com.asetecit.controlplusmtest.core.Sucursal;

public interface SucursalRepository {

	Collection<Sucursal> listar();

	Sucursal agregar(Sucursal sucursal);

	Sucursal actualizar(Sucursal sucursal);

}
