package com.ceiba.reserva.servicio;

import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.servicio.testdatabuilder.ReservaTestDataBuilder;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;

public class ServicioActualizarReservaTest {

	@Test
	public void validarReservaExistenciaPreviaTest() {
		// arrange
		Reserva reserva = new ReservaTestDataBuilder().conId(2L).build();
		RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
		Mockito.when(repositorioReserva.existe(Mockito.anyLong())).thenReturn(false);
		ServicioActualizarReserva servicioActualizarReserva = new ServicioActualizarReserva(repositorioReserva);

		// act - assert
		BasePrueba.assertThrows(() -> servicioActualizarReserva.ejecutar(reserva), ExcepcionSinDatos.class,
				"La reserva no existe en el sistema");
	}

	@Test
	public void ejecutarTodoValido() {
		// arrange
		Reserva reserva = new ReservaTestDataBuilder().build();
		RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
		Mockito.when(repositorioReserva.existe(Mockito.anyLong())).thenReturn(true);
		ServicioActualizarReserva servicioActualizarReserva = new ServicioActualizarReserva(repositorioReserva);

		// act
		servicioActualizarReserva.ejecutar(reserva);

		// assert
		Mockito.verify(repositorioReserva).actualizar(reserva);

	}

}
