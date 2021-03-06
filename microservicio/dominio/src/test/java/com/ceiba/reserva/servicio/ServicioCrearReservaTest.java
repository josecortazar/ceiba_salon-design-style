package com.ceiba.reserva.servicio;

import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.servicio.testdatabuilder.DtoClienteTestDataBuilder;
import com.ceiba.reserva.servicio.testdatabuilder.ReservaTestDataBuilder;

import static org.junit.Assert.assertThat;

import java.time.LocalDateTime;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.puerto.dao.DaoCliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;

public class ServicioCrearReservaTest {

	private Reserva reserva;
	private RepositorioReserva repositorioReserva;
	private RepositorioCliente repositorioCliente;
	private DtoClienteTestDataBuilder dtoClienteTestDataBuilder;
	private DaoCliente daoCliente;

	@Before
	public void setup() {
		// arrange
		reserva = new ReservaTestDataBuilder().build();
		repositorioReserva = Mockito.mock(RepositorioReserva.class);
		repositorioCliente = Mockito.mock(RepositorioCliente.class);

		dtoClienteTestDataBuilder = new DtoClienteTestDataBuilder();
		daoCliente = Mockito.mock(DaoCliente.class);
	}

	@Test
	public void validarReservaClienteMayor() {
		// arrange
		Mockito.when(repositorioReserva.existe(Mockito.anyLong())).thenReturn(false);
		Mockito.when(repositorioCliente.existeId(Mockito.anyLong())).thenReturn(true);
		dtoClienteTestDataBuilder = dtoClienteTestDataBuilder.conFechanacimiento(LocalDateTime.of(1990, 7, 16, 11, 00));
		Mockito.when(daoCliente.obtener(Mockito.anyLong())).thenReturn(dtoClienteTestDataBuilder.build());

		ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva, repositorioCliente,
				daoCliente);
		// act
		servicioCrearReserva.ejecutar(reserva);
		// assert
		assertThat(false, CoreMatchers.is(reserva.getEsReservaDeMenor()));
	}

	@Test
	public void validarReservaClienteMenor() {
		// arrange
		Mockito.when(repositorioReserva.existe(Mockito.anyLong())).thenReturn(false);
		Mockito.when(repositorioCliente.existeId(Mockito.anyLong())).thenReturn(true);
		dtoClienteTestDataBuilder = dtoClienteTestDataBuilder.conFechanacimiento(LocalDateTime.of(2010, 7, 16, 11, 00));
		Mockito.when(daoCliente.obtener(Mockito.anyLong())).thenReturn(dtoClienteTestDataBuilder.build());

		ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva, repositorioCliente,
				daoCliente);
		// act
		servicioCrearReserva.ejecutar(reserva);
		// assert
		assertThat(true, CoreMatchers.is(reserva.getEsReservaDeMenor()));
	}

	@Test
	public void validarReservaSinClienteRegistradoEnSistema() {
		// arrange
		Mockito.when(repositorioReserva.existe(Mockito.anyLong())).thenReturn(false);
		Mockito.when(daoCliente.obtener(Mockito.anyLong())).thenReturn(null);

		ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva, repositorioCliente,
				daoCliente);
		// act - assert
		BasePrueba.assertThrows(() -> servicioCrearReserva.ejecutar(reserva), ExcepcionSinDatos.class,
				"El cliente no se encontro en el sistema");
	}

	@Test
	public void validarReservaExistenciaPreviaTest() {
		// arrange
		Mockito.when(repositorioReserva.existe(Mockito.anyLong())).thenReturn(true);
		Mockito.when(repositorioCliente.existeId(Mockito.anyLong())).thenReturn(true);
		Mockito.when(daoCliente.obtener(Mockito.anyLong())).thenReturn(dtoClienteTestDataBuilder.build());

		ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva, repositorioCliente,
				daoCliente);
		// act - assert
		BasePrueba.assertThrows(() -> servicioCrearReserva.ejecutar(reserva), ExcepcionDuplicidad.class,
				"La reserva ya existe en el sistema");
	}

	@Test
	public void ejecutarTodoValido() {
		// arrange
		Mockito.when(repositorioReserva.existe(Mockito.anyLong())).thenReturn(false);
		Mockito.when(repositorioCliente.existeId(Mockito.anyLong())).thenReturn(true);
		Mockito.when(daoCliente.obtener(Mockito.anyLong())).thenReturn(dtoClienteTestDataBuilder.build());

		ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva, repositorioCliente,
				daoCliente);
		// act
		servicioCrearReserva.ejecutar(reserva);
		// assert
		Mockito.verify(repositorioReserva).crear(reserva);
	}
}
