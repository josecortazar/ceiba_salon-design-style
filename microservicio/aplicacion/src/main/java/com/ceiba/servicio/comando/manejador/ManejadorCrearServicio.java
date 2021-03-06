package com.ceiba.servicio.comando.manejador;

import com.ceiba.ComandoRespuesta;


import com.ceiba.servicio.comando.ComandoServicio;
import com.ceiba.servicio.comando.fabrica.FabricaServicio;
import com.ceiba.servicio.modelo.entidad.Servicio;
import com.ceiba.servicio.servicio.ServicioCrearServicio;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearServicio implements ManejadorComandoRespuesta<ComandoServicio, ComandoRespuesta<Long>> {

	private final FabricaServicio fabricaServicio;
	private final ServicioCrearServicio servicioCrearServicio;

	public ManejadorCrearServicio(FabricaServicio fabricaServicio, ServicioCrearServicio servicioCrearServicio) {
		this.fabricaServicio = fabricaServicio;
		this.servicioCrearServicio = servicioCrearServicio;
	}

	public ComandoRespuesta<Long> ejecutar(ComandoServicio comandoServicio) {
		Servicio servicio = this.fabricaServicio.crear(comandoServicio);
		return new ComandoRespuesta<>(this.servicioCrearServicio.ejecutar(servicio));
	}
}
