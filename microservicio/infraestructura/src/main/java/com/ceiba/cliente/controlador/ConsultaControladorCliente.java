package com.ceiba.cliente.controlador;

import java.util.List;

import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.cliente.consulta.ManejadorListarClientes;
import com.ceiba.cliente.consulta.ManejadorObtenerCliente;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/clientes")
@Api(tags = { "Controlador consulta Cliente" })
public class ConsultaControladorCliente {

	private final ManejadorListarClientes manejadorListarClientes;
	private final ManejadorObtenerCliente manejadorObtenerCliente;

	public ConsultaControladorCliente(ManejadorListarClientes manejadorListarClientes,
			ManejadorObtenerCliente manejadorObtenerCliente) {
		this.manejadorListarClientes = manejadorListarClientes;
		this.manejadorObtenerCliente = manejadorObtenerCliente;
	}

	@GetMapping
	@ApiOperation("Listar Clientes")
	public List<DtoCliente> listar() {
		return this.manejadorListarClientes.ejecutar();
	}

	@GetMapping(value = "/{identificacion}")
	@ApiOperation("Obtener Cliente")
	public DtoCliente obtener(@PathVariable String identificacion) {
		return this.manejadorObtenerCliente.ejecutar(identificacion);
	}

}
