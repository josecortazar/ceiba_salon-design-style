package com.ceiba.servicio.puerto.dao;

import com.ceiba.servicio.modelo.dto.DtoServicio;

import java.util.List;

public interface DaoServicio {

	/**
	 * Permite listar los servicios
	 * 
	 * @return lista de DTOs de servicios
	 */
	List<DtoServicio> listar();

	/**
	 * Permite obtener un servicio segun su id
	 * @param id
	 * @return servicio en un DTO
	 */
	DtoServicio obtener(Long id);
	
	
}
