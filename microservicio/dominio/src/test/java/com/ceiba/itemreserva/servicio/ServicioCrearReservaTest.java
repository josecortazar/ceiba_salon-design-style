package com.ceiba.itemreserva.servicio;

import static org.junit.Assert.assertThat;

import java.time.LocalDateTime;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;

import com.ceiba.itemreserva.modelo.entidad.ItemReserva;
import com.ceiba.itemreserva.puerto.repositorio.RepositorioItemReserva;
import com.ceiba.itemreserva.servicio.testdatabuilder.DtoReservaTestDataBuilder;
import com.ceiba.itemreserva.servicio.testdatabuilder.DtoServicioTestDataBuilder;
import com.ceiba.itemreserva.servicio.testdatabuilder.ItemReservaTestDataBuilder;
import com.ceiba.reserva.puerto.dao.DaoReserva;
import com.ceiba.servicio.puerto.dao.DaoServicio;

public class ServicioCrearReservaTest {

	private ItemReserva itemReserva;
	private RepositorioItemReserva repositorioItemReserva;
	private DtoReservaTestDataBuilder dtoReservaTestDataBuilder;
	private DtoServicioTestDataBuilder dtoServicioTestDataBuilder;
	private DaoReserva daoReserva;
	private DaoServicio daoServicio;

	@Before
	public void setup() {
		// arrange
		itemReserva = new ItemReservaTestDataBuilder().build();
		repositorioItemReserva = Mockito.mock(RepositorioItemReserva.class);

		dtoReservaTestDataBuilder = new DtoReservaTestDataBuilder();
		daoReserva = Mockito.mock(DaoReserva.class);

		dtoServicioTestDataBuilder = new DtoServicioTestDataBuilder();
		daoServicio = Mockito.mock(DaoServicio.class);
	}

	@Test
	public void validarItemReservaSinReservaRegistradaEnSistema() {
		// arrange
		Mockito.when(repositorioItemReserva.existe(Mockito.anyLong())).thenReturn(false);
		Mockito.when(daoReserva.obtener(Mockito.anyLong())).thenReturn(null);

		ServicioCrearItemReserva servicioCrearItemReserva = new ServicioCrearItemReserva(repositorioItemReserva,
				daoReserva, daoServicio);
		// act - assert
		BasePrueba.assertThrows(() -> servicioCrearItemReserva.ejecutar(itemReserva), ExcepcionSinDatos.class,
				"La reserva no se encontro en el sistema");
	}

	@Test
	public void validarItemReservaSinServicioYConReserva() {
		// arrange
		Mockito.when(repositorioItemReserva.existe(Mockito.anyLong())).thenReturn(false);
		Mockito.when(daoReserva.obtener(Mockito.anyLong())).thenReturn(dtoReservaTestDataBuilder.build());
		Mockito.when(daoServicio.obtener(Mockito.anyLong())).thenReturn(null);

		ServicioCrearItemReserva servicioCrearItemReserva = new ServicioCrearItemReserva(repositorioItemReserva,
				daoReserva, daoServicio);
		// act - assert
		BasePrueba.assertThrows(() -> servicioCrearItemReserva.ejecutar(itemReserva), ExcepcionSinDatos.class,
				"El servicio no se encontro en el sistema");
	}

	@Test
	public void validarItemReservaSinReservaYConServicio() {
		// arrange
		Mockito.when(repositorioItemReserva.existe(Mockito.anyLong())).thenReturn(false);
		Mockito.when(daoReserva.obtener(Mockito.anyLong())).thenReturn(null);
		Mockito.when(daoServicio.obtener(Mockito.anyLong())).thenReturn(dtoServicioTestDataBuilder.build());

		ServicioCrearItemReserva servicioCrearItemReserva = new ServicioCrearItemReserva(repositorioItemReserva,
				daoReserva, daoServicio);
		// act - assert
		BasePrueba.assertThrows(() -> servicioCrearItemReserva.ejecutar(itemReserva), ExcepcionSinDatos.class,
				"La reserva no se encontro en el sistema");
	}

	@Test
	public void validarItemReservaExistenciaPreviaTest() {
		// arrange
		Mockito.when(repositorioItemReserva.existe(Mockito.anyLong())).thenReturn(true);
		Mockito.when(daoReserva.obtener(Mockito.anyLong())).thenReturn(dtoReservaTestDataBuilder.build());
		Mockito.when(daoServicio.obtener(Mockito.anyLong())).thenReturn(dtoServicioTestDataBuilder.build());

		ServicioCrearItemReserva servicioCrearItemReserva = new ServicioCrearItemReserva(repositorioItemReserva,
				daoReserva, daoServicio);
		// act - assert
		BasePrueba.assertThrows(() -> servicioCrearItemReserva.ejecutar(itemReserva), ExcepcionDuplicidad.class,
				"El itemReserva ya existe en el sistema");
	}

	@Test
	public void ejecutarTodoValido() {
		// arrange
		Mockito.when(repositorioItemReserva.existe(Mockito.anyLong())).thenReturn(false);
		Mockito.when(daoReserva.obtener(Mockito.anyLong())).thenReturn(dtoReservaTestDataBuilder.build());
		Mockito.when(daoServicio.obtener(Mockito.anyLong())).thenReturn(dtoServicioTestDataBuilder.build());

		ServicioCrearItemReserva servicioCrearItemReserva = new ServicioCrearItemReserva(repositorioItemReserva,
				daoReserva, daoServicio);

		// act
		servicioCrearItemReserva.ejecutar(itemReserva);
		// assert
		Mockito.verify(repositorioItemReserva).crear(itemReserva);
	}
}
