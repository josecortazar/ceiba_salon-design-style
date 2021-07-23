package com.ceiba.itemreserva.controlador;

import java.util.List;

import com.ceiba.itemreserva.consulta.ManejadorListarItemReservas;
import com.ceiba.itemreserva.consulta.ManejadorObtenerItemReserva;
import com.ceiba.itemreserva.modelo.dto.DtoItemReserva;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/itemreservas")
@Api(tags = { "Controlador consulta Reserva" })
public class ConsultaControladorItemReserva {

	private final ManejadorListarItemReservas manejadorListarItemReservas;
	private final ManejadorObtenerItemReserva manejadorObtenerItemReserva;

	public ConsultaControladorItemReserva(ManejadorListarItemReservas manejadorListarItemReservas,
			ManejadorObtenerItemReserva manejadorObtenerItemReserva) {
		this.manejadorListarItemReservas = manejadorListarItemReservas;
		this.manejadorObtenerItemReserva = manejadorObtenerItemReserva;
	}

	@GetMapping
	@ApiOperation("Listar ItemReservas")
	public List<DtoItemReserva> listar() {
		return this.manejadorListarItemReservas.ejecutar();
	}

	@GetMapping(value = "/{id}")
	@ApiOperation("Obtener Reserva")
	public DtoItemReserva obtener(@PathVariable Long id) {
		return this.manejadorObtenerItemReserva.ejecutar(id);
	}

}
