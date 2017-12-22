package com.asetecit.controlplusmtest.core;

import java.io.Serializable;

public class Categoria implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int codigo;
	private String nombre;
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public static class Build{
		
		private String nombre="";
		
		public Build withNombre(String nombre){
			this.nombre=nombre;
			return this;
		}
		
		public Categoria build(){
			return new Categoria(this);
		}	
	}
	
	private Categoria(Build b) {
		this.nombre = b.nombre;
	}

}
