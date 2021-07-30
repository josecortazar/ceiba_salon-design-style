-- -----------------------------------------------------
-- Table reserva
-- -----------------------------------------------------
SELECT r.idreserva,r.idcliente,r.fechacreacion,r.fechareserva,  CASE WHEN r.cantidadservicios >= 3 THEN r.preciototal-0.1 ELSE r.preciototal END AS preciototal , r.precioneto, r.cantidadservicios, r.esreservademenor
FROM reserva r INNER JOIN cliente c ON r.idcliente = c.idcliente AND c.identificacion = :identificacion