package com.ceiba.itemreserva.controlador;

import java.util.List;

import com.ceiba.itemreserva.consulta.ManejadorListarItemReservas;
import com.ceiba.itemreserva.consulta.ManejadorListarItemReservasPorReserva;
import com.ceiba.itemreserva.consulta.ManejadorObtenerItemReserva;
import com.ceiba.itemreserva.modelo.dto.DtoItemReserva;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/itemreservas")
@Api(tags = { "Controlador consulta ItemReserva" })
public class ConsultaControladorItemReserva {

	private final ManejadorListarItemReservas manejadorListarItemReservas;
	private final ManejadorObtenerItemReserva manejadorObtenerItemReserva;
	private final ManejadorListarItemReservasPorReserva manejadorListarItemReservasPorReserva;

	public ConsultaControladorItemReserva(ManejadorListarItemReservas manejadorListarItemReservas,
			ManejadorObtenerItemReserva manejadorObtenerItemReserva,
			ManejadorListarItemReservasPorReserva manejadorListarItemReservasPorReserva) {
		this.manejadorListarItemReservas = manejadorListarItemReservas;
		this.manejadorObtenerItemReserva = manejadorObtenerItemReserva;
		this.manejadorListarItemReservasPorReserva = manejadorListarItemReservasPorReserva;
	}

	@GetMapping
	@ApiOperation("Listar ItemReservas")
	public List<DtoItemReserva> listar() {
		return this.manejadorListarItemReservas.ejecutar();
	}

	@GetMapping(value = "/{id}")
	@ApiOperation("Obtener ItemReserva")
	public DtoItemReserva obtener(@PathVariable Long id) {
		return this.manejadorObtenerItemReserva.ejecutar(id);
	}

	@GetMapping(value = "/reserva/{id}")
	@ApiOperation("Listar los Item de una reserva")
	public List<DtoItemReserva> listarPorReserva(@PathVariable Long id) {
		return this.manejadorListarItemReservasPorReserva.ejecutar(id);
	}

}
