package com.asetecit.controlplusmtest.repository;

import java.math.BigDecimal;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asetecit.controlplusmtest.core.BusinessException;
import com.asetecit.controlplusmtest.core.Producto;

@Repository
public class ProductoRegistro implements ProductoRepository {

	ProductoJpaRepository repository;

	@Autowired
	public ProductoRegistro(ProductoJpaRepository repository) {
		this.repository = repository;
	}

	@Override
	public Collection<Producto> listar(Boolean active) {

		return repository.findByActivo(active);
	}

	@Override
	public Producto buscar(String nombre) throws BusinessException {
		Producto producto = repository.findByNombre(nombre);
		checkIfNull(producto, "No existe un producto con ese nombre");
		return producto;
	}

	@Override
	public Collection<Producto> buscarPorCategoria(int codigo) {
		return repository.findByCategoriaId(codigo);
	}

	@Override
	public Producto buscarPorCup(String cup) throws BusinessException {
		Producto producto = repository.findByCup(cup);
		checkIfNull(producto, "No existe un producto con ese nombre de cup");
		return producto;
	}

	private void checkIfNull(Producto producto, String msg) {
		if (producto == null) {
			throw new BusinessException(msg);
		}
	}

	@Override
	public Collection<Producto> buscarPorPrecio(BigDecimal precio) {
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
