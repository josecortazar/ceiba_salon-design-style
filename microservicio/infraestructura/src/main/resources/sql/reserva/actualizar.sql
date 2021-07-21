-- -----------------------------------------------------
-- Table reserva
-- -----------------------------------------------------

UPDATE reserva SET  
	fechareserva = :fechaReserva, 
	preciototal = :precioTotal, 
	precioneto = :precioNeto,
	cantidadservicios = :cantidadServicios
WHERE idreserva = :id