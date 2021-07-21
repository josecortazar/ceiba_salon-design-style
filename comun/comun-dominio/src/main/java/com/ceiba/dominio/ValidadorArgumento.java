package com.ceiba.dominio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ceiba.dominio.excepcion.ExcepcionCierreFinesSemana;
import com.ceiba.dominio.excepcion.ExcepcionFechaReserva;
import com.ceiba.dominio.excepcion.ExcepcionHoraroReserva;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.dominio.util.FechasUtil;


public class ValidadorArgumento {

	private ValidadorArgumento() {
	}

	public static void validarObligatorio(Object valor, String mensaje) {
		if (valor == null) {
			throw new ExcepcionValorObligatorio(mensaje);
		}
	}

	public static void validarLongitud(String valor, int longitud, String mensaje) {
		if (valor.length() < longitud) {
			throw new ExcepcionLongitudValor(mensaje);
		}
	}

	public static <T> void validarNoVacio(List<T> lista, String mensaje) {
		if (lista.isEmpty()) {
			throw new ExcepcionValorObligatorio(mensaje);
		}
	}

	public static void validarPositivo(Double valor, String mensaje) {
		if (valor <= 0) {
			throw new ExcepcionValorInvalido(mensaje);
		}
	}

	public static void validarIgual(Double valor, Double valorEsperado, String mensaje) {
		if (!valor.equals(valorEsperado)) {
			throw new ExcepcionValorInvalido(mensaje);
		}
	}

	public static void validarLongitudMinima(Object valor, int longitudMinima, String mensaje) {
		if (valor.toString().length() < longitudMinima) {
			throw new ExcepcionLongitudValor(mensaje);
		}
	}

	public static void validarMenor(LocalDateTime fechaInicial, LocalDateTime fechaFinal, String mensaje) {
		if (fechaInicial.toLocalDate().isAfter(fechaFinal.toLocalDate())) {
			throw new ExcepcionValorInvalido(mensaje);
		}
	}

	public static void validarMenor(Long numeroInicial, Long numeroFinal, String mensaje) {
		if (numeroInicial > numeroFinal) {
			throw new ExcepcionValorInvalido(mensaje);
		}
	}

	public static void validarRegex(String correoElectronico, String regex, String mensaje) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(correoElectronico);

		if (!matcher.matches()) {
			throw new ExcepcionValorInvalido(mensaje);
		}
	}

	public static <E extends Enum<E>> E validarValido(String valor, Class<E> enumAObtener, String mensaje) {
		E enumObtenido = null;
		if (null != valor) {
			Optional<E> resultadoOpcional = Arrays.stream(enumAObtener.getEnumConstants())
					.filter(resultado -> resultado.toString().equals(valor)).findFirst();

			if (resultadoOpcional.isPresent()) {
				enumObtenido = resultadoOpcional.get();
			} else {
				throw new ExcepcionValorInvalido(mensaje);
			}
		}
		return enumObtenido;
	}

	public static void validarNumerico(String valor, String mensaje) {
		try {
			Long.parseLong(valor);
		} catch (NumberFormatException numberFormatException) {
			throw new ExcepcionValorInvalido(mensaje);
		}
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

	public static void validarCierreFestivos(LocalDate fechaTCreacion, String mensaje) {

		for (int i = 0; i < FechasUtil.DIAS_FESTIVOS_COLOMBIA.length; i++) {
			if (FechasUtil.DIAS_FESTIVOS_COLOMBIA[i].equals(fechaTCreacion)) {
				throw new ExcepcionCierreFinesSemana(mensaje);
			}
		}
	}

	public static boolean validarIncrementoFinesSemana(LocalDateTime fechaTReserva, int diaInicial, int diaFinal) {

		int diaReserva = fechaTReserva.getDayOfWeek().getValue();
		return (diaInicial == diaReserva) || (diaFinal == diaReserva);
	}

	public static boolean validarIncrementoFestivos(LocalDate fechaTReserva) {
		for (int i = 0; i < FechasUtil.DIAS_FESTIVOS_COLOMBIA.length; i++) {
			if (FechasUtil.DIAS_FESTIVOS_COLOMBIA[i].equals(fechaTReserva)) {
				return true;
			}
		}
		return false;
	}

	public static boolean validarMenorEdad(LocalDateTime fechaNacimiento) {

		long edad = ChronoUnit.YEARS.between(fechaNacimiento.toLocalDate(), LocalDate.now());
		return edad < 18;
	}
}
