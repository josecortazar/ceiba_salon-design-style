package com.ceiba.itemreserva.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.itemreserva.modelo.entidad.ItemReserva;
import com.ceiba.itemreserva.puerto.repositorio.RepositorioItemReserva;
import com.ceiba.reserva.puerto.dao.DaoReserva;
import com.ceiba.servicio.puerto.dao.DaoServicio;

import static com.ceiba.dominio.ValidadorArgumento.validarExistencia;

public class ServicioCrearItemReserva {

	private static final String EL_ITEM_DE_LA_RESERVA_YA_EXISTE_EN_EL_SISTEMA = "El itemReserva ya existe en el sistema";
	private static final String EL_SERVICIO_NO_SE_ENCONTRO_EN_EL_SISTEMA = "El servicio no se encontro en el sistema";
	private static final String LA_RESERVA_NO_SE_ENCONTRO_EN_EL_SISTEMA = "La reserva no se encontro en el sistema";

	private final RepositorioItemReserva repositorioItemReserva;
	private final DaoReserva daoReserva;
	private final DaoServicio daoServicio;

	public ServicioCrearItemReserva(RepositorioItemReserva repositorioItemReserva, DaoReserva daoReserva,
			DaoServicio daoServicio) {
		this.repositorioItemReserva = repositorioItemReserva;
		this.daoReserva = daoReserva;
		this.daoServicio = daoServicio;
	}

	public Long ejecutar(ItemReserva itemReserva) {
		validarExistenciaPrevia(itemReserva);
		validarReservaExistenciaPrevia(itemReserva);
		validarExistencia(daoServicio.obtener(itemReserva.getIdServicio()), EL_SERVICIO_NO_SE_ENCONTRO_EN_EL_SISTEMA);
		itemReserva.setNombre(obtenerNombreServicio(itemReserva));
		itemReserva.setValor(obtenerValorServicio(itemReserva));
		return this.repositorioItemReserva.crear(itemReserva);
	}

	private void validarExistenciaPrevia(ItemReserva itemReserva) {
		boolean existe = this.repositorioItemReserva.existe(itemReserva.getId());
		if (existe) {
			throw new ExcepcionDuplicidad(EL_ITEM_DE_LA_RESERVA_YA_EXISTE_EN_EL_SISTEMA);
		}
	}

	private void validarReservaExistenciaPrevia(ItemReserva itemReserva) {
		validarExistencia(daoReserva.obtener(itemReserva.getIdReserva()), LA_RESERVA_NO_SE_ENCONTRO_EN_EL_SISTEMA);
	}

	private String obtenerNombreServicio(ItemReserva itemReserva) {
		return daoServicio.obtener(itemReserva.getIdServicio()).getNombre();
	}

	private Double obtenerValorServicio(ItemReserva itemReserva) {
		return daoServicio.obtener(itemReserva.getIdServicio()).getValor();
	}

}
