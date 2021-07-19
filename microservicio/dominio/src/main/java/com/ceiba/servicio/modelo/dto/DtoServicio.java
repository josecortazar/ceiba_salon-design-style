package com.ceiba.servicio.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class DtoServicio{
    private Long id;
    private String nombre;
    private String descripcion;
    private Double valor;
    private String imagen;


}
