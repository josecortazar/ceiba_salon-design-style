package com.ceiba.reserva.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioReservaMysql implements RepositorioReserva {

	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

	private static final String CAMPO_ID_RESERVA = "id";

	@SqlStatement(namespace = "reserva", value = "crear")
	private static String sqlCrear;

	@SqlStatement(namespace = "reserva", value = "actualizar")
	private static String sqlActualizar;

	@SqlStatement(namespace = "reserva", value = "eliminar")
	private static String sqlEliminar;

	@SqlStatement(namespace = "reserva", value = "existe")
	private static String sqlExiste;

	public RepositorioReservaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	@Override
	public Long crear(Reserva reserva) {
		return this.customNamedParameterJdbcTemplate.crear(reserva, sqlCrear);
	}

	@Override
	public void eliminar(Long id) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue(CAMPO_ID_RESERVA, id);

		this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
	}

	@Override
	public boolean existe(Long id) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue(CAMPO_ID_RESERVA, id);

		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,
				paramSource, Boolean.class);
	}

	@Override
	public void actualizar(Reserva reserva) {
		this.customNamedParameterJdbcTemplate.actualizar(reserva, sqlActualizar);
	}

}
