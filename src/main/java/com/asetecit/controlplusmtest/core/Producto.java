package com.asetecit.controlplusmtest.core;

import java.io.Serializable;
import java.math.BigDecimal;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "cup")
	private String cup;

	@Column(name = "nombre")
	private String nombre;

	@OneToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	@Column(name = "precio")
	private BigDecimal precio;

	@Column(name = "activo")
	private boolean activo;

	protected Producto() {
	}

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

	public boolean getActivo() {
		return activo;
	}

	public static class Builder {

		private int id;
		private String cup = "";
		private String nombre = "";
		private Categoria categoria;
		private BigDecimal precio;
		private boolean activo;

		public Builder() {
		}

		protected Builder(Producto producto) {
			this.id = producto.id;
			this.cup = producto.cup;
			this.nombre = producto.nombre;
			this.categoria = producto.categoria;
			this.precio = producto.precio;
			this.activo = producto.activo;
		}

		public Builder withId(int id) {
			this.id = id;
			return this;
		}

		public Builder withCup(String cup) {
			this.cup = cup;
			return this;
		}

		public Builder withNombre(String nombre) {
			this.nombre = nombre;
			return this;
		}

		public Builder withCategoria(Categoria categoria) {
			this.categoria = categoria;
			return this;
		}

		public Builder withPrecio(BigDecimal precio) {
			this.precio = precio;
			return this;
		}

		public Builder withActivo(Boolean activo) {
			this.activo = activo;
			return this;
		}

		public Producto build() {
			return new Producto(this);
		}
	}

	public Builder builder() {
		return new Builder(this);
	}

	private Producto(Builder b) {
		this.id = b.id;
		setCup(b.cup).setNombre(b.nombre).setCategoria(b.categoria).setPrecio(b.precio).setActivo(b.activo);
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", cup=" + cup + ", nombre=" + nombre + ", categoria=" + categoria + ", precio="
				+ precio + ", activo=" + activo + "]";
	}

	private Producto setCup(String cup) {
		if ((cup == null) || cup.trim().isEmpty()) {
			throw new RuntimeException("no ha ingresado un valor correcto para el cup");
		}
		this.cup = cup;
		return this;
	}

	private Producto setNombre(String nombre) {
		if ((nombre == null) || nombre.trim().isEmpty()) {
			throw new RuntimeException("no ha ingresado un valor correcto para el nombre");
		}
		this.nombre = nombre;
		return this;
	}

	private Producto setCategoria(Categoria categoria) {
		if (categoria == null) {
			throw new RuntimeException("La categoría no es válida.");
		}
		this.categoria = categoria;
		return this;
	}

	private Producto setPrecio(BigDecimal precio) {
		this.precio = precio;
		return this;
	}

	private Producto setActivo(boolean activo) {
		this.activo = activo;
		return this;
	}

}
