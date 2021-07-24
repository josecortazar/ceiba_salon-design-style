package com.ceiba.cliente.controlador;

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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ConsultaControladorCliente.class)
public class ConsultaControladorClienteTest {

	@Autowired
	private MockMvc mocMvc;

	@Test
	public void listarClientes() throws Exception {
		// arrange act - assert
		mocMvc.perform(MockMvcRequestBuilders.get("/clientes").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$[0].nombre").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].nombre").value("Luisa Gomez"));

	}

	@Test
	public void obtenerCliente() throws Exception {
		// arrange act - assert
		String identificacion = "1094952356";
		mocMvc.perform(MockMvcRequestBuilders.get("/clientes/{identificacion}", identificacion)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("identificacion", is("1094952356")));
	}

}
