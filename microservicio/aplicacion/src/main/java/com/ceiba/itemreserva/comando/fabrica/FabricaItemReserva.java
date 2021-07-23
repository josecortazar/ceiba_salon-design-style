package com.ceiba.itemreserva.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.itemreserva.comando.ComandoItemReserva;
import com.ceiba.itemreserva.modelo.entidad.ItemReserva;

@Component
public class FabricaItemReserva {

	public ItemReserva crear(ComandoItemReserva comandoItemReserva) {
		return new ItemReserva(
				comandoItemReserva.getId(),
				comandoItemReserva.getIdReserva(), 
				comandoItemReserva.getIdServicio(),
				comandoItemReserva.getNombre(),
				comandoItemReserva.getValor()
		);
	}

}
