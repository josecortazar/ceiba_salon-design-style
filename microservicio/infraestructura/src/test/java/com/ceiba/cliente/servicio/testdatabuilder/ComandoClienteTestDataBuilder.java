package com.ceiba.cliente.servicio.testdatabuilder;

import com.ceiba.cliente.comando.ComandoCliente;

public class ComandoClienteTestDataBuilder {

	private Long id;
	private String nombre;
	private String identificacion;
	private String correoElectronico;
	private String numTelefono;

	public ComandoClienteTestDataBuilder() {
		id = 2L;
		nombre = "Juanita";
		identificacion = "10951623635";
		correoElectronico = "juanita2000@hotmail.com";
		numTelefono = "3124567896";
	}

	public ComandoClienteTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}
	
	public ComandoClienteTestDataBuilder conIdentificacion(String identificacion) {
		this.identificacion = identificacion;
		return this;
	}
	
	public ComandoClienteTestDataBuilder conCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
		return this;
	}
	
	public ComandoClienteTestDataBuilder conNumTelefono(String numTelefono) {
		this.numTelefono = numTelefono;
		return this;
	}

	public ComandoCliente build() {
		return new ComandoCliente(id, nombre, identificacion, correoElectronico, numTelefono);
	}
}
