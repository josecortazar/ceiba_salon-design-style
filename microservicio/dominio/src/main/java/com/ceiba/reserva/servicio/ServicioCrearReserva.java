package com.ceiba.reserva.servicio;

import com.ceiba.cliente.puerto.dao.DaoCliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;

import static com.ceiba.reserva.validador.ValidadorReserva.validarMenorEdad;

import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;

public class ServicioCrearReserva {

	private static final String LA_RESERVA_YA_EXISTE_EN_EL_SISTEMA = "La reserva ya existe en el sistema";
	private static final String EL_CLIENTE_NO_SE_ENCONTRO_EN_EL_SISTEMA = "El cliente no se encontro en el sistema";

	private final RepositorioReserva repositorioReserva;

	private final RepositorioCliente repositorioCliente;
	private final DaoCliente daoCliente;

	public ServicioCrearReserva(RepositorioReserva repositorioReserva, RepositorioCliente repositorioCliente,
			DaoCliente daoCliente) {
		this.repositorioReserva = repositorioReserva;
		this.repositorioCliente = repositorioCliente;
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
			throw new ExcepcionDuplicidad(LA_RESERVA_YA_EXISTE_EN_EL_SISTEMA);
		}
	}

	private boolean esClienteMenor(Reserva reserva) {
		boolean existe = this.repositorioCliente.existeId(reserva.getIdCliente());
		if (existe) {
			return validarMenorEdad(daoCliente.obtener(reserva.getIdCliente()).getFechaNacimiento());
		}
		throw new ExcepcionSinDatos(EL_CLIENTE_NO_SE_ENCONTRO_EN_EL_SISTEMA);

	}

}
