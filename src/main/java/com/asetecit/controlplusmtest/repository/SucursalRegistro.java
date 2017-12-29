package com.asetecit.controlplusmtest.repository;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;

import com.asetecit.controlplusmtest.core.Sucursal;

public class SucursalRegistro implements SucursalRepository {

	private EntityManager em;

	public SucursalRegistro(EntityManager em) {
		this.em = em;
	}

	@Override
	public Collection<Sucursal> listar() {
		@SuppressWarnings("unchecked")
		List<Sucursal> sucursales = (List<Sucursal>) em.createQuery("FROM Sucursal").getResultList();
		return sucursales;
	}

	@Override
	public Sucursal agregar(Sucursal sucursal) {
		em.getTransaction().begin();
		em.persist(sucursal);
		em.getTransaction().commit();
		return null;
	}

	@Override
	public Sucursal actualizar(Sucursal sucursal) {
		em.find(Sucursal.class, sucursal.getId());
		em.getTransaction().begin();
		sucursal.setNombre(sucursal.getNombre());
		em.getTransaction().commit();
		return sucursal;
	}

}
