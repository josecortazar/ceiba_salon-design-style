package com.ceiba.cliente.consulta;

import org.springframework.stereotype.Component;

import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.cliente.puerto.dao.DaoCliente;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;

@Component
public class ManejadorObtenerCliente {

	private final DaoCliente daoCliente;
	private static final String EL_USUARIO_NO_EXISTE_EN_EL_SISTEMA = "El cliente no existe en el sistema";

	public ManejadorObtenerCliente(DaoCliente daoCliente) {
		this.daoCliente = daoCliente;
	}

	public DtoCliente ejecutar(String identificacion) {
		try {
			return this.daoCliente.obtener(identificacion);
		} catch (Exception e) {
			throw new ExcepcionSinDatos(EL_USUARIO_NO_EXISTE_EN_EL_SISTEMA);
		}
	}
}
