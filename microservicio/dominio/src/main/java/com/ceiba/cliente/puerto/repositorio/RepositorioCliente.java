package com.ceiba.cliente.puerto.repositorio;

import com.ceiba.cliente.modelo.entidad.Cliente;

public interface RepositorioCliente {
	/**
	 * Permite crear un cliente
	 * 
	 * @param cliente
	 * @return el id
	 */
	Long crear(Cliente cliente);

	/**
	 * Permite actualizar un cliente
	 * 
	 * @param cliente
	 */
	void actualizar(Cliente cliente);

	/**
	 * Permite eliminar un cliente
	 * 
	 * @param id
	 */
	void eliminar(String identificacion);

	/**
	 * Permite validar si existe un cliente con id
	 * 
	 * @param id
	 * @return si existe o no
	 */
	boolean existe(String identificacion);

	/**
	 * Permite validar si existe un cliente con id
	 * 
	 * @param id
	 * @return si existe o no
	 */
	boolean existeId(Long id);

	/**
	 * Permite validar si existe un cliente con un nombre excluyendo un id
	 * 
	 * @param id, nombre
	 * @return si existe o no
	 */
	boolean existeExcluyendoId(Long id, String identificacion);

}
