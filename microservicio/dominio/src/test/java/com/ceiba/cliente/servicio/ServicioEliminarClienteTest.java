package com.ceiba.cliente.servicio;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.cliente.servicio.testdatabuilder.ClienteTestDataBuilder;

public class ServicioEliminarClienteTest {

	@Test
	public void ejecutarTodoValido() {
		// arrange
		Cliente cliente = new ClienteTestDataBuilder().build();
		RepositorioCliente repositorioCliente = Mockito.spy(RepositorioCliente.class);
		Mockito.doNothing().when(repositorioCliente).eliminar(Mockito.anyString());
		ServicioEliminarCliente servicioEliminarCliente = new ServicioEliminarCliente(repositorioCliente);

		// act
		servicioEliminarCliente.ejecutar(cliente.getIdentificacion());

		// assert
		Mockito.verify(repositorioCliente).eliminar(cliente.getIdentificacion());
	}

}