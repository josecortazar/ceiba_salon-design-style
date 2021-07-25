package com.ceiba.reserva.puerto.dao;

import com.ceiba.reserva.modelo.dto.DtoReserva;

import java.util.List;

public interface DaoReserva {

	/**
	 * Permite listar las reservas
	 * 
	 * @return Lista de DTOs de reservas
	 */
	List<DtoReserva> listar();

	/**
	 * Permite obtener una reserva segun su id
	 * @param id
	 * @return DTO de reserva
	 */
	DtoReserva obtener(Long id);
	
	/**
	 * Permite listar las reservas de un cliente
	 * 
	 * @return Lista de DTOs de reservas
	 */
	List<DtoReserva> listarPorCliente(String identificacion);
	
}
