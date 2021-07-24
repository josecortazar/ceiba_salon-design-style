package com.ceiba.configuracion;

import com.ceiba.cliente.puerto.dao.DaoCliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.cliente.servicio.ServicioActualizarCliente;
import com.ceiba.cliente.servicio.ServicioCrearCliente;
import com.ceiba.cliente.servicio.ServicioEliminarCliente;
import com.ceiba.itemreserva.puerto.repositorio.RepositorioItemReserva;
import com.ceiba.itemreserva.servicio.ServicioActualizarItemReserva;
import com.ceiba.itemreserva.servicio.ServicioCrearItemReserva;
import com.ceiba.itemreserva.servicio.ServicioEliminarItemReserva;
import com.ceiba.reserva.puerto.dao.DaoReserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.servicio.ServicioActualizarReserva;
import com.ceiba.reserva.servicio.ServicioCrearReserva;
import com.ceiba.reserva.servicio.ServicioEliminarReserva;
import com.ceiba.servicio.puerto.dao.DaoServicio;
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

	/**
	 * Reservas
	 */

	@Bean
	public ServicioCrearReserva servicioCrearReserva(RepositorioReserva repositorioReserva,
			RepositorioCliente repositorioCliente, DaoCliente daoCliente) {
		return new ServicioCrearReserva(repositorioReserva, repositorioCliente, daoCliente);
	}

	@Bean
	public ServicioEliminarReserva servicioEliminarReserva(RepositorioReserva repositorioReserva) {
		return new ServicioEliminarReserva(repositorioReserva);
	}

	@Bean
	public ServicioActualizarReserva servicioActualizarReserva(RepositorioReserva repositorioReserva) {
		return new ServicioActualizarReserva(repositorioReserva);
	}

	/**
	 * ItemReservas
	 */

	@Bean
	public ServicioCrearItemReserva servicioCrearItemReserva(RepositorioItemReserva repositorioItemReserva,
			DaoReserva daoReserva, DaoServicio daoServicio) {
		return new ServicioCrearItemReserva(repositorioItemReserva, daoReserva, daoServicio);
	}

	@Bean
	public ServicioEliminarItemReserva servicioEliminarItemReserva(RepositorioItemReserva repositorioItemReserva) {
		return new ServicioEliminarItemReserva(repositorioItemReserva);
	}

	@Bean
	public ServicioActualizarItemReserva servicioActualizarItemReserva(RepositorioItemReserva repositorioItemReserva) {
		return new ServicioActualizarItemReserva(repositorioItemReserva);
	}

}
