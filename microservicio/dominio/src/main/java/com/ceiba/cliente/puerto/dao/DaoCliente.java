package com.ceiba.cliente.puerto.dao;

import com.ceiba.cliente.modelo.dto.DtoCliente;

import java.util.List;

public interface DaoCliente {

	/**
	 * Permite listar clientes
	 * 
	 * @return los clientes
	 */
	List<DtoCliente> listar();

	/**
	 * Permite obtener un cliente segun su identificacion
	 * @param identificacion
	 * @return
	 */
	DtoCliente obtener(String identificacion);
	
	
}
