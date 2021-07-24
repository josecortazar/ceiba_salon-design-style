package com.ceiba.servicio.controlador;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ceiba.ApplicationMock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

//@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = ApplicationMock.class)
//@WebMvcTest(ConsultaControladorServicio.class)
public class ConsultaControladorServicioTest {

//	@Autowired
//	private MockMvc mocMvc;
//
//	@Test
//	public void listarServicios() throws Exception {
//		// arrange act - assert
//		mocMvc.perform(get("/servicios").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
//				.andExpect(jsonPath("$", hasSize(1))).andExpect(jsonPath("$[0].nombre", is("Mascarilla Capilar")));
//	}
//
//	@Test
//	public void obtenerServicio() throws Exception {
//		// arrange act - assert
//		mocMvc.perform(get("/servicios/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
//				.andExpect(jsonPath("nombre", is("Mascarilla Capilar")));
//	}

}
