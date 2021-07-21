package com.ceiba.excepcion;

public class ExcepcionFechaReserva extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionFechaReserva(String mensaje) {
		super(mensaje);
	}
}
