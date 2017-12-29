package com.asetecit.controlplusmtest.repository;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;

import com.asetecit.controlplusmtest.core.Categoria;

public class CategoriaRegistro implements CategoriaRepository {

	private EntityManager em;

	public CategoriaRegistro(EntityManager em) {
		this.em = em;
	}

	@Override
	public Collection<Categoria> listar() {
		@SuppressWarnings("unchecked")
		List<Categoria> categorias = (List<Categoria>) em.createQuery("FROM Categoria").getResultList();
		return categorias;
	}

	@Override
	public Categoria agregar(Categoria cat) {
		em.getTransaction().begin();
		em.persist(cat);
		em.getTransaction().commit();
		return cat;
	}

	@Override
	public Categoria actualizar(Categoria cat) {

		em.find(Categoria.class, cat.getId());
		em.getTransaction().begin();
		cat.setNombre(cat.getNombre());
		em.getTransaction().commit();

		return cat;
	}

}
