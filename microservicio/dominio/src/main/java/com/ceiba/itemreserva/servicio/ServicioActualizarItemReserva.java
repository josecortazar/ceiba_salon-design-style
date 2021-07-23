package com.ceiba.itemreserva.servicio;

import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.itemreserva.modelo.entidad.ItemReserva;
import com.ceiba.itemreserva.puerto.repositorio.RepositorioItemReserva;

public class ServicioActualizarItemReserva {

	private static final String EL_ITEM_DE_LA_RESERVA_NO_EXISTE_EN_EL_SISTEMA = "El item de la reserva no existe en el sistema";

	private final RepositorioItemReserva repositorioItemReserva;

	public ServicioActualizarItemReserva(RepositorioItemReserva repositorioItemReserva) {
		this.repositorioItemReserva = repositorioItemReserva;
	}

	public void ejecutar(ItemReserva itemReserva) {
		validarExistenciaPrevia(itemReserva);
		this.repositorioItemReserva.actualizar(itemReserva);
	}

	private void validarExistenciaPrevia(ItemReserva itemReserva) {
		boolean existe = this.repositorioItemReserva.existe(itemReserva.getId());
		if (!existe) {
			throw new ExcepcionSinDatos(EL_ITEM_DE_LA_RESERVA_NO_EXISTE_EN_EL_SISTEMA);
		}
	}
}
