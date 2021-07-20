package com.ceiba.cliente.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.dominio.ValidadorArgumento.validarRegex;

import java.time.LocalDateTime;

@Getter
public class Cliente {

	private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_CLIENTE = "Se debe ingresar el nombre del cliente";
	private static final String SE_DEBE_INGRESAR_UN_NOMBRE_VALIDO = "Se debe ingresar un nombre valido";
	private static final String SE_DEBE_INGRESAR_LA_IDENTIFICACION = "Se debe ingresar la identificacion del cliente";
	private static final String SE_DEBE_INGRESAR_UNA_LA_IDENTIFICACION_VALIDA = "Se debe ingresar un numero de identificacion valido";
	private static final String SE_DEBE_INGRESAR_EL_CORREO_DEL_CLIENTE = "Se debe ingresar el correo electronico del cliente";
	private static final String SE_DEBE_INGRESAR_UN_CORREO_ELECTRONICO_VALIDO = "Se debe ingresar un correo electronico valido";
	private static final String SE_DEBE_INGRESAR_EL_NUMERO_DE_CONTACTO_DEL_CLIENTE = "Se debe ingresar el numero telefonico del cliente";
	private static final String SE_DEBE_INGRESAR_UN_NUMERO_DE_CONTACTO_VALIDO = "Se debe ingresar un numero telefonico valido";
	private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_NACIMIENTO = "Se debe ingresar una fecha de nacimiento";

	private static final String VALIDADOR_LETRAS = "[(a-zA-Z)+(\\ *)+]+";
	private static final String VALIDADOR_NUMERICO = "[0-9]+";

	private Long id;
	private String nombre;
	private String identificacion;
	private String correoElectronico;
	private String numTelefono;
	private LocalDateTime fechaNacimiento;

	public Cliente(Long id, String nombre, String identificacion, String correoElectronico, String numTelefono,
			LocalDateTime fechaNacimiento) {

		validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DE_CLIENTE);
		validarObligatorio(identificacion, SE_DEBE_INGRESAR_LA_IDENTIFICACION);
		validarObligatorio(correoElectronico, SE_DEBE_INGRESAR_EL_CORREO_DEL_CLIENTE);
		validarObligatorio(numTelefono, SE_DEBE_INGRESAR_EL_NUMERO_DE_CONTACTO_DEL_CLIENTE);
		validarObligatorio(fechaNacimiento, SE_DEBE_INGRESAR_LA_FECHA_DE_NACIMIENTO);

		validarRegex(nombre, VALIDADOR_LETRAS, SE_DEBE_INGRESAR_UN_NOMBRE_VALIDO);
		validarRegex(identificacion, VALIDADOR_NUMERICO, SE_DEBE_INGRESAR_UNA_LA_IDENTIFICACION_VALIDA);
		validarRegex(numTelefono, VALIDADOR_NUMERICO, SE_DEBE_INGRESAR_UN_NUMERO_DE_CONTACTO_VALIDO);
		validarRegex(correoElectronico, "([a-z0-9]+(\\_*)+(\\.?[a-z0-9])*)+@(([a-z]+)\\.([a-z]+))+", SE_DEBE_INGRESAR_UN_CORREO_ELECTRONICO_VALIDO);
		validarRegex(numTelefono, VALIDADOR_NUMERICO, SE_DEBE_INGRESAR_UN_NUMERO_DE_CONTACTO_VALIDO);

		this.id = id;
		this.nombre = nombre;
		this.identificacion = identificacion;
		this.correoElectronico = correoElectronico;
		this.numTelefono = numTelefono;
		this.fechaNacimiento = fechaNacimiento;
	}

}
