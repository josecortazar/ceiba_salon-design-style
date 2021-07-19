package com.ceiba.configuracion;

import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.cliente.servicio.ServicioActualizarCliente;
import com.ceiba.cliente.servicio.ServicioCrearCliente;
import com.ceiba.cliente.servicio.ServicioEliminarCliente;
import com.ceiba.servicio.puerto.repositorio.RepositorioServicio;
import com.ceiba.servicio.servicio.ServicioActualizarServicio;
import com.ceiba.servicio.servicio.ServicioCrearServicio;
import com.ceiba.servicio.servicio.ServicioEliminarServicio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {
	
	/**
	 * Clientes
	 */

	@Bean
	public ServicioCrearCliente servicioCrearCliente(RepositorioCliente repositorioCliente) {
		return new ServicioCrearCliente(repositorioCliente);
	}

	@Bean
	public ServicioEliminarCliente servicioEliminarCliente(RepositorioCliente repositorioCliente) {
		return new ServicioEliminarCliente(repositorioCliente);
	}

	@Bean
	public ServicioActualizarCliente servicioActualizarCliente(RepositorioCliente repositorioCliente) {
		return new ServicioActualizarCliente(repositorioCliente);
	}
	
	/**
	 * Servicios
	 */
	
	@Bean
	public ServicioCrearServicio servicioCrearServicio(RepositorioServicio repositorioServicio) {
		return new ServicioCrearServicio(repositorioServicio);
	}

	@Bean
	public ServicioEliminarServicio servicioEliminarServicio(RepositorioServicio repositorioServicio) {
		return new ServicioEliminarServicio(repositorioServicio);
	}

	@Bean
	public ServicioActualizarServicio servicioActualizarServicio(RepositorioServicio repositorioServicio) {
		return new ServicioActualizarServicio(repositorioServicio);
	}

}
