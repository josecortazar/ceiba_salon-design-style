package com.ceiba.itemreserva.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.itemreserva.comando.ComandoItemReserva;
import com.ceiba.itemreserva.comando.fabrica.FabricaItemReserva;
import com.ceiba.itemreserva.modelo.entidad.ItemReserva;
import com.ceiba.itemreserva.servicio.ServicioCrearItemReserva;
import com.ceiba.manejador.ManejadorComandoRespuesta;

import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearItemReserva
		implements ManejadorComandoRespuesta<ComandoItemReserva, ComandoRespuesta<Long>> {

	private final FabricaItemReserva fabricaItemReserva;
	private final ServicioCrearItemReserva servicioCrearItemReserva;

	public ManejadorCrearItemReserva(FabricaItemReserva fabricaItemReserva,
			ServicioCrearItemReserva servicioCrearItemReserva) {
		this.fabricaItemReserva = fabricaItemReserva;
		this.servicioCrearItemReserva = servicioCrearItemReserva;
	}

	public ComandoRespuesta<Long> ejecutar(ComandoItemReserva comandoItemReserva) {
		ItemReserva itemReserva = this.fabricaItemReserva.crear(comandoItemReserva);
		return new ComandoRespuesta<>(this.servicioCrearItemReserva.ejecutar(itemReserva));
	}
}
