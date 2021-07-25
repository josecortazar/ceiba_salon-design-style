-- -----------------------------------------------------
-- Table reserva
-- -----------------------------------------------------
SELECT r.idreserva,r.idcliente,r.fechacreacion,r.fechareserva,r.preciototal, r.precioneto, r.cantidadservicios, r.esreservademenor
FROM reserva r INNER JOIN cliente c ON r.idcliente = c.idcliente AND c.identificacion = :identificacion