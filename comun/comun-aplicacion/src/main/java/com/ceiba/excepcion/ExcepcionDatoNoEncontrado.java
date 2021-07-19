package com.ceiba.excepcion;

public class ExcepcionDatoNoEncontrado extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
    public ExcepcionDatoNoEncontrado(String message) {
        super(message);
    }
}
