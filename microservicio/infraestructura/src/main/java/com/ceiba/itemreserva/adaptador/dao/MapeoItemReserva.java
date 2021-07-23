package com.ceiba.itemreserva.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.itemreserva.modelo.dto.DtoItemReserva;

import org.springframework.jdbc.core.RowMapper;

public class MapeoItemReserva implements RowMapper<DtoItemReserva>, MapperResult {

	@Override
	public DtoItemReserva mapRow(ResultSet resultSet, int rowNum) throws SQLException {

		Long id = resultSet.getLong("iditemreserva");
		Long idReserva = resultSet.getLong("idreserva");
		Long idServicio = resultSet.getLong("idservicio");
		String nombre = resultSet.getString("nombre");
		Double valor = resultSet.getDouble("valor");

		return new DtoItemReserva(id, idReserva, idServicio, nombre, valor);
	}

}
