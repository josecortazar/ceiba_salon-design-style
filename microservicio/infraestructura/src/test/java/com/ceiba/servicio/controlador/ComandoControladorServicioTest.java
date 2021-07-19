package com.ceiba.servicio.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ceiba.ApplicationMock;
import com.ceiba.servicio.comando.ComandoServicio;
import com.ceiba.servicio.controlador.ComandoControladorServicio;
import com.ceiba.servicio.servicio.testdatabuilder.ComandoServicioTestDataBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoControladorServicio.class)
public class ComandoControladorServicioTest {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MockMvc mocMvc;

	@Test
	public void crearServicio() throws Exception {
		// arrange
		ComandoServicio servicio = new ComandoServicioTestDataBuilder().build();

		// act - assert
		mocMvc.perform(post("/servicios").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(servicio))).andExpect(status().isOk())
				.andExpect(content().json("{'valor': 2}"));

	}

	@Test
	public void actualizarServicio() throws Exception {
		// arrange
		Long id = 1L;
		ComandoServicio servicio = new ComandoServicioTestDataBuilder().conId(id).build();

		// act - assert
		mocMvc.perform(put("/servicios/{id}", id).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(servicio))).andExpect(status().isOk());
	}

	@Test
	public void eliminarServicio() throws Exception {
		// arrange
		Long id = 2L;

		// act - assert
		mocMvc.perform(delete("/servicios/{id}", id).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

}
