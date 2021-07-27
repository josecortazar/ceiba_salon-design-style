package com.ceiba.reserva.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.reserva.modelo.dto.DtoReserva;

import org.springframework.jdbc.core.RowMapper;

public class MapeoReserva implements RowMapper<DtoReserva>, MapperResult {

	@Override
	public DtoReserva mapRow(ResultSet resultSet, int rowNum) throws SQLException {

		Long id = resultSet.getLong("idreserva");
		Long idCliente = resultSet.getLong("idcliente");
		LocalDateTime fechaCreacion = extraerLocalDateTime(resultSet, "fechacreacion");
		LocalDateTime fechaReserva = extraerLocalDateTime(resultSet, "fechareserva");
		Double precioNeto = resultSet.getDouble("precioneto");
		Double modificacadorPrecio = resultSet.getDouble("preciototal");
		Long cantidadServicios = resultSet.getLong("cantidadservicios");
		Boolean esReservaDeMenor = resultSet.getBoolean("esreservademenor");

		return new DtoReserva(id, idCliente, fechaCreacion, fechaReserva, precioNeto, modificacadorPrecio, cantidadServicios, esReservaDeMenor);
	}

}
