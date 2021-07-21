package com.ceiba.servicio.servicio;

import com.ceiba.servicio.modelo.entidad.Servicio;
import com.ceiba.servicio.puerto.repositorio.RepositorioServicio;
import com.ceiba.servicio.servicio.testdatabuilder.ServicioTestDataBuilder;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;

public class ServicioCrearServicioTest {

	@Test
	public void validarCampoNombre() {
		// arrange
		ServicioTestDataBuilder servicioTestDataBuilder = new ServicioTestDataBuilder().conNombre(null);
		// act - assert
		BasePrueba.assertThrows(() -> servicioTestDataBuilder.build(), ExcepcionValorObligatorio.class,
				"Se debe ingresar el nombre del servicio");
	}

	@Test
	public void validarIdentificaionTest() {
		// arrange
		ServicioTestDataBuilder servicioTestDataBuilder = new ServicioTestDataBuilder().conDescripcion(null);
		// act - assert
		BasePrueba.assertThrows(() -> servicioTestDataBuilder.build(), ExcepcionValorObligatorio.class,
				"Se debe ingresar una descricion del servicio");
	}

	@Test
	public void validarCampoValor() {
		// arrange
		ServicioTestDataBuilder servicioTestDataBuilder = new ServicioTestDataBuilder().conValor(null);
		// act - assert
		BasePrueba.assertThrows(() -> servicioTestDataBuilder.build(), ExcepcionValorObligatorio.class,
				"Se debe ingresar el valor del servicio");
	}

	@Test
	public void validarURLImagenTest() {
		// arrange
		ServicioTestDataBuilder servicioTestDataBuilder = new ServicioTestDataBuilder().conImagen("asd3216545052.jpg");
		// act - assert
		BasePrueba.assertThrows(() -> servicioTestDataBuilder.build(), ExcepcionValorInvalido.class,
				"Se debe ingresar una url valida");
	}

	@Test
	public void validarCampoURLImagenTest() {
		// arrange
		ServicioTestDataBuilder servicioTestDataBuilder = new ServicioTestDataBuilder().conImagen(null);
		// act - assert
		BasePrueba.assertThrows(() -> servicioTestDataBuilder.build(), ExcepcionValorObligatorio.class,
				"Se debe ingresar una url para la imagen del servicio");
	}

	@Test
	public void validarServicioExistenciaPreviaTest() {
		// arrange
		Servicio servicio = new ServicioTestDataBuilder().build();
		RepositorioServicio repositorioServicio = Mockito.mock(RepositorioServicio.class);
		Mockito.when(repositorioServicio.existe(Mockito.anyLong())).thenReturn(true);
		ServicioCrearServicio servicioCrearServicio = new ServicioCrearServicio(repositorioServicio);

		// act - assert
		BasePrueba.assertThrows(() -> servicioCrearServicio.ejecutar(servicio), ExcepcionDuplicidad.class,
				"El servicio ya existe en el sistema");
	}

	@Test
	public void ejecutarTodoValido() {
		// arrange
		Servicio servicio = new ServicioTestDataBuilder().build();
		RepositorioServicio repositorioServicio = Mockito.mock(RepositorioServicio.class);
		Mockito.when(repositorioServicio.existe(Mockito.anyLong())).thenReturn(false);
		ServicioCrearServicio servicioCrearServicio = new ServicioCrearServicio(repositorioServicio);

		// act
		servicioCrearServicio.ejecutar(servicio);

		// assert
		Mockito.verify(repositorioServicio).crear(servicio);

	}

}
