-- -----------------------------------------------------
-- Table reserva
-- -----------------------------------------------------
SELECT idreserva, idcliente, fechacreacion, fechareserva,  CASE WHEN cantidadservicios >= 3 THEN preciototal-0.1 ELSE preciototal END AS preciototal, precioneto, cantidadservicios, esreservademenor
FROM reserva WHERE idreserva = :id