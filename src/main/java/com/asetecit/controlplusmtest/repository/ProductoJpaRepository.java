package com.asetecit.controlplusmtest.repository;

import java.math.BigDecimal;
import java.util.Collection;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.asetecit.controlplusmtest.core.Producto;

public interface ProductoJpaRepository extends PagingAndSortingRepository<Producto, Integer> {

	Producto findByNombre(String nombre);

	Collection<Producto> findByCategoriaId(int codigo);

	Producto findByCup(String cup);

	Collection<Producto> findByPrecio(BigDecimal precio);

}
