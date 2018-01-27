package com.asetecit.controlplusmtest.core;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "existencia", uniqueConstraints = { @UniqueConstraint(columnNames = { "producto_id", "sucursal_id" }) })
public class Existencia implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(unique = true)
	private Producto producto;

	@ManyToOne(fetch = FetchType.LAZY)
	private Sucursal sucursal;

	@Column(name = "unidades")
	private int unidades;

	public Existencia(Sucursal sucursal, Producto producto, int unidades) {
		this(0, sucursal, producto, unidades);
	}

	public Existencia(int id, Sucursal sucursal, Producto producto, int unidades) {
		this.id = id;
		setProducto(producto).setSucursal(sucursal).setUnidades(unidades);
	}

	protected Existencia() {
	}

	public int getId() {
		return id;
	}

	public Producto getProducto() {
		return producto;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public int getUnidades() {
		return unidades;
	}

	@Override
	public String toString() {
		return "Existencia [id=" + id + ", producto=" + producto + ", unidades=" + unidades + "]";
	}

	private Existencia setProducto(Producto producto) {
		if (producto == null) {
			throw new RuntimeException("El producto no es valido.");
		}

		this.producto = producto;
		return this;
	}

	private Existencia setSucursal(Sucursal sucursal) {
		if (sucursal == null) {
			throw new RuntimeException("La sucursal no es válida.");
		}

		this.sucursal = sucursal;
		return this;
	}

	private Existencia setUnidades(int unidades) {
		this.unidades = unidades < 0 ? 0 : unidades;
		return this;
	}

}
