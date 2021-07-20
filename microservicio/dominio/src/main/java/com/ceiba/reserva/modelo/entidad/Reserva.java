package com.ceiba.reserva.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.dominio.ValidadorReserva.validarCierreFinesDeSemana;
import static com.ceiba.dominio.ValidadorReserva.validarFechaReserva;
import static com.ceiba.dominio.ValidadorReserva.validarHorarioReserva;
import static com.ceiba.dominio.ValidadorReserva.validarIncrementoFinesSemana;
import static com.ceiba.dominio.ValidadorReserva.validarIncrementoFestivos;

import java.time.LocalDateTime;

@Getter
public class Reserva {

	private static final String SE_DEBE_INGRESAR_EL_CLIENTE_DE_LA_RESERVA = "Se debe ingresar el cliente de la reserva";
	private static final String SE_DEBE_INGRESAR_UNA_FECHA_PARA_RESERVA = "Se debe ingresar una fecha para la reserva";

	private static final String HORARIO_NO_VALIDO = "El horario para asignar la reserva no es valido";
	private static final String FECHA_NO_VALIDA_ANTICIPACION = "La fecha para la reserva no valida, tiene mas de 4 meses de anticipacion";
	private static final String FECHA_NO_VALIDA_PREVIA = "La fecha para la reserva no valida, no es hecha previamente";
	private static final String FIN_DE_SEMANA = "La plataforma esta cerrada para reservas los fines de semana";

	private static final int HORA_INICIAL = 7;
	private static final int HORA_FINAL = 20;

	private static final int MESES_ANTICIPACION = 4;

	private static final int DIA_INICIAL_LUNES_RESERVAS = 1;
	private static final int DIA_FINAL_VIERNES_RESERVAS = 5;

	private static final double INCREMENTO_FINES_DE_SEMANA = 0.1;
	private static final double INCREMENTO_FESTIVOS = 0.15;

	private static final int DIA_DOMINGO = 7;
	private static final int DIA_SABADO = 6;

	private Long id;
	private Long idCliente;
	private LocalDateTime fechaCreacion;
	private LocalDateTime fechaReserva;
	private Double precioNeto;
	private Double precioTotal;
	private Boolean esReservaDeMenor;

	public Reserva(Long id, Long idCliente, LocalDateTime fechaCreacion, LocalDateTime fechaReserva, Double precioNeto,
			Double precioTotal, Boolean esReservaDeMenor) {

		double alteracionPrecio = 1;

		validarObligatorio(idCliente, SE_DEBE_INGRESAR_EL_CLIENTE_DE_LA_RESERVA);
		validarObligatorio(fechaReserva, SE_DEBE_INGRESAR_UNA_FECHA_PARA_RESERVA);

		validarHorarioReserva(fechaReserva, HORA_INICIAL, HORA_FINAL, HORARIO_NO_VALIDO);
		validarFechaReserva(fechaReserva, fechaCreacion, MESES_ANTICIPACION, FECHA_NO_VALIDA_PREVIA,
				FECHA_NO_VALIDA_ANTICIPACION);
		validarCierreFinesDeSemana(fechaCreacion, DIA_INICIAL_LUNES_RESERVAS, DIA_FINAL_VIERNES_RESERVAS,
				FIN_DE_SEMANA);

		if (validarIncrementoFestivos(fechaReserva.toLocalDate())) {
			alteracionPrecio = 1.15;
		} else if (validarIncrementoFinesSemana(fechaReserva, DIA_SABADO, DIA_DOMINGO)) {
			alteracionPrecio = 1.1;
		}

		this.id = id;
		this.idCliente = idCliente;
		this.fechaCreacion = fechaCreacion;
		this.fechaReserva = fechaReserva;
		this.precioNeto = precioNeto;
		this.precioTotal = precioTotal * alteracionPrecio;
		this.esReservaDeMenor = esReservaDeMenor;
	}

}
