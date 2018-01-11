package com.asetecit.controlplusmtest.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.asetecit.controlplusmtest.core.Producto;

public interface ProductoJpaRepository extends PagingAndSortingRepository<Producto, Integer> {

}
