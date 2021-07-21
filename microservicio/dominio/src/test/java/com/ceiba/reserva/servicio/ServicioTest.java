package com.ceiba.reserva.servicio;

import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.servicio.testdatabuilder.ReservaTestDataBuilder;

import static org.junit.Assert.assertThat;

import java.time.LocalDateTime;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionCierreFinesSemana;
import com.ceiba.dominio.excepcion.ExcepcionFechaReserva;
import com.ceiba.dominio.excepcion.ExcepcionHoraroReserva;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;

public class ServicioTest {

	@Test
	public void validarCampoCliente() {
		// arrange
		ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conCliente(null);
		// act - assert
		BasePrueba.assertThrows(() -> reservaTestDataBuilder.build(), ExcepcionValorObligatorio.class,
				"Se debe ingresar el cliente de la reserva");
	}

	@Test
	public void validarCampoFechaReserva() {
		// arrange
		ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conFechaReserva(null);
		// act - assert
		BasePrueba.assertThrows(() -> reservaTestDataBuilder.build(), ExcepcionValorObligatorio.class,
				"Se debe ingresar una fecha para la reserva");
	}

	@Test
	public void validarHoraReserva() {
		// arrange
		ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder()
				.conFechaReserva(LocalDateTime.of(2021, 7, 16, 01, 00));

		// act - assert
		BasePrueba.assertThrows(() -> reservaTestDataBuilder.build(), ExcepcionHoraroReserva.class,
				"El horario para asignar la reserva no es valido");

	}

	@Test
	public void validarFechaReservaMuchaAnticipacion() {
		// arrange
		ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder()
				.conFechaReserva(LocalDateTime.of(2023, 7, 16, 11, 00));

		// act - assert
		BasePrueba.assertThrows(() -> reservaTestDataBuilder.build(), ExcepcionFechaReserva.class,
				"La fecha para la reserva no valida, tiene mas de 4 meses de anticipacion");
	}

	@Test
	public void validarFechaReservaPreviamente() {
		// arrange
		ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder()
				.conFechaCreacion(LocalDateTime.of(2021, 7, 16, 11, 00));
		reservaTestDataBuilder.conFechaReserva(LocalDateTime.of(2021, 7, 10, 11, 00));
		// act - assert
		BasePrueba.assertThrows(() -> reservaTestDataBuilder.build(), ExcepcionFechaReserva.class,
				"La fecha para la reserva no valida, no es hecha previamente");
	}

	@Test
	public void validarCierreReservasFinesDeSemana() {
		// arrange
		ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder()
				.conFechaCreacion(LocalDateTime.of(2021, 8, 14, 11, 00));
		reservaTestDataBuilder.conFechaReserva(LocalDateTime.of(2021, 8, 20, 13, 00));

		// act - assert
		BasePrueba.assertThrows(() -> reservaTestDataBuilder.build(), ExcepcionCierreFinesSemana.class,
				"La plataforma esta cerrada para reservas los fines de semana");
	}

	@Test
	public void validarIncrementoFinesSemana() {
		// arrange
		ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder()
				.conFechaCreacion(LocalDateTime.of(2021, 7, 21, 11, 00));
		reservaTestDataBuilder.conFechaReserva(LocalDateTime.of(2021, 7, 25, 13, 00));

		Reserva reserva = reservaTestDataBuilder.build();

		// act - assert
		assertThat((reserva.getPrecioNeto() * 1.1), CoreMatchers.is(reserva.getPrecioTotal()));
	}

	@Test
	public void validarIncrementoFestivos() {
		// arrange
		ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder()
				.conFechaCreacion(LocalDateTime.of(2021, 7, 16, 11, 00));
		reservaTestDataBuilder.conFechaReserva(LocalDateTime.of(2021, 7, 20, 13, 00));

		Reserva reserva = reservaTestDataBuilder.build();

		// act - assert
		assertThat((reserva.getPrecioNeto() * 1.15), CoreMatchers.is(reserva.getPrecioTotal()));
	}

}
