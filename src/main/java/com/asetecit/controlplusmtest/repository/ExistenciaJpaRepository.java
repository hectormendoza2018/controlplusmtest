package com.asetecit.controlplusmtest.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import com.asetecit.controlplusmtest.core.Existencia;

public interface ExistenciaJpaRepository extends CrudRepository<Existencia, Integer> {

	Collection<Existencia> findByUnidades(int existencia);

}
