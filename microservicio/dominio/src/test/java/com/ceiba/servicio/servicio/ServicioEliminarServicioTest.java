package com.ceiba.servicio.servicio;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.servicio.modelo.entidad.Servicio;
import com.ceiba.servicio.puerto.repositorio.RepositorioServicio;
import com.ceiba.servicio.servicio.testdatabuilder.ServicioTestDataBuilder;

public class ServicioEliminarServicioTest {

	@Test
	public void ejecutarTodoValido() {
		// arrange
		Servicio servicio = new ServicioTestDataBuilder().conId(1L).build();
		RepositorioServicio repositorioServicio = Mockito.spy(RepositorioServicio.class);
		Mockito.doNothing().when(repositorioServicio).eliminar(Mockito.anyLong());
		ServicioEliminarServicio servicioEliminarServicio = new ServicioEliminarServicio(repositorioServicio);

		// act
		servicioEliminarServicio.ejecutar(servicio.getId());

		// assert
		Mockito.verify(repositorioServicio).eliminar(servicio.getId());
	}

}