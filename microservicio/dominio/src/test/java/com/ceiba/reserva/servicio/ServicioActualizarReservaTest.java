package com.ceiba.reserva.servicio;

import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.servicio.testdatabuilder.ReservaTestDataBuilder;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;

public class ServicioActualizarReservaTest {

	@Test
	public void validarReservaExistenciaPreviaTest() {
		// arrange
		Reserva reserva = new ReservaTestDataBuilder().conId(2L).build();
		RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
		Mockito.when(repositorioReserva.existe(Mockito.anyLong())).thenReturn(false);
		ServicioActualizarReserva reservaActualizarReserva = new ServicioActualizarReserva(repositorioReserva);

		// act - assert
		BasePrueba.assertThrows(() -> reservaActualizarReserva.ejecutar(reserva), ExcepcionSinDatos.class,
				"La reserva no existe en el sistema");
	}

	@Test
	public void ejecutarTodoValido() {
		// arrange
		Reserva reserva = new ReservaTestDataBuilder().build();
		RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
		Mockito.when(repositorioReserva.existe(Mockito.anyLong())).thenReturn(true);
		ServicioActualizarReserva reservaActualizarReserva = new ServicioActualizarReserva(repositorioReserva);

		// act
		reservaActualizarReserva.ejecutar(reserva);

		// assert
		Mockito.verify(repositorioReserva).actualizar(reserva);

	}
	
}
