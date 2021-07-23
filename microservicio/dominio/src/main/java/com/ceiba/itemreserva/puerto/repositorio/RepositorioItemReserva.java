package com.ceiba.itemreserva.puerto.repositorio;

import com.ceiba.itemreserva.modelo.entidad.ItemReserva;

public interface RepositorioItemReserva {
	/**
	 * Permite crear un itemReserva
	 * 
	 * @param itemReserva
	 * @return el id de la reserva
	 */
	Long crear(ItemReserva itemReserva);

	/**
	 * Permite actualizar una reserva
	 * 
	 * @param reserva
	 */
	void actualizar(ItemReserva itemReserva);

	/**
	 * Permite eliminar un itemReserva
	 * 
	 * @param id
	 */
	void eliminar(Long id);

	/**
	 * Permite validar si existe un itemReserva con id
	 * 
	 * @param id
	 * @return si existe o no
	 */
	boolean existe(Long id);
}
