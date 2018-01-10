package com.asetecit.controlplusmtest.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
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

	@Override
	@SuppressWarnings("unchecked")
	public Collection<Producto> listar(Boolean activo) {

		Query query = em.createQuery("FROM Producto prod where prod.activo = :activo");
		query.setParameter("activo", activo);
		List<Producto> productos = new ArrayList<>(query.getResultList());

		return productos;
	}

	@Override
	public Producto buscar(String nombre) throws BusinessException {
		Query query = em.createQuery("from Producto prod where prod.nombre = :nombre");
		query.setParameter("nombre", nombre);
		Producto producto;
		try {
			producto = (Producto) query.getSingleResult();
		} catch (Exception ex) {
			producto = null;
		}
		return producto;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Producto> buscarPorCategoria(int codigo) throws BusinessException {
		Query query = em
				.createQuery("FROM Producto prod where prod.categoria.id = :categoria AND prod.activo = :activo");
		query.setParameter("categoria", codigo);
		query.setParameter("activo", true);
		List<Producto> productos = (List<Producto>) query.getResultList();
		return productos;
	}

	@Override
	public Producto buscarPorCup(String nombre) throws BusinessException {
		Query query = em.createQuery("FROM Producto prod where prod.cup = :cup AND prod.activo = :activo");
		query.setParameter("cup", nombre);
		query.setParameter("activo", true);
		Producto producto;
		try {
			producto = (Producto) query.getSingleResult();
		} catch (Exception ex) {
			producto = null;
		}

		return producto;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Producto> buscarPorPrecio(BigDecimal precio) throws BusinessException {
		Query query = em.createQuery("FROM Producto prod where prod.precio = :precio AND prod.activo = :activo");
		query.setParameter("precio", precio);
		query.setParameter("activo", true);
		List<Producto> productos = (List<Producto>) query.getResultList();
		return productos;
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
