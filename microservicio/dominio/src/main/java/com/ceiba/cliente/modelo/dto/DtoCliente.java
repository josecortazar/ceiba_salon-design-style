package com.ceiba.cliente.modelo.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class DtoCliente {
    private Long id;
    private String nombre;
    private String identificacion;
    private String correoElectronico;
    private String numTelefono;
    private LocalDateTime fechaNacimiento;

}
