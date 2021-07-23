package com.ceiba.itemreserva.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Setter
@Getter
public class ItemReserva {

	private static final String SE_DEBE_INGRESAR_UNA_RESERVA = "Se debe ingresar una reserva";
	private static final String SE_DEBE_INGRESAR_UN_SERVICIO = "Se debe ingresar un servicio";

	private Long id;
	private Long idReserva;
	private Long idServicio;
	private String nombre;
	private Double valor;

	public ItemReserva(Long id, Long idReserva, Long idServicio, String nombre, Double valor) {

		validarObligatorio(idReserva, SE_DEBE_INGRESAR_UNA_RESERVA);
		validarObligatorio(idServicio, SE_DEBE_INGRESAR_UN_SERVICIO);

		this.id = id;
		this.idReserva = idReserva;
		this.idServicio = idServicio;
		this.nombre = nombre;
		this.valor = valor;
	}

}
