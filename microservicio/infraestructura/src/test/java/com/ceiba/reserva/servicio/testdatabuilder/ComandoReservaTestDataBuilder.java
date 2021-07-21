package com.ceiba.reserva.servicio.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.servicio.comando.ComandoServicio;

public class ComandoReservaTestDataBuilder {

	private Long id;
	private Long idCliente;
	private LocalDateTime fechaCreacion;
	private LocalDateTime fechaReserva;
	private Double precioNeto;
	private Double precioTotal;
	private Long cantidadServicios;
	private Boolean esReservaDeMenor;

	public ComandoReservaTestDataBuilder() {
		id = 2L;
		idCliente = 1L;
		fechaCreacion = LocalDateTime.of(2021, 7, 15, 02, 10);
		fechaReserva = LocalDateTime.of(2021, 7, 16, 13, 00);
		precioNeto = 35000.0;
		precioTotal = 35000.0;
		cantidadServicios = 1L;
		esReservaDeMenor = false;
	}

	public ComandoReservaTestDataBuilder conCantidadServicios(Long cantidadServicios) {
		this.cantidadServicios = cantidadServicios;
		return this;
	}

	public ComandoReservaTestDataBuilder conPrecioTotal(Double precioTotal) {
		this.precioTotal = precioTotal;
		return this;
	}

	public ComandoReservaTestDataBuilder conPrecioNeto(Double precioNeto) {
		this.precioNeto = precioNeto;
		return this;
	}

	public ComandoReservaTestDataBuilder conFechaReserva(LocalDateTime fechaReserva) {
		this.fechaReserva = fechaReserva;
		return this;
	}

	public ComandoReservaTestDataBuilder conFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
		return this;
	}

	public ComandoReservaTestDataBuilder conCliente(Long idCliente) {
		this.idCliente = idCliente;
		return this;
	}

	public ComandoReservaTestDataBuilder conId(Long id) {
		this.id = id;
		return this;
	}

	public ComandoReserva build() {
		return new ComandoReserva(id, idCliente, fechaCreacion, fechaReserva, precioNeto, precioTotal,
				cantidadServicios, esReservaDeMenor);
	}
}
