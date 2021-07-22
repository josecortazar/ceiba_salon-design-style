package com.ceiba.reserva.validador;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import com.ceiba.dominio.excepcion.ExcepcionAccionInvalida;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;

import static com.ceiba.reserva.validador.util.FechasUtil.DIAS_FESTIVOS_COLOMBIA;

public class ValidadorReserva {

	private ValidadorReserva() {
	}

	public static void validarHorarioReserva(LocalDateTime fechaReseva, int horaInicial, int horaFinal,
			String mensaje) {
		int horaReserva = fechaReseva.getHour();
		if ((horaReserva < horaInicial) || (horaReserva >= horaFinal)) {
			throw new ExcepcionValorInvalido(mensaje);
		}
	}

	public static void validarFechaReserva(LocalDateTime fechaTReserva, LocalDateTime fechaTCreacion,
			int mesesAntcipacion, String mensajePrevio, String mensajeAnticipado) {

		if (fechaTCreacion.isBefore(fechaTReserva)) {

			LocalDate fechaReserva = fechaTReserva.toLocalDate();
			LocalDate fechaCreacion = fechaTCreacion.toLocalDate();

			int diferenciaAno = fechaReserva.getYear() - fechaCreacion.getYear();
			int diferenciaMes = (diferenciaAno * 12) + (fechaReserva.getMonthValue() - fechaCreacion.getMonthValue());

			if (diferenciaMes > mesesAntcipacion) {
				throw new ExcepcionValorInvalido(mensajeAnticipado);
			}
		} else {
			throw new ExcepcionValorInvalido(mensajePrevio);
		}
	}

	public static void validarCierreFinesDeSemana(LocalDateTime fechaTCreacion, int diaInicial, int diaFinal,
			String mensaje) {

		int diaCreacion = fechaTCreacion.getDayOfWeek().getValue();
		if ((diaInicial > diaCreacion) || (diaFinal < diaCreacion)) {
			throw new ExcepcionAccionInvalida(mensaje);
		}
	}

	public static void validarCierreFestivos(LocalDate fechaTCreacion, String mensaje) {

		for (int i = 0; i < DIAS_FESTIVOS_COLOMBIA.length; i++) {
			if (DIAS_FESTIVOS_COLOMBIA[i].equals(fechaTCreacion)) {
				throw new ExcepcionAccionInvalida(mensaje);
			}
		}
	}

	public static boolean validarIncrementoFinesSemana(LocalDateTime fechaTReserva, int diaInicial, int diaFinal) {

		int diaReserva = fechaTReserva.getDayOfWeek().getValue();
		return (diaInicial == diaReserva) || (diaFinal == diaReserva);
	}

	public static boolean validarIncrementoFestivos(LocalDate fechaTReserva) {
		for (int i = 0; i < DIAS_FESTIVOS_COLOMBIA.length; i++) {
			if (DIAS_FESTIVOS_COLOMBIA[i].equals(fechaTReserva)) {
				return true;
			}
		}
		return false;
	}

	public static boolean validarDescuento(Long cantidad, Long cantidadParaDescuento) {
		return cantidad >= cantidadParaDescuento;
	}

	public static boolean validarMenorEdad(LocalDateTime fechaNacimiento) {

		long edad = ChronoUnit.YEARS.between(fechaNacimiento.toLocalDate(), LocalDate.now());
		return edad < 18;
	}

}
