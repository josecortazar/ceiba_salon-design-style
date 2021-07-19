package com.ceiba.servicio.servicio.testdatabuilder;

import com.ceiba.servicio.modelo.entidad.Servicio;

public class ServicioTestDataBuilder {

	private Long id;
	private String nombre;
	private String descripcion;
	private Double valor;
	private String imagen;

	public ServicioTestDataBuilder() {
		id = 1L;
		nombre = "Juagado de Cabello sin Shampoo";
		descripcion = "Tendencia en higiene personal que consiste en no usar shampoo y lavar el cabello solo con agua y otros productos.";
		valor = 12000.0;
		imagen = "https://www.sensebox.com.co/uploads/IMG_4494.JPG";
	}

	public ServicioTestDataBuilder conImagen(String imagen) {
		this.imagen = imagen;
		return this;
	}

	public ServicioTestDataBuilder conValor(Double valor) {
		this.valor = valor;
		return this;
	}

	public ServicioTestDataBuilder conDescripcion(String descripcion) {
		this.descripcion = descripcion;
		return this;
	}

	public ServicioTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public ServicioTestDataBuilder conId(Long id) {
		this.id = id;
		return this;
	}

	public Servicio build() {
		return new Servicio(id, nombre, descripcion, valor, imagen);
	}

}
