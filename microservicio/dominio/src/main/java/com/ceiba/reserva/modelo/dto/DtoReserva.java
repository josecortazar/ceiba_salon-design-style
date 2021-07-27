package com.ceiba.reserva.modelo.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class DtoReserva{
    private Long id;
    private Long idCliente;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaReserva;
    private Double precioNeto;
    private Double modificacadorPrecio;
    private Long cantidadServicios;
    private Boolean esReservaDeMenor;   
}
