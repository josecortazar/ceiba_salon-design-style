package com.ceiba.servicio.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.dominio.ValidadorArgumento.validarRegex;

@Getter
public class Servicio {

	private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_SERVICIO = "Se debe ingresar el nombre del servicio";
	private static final String SE_DEBE_INGRESAR_UNA_DESCRICION_DEL_SERVICIO = "Se debe ingresar una descricion del servicio";
	private static final String SE_DEBE_INGRESAR_EL_VALOR_DEL_SERVICIO = "Se debe ingresar el valor del servicio";
	private static final String SE_DEBE_AGREGAR_UNA_URL_PARA_LA_IMAGEN_DEL_SERVICIO = "Se debe ingresar una url para la imagen del servicio";
	private static final String SE_DEBE_AGREGAR_UNA_URL_VALIDA = "Se debe ingresar una url valida";

	private static final String VALIDADOR_URL = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

	private Long id;
	private String nombre;
	private String descripcion;
	private Double valor;
	private String imagen;

	public Servicio(Long id, String nombre, String descripcion, Double valor, String imagen) {

		validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DE_SERVICIO);
		validarObligatorio(descripcion, SE_DEBE_INGRESAR_UNA_DESCRICION_DEL_SERVICIO);
		validarObligatorio(valor, SE_DEBE_INGRESAR_EL_VALOR_DEL_SERVICIO);
		validarObligatorio(imagen, SE_DEBE_AGREGAR_UNA_URL_PARA_LA_IMAGEN_DEL_SERVICIO);

		validarRegex(imagen, VALIDADOR_URL, SE_DEBE_AGREGAR_UNA_URL_VALIDA);

		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.valor = valor;
		this.imagen = imagen;
	}

}
