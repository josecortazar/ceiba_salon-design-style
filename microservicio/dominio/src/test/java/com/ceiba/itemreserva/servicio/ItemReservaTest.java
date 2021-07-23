package com.ceiba.itemreserva.servicio;

import org.junit.Test;

import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.itemreserva.servicio.testdatabuilder.ItemReservaTestDataBuilder;

import com.ceiba.BasePrueba;

public class ItemReservaTest {

	@Test
	public void validarCampoReserva() {
		// arrange
		ItemReservaTestDataBuilder itemReservaTestDataBuilder = new ItemReservaTestDataBuilder().conReserva(null);
		// act - assert
		BasePrueba.assertThrows(() -> itemReservaTestDataBuilder.build(), ExcepcionValorObligatorio.class,
				"Se debe ingresar una reserva");
	}

	@Test
	public void validarCampoServicio() {
		// arrange
		ItemReservaTestDataBuilder itemReservaTestDataBuilder = new ItemReservaTestDataBuilder().conServicio(null);
		// act - assert
		BasePrueba.assertThrows(() -> itemReservaTestDataBuilder.build(), ExcepcionValorObligatorio.class,
				"Se debe ingresar un servicio");
	}

}
