package com.ceiba.itemreserva.controlador;

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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ConsultaControladorItemReserva.class)
public class ConsultaControladorReservaTest {

	@Autowired
	private MockMvc mocMvc;

	@Test
	public void listarItemReservas() throws Exception {
		// arrange act - assert

		mocMvc.perform(MockMvcRequestBuilders.get("/itemreservas").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$[0].idReserva").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].idReserva").value(1));
	}

	@Test
	public void obtenerItemReserva() throws Exception {
		// arrange act - assert
		Long id = 1L;
		mocMvc.perform(MockMvcRequestBuilders.get("/itemreservas/{id}", id).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("id").value(1));
	}
	
	@Test
	public void listarItemDeUnaReserva() throws Exception {
		// arrange act - assert
		Long id = 1L;
		mocMvc.perform(MockMvcRequestBuilders.get("/itemreservas/reserva/{id}", id).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$[0].idReserva").exists())
		.andExpect(MockMvcResultMatchers.jsonPath("$[0].idReserva").value(1));
	}
}
