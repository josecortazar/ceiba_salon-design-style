package com.ceiba.reserva.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ceiba.ApplicationMock;
import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.servicio.testdatabuilder.ComandoReservaTestDataBuilder;
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
@WebMvcTest(ComandoControladorReserva.class)
public class ComandoControladorReservaTest {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MockMvc mocMvc;

	@Test
	public void crearReserva() throws Exception {
		// arrange
		ComandoReserva reserva = new ComandoReservaTestDataBuilder().build();

		// act - assert
		mocMvc.perform(post("/reservas").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(reserva))).andExpect(status().isOk())
				.andExpect(content().json("{'valor': 2}"));

	}

	@Test
	public void actualizarReserva() throws Exception {
		// arrange
		Long id = 1L;
		ComandoReserva reserva = new ComandoReservaTestDataBuilder().conId(id).build();

		// act - assert
		mocMvc.perform(put("/reservas/{id}", id).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(reserva))).andExpect(status().isOk());
	}

	@Test
	public void eliminarReserva() throws Exception {
		// arrange
		Long id = 2L;

		// act - assert
		mocMvc.perform(delete("/reservas/{id}", id).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

}
