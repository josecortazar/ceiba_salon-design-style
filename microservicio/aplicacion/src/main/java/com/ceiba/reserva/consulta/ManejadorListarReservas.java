package com.ceiba.reserva.consulta;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.reserva.modelo.dto.DtoReserva;
import com.ceiba.reserva.puerto.dao.DaoReserva;

@Component
public class ManejadorListarReservas {

	private final DaoReserva daoReserva;

	public ManejadorListarReservas(DaoReserva daoReserva) {
		this.daoReserva = daoReserva;
	}

	public List<DtoReserva> ejecutar() {
		return this.daoReserva.listar();
	}
}
