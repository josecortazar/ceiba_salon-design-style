package com.ceiba.itemreserva.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.itemreserva.comando.ComandoItemReserva;
import com.ceiba.itemreserva.comando.fabrica.FabricaItemReserva;
import com.ceiba.itemreserva.modelo.entidad.ItemReserva;
import com.ceiba.itemreserva.servicio.ServicioActualizarItemReserva;
import com.ceiba.manejador.ManejadorComando;

@Component
public class ManejadorActualizarItemReserva implements ManejadorComando<ComandoItemReserva> {

	private final FabricaItemReserva fabricaItemReserva;
	private final ServicioActualizarItemReserva servicioActualizarItemReserva;

	public ManejadorActualizarItemReserva(FabricaItemReserva fabricaReserva,
			ServicioActualizarItemReserva servicioActualizarReserva) {
		this.fabricaItemReserva = fabricaReserva;
		this.servicioActualizarItemReserva = servicioActualizarReserva;
	}

	public void ejecutar(ComandoItemReserva comandoItemReserva) {
		ItemReserva itemReserva = this.fabricaItemReserva.crear(comandoItemReserva);
		this.servicioActualizarItemReserva.ejecutar(itemReserva);
	}
}
