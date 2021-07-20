package com.ceiba.reserva.servicio;

import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;

public class ServicioActualizarReserva {

	private static final String LA_SERVICIO_NO_EXISTE_EN_EL_SISTEMA = "La reserva no existe en el sistema";

	private final RepositorioReserva repositorioReserva;

	public ServicioActualizarReserva(RepositorioReserva repositorioReserva) {
		this.repositorioReserva = repositorioReserva;
	}

	public void ejecutar(Reserva reserva) {
		validarExistenciaPrevia(reserva);
		this.repositorioReserva.actualizar(reserva);
	}

	private void validarExistenciaPrevia(Reserva reserva) {
		boolean existe = this.repositorioReserva.existe(reserva.getId());
		if (!existe) {
			throw new ExcepcionSinDatos(LA_SERVICIO_NO_EXISTE_EN_EL_SISTEMA);
		}
	}
}
