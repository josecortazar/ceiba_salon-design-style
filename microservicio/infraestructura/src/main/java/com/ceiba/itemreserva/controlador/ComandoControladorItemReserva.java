package com.ceiba.itemreserva.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.itemreserva.comando.ComandoItemReserva;
import com.ceiba.itemreserva.comando.manejador.ManejadorActualizarItemReserva;
import com.ceiba.itemreserva.comando.manejador.ManejadorCrearItemReserva;
import com.ceiba.itemreserva.comando.manejador.ManejadorEliminarItemReserva;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/itemreservas")
@Api(tags = { "Controlador comando ItemReserva" })
public class ComandoControladorItemReserva {

	private final ManejadorCrearItemReserva manejadorCrearItemReserva;
	private final ManejadorEliminarItemReserva manejadorEliminarItemReserva;
	private final ManejadorActualizarItemReserva manejadorActualizarItemReserva;

	@Autowired
	public ComandoControladorItemReserva(ManejadorCrearItemReserva manejadorCrearItemReserva,
			ManejadorEliminarItemReserva manejadorEliminarItemReserva,
			ManejadorActualizarItemReserva manejadorActualizarItemReserva) {

		this.manejadorCrearItemReserva = manejadorCrearItemReserva;
		this.manejadorEliminarItemReserva = manejadorEliminarItemReserva;
		this.manejadorActualizarItemReserva = manejadorActualizarItemReserva;
	}

	@PostMapping
	@ApiOperation("Crear Item ItemReserva")
	public ComandoRespuesta<Long> crear(@RequestBody ComandoItemReserva comandoItemReserva) {
		return manejadorCrearItemReserva.ejecutar(comandoItemReserva);
	}

	@DeleteMapping(value = "/{id}")
	@ApiOperation("Eliminar Item ItemReserva")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarItemReserva.ejecutar(id);
	}

	@PutMapping(value = "/{id}")
	@ApiOperation("Actualizar Item ItemReserva")
	public void actualizar(@RequestBody ComandoItemReserva comandoItemReserva, @PathVariable Long id) {
		comandoItemReserva.setId(id);
		manejadorActualizarItemReserva.ejecutar(comandoItemReserva);
	}
}
