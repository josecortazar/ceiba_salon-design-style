package com.ceiba.servicio.puerto.repositorio;

import com.ceiba.servicio.modelo.entidad.Servicio;

public interface RepositorioServicio {
	/**
	 * Permite crear un servicio
	 * 
	 * @param servicio
	 * @return el id
	 */
	Long crear(Servicio servicio);

	/**
	 * Permite actualizar un servicio
	 * 
	 * @param servicio
	 */
	void actualizar(Servicio servicio);

	/**
	 * Permite eliminar un servicio
	 * 
	 * @param id
	 */
	void eliminar(Long id);

	/**
	 * Permite validar si existe un servicio con id
	 * 
	 * @param id
	 * @return si existe o no
	 */
	boolean existe(Long id);



}
