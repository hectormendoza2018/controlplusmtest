package com.asetecit.controlplusmtest.repository;

import java.math.BigDecimal;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asetecit.controlplusmtest.core.BusinessException;
import com.asetecit.controlplusmtest.core.Producto;
import com.google.common.collect.Lists;

@Repository
public class ProductoRegistro implements ProductoRepository {

	ProductoJpaRepository repository;

	@Autowired
	public ProductoRegistro(ProductoJpaRepository repository) {
		this.repository = repository;
	}

	@Override
	public Collection<Producto> listar(Boolean activo) {
		return Lists.newArrayList(repository.findAll());
	}

	@Override
	public Producto buscar(String nombre) throws BusinessException {

		return repository.findByNombre(nombre);
	}

	@Override
	public Collection<Producto> buscarPorCategoria(int codigo) throws BusinessException {
		return repository.findByCategoriaId(codigo);
	}

	@Override
	public Producto buscarPorCup(String nombre) throws BusinessException {
		return repository.findByCup(nombre);
	}

	@Override
	public Collection<Producto> buscarPorPrecio(BigDecimal precio) throws BusinessException {
		return repository.findByPrecio(precio);
	}

	@Override
	public Producto agregar(Producto producto) {
		if (null == producto) {
			throw new BusinessException("El Producto no es válido.");
		}
		return repository.save(producto);
	}

	@Override
	public Producto actualizar(Producto producto) {
		return agregar(producto);
	}
}
