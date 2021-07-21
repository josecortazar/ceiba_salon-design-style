package com.ceiba.cliente.adaptador.repositorio;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioClienteMysql implements RepositorioCliente {

	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

	private static final String CAMPO_IDENTIFICACION = "identificacion";
	private static final String CAMPO_ID = "id";

	@SqlStatement(namespace = "cliente", value = "crear")
	private static String sqlCrear;

	@SqlStatement(namespace = "cliente", value = "actualizar")
	private static String sqlActualizar;

	@SqlStatement(namespace = "cliente", value = "eliminar")
	private static String sqlEliminar;

	@SqlStatement(namespace = "cliente", value = "existe")
	private static String sqlExiste;

	@SqlStatement(namespace = "cliente", value = "existeExcluyendoId")
	private static String sqlExisteExcluyendoId;

	public RepositorioClienteMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	@Override
	public Long crear(Cliente cliente) {
		return this.customNamedParameterJdbcTemplate.crear(cliente, sqlCrear);
	}

	@Override
	public void eliminar(String identificacion) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue(CAMPO_IDENTIFICACION, identificacion);

		this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
	}

	@Override
	public boolean existe(String identificacion) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue(CAMPO_IDENTIFICACION, identificacion);

		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,
				paramSource, Boolean.class);
	}

	@Override
	public void actualizar(Cliente cliente) {
		this.customNamedParameterJdbcTemplate.actualizar(cliente, sqlActualizar);
	}

	@Override
	public boolean existeExcluyendoId(Long id, String identificacion) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue(CAMPO_ID, id);
		paramSource.addValue(CAMPO_IDENTIFICACION, identificacion);

		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
				.queryForObject(sqlExisteExcluyendoId, paramSource, Boolean.class);
	}
}
