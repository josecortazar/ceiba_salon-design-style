package com.ceiba.servicio.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoServicio{

    private Long id;
    private String nombre;
    private String descripcion;
    private Double valor;
    private String imagen;
    
}
