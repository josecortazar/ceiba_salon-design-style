package com.ceiba.itemreserva.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoItemReserva {

	private Long id;
	private Long idReserva;
	private Long idServicio;
	private String nombre;
	private Double valor;

}
