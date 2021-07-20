package com.ceiba.reserva.servicio;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.servicio.testdatabuilder.ReservaTestDataBuilder;

public class ServicioEliminarReservaTest {

	@Test
	public void ejecutarTodoValido() {
		// arrange
		Reserva reserva = new ReservaTestDataBuilder().conId(1L).build();
		RepositorioReserva repositorioReserva = Mockito.spy(RepositorioReserva.class);
		Mockito.doNothing().when(repositorioReserva).eliminar(Mockito.anyLong());
		ServicioEliminarReserva reservaEliminarReserva = new ServicioEliminarReserva(repositorioReserva);

		// act
		reservaEliminarReserva.ejecutar(reserva.getId());

		// assert
		Mockito.verify(repositorioReserva).eliminar(reserva.getId());
	}

}