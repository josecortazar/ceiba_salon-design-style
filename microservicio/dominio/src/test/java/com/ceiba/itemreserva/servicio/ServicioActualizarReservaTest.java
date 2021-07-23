package com.ceiba.itemreserva.servicio;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.itemreserva.modelo.entidad.ItemReserva;
import com.ceiba.itemreserva.puerto.repositorio.RepositorioItemReserva;
import com.ceiba.itemreserva.servicio.testdatabuilder.ItemReservaTestDataBuilder;

public class ServicioActualizarReservaTest {

	@Test
	public void validarItemReservaExistenciaPreviaTest() {
		// arrange
		ItemReserva itemReserva = new ItemReservaTestDataBuilder().conId(2L).build();

		RepositorioItemReserva repositorioItemReserva = Mockito.mock(RepositorioItemReserva.class);
		Mockito.when(repositorioItemReserva.existe(Mockito.anyLong())).thenReturn(false);

		ServicioActualizarItemReserva servicioActualizarItemReserva = new ServicioActualizarItemReserva(
				repositorioItemReserva);

		// act - assert
		BasePrueba.assertThrows(() -> servicioActualizarItemReserva.ejecutar(itemReserva), ExcepcionSinDatos.class,
				"El item de la reserva no existe en el sistema");
	}

	@Test
	public void ejecutarTodoValido() {
		// arrange
		ItemReserva itemReserva = new ItemReservaTestDataBuilder().conId(2L).build();

		RepositorioItemReserva repositorioItemReserva = Mockito.mock(RepositorioItemReserva.class);
		Mockito.when(repositorioItemReserva.existe(Mockito.anyLong())).thenReturn(true);

		ServicioActualizarItemReserva servicioActualizarItemReserva = new ServicioActualizarItemReserva(
				repositorioItemReserva);
		// act
		servicioActualizarItemReserva.ejecutar(itemReserva);

		// assert
		Mockito.verify(repositorioItemReserva).actualizar(itemReserva);

	}

}
