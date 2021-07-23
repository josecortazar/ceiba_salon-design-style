package com.ceiba.itemreserva.servicio;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.itemreserva.modelo.entidad.ItemReserva;
import com.ceiba.itemreserva.puerto.repositorio.RepositorioItemReserva;
import com.ceiba.itemreserva.servicio.testdatabuilder.ItemReservaTestDataBuilder;

public class ServicioEliminarItemReservaTest {

	@Test
	public void ejecutarTodoValido() {
		// arrange
		ItemReserva itemReserva = new ItemReservaTestDataBuilder().build();
		RepositorioItemReserva repositorioItemReserva = Mockito.spy(RepositorioItemReserva.class);
		Mockito.doNothing().when(repositorioItemReserva).eliminar(Mockito.anyLong());
		ServicioEliminarItemReserva servicioEliminarItemReserva = new ServicioEliminarItemReserva(
				repositorioItemReserva);

		// act
		servicioEliminarItemReserva.ejecutar(itemReserva.getId());

		// assert
		Mockito.verify(repositorioItemReserva).eliminar(itemReserva.getId());
	}

}