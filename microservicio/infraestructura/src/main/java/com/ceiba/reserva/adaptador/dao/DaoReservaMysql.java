package com.ceiba.reserva.adaptador.dao;

import java.util.List;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.reserva.modelo.dto.DtoReserva;
import com.ceiba.reserva.puerto.dao.DaoReserva;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class DaoReservaMysql implements DaoReserva {

	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

	@SqlStatement(namespace = "reserva", value = "listar")
	private static String sqlListar;

	@SqlStatement(namespace = "reserva", value = "obtener")
	private static String sqlObtener;

	@SqlStatement(namespace = "reserva", value = "listarporcliente")
	private static String sqlListarPorCliente;

	public DaoReservaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	@Override
	public List<DtoReserva> listar() {
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar,
				new MapeoReserva());
	}

	@Override
	public DtoReserva obtener(Long id) {
		MapSqlParameterSource parametro = new MapSqlParameterSource();
		parametro.addValue("id", id);
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
				.query(sqlObtener, parametro, new MapeoReserva()).iterator().next();
	}

	@Override
	public List<DtoReserva> listarPorCliente(String identificacion) {
		MapSqlParameterSource parametro = new MapSqlParameterSource();
		parametro.addValue("identificacion", identificacion);
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorCliente,
				parametro, new MapeoReserva());
	}

}
