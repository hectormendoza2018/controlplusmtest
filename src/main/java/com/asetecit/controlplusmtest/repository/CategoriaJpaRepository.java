package com.asetecit.controlplusmtest.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.asetecit.controlplusmtest.core.Categoria;

public interface CategoriaJpaRepository extends PagingAndSortingRepository<Categoria, Integer> {

}
