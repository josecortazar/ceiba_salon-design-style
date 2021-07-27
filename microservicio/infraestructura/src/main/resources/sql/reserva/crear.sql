-- -----------------------------------------------------
-- Table reserva
-- -----------------------------------------------------

INSERT INTO reserva ( idcliente, fechacreacion, fechareserva, preciototal, precioneto, cantidadservicios, esreservademenor)
VALUES ( :idCliente, :fechaCreacion, :fechaReserva, :modificacadorPrecio, :precioNeto, :cantidadServicios, :esReservaDeMenor)