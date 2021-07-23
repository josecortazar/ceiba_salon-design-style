package com.ceiba.itemreserva.servicio.testdatabuilder;

import com.ceiba.itemreserva.modelo.entidad.ItemReserva;

public class ItemReservaTestDataBuilder {

	private Long id;
	private Long idReserva;
	private Long idServicio;
	private String nombre;
	private Double valor;

	public ItemReservaTestDataBuilder() {
		id = 1L;
		idReserva = 1L;
		idServicio = 1L;
		nombre = "Juagado de Cabello sin Shampoo";
		valor = 12000.0;
	}

	public ItemReservaTestDataBuilder conValor(Double valor) {
		this.valor = valor;
		return this;
	}

	public ItemReservaTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public ItemReservaTestDataBuilder conServicio(Long idServicio) {
		this.idServicio = idServicio;
		return this;
	}

	public ItemReservaTestDataBuilder conReserva(Long idReserva) {
		this.idReserva = idReserva;
		return this;
	}

	public ItemReservaTestDataBuilder conId(Long id) {
		this.id = id;
		return this;
	}

	public ItemReserva build() {
		return new ItemReserva(id, idReserva, idServicio, nombre, valor);
	}

}
