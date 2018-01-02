package com.asetecit.controlplusmtest.repository;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.asetecit.controlplusmtest.core.Existencia;

public class ExistenciaRegistro implements ExistenciaRepository {

	private EntityManager em;

	public ExistenciaRegistro(EntityManager em) {
		this.em = em;
	}

	@Override
	public Collection<Existencia> listar() {
		@SuppressWarnings("unchecked")
		List<Existencia> existencias = (List<Existencia>) em.createQuery("FROM Existencia").getResultList();
		return existencias;
	}

	@Override
	public Existencia agregar(Existencia existencia) {
		em.getTransaction().begin();
		em.persist(existencia);
		em.getTransaction().commit();
		return existencia;
	}

	@Override
	public Existencia actualizar(Existencia existencia) {
		em.getTransaction().begin();
		em.merge(existencia);
		em.getTransaction().commit();
		return existencia;
	}

	@Override
	public Collection<Existencia> listarEqualZero() {
		Query query = em.createQuery("from Existencia exist where exist.unidades =:unidades");
		query.setParameter("unidades", 0);
		@SuppressWarnings("unchecked")
		List<Existencia> existencias = (List<Existencia>) query.getResultList();
		return existencias;
	}

}
