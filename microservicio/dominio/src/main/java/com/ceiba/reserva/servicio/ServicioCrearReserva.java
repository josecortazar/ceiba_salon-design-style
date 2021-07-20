package com.ceiba.reserva.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;

public class ServicioCrearReserva {

	private static final String LA_SERVICIO_YA_EXISTE_EN_EL_SISTEMA = "La reserva ya existe en el sistema";

	private final RepositorioReserva repositorioReserva;

	public ServicioCrearReserva(RepositorioReserva repositorioReserva) {
		this.repositorioReserva = repositorioReserva;
	}

	public Long ejecutar(Reserva reserva) {
		validarExistenciaPrevia(reserva);
		return this.repositorioReserva.crear(reserva);
	}

	private void validarExistenciaPrevia(Reserva reserva) {
		boolean existe = this.repositorioReserva.existe(reserva.getId());
		if (existe) {
			throw new ExcepcionDuplicidad(LA_SERVICIO_YA_EXISTE_EN_EL_SISTEMA);
		}
	}

}
