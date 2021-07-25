package com.ceiba.reserva.controlador;

import java.util.List;

import com.ceiba.reserva.consulta.ManejadorListarReservas;
import com.ceiba.reserva.consulta.ManejadorListarReservasPorCliente;
import com.ceiba.reserva.consulta.ManejadorObtenerReserva;
import com.ceiba.reserva.modelo.dto.DtoReserva;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/reservas")
@Api(tags = { "Controlador consulta Reserva" })
public class ConsultaControladorReserva {

	private final ManejadorListarReservas manejadorListarReservas;
	private final ManejadorObtenerReserva manejadorObtenerReserva;
	private final ManejadorListarReservasPorCliente manejadorListarReservaPorCliente;

	public ConsultaControladorReserva(ManejadorListarReservas manejadorListarReservas,
			ManejadorObtenerReserva manejadorObtenerReserva,
			ManejadorListarReservasPorCliente manejadorListarReservaPorCliente) {
		this.manejadorListarReservas = manejadorListarReservas;
		this.manejadorObtenerReserva = manejadorObtenerReserva;
		this.manejadorListarReservaPorCliente = manejadorListarReservaPorCliente;
	}

	@GetMapping
	@ApiOperation("Listar Reservas")
	public List<DtoReserva> listar() {
		return this.manejadorListarReservas.ejecutar();
	}

	@GetMapping(value = "/{id}")
	@ApiOperation("Obtener Reserva")
	public DtoReserva obtener(@PathVariable Long id) {
		return this.manejadorObtenerReserva.ejecutar(id);
	}

	@GetMapping(value = "/cliente/{identificacion}")
	@ApiOperation("Listar las reservas de un cliente")
	public List<DtoReserva> listarPorCliente(@PathVariable String identificacion) {
		return this.manejadorListarReservaPorCliente.ejecutar(identificacion);
	}

}
