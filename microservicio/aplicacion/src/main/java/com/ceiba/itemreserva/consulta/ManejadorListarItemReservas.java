package com.ceiba.itemreserva.consulta;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.itemreserva.modelo.dto.DtoItemReserva;
import com.ceiba.itemreserva.puerto.dao.DaoItemReserva;

@Component
public class ManejadorListarItemReservas {

	private final DaoItemReserva daoItemReservas;

	public ManejadorListarItemReservas(DaoItemReserva daoItemReservas) {
		this.daoItemReservas = daoItemReservas;
	}

	public List<DtoItemReserva> ejecutar() {
		return this.daoItemReservas.listar();
	}
}
