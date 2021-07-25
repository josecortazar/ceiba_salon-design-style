package com.ceiba.itemreserva.servicio.testdatabuilder;

import com.ceiba.itemreserva.comando.ComandoItemReserva;

public class ComandoItemReservaTestDataBuilder {

	private Long id;
	private Long idReserva;
	private Long idServicio;
	private String nombre;
	private Double valor;

	public ComandoItemReservaTestDataBuilder() {
		id = 2L;
		idReserva = 1L;
		idServicio = 1L;
		nombre = "Mascarilla Capilar";
		valor = 35000.0;
	}

	public ComandoItemReservaTestDataBuilder conValor(Double valor) {
		this.valor = valor;
		return this;
	}

	public ComandoItemReservaTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public ComandoItemReservaTestDataBuilder conServicio(Long idServicio) {
		this.idServicio = idServicio;
		return this;
	}

	public ComandoItemReservaTestDataBuilder conReserva(Long idReserva) {
		this.idReserva = idReserva;
		return this;
	}

	public ComandoItemReservaTestDataBuilder conId(Long id) {
		this.id = id;
		return this;
	}

	public ComandoItemReserva build() {
		return new ComandoItemReserva(id, idReserva, idServicio, nombre, valor);
	}
}
