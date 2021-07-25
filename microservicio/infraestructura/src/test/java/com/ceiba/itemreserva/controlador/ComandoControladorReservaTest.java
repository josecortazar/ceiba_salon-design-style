package com.ceiba.itemreserva.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

import com.ceiba.ApplicationMock;
import com.ceiba.itemreserva.comando.ComandoItemReserva;
import com.ceiba.itemreserva.servicio.testdatabuilder.ComandoItemReservaTestDataBuilder;

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
@WebMvcTest(ComandoControladorItemReserva.class)
public class ComandoControladorReservaTest {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MockMvc mocMvc;

	@Test
	public void crearItemReserva() throws Exception {
		// arrange
		ComandoItemReserva itemReserva = new ComandoItemReservaTestDataBuilder().build();

		// act - assert
		mocMvc.perform(post("/itemreservas").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(itemReserva))).andExpect(status().isOk())
				.andExpect(content().json("{'valor': 2}"));

	}

	@Test
	public void actualizarItemReserva() throws Exception {
		// arrange
		Long id = 1L;
		ComandoItemReserva itemReserva = new ComandoItemReservaTestDataBuilder().conId(id).build();

		// act - assert
		mocMvc.perform(put("/itemreservas/{id}", id).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(itemReserva))).andExpect(status().isOk());
	}

	@Test
	public void eliminarItemReserva() throws Exception {
		// arrange
		Long id = 2L;

		// act - assert
		mocMvc.perform(delete("/itemreservas/{id}", id).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

}
