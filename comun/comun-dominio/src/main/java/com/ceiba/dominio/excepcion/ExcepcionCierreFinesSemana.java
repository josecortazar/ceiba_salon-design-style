package com.ceiba.dominio.excepcion;

public class ExcepcionCierreFinesSemana extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionCierreFinesSemana(String mensaje) {
		super(mensaje);
	}
}
