package com.ceiba.servicio.puerto.dao;

import com.ceiba.servicio.modelo.dto.DtoServicio;

import java.util.List;

public interface DaoServicio {

	/**
	 * Permite listar los servicios
	 * 
	 * @return los clientes
	 */
	List<DtoServicio> listar();

	/**
	 * Permite obtener un cliente segun su identificacion
	 * @param identificacion
	 * @return
	 */
	DtoServicio obtener(Long id);
	
	
}
