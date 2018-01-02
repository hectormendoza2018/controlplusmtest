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

	@Override
	public Collection<Producto> listar() {
		@SuppressWarnings("unchecked")
		List<Producto> productos = (List<Producto>) em.createQuery("FROM Producto").getResultList();
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
		Producto saved = em.find(Producto.class, producto.getId());

		saved = new Producto.Build().from(saved).withCategoria(saved.getCategoria()).withCup(saved.getCup())
				.withNombre(saved.getNombre()).withPrecio(saved.getPrecio()).build();

		em.getTransaction().begin();
		em.persist(saved);
		em.getTransaction().commit();

		return producto;
	}

}
