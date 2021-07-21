package com.ceiba.reserva.servicio.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.reserva.modelo.entidad.Reserva;

public class ReservaTestDataBuilder {

	private Long id;
	private Long idCliente;
	private LocalDateTime fechaCreacion;
	private LocalDateTime fechaReserva;
	private Double precioNeto;
	private Double precioTotal;
	private Boolean esReservaDeMenor;

	public ReservaTestDataBuilder() {
		id = 1L;
		idCliente = 1L;
		fechaCreacion = LocalDateTime.of(2021, 7, 15, 02, 10);
		fechaReserva = LocalDateTime.of(2021, 7, 16, 13, 00);
		precioNeto = 35000.0;
		precioTotal = 35000.0;
		esReservaDeMenor = false;
	}

	public ReservaTestDataBuilder conPrecioTotal(Double precioTotal) {
		this.precioTotal = precioTotal;
		return this;
	}

	public ReservaTestDataBuilder conPrecioNeto(Double precioNeto) {
		this.precioNeto = precioNeto;
		return this;
	}

	public ReservaTestDataBuilder conFechaReserva(LocalDateTime fechaReserva) {
		this.fechaReserva = fechaReserva;
		return this;
	}

	public ReservaTestDataBuilder conFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
		return this;
	}

	public ReservaTestDataBuilder conCliente(Long idCliente) {
		this.idCliente = idCliente;
		return this;
	}

	public ReservaTestDataBuilder conId(Long id) {
		this.id = id;
		return this;
	}

	public Reserva build() {
		return new Reserva(id, idCliente, fechaCreacion, fechaReserva, precioNeto, precioTotal, esReservaDeMenor);
	}

}
