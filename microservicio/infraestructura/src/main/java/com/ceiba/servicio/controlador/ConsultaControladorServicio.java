package com.ceiba.servicio.controlador;

import java.util.List;

import com.ceiba.servicio.consulta.ManejadorListarServicios;
import com.ceiba.servicio.consulta.ManejadorObtenerServicio;
import com.ceiba.servicio.modelo.dto.DtoServicio;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/servicios")
@Api(tags = { "Controlador consulta Servicio" })
public class ConsultaControladorServicio {

	private final ManejadorListarServicios manejadorListarServicios;
	private final ManejadorObtenerServicio manejadorObtenerServicio;

	public ConsultaControladorServicio(ManejadorListarServicios manejadorListarServicios,
			ManejadorObtenerServicio manejadorObtenerServicio) {
		this.manejadorListarServicios = manejadorListarServicios;
		this.manejadorObtenerServicio = manejadorObtenerServicio;
	}

	@GetMapping
	@ApiOperation("Listar Servicios")
	public List<DtoServicio> listar() {
		return this.manejadorListarServicios.ejecutar();
	}

	@GetMapping(value = "/{id}")
	@ApiOperation("Obtener Servicio")
	public DtoServicio obtener(@PathVariable Long id) {
		return this.manejadorObtenerServicio.ejecutar(id);
	}

}
