package com.ceiba.reserva.consulta;

import org.springframework.stereotype.Component;

import com.ceiba.excepcion.ExcepcionSinDatos;
import com.ceiba.reserva.modelo.dto.DtoReserva;
import com.ceiba.reserva.puerto.dao.DaoReserva;

@Component
public class ManejadorObtenerReserva {

	private final DaoReserva daoReserva;
	private static final String LA_RESERVA_NO_EXISTE_EN_EL_SISTEMA = "La reserva no existe en el sistema";

	public ManejadorObtenerReserva(DaoReserva daoReserva) {
		this.daoReserva = daoReserva;
	}

	public DtoReserva ejecutar(Long id) {
		try {
			return this.daoReserva.obtener(id);
		} catch (Exception e) {
			throw new ExcepcionSinDatos(LA_RESERVA_NO_EXISTE_EN_EL_SISTEMA);
		}

	}
}
