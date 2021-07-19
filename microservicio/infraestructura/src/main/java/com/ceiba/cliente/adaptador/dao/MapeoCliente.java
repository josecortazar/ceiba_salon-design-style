package com.ceiba.cliente.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

public class MapeoCliente implements RowMapper<DtoCliente>, MapperResult {

	@Override
	public DtoCliente mapRow(ResultSet resultSet, int rowNum) throws SQLException {

		Long id = resultSet.getLong("idcliente");
		String nombre = resultSet.getString("nombre");
		String identificacion = resultSet.getString("identificacion");
		String correoElectronico = resultSet.getString("correoelectronico");
		String numTelefono = resultSet.getString("numtelefono");
		LocalDateTime fechaNacimiento = extraerLocalDateTime(resultSet, "fechanacimiento");
		
		return new DtoCliente(id, nombre, identificacion, correoElectronico, numTelefono, fechaNacimiento);
	}

}
