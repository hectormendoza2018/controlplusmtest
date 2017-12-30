package com.asetecit.controlplusmtest.core;

import java.io.Serializable;
import java.math.BigDecimal;

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
@Table(name = "producto")
public class Producto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private int id;

	@Column(name = "cup")
	private String cup;

	@Column(name = "nombre")
	private String nombre;

	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "CategoriaId")
	private Categoria categoria;

	@Column(name = "precio")
	private BigDecimal precio;

	public int getId() {
		return id;
	}

	public String getCup() {
		return cup;
	}

	public String getNombre() {
		return nombre;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public static class Build {

		private String cup = "";
		private String nombre = "";
		private Categoria categoria;
		private BigDecimal precio;

		public Build withCup(String cup) {
			if ((cup == null) || cup.trim().isEmpty()) {
				throw new RuntimeException("no ha ingresado un valor correcto para el cup");
			}
			this.cup = cup;
			return this;
		}

		public Build withNombre(String nombre) {
			if ((cup == null) || cup.trim().isEmpty()) {
				throw new RuntimeException("no ha ingresado un valor correcto para el cup");
			}
			this.nombre = nombre;
			return this;
		}

		public Build withCategoria(Categoria categoria) {
			if (categoria == null) {
				throw new RuntimeException("La categoría no es válida.");
			}
			this.categoria = categoria;
			return this;
		}

		public Build withPrecio(BigDecimal precio) {

			if ((precio == null) || (precio.signum() == 0)) {
				throw new RuntimeException("el precio ingresado no es válido");
			}
			this.precio = precio;
			return this;
		}

		public Producto build() {
			return new Producto(this);
		}
	}

	private Producto(Build b) {
		this.cup = b.cup;
		this.nombre = b.nombre;
		this.categoria = b.categoria;
		this.precio = b.precio;
	}

}
