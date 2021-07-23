package com.ceiba.itemreserva.servicio;

import com.ceiba.itemreserva.puerto.repositorio.RepositorioItemReserva;

public class ServicioEliminarItemReserva {

	private final RepositorioItemReserva repositorioItemReserva;

	public ServicioEliminarItemReserva(RepositorioItemReserva repositorioItemReserva) {
		this.repositorioItemReserva = repositorioItemReserva;
	}

	public void ejecutar(Long id) {
		this.repositorioItemReserva.eliminar(id);
	}
}
