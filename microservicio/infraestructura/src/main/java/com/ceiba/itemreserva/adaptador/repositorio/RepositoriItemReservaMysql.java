package com.ceiba.itemreserva.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.itemreserva.modelo.entidad.ItemReserva;
import com.ceiba.itemreserva.puerto.repositorio.RepositorioItemReserva;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositoriItemReservaMysql implements RepositorioItemReserva {

	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

	private static final String CAMPO_ID_ITEM_RESERVA = "id";
	private static final String CAMPO_ID_RESERVA = "idReserva";

	@SqlStatement(namespace = "itemreserva", value = "crear")
	private static String sqlCrear;

	@SqlStatement(namespace = "itemreserva", value = "actualizar")
	private static String sqlActualizar;
	
	@SqlStatement(namespace = "itemreserva", value = "actualizarcantidad")
	private static String sqlActualizarCantidad;
	
	@SqlStatement(namespace = "itemreserva", value = "eliminar")
	private static String sqlEliminar;

	@SqlStatement(namespace = "itemreserva", value = "existe")
	private static String sqlExiste;

	public RepositoriItemReservaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	@Override
	public Long crear(ItemReserva itemReserva) {
		
		Long respuesta =  this.customNamedParameterJdbcTemplate.crear(itemReserva, sqlCrear);
		
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue(CAMPO_ID_RESERVA, itemReserva.getIdReserva());
		
		this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlActualizarCantidad, paramSource);
				
		return respuesta;
		
	}

	@Override
	public void eliminar(Long id) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue(CAMPO_ID_ITEM_RESERVA, id);

		this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
	}

	@Override
	public boolean existe(Long id) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue(CAMPO_ID_ITEM_RESERVA, id);

		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,
				paramSource, Boolean.class);
	}

	@Override
	public void actualizar(ItemReserva itemReserva) {
		this.customNamedParameterJdbcTemplate.actualizar(itemReserva, sqlActualizar);
	}

}
