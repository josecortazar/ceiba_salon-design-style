package com.ceiba.cliente.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.cliente.servicio.testdatabuilder.ClienteTestDataBuilder;

public class ServicioActualizarClienteTest {

	@Test
	public void validarClienteExistenciaPreviaTest() {
		// arrange
		Cliente cliente = new ClienteTestDataBuilder().conId(2L).build();
		RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
		Mockito.when(repositorioCliente.existe(Mockito.anyLong())).thenReturn(false);
		ServicioActualizarCliente servicioActualizarUsuario = new ServicioActualizarCliente(repositorioCliente);

		// act - assert
		BasePrueba.assertThrows(() -> servicioActualizarUsuario.ejecutar(cliente), ExcepcionDuplicidad.class,
				"El cliente no existe en el sistema");
	}

	@Test
	public void ejecutarTodoValido() {
		// arrange
		Cliente cliente = new ClienteTestDataBuilder().build();
		RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
		Mockito.when(repositorioCliente.existe(Mockito.any())).thenReturn(true);
		ServicioActualizarCliente servicioActualizarCliente = new ServicioActualizarCliente(repositorioCliente);

		// act
		servicioActualizarCliente.ejecutar(cliente);

		// assert
		Mockito.verify(repositorioCliente).actualizar(cliente);

	}

}
