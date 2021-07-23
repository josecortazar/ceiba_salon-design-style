package com.ceiba.itemreserva.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class DtoItemReserva{
	
    private Long id;
    private Long idReserva;
    private Long idServicio;
    private String nombre;
    private Double valor;
  
}
