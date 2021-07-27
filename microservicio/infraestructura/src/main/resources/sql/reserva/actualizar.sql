-- -----------------------------------------------------
-- Table reserva
-- -----------------------------------------------------

UPDATE reserva SET  
	fechareserva = :fechaReserva, 
	preciototal = :modificacadorPrecio, 
	precioneto = :precioNeto,
	cantidadservicios = :cantidadServicios
WHERE idreserva = :id