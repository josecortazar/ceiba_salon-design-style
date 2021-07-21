-- -----------------------------------------------------
-- Table reserva
-- -----------------------------------------------------

INSERT INTO reserva (idreserva, idcliente, fechacreacion, fechareserva, preciototal, precioneto, cantidadservicios, esreservademenor)
VALUES (:id, :idCliente, :fechaCreacion, :fechaReserva, :precioTotal, :precioNeto, :cantidadServicios, :esReservaDeMenor)