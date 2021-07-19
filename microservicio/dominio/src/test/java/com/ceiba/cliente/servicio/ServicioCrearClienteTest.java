package com.ceiba.cliente.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;

import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.cliente.servicio.ServicioCrearCliente;
import com.ceiba.cliente.servicio.testdatabuilder.ClienteTestDataBuilder;

public class ServicioCrearClienteTest {

	@Test
	public void validarCampoIdentificacionTest() {
		// arrange
		ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conIdentficacion(null);
		// act - assert
		BasePrueba.assertThrows(() -> clienteTestDataBuilder.build(), ExcepcionValorObligatorio.class,
				"Se debe ingresar la identificacion del cliente");
	}

	@Test
	public void validarIdentificaionTest() {
		// arrange
		ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conIdentficacion("lO9A6545O52");
		// act - assert
		BasePrueba.assertThrows(() -> clienteTestDataBuilder.build(), ExcepcionValorInvalido.class,
				"Se debe ingresar un numero de identificacion valido");
	}

	@Test
	public void validarCampoNombreTest() {
		// arrange
		ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conNombre(null);
		// act - assert
		BasePrueba.assertThrows(() -> clienteTestDataBuilder.build(), ExcepcionValorObligatorio.class,
				"Se debe ingresar el nombre del cliente");
	}

	@Test
	public void validarNombreTest() {
		// arrange
		ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conNombre("4ndres L0pez");
		// act - assert
		BasePrueba.assertThrows(() -> clienteTestDataBuilder.build(), ExcepcionValorInvalido.class,
				"Se debe ingresar un nombre valido");
	}

	@Test
	public void validarCampoCorreoElectronicoTest() {
		// arrange
		ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conCorreoElectronico(null);
		// act - assert
		BasePrueba.assertThrows(() -> clienteTestDataBuilder.build(), ExcepcionValorObligatorio.class,
				"Se debe ingresar el correo electronico del cliente");
	}

	@Test
	public void validarCorreoElectronicoTest() {
		// arrange
		ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder()
				.conCorreoElectronico("josegmail.com");
		// act - assert
		BasePrueba.assertThrows(() -> clienteTestDataBuilder.build(), ExcepcionValorInvalido.class,
				"Se debe ingresar un correo electronico valido");
	}

	@Test
	public void validarCampoNumTelefonoTest() {
		// arrange
		ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conNumTelefono(null);
		// act - assert
		BasePrueba.assertThrows(() -> clienteTestDataBuilder.build(), ExcepcionValorObligatorio.class,
				"Se debe ingresar el numero telefonico del cliente");
	}

	@Test
	public void validarNumTelefonoTest() {
		// arrange
		ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conNumTelefono("asd3216545052");
		// act - assert
		BasePrueba.assertThrows(() -> clienteTestDataBuilder.build(), ExcepcionValorInvalido.class,
				"Se debe ingresar un numero telefonico valido");
	}

	@Test
	public void validarCampoFechaNacimientoTest() {
		// arrange
		ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conFechanacimiento(null);
		// act - assert
		BasePrueba.assertThrows(() -> clienteTestDataBuilder.build(), ExcepcionValorObligatorio.class,
				"Se debe ingresar una fecha de nacimiento");
	}

	@Test
	public void validarClienteExistenciaPreviaTest() {
		// arrange
		Cliente usuario = new ClienteTestDataBuilder().build();
		RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
		Mockito.when(repositorioCliente.existe(Mockito.anyString())).thenReturn(true);
		ServicioCrearCliente servicioCrearCliente = new ServicioCrearCliente(repositorioCliente);

		// act - assert
		BasePrueba.assertThrows(() -> servicioCrearCliente.ejecutar(usuario), ExcepcionDuplicidad.class,
				"El usuario ya existe en el sistema");
	}

	@Test
	public void ejecutarTodoValido() {
		// arrange
		Cliente cliente = new ClienteTestDataBuilder().build();
		RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
		Mockito.when(repositorioCliente.existe(Mockito.anyString())).thenReturn(false);
		ServicioCrearCliente servicioCrearCliente = new ServicioCrearCliente(repositorioCliente);

		// act
		servicioCrearCliente.ejecutar(cliente);

		// assert
		Mockito.verify(repositorioCliente).crear(cliente);

	}

}
