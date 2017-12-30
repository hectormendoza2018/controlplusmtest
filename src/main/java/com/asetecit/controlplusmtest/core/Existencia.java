package com.asetecit.controlplusmtest.core;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "existencia")
public class Existencia implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private int id;

	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "ProductoId")
	private Producto producto;

	@Column(name = "unidades")
	private int unidades;

	public int getId() {
		return id;
	}

	public Producto getProducto() {
		return producto;
	}

	public int getUnidades() {
		return unidades;
	}

	public static class Build {

		private Producto producto;
		private int unidades;

		public Build withProducto(Producto producto) {
			if (producto == null) {
				throw new RuntimeException("El producto no es valido.");
			}
			this.producto = producto;
			return this;
		}

		public Build withUnidades(int unidades) {
			this.unidades = unidades < 0 ? 0 : unidades;
			return this;
		}

		public Existencia build() {
			return new Existencia(this);
		}
	}

	public Existencia(Build b) {
		this.producto = b.producto;
		this.unidades = b.unidades;
	}

}
