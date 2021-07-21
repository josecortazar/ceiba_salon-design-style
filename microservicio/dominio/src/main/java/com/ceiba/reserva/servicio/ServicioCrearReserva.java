package com.ceiba.reserva.servicio;

import com.ceiba.cliente.puerto.dao.DaoCliente;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;

import static com.ceiba.dominio.ValidadorArgumento.validarMenorEdad;

import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;

public class ServicioCrearReserva {

	private static final String LA_SERVICIO_YA_EXISTE_EN_EL_SISTEMA = "La reserva ya existe en el sistema";

	private static final String EL_CLIENTE_NO_EXISTE_EN_EL_SISTEMA = "El cliente no existe en el sistema";

	private final RepositorioReserva repositorioReserva;
	private final DaoCliente daoCliente;

	public ServicioCrearReserva(RepositorioReserva repositorioReserva, DaoCliente daoCliente) {
		this.repositorioReserva = repositorioReserva;
		this.daoCliente = daoCliente;
	}

	public Long ejecutar(Reserva reserva) {
		validarExistenciaPrevia(reserva);
		reserva.setEsReservaDeMenor(esClienteMenor(reserva));
		return this.repositorioReserva.crear(reserva);
	}

	private void validarExistenciaPrevia(Reserva reserva) {
		boolean existe = this.repositorioReserva.existe(reserva.getId());
		if (existe) {
			throw new ExcepcionDuplicidad(LA_SERVICIO_YA_EXISTE_EN_EL_SISTEMA);
		}
	}

	private boolean esClienteMenor(Reserva reserva) {
		try {
			return validarMenorEdad(daoCliente.obtener(reserva.getIdCliente()).getFechaNacimiento());
		} catch (Exception e) {
			throw new ExcepcionSinDatos(EL_CLIENTE_NO_EXISTE_EN_EL_SISTEMA);
		}
	}

}
