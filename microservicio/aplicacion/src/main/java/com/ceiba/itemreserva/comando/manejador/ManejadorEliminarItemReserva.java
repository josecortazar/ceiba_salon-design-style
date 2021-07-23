package com.ceiba.itemreserva.comando.manejador;

import com.ceiba.itemreserva.servicio.ServicioEliminarItemReserva;
import com.ceiba.manejador.ManejadorComando;

import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarItemReserva implements ManejadorComando<Long> {

	private final ServicioEliminarItemReserva servicioEliminarItemReserva;

	public ManejadorEliminarItemReserva(ServicioEliminarItemReserva servicioEliminarItemReserva) {
		this.servicioEliminarItemReserva = servicioEliminarItemReserva;
	}

	public void ejecutar(Long id) {
		this.servicioEliminarItemReserva.ejecutar(id);
	}
}
