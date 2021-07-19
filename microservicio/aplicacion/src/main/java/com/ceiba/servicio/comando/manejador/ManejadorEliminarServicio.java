package com.ceiba.servicio.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.servicio.servicio.ServicioEliminarServicio;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarServicio implements ManejadorComando<Long> {

	private final ServicioEliminarServicio servicioEliminarServicio;

	public ManejadorEliminarServicio(ServicioEliminarServicio servicioEliminarServicio) {
		this.servicioEliminarServicio = servicioEliminarServicio;
	}

	public void ejecutar(Long id) {
		this.servicioEliminarServicio.ejecutar(id);
	}
}
