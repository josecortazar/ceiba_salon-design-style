package com.ceiba.servicio.servicio.testdatabuilder;

import com.ceiba.servicio.comando.ComandoServicio;

public class ComandoServicioTestDataBuilder {

	private Long id;
	private String nombre;
	private String descripcion;
	private Double valor;
	private String imagen;

	public ComandoServicioTestDataBuilder() {
		id = 2L;
		nombre = "Juagado de Cabello sin Shampoo";
		descripcion = "Tendencia en higiene personal que consiste en no usar shampoo y lavar el cabello solo con agua y otros productos.";
		valor = 12000.0;
		imagen = "https://www.sensebox.com.co/uploads/IMG_4494.JPG";
	}

	public ComandoServicioTestDataBuilder conImagen(String imagen) {
		this.imagen = imagen;
		return this;
	}

	public ComandoServicioTestDataBuilder conValor(Double valor) {
		this.valor = valor;
		return this;
	}

	public ComandoServicioTestDataBuilder conDescripcion(String descripcion) {
		this.descripcion = descripcion;
		return this;
	}

	public ComandoServicioTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public ComandoServicioTestDataBuilder conId(Long id) {
		this.id = id;
		return this;
	}

	public ComandoServicio build() {
		return new ComandoServicio(id, nombre, descripcion, valor, imagen);
	}
}
