-- -----------------------------------------------------
-- Table reserva
-- -----------------------------------------------------

INSERT INTO reserva (idreserva, idcliente, fechacreacion, fechareserva, preciototal, precioneto, esreservademenor)
VALUES (:id, :idCliente, :fechaCreacion, :fechaReserva, :precioTotal, :precioNeto, :esReservaDeMenor)