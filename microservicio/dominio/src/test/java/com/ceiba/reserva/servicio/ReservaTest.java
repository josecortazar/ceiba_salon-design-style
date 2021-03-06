package com.ceiba.reserva.servicio;

import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.servicio.testdatabuilder.ReservaTestDataBuilder;

import static org.junit.Assert.assertThat;

import java.time.LocalDateTime;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionAccionInvalida;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;

public class ReservaTest {

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
		BasePrueba.assertThrows(() -> reservaTestDataBuilder.build(), ExcepcionValorInvalido.class,
				"El horario para asignar la reserva no es valido");

	}

	@Test
	public void validarFechaReservaMuchaAnticipacion() {
		// arrange
		ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder()
				.conFechaReserva(LocalDateTime.of(2023, 7, 16, 11, 00));

		// act - assert
		BasePrueba.assertThrows(() -> reservaTestDataBuilder.build(), ExcepcionValorInvalido.class,
				"La fecha para la reserva no valida, tiene mas de 4 meses de anticipacion");
	}

	@Test
	public void validarFechaReservaPreviamente() {
		// arrange
		ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder()
				.conFechaCreacion(LocalDateTime.of(2021, 7, 16, 11, 00));
		reservaTestDataBuilder.conFechaReserva(LocalDateTime.of(2021, 7, 10, 11, 00));
		// act - assert
		BasePrueba.assertThrows(() -> reservaTestDataBuilder.build(), ExcepcionValorInvalido.class,
				"La fecha para la reserva no valida, no es hecha previamente");
	}

	@Test
	public void validarCierreReservasFinesDeSemana() {
		// arrange
		ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder()
				.conFechaCreacion(LocalDateTime.of(2021, 8, 14, 11, 00));
		reservaTestDataBuilder.conFechaReserva(LocalDateTime.of(2021, 8, 20, 13, 00));

		// act - assert
		BasePrueba.assertThrows(() -> reservaTestDataBuilder.build(), ExcepcionAccionInvalida.class,
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
		assertThat(reserva.getModificacadorPrecio(), CoreMatchers.is(1.1));
	}

	@Test
	public void validarIncrementoFestivos() {
		// arrange
		ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder()
				.conFechaCreacion(LocalDateTime.of(2021, 7, 16, 11, 00));
		reservaTestDataBuilder.conFechaReserva(LocalDateTime.of(2021, 7, 20, 13, 00));

		Reserva reserva = reservaTestDataBuilder.build();

		// act - assert
		assertThat(reserva.getModificacadorPrecio(), CoreMatchers.is(1.15));
	}

	@Test
	public void validarDescuentoTresServicios() {
		// arrange
		ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conCantidadServicios(3L);

		Reserva reserva = reservaTestDataBuilder.build();

		// act - assert
		assertThat(reserva.getModificacadorPrecio(), CoreMatchers.is( 0.9));
	}

	@Test
	public void validarIncrementoFestivosConDescuento() {
		// arrange
		ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder()
				.conFechaCreacion(LocalDateTime.of(2021, 7, 16, 11, 00));
		reservaTestDataBuilder.conFechaReserva(LocalDateTime.of(2021, 7, 20, 13, 00));
		reservaTestDataBuilder.conCantidadServicios(3L);
		Reserva reserva = reservaTestDataBuilder.build();

		// act - assert
		assertThat(reserva.getModificacadorPrecio(), CoreMatchers.is((1.0 + 0.15) - 0.1));
	}

	@Test
	public void validarIncrementoDomingoConDescuento() {
		// arrange
		ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder()
				.conFechaCreacion(LocalDateTime.of(2021, 7, 16, 11, 00));
		reservaTestDataBuilder.conFechaReserva(LocalDateTime.of(2021, 7, 24, 13, 00));
		reservaTestDataBuilder.conCantidadServicios(3L);
		Reserva reserva = reservaTestDataBuilder.build();

		// act - assert
		assertThat(reserva.getModificacadorPrecio(), CoreMatchers.is((1.0 + 0.1) - 0.1));
	}

}
