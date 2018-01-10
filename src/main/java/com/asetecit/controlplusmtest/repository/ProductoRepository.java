package com.asetecit.controlplusmtest.repository;

import java.math.BigDecimal;
import java.util.Collection;

import com.asetecit.controlplusmtest.core.BusinessException;
import com.asetecit.controlplusmtest.core.Producto;

public interface ProductoRepository {

	Collection<Producto> listar(Boolean activo);

	Producto buscar(String nombre) throws BusinessException;

	Collection<Producto> buscarPorCategoria(int codigo) throws BusinessException;

	Producto buscarPorCup(String nombre) throws BusinessException;

	Collection<Producto> buscarPorPrecio(BigDecimal precio) throws BusinessException;

	Producto agregar(Producto producto);

	Producto actualizar(Producto producto);

}
