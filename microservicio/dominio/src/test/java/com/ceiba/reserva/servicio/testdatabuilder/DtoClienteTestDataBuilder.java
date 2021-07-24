package com.ceiba.reserva.servicio.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.cliente.modelo.dto.DtoCliente;

public class DtoClienteTestDataBuilder {

	private Long id;
	private String nombre;
	private String identificacion;
	private String correoElectronico;
	private String numTelefono;
	private LocalDateTime fechaNacimiento;

	public DtoClienteTestDataBuilder() {
		this.id = 1L;
		this.nombre = "Laura";
		this.identificacion = "1093852145";
		this.correoElectronico = "lau@hotmai.com";
		this.numTelefono = "3216547425";
		this.fechaNacimiento = LocalDateTime.of(2001, 7, 16, 11, 00);
	}

	public DtoClienteTestDataBuilder conFechanacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
		return this;
	}

	public DtoCliente build() {
		return new DtoCliente(id, nombre, identificacion, correoElectronico, numTelefono, fechaNacimiento);
	}

}
