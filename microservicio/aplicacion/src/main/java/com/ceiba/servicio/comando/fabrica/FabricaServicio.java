package com.ceiba.servicio.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.servicio.comando.ComandoServicio;
import com.ceiba.servicio.modelo.entidad.Servicio;


@Component
public class FabricaServicio {

    public Servicio crear(ComandoServicio comandoServicio) {
        return new Servicio(
        		comandoServicio.getId(),
                comandoServicio.getNombre(),
                comandoServicio.getDescripcion(),
        		comandoServicio.getValor(),
        		comandoServicio.getImagen()
        );
    }

}
