package com.ceiba.dominio.excepcion;

public class ExcepcionHoraroReserva extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionHoraroReserva(String mensaje) {
        super(mensaje);
    }
}
