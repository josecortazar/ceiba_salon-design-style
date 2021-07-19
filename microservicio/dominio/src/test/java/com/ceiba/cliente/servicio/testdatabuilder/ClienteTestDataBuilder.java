package com.ceiba.cliente.servicio.testdatabuilder;

import com.ceiba.cliente.modelo.entidad.Cliente;

public class ClienteTestDataBuilder {

	private Long id;
	private String nombre;
	private String identificacion;
	private String correoElectronico;
	private String numTelefono;

	public ClienteTestDataBuilder() {
		id = 1L;
		nombre = "Luis";
		identificacion = "10949852147";
		correoElectronico = "luis@gmail.com";
		numTelefono = "3216549865";
	}

	public ClienteTestDataBuilder conCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
		return this;
	}

	public ClienteTestDataBuilder conNumTelefono(String numTelefono) {
		this.numTelefono = numTelefono;
		return this;
	}
	
	public ClienteTestDataBuilder conIdentficacion(String identificacion) {
		this.identificacion = identificacion;
		return this;
	}

	public ClienteTestDataBuilder conId(Long id) {
		this.id = id;
		return this;
	}

	public Cliente build() {
		return new Cliente(id, nombre, identificacion, correoElectronico, numTelefono);
	}
}
