package com.ceiba.itemreserva.servicio.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.reserva.modelo.dto.DtoReserva;

public class DtoReservaTestDataBuilder {

	private Long id;
	private Long idCliente;
	private LocalDateTime fechaCreacion;
	private LocalDateTime fechaReserva;
	private Double precioNeto;
	private Long cantidadServicios;
	private Boolean esReservaDeMenor;

	public DtoReservaTestDataBuilder() {
		id = 1L;
		idCliente = 1L;
		fechaCreacion = LocalDateTime.of(2021, 7, 15, 02, 10);
		fechaReserva = LocalDateTime.of(2021, 7, 16, 13, 00);
		precioNeto = 35000.0;
		cantidadServicios = 1L;
		esReservaDeMenor = false;
	}

	public DtoReservaTestDataBuilder conId(Long id) {
		this.id = id;
		return this;
	}

	public DtoReserva build() {
		return new DtoReserva(id, idCliente, fechaCreacion, fechaReserva, precioNeto, precioNeto, cantidadServicios,
				esReservaDeMenor);
	}
}
