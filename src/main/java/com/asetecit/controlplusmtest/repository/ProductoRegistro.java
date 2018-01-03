package com.asetecit.controlplusmtest.repository;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.asetecit.controlplusmtest.core.BusinessException;
import com.asetecit.controlplusmtest.core.Producto;

public class ProductoRegistro implements ProductoRepository {

	private EntityManager em;

	public ProductoRegistro(EntityManager em) {
		this.em = em;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Producto> listar(Boolean activo) {
		Query query = em.createQuery("FROM Producto prod where prod.activo = :activo");
		query.setParameter("activo", activo);
		List<Producto> productos = (List<Producto>) query.getResultList();
		return productos;
	}

	@Override
	public Producto buscar(String nombre) throws BusinessException {
		Query query = em.createQuery("from Producto prod where prod.nombre = :nombre");
		query.setParameter("nombre", nombre);
		Producto producto = (Producto) query.getSingleResult();
		return producto;
	}

	@Override
	public Producto agregar(Producto producto) {
		em.getTransaction().begin();
		em.persist(producto);
		em.getTransaction().commit();
		return producto;
	}

	@Override
	public Producto actualizar(Producto producto) {
		em.getTransaction().begin();
		em.merge(producto);
		em.getTransaction().commit();
		return producto;
	}

}
