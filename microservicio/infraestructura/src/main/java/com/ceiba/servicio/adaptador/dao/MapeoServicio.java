package com.ceiba.servicio.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.servicio.modelo.dto.DtoServicio;

import org.springframework.jdbc.core.RowMapper;

public class MapeoServicio implements RowMapper<DtoServicio>, MapperResult {

	@Override
	public DtoServicio mapRow(ResultSet resultSet, int rowNum) throws SQLException {

		Long id = resultSet.getLong("idservicio");
		String nombre = resultSet.getString("nombre");
		String descripcion = resultSet.getString("descripcion");
		Double valor = resultSet.getDouble("valor");
		String imagen = resultSet.getString("imagen");
		
		return new DtoServicio(id, nombre, descripcion, valor, imagen);
	}

}
