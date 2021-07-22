package com.ceiba.dominio.excepcion;

public class ExcepcionAccionInvalida extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionAccionInvalida(String mensaje) {
		super(mensaje);
	}
}
