package com.ceiba.itemreserva.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.itemreserva.modelo.entidad.ItemReserva;
import com.ceiba.itemreserva.puerto.repositorio.RepositorioItemReserva;
import com.ceiba.reserva.puerto.dao.DaoReserva;
import com.ceiba.servicio.puerto.dao.DaoServicio;

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

		validarReserva(itemReserva);

		// Segun el id del servicio, se validada y se obtiene el nombre
		itemReserva.setNombre(asignarNombre(itemReserva));

		// Segun el id del servicio, se validada y se obtiene el valor
		itemReserva.setValor(asignarValor(itemReserva));

		return this.repositorioItemReserva.crear(itemReserva);
	}

	private void validarExistenciaPrevia(ItemReserva itemReserva) {
		boolean existe = this.repositorioItemReserva.existe(itemReserva.getId());
		if (existe) {
			throw new ExcepcionDuplicidad(EL_ITEM_DE_LA_RESERVA_YA_EXISTE_EN_EL_SISTEMA);
		}
	}

	private void validarReserva(ItemReserva itemReserva) {
		try {
			daoReserva.obtener(itemReserva.getIdReserva()).getId();
		} catch (Exception e) {
			throw new ExcepcionSinDatos(LA_RESERVA_NO_SE_ENCONTRO_EN_EL_SISTEMA);
		}

	}

	private String asignarNombre(ItemReserva itemReserva) {
		try {
			return daoServicio.obtener(itemReserva.getIdServicio()).getNombre();
		} catch (Exception e) {
			throw new ExcepcionSinDatos(EL_SERVICIO_NO_SE_ENCONTRO_EN_EL_SISTEMA);
		}
	}

	private Double asignarValor(ItemReserva itemReserva) {
		try {
			return daoServicio.obtener(itemReserva.getIdServicio()).getValor();
		} catch (Exception e) {
			throw new ExcepcionSinDatos(EL_SERVICIO_NO_SE_ENCONTRO_EN_EL_SISTEMA);
		}
	}

}
