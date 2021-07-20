package com.ceiba.dominio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Iterator;

import com.ceiba.dominio.excepcion.ExcepcionCierreFinesSemana;
import com.ceiba.dominio.excepcion.ExcepcionFechaReserva;
import com.ceiba.dominio.excepcion.ExcepcionHoraroReserva;

public class ValidadorReserva {

	private ValidadorReserva() {
	}

	public static void validarHorarioReserva(LocalDateTime fechaReseva, int horaInicial, int horaFinal,
			String mensaje) {
		int horaReserva = fechaReseva.getHour();
		if ((horaReserva < horaInicial) || (horaReserva >= horaFinal)) {
			throw new ExcepcionHoraroReserva(mensaje);
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
				throw new ExcepcionFechaReserva(mensajeAnticipado);
			}
		} else {
			throw new ExcepcionFechaReserva(mensajePrevio);
		}
	}

	public static void validarCierreFinesDeSemana(LocalDateTime fechaTCreacion, int diaInicial, int diaFinal,
			String mensaje) {

		int diaCreacion = fechaTCreacion.getDayOfWeek().getValue();
		if ((diaInicial > diaCreacion) || (diaFinal < diaCreacion)) {
			throw new ExcepcionCierreFinesSemana(mensaje);
		}
	}

	public static boolean validarIncrementoFinesSemana(LocalDateTime fechaTReserva, int diaInicial, int diaFinal) {

		int diaReserva = fechaTReserva.getDayOfWeek().getValue();
		return (diaInicial == diaReserva) || (diaFinal == diaReserva);
	}

	public static boolean validarIncrementoFestivos(LocalDate fechaTReserva) {
		LocalDate[] DIAS_FESTIVOS_COLOMBIA = { LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 11),
				LocalDate.of(2021, 3, 22), LocalDate.of(2021, 4, 1), LocalDate.of(2021, 4, 2), LocalDate.of(2021, 5, 1),
				LocalDate.of(2021, 5, 17), LocalDate.of(2021, 6, 7), LocalDate.of(2021, 6, 14),
				LocalDate.of(2021, 7, 5), LocalDate.of(2021, 7, 20), LocalDate.of(2021, 8, 7),
				LocalDate.of(2021, 8, 16), LocalDate.of(2021, 10, 18), LocalDate.of(2021, 11, 01),
				LocalDate.of(2021, 11, 15), LocalDate.of(2021, 12, 8), LocalDate.of(2021, 12, 25),
				LocalDate.of(2022, 1, 1), LocalDate.of(2022, 1, 10), LocalDate.of(2022, 3, 21),
				LocalDate.of(2022, 4, 14), LocalDate.of(2022, 4, 15), LocalDate.of(2022, 5, 01),
				LocalDate.of(2022, 5, 30), LocalDate.of(2022, 6, 20), LocalDate.of(2022, 6, 27),
				LocalDate.of(2022, 7, 4), LocalDate.of(2022, 7, 20), LocalDate.of(2022, 8, 7),
				LocalDate.of(2022, 8, 15), LocalDate.of(2022, 10, 17), LocalDate.of(2022, 11, 7),
				LocalDate.of(2022, 11, 14), LocalDate.of(2022, 12, 8), LocalDate.of(2022, 12, 25),
				LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 9), LocalDate.of(2023, 3, 20), LocalDate.of(2023, 4, 6),
				LocalDate.of(2023, 4, 7), LocalDate.of(2023, 5, 1), LocalDate.of(2023, 5, 22),
				LocalDate.of(2023, 6, 12), LocalDate.of(2023, 6, 19), LocalDate.of(2023, 7, 3),
				LocalDate.of(2023, 7, 20), LocalDate.of(2023, 8, 7), LocalDate.of(2023, 8, 21),
				LocalDate.of(2023, 10, 16), LocalDate.of(2023, 11, 06), LocalDate.of(2023, 11, 13),
				LocalDate.of(2023, 12, 8), LocalDate.of(2023, 12, 25), };

		for (int i = 0; i < DIAS_FESTIVOS_COLOMBIA.length; i++) {
			if (DIAS_FESTIVOS_COLOMBIA[i].equals(fechaTReserva)) {
				return true;
			}
		}
		return false;
	}

}
