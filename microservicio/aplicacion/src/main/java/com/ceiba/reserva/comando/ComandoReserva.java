package com.ceiba.reserva.comando;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoReserva{

    private Long id;
    private Long idCliente;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaReserva;
    private Double precioNeto;
    private Long cantidadServicios;
    private Boolean esReservaDeMenor;
    
}
