package com.asetecit.controlplusmtest.repository;

import java.util.Collection;

import com.asetecit.controlplusmtest.core.BusinessException;
import com.asetecit.controlplusmtest.core.Producto;

public interface ProductoRepository {

	Collection<Producto> listar();

	Producto buscar(String nombre) throws BusinessException;

	Producto agregar(Producto producto);

	Producto actualizar(Producto producto);

}
