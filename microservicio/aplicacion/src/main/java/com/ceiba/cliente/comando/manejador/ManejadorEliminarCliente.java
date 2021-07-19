package com.ceiba.cliente.comando.manejador;

import com.ceiba.cliente.servicio.ServicioEliminarCliente;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarCliente implements ManejadorComando<String> {

	private final ServicioEliminarCliente servicioEliminarCliente;

	public ManejadorEliminarCliente(ServicioEliminarCliente servicioEliminarCliente) {
		this.servicioEliminarCliente = servicioEliminarCliente;
	}

	public void ejecutar(String identificacion) {
		this.servicioEliminarCliente.ejecutar(identificacion);
	}
}
