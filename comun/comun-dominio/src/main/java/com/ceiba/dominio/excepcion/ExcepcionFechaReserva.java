package com.ceiba.dominio.excepcion;

public class ExcepcionFechaReserva extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionFechaReserva(String mensaje) {
		super(mensaje);
	}
}
