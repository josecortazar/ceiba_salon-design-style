package com.ceiba.cliente.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ceiba.ApplicationMock;
import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.cliente.servicio.testdatabuilder.ComandoClienteTestDataBuilder;
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
@WebMvcTest(ComandoControladorCliente.class)
public class ComandoControladorClienteTest {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MockMvc mocMvc;

	@Test
	public void crearCliente() throws Exception {
		// arrange
		ComandoCliente cliente = new ComandoClienteTestDataBuilder().build();

		// act - assert
		mocMvc.perform(post("/clientes").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(cliente))).andExpect(status().isOk())
				.andExpect(content().json("{'valor': 2}"));

	}

	@Test
	public void actualizarCliente() throws Exception {
		// arrange
		String identificacion = "10951623635";
		ComandoCliente cliente = new ComandoClienteTestDataBuilder().conNombre("Juana").build();

		// act - assert
		mocMvc.perform(put("/clientes/{identificacion}", identificacion).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(cliente))).andExpect(status().isOk());
	}

	@Test
	public void eliminarCliente() throws Exception {
		// arrange
		String identificacion = "10951623635";

		// act - assert
		mocMvc.perform(
				delete("/clientes/{identificacion}", identificacion).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	
	
}
