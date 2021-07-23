package com.ceiba.itemreserva.servicio.testdatabuilder;

import com.ceiba.servicio.modelo.dto.DtoServicio;

public class DtoServicioTestDataBuilder {

	private Long id;
	private String nombre;
	private String descripcion;
	private Double valor;
	private String imagen;

	public DtoServicioTestDataBuilder() {
		id = 1L;
		nombre = "Juagado de Cabello sin Shampoo";
		descripcion = "Tendencia en higiene personal que consiste en no usar shampoo y lavar el cabello solo con agua y otros productos.";
		valor = 12000.0;
		imagen = "https://www.sensebox.com.co/uploads/IMG_4494.JPG";
	}

	public DtoServicioTestDataBuilder conId(Long id) {
		this.id = id;
		return this;
	}

	public DtoServicio build() {
		return new DtoServicio(id, nombre, descripcion, valor, imagen);
	}
}
