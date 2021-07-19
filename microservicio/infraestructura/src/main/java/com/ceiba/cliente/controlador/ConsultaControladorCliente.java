package com.ceiba.cliente.controlador;

import java.util.List;

import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.usuario.consulta.ManejadorListarClientes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/clientes")
@Api(tags={"Controlador consulta Cliente"})
public class ConsultaControladorCliente {

    private final ManejadorListarClientes manejadorListarClientes;

    public ConsultaControladorCliente(ManejadorListarClientes manejadorListarClientes) {
        this.manejadorListarClientes = manejadorListarClientes;
    }

    @GetMapping
    @ApiOperation("Listar Clientes")
    public List<DtoCliente> listar() {
        return this.manejadorListarClientes.ejecutar();
    }

}
