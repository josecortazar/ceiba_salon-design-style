package com.ceiba.itemreserva.puerto.dao;

import com.ceiba.itemreserva.modelo.dto.DtoItemReserva;

import java.util.List;

public interface DaoItemReserva {

	/**
	 * Permite listar las reservas
	 * 
	 * @return Lista de DTOs de reservas
	 */
	List<DtoItemReserva> listar();

	/**
	 * Permite obtener una reserva segun su id
	 * @param id
	 * @return DTO de reserva
	 */
	DtoItemReserva obtener(Long id);
	
	
}
