package com.ceiba.itemreserva.adaptador.dao;

import java.util.List;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.itemreserva.modelo.dto.DtoItemReserva;
import com.ceiba.itemreserva.puerto.dao.DaoItemReserva;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class DaoItemReservaMysql implements DaoItemReserva {

	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

	@SqlStatement(namespace = "itemreserva", value = "listar")
	private static String sqlListar;

	@SqlStatement(namespace = "itemreserva", value = "obtener")
	private static String sqlObtener;

	public DaoItemReservaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	@Override
	public List<DtoItemReserva> listar() {
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar,
				new MapeoItemReserva());
	}

	@Override
	public DtoItemReserva obtener(Long id) {
		MapSqlParameterSource parametro = new MapSqlParameterSource();
		parametro.addValue("id", id);
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
				.query(sqlObtener, parametro, new MapeoItemReserva()).iterator().next();
	}

}
