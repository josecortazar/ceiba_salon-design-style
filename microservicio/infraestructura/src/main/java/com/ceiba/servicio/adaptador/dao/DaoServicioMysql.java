package com.ceiba.servicio.adaptador.dao;

import java.util.List;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.servicio.modelo.dto.DtoServicio;
import com.ceiba.servicio.puerto.dao.DaoServicio;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class DaoServicioMysql implements DaoServicio {

	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

	@SqlStatement(namespace = "servicio", value = "listar")
	private static String sqlListar;

	@SqlStatement(namespace = "servicio", value = "obtener")
	private static String sqlObtener;

	public DaoServicioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	@Override
	public List<DtoServicio> listar() {
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar,
				new MapeoServicio());
	}

	@Override
	public DtoServicio obtener(Long id) {
		MapSqlParameterSource parametro = new MapSqlParameterSource();
		parametro.addValue("id", id);
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
				.query(sqlObtener, parametro, new MapeoServicio()).iterator().next();
	}

}
