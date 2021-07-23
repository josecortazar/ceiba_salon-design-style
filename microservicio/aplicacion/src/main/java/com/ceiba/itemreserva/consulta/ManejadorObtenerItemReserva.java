package com.ceiba.itemreserva.consulta;

import org.springframework.stereotype.Component;

import com.ceiba.aplicacion.excepcion.ExcepcionSinDatos;
import com.ceiba.itemreserva.modelo.dto.DtoItemReserva;
import com.ceiba.itemreserva.puerto.dao.DaoItemReserva;

@Component
public class ManejadorObtenerItemReserva {

	private final DaoItemReserva daoItemReserva;
	private static final String EL_ITEM_RESERVA_NO_EXISTE_EN_EL_SISTEMA = "El Item reserva no existe en el sistema";

	public ManejadorObtenerItemReserva(DaoItemReserva daoItemReserva) {
		this.daoItemReserva = daoItemReserva;
	}

	public DtoItemReserva ejecutar(Long id) {
		try {
			return this.daoItemReserva.obtener(id);
		} catch (Exception e) {
			throw new ExcepcionSinDatos(EL_ITEM_RESERVA_NO_EXISTE_EN_EL_SISTEMA);
		}

	}
}
