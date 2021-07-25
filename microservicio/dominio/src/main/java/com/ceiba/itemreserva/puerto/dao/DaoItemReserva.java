package com.ceiba.itemreserva.puerto.dao;

import com.ceiba.itemreserva.modelo.dto.DtoItemReserva;

import java.util.List;

public interface DaoItemReserva {

	/**
	 * Permite listar las reservas
	 * 
	 * @return Lista de DTOs de itemreservas
	 */
	List<DtoItemReserva> listar();

	/**
	 * Permite obtener un itemreserva segun su id
	 * 
	 * @param id
	 * @return DTO de itemreserva
	 */
	DtoItemReserva obtener(Long id);

	/**
	 * Permite listar los item de una reserva
	 * 
	 * @return Lista de DTOs de itemreservas
	 */
	List<DtoItemReserva> listarPorReserva(Long id);

}
