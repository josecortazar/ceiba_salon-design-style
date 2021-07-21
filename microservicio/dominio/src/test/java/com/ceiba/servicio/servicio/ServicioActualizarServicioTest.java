package com.ceiba.servicio.servicio;

import com.ceiba.servicio.modelo.entidad.Servicio;
import com.ceiba.servicio.puerto.repositorio.RepositorioServicio;
import com.ceiba.servicio.servicio.testdatabuilder.ServicioTestDataBuilder;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;

public class ServicioActualizarServicioTest {

	@Test
	public void validarServicioExistenciaPreviaTest() {
		// arrange
		Servicio servicio = new ServicioTestDataBuilder().conId(2L).build();
		RepositorioServicio repositorioServicio = Mockito.mock(RepositorioServicio.class);
		Mockito.when(repositorioServicio.existe(Mockito.anyLong())).thenReturn(false);
		ServicioActualizarServicio servicioActualizarServicio = new ServicioActualizarServicio(repositorioServicio);

		// act - assert
		BasePrueba.assertThrows(() -> servicioActualizarServicio.ejecutar(servicio), ExcepcionSinDatos.class,
				"El servicio no existe en el sistema");
	}

	@Test
	public void ejecutarTodoValido() {
		// arrange
		Servicio servicio = new ServicioTestDataBuilder().build();
		RepositorioServicio repositorioServicio = Mockito.mock(RepositorioServicio.class);
		Mockito.when(repositorioServicio.existe(Mockito.anyLong())).thenReturn(true);
		ServicioActualizarServicio servicioActualizarServicio = new ServicioActualizarServicio(repositorioServicio);

		// act
		servicioActualizarServicio.ejecutar(servicio);

		// assert
		Mockito.verify(repositorioServicio).actualizar(servicio);

	}
	
}
