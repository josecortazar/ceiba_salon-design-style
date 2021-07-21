-- -----------------------------------------------------
-- Table reserva
-- -----------------------------------------------------

UPDATE reserva SET  
	fechareserva = :fechaReserva, 
	preciototal = :precioTotal, 
	precioneto = :precioNeto
WHERE idreserva = :id