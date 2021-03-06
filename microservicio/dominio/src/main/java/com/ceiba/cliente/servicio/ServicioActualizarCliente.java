package com.ceiba.cliente.servicio;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;

public class ServicioActualizarCliente {

	private static final String EL_USUARIO_NO_EXISTE_EN_EL_SISTEMA = "El cliente no existe en el sistema";

	private final RepositorioCliente repositorioCliente;

	public ServicioActualizarCliente(RepositorioCliente repositorioCliente) {
		this.repositorioCliente = repositorioCliente;
	}

	public void ejecutar(Cliente cliente) {
		validarExistenciaPrevia(cliente);
		this.repositorioCliente.actualizar(cliente);
	}

	private void validarExistenciaPrevia(Cliente cliente) {
		boolean existe = this.repositorioCliente.existe(cliente.getIdentificacion());
		if (!existe) {
			throw new ExcepcionSinDatos(EL_USUARIO_NO_EXISTE_EN_EL_SISTEMA);
		}
	}
}
