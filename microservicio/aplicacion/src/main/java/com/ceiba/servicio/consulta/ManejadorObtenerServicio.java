package com.ceiba.servicio.consulta;

import org.springframework.stereotype.Component;

import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.servicio.modelo.dto.DtoServicio;
import com.ceiba.servicio.puerto.dao.DaoServicio;

@Component
public class ManejadorObtenerServicio {

	private final DaoServicio daoServicio;
	private static final String EL_SERVICIO_NO_EXISTE_EN_EL_SISTEMA = "El servicio no existe en el sistema";

	public ManejadorObtenerServicio(DaoServicio daoServicio) {
		this.daoServicio = daoServicio;
	}

	public DtoServicio ejecutar(Long id) {
		try {
			return this.daoServicio.obtener(id);
		} catch (Exception e) {
			throw new ExcepcionSinDatos(EL_SERVICIO_NO_EXISTE_EN_EL_SISTEMA);
		}

	}
}
