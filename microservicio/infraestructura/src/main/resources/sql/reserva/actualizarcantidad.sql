-- -----------------------------------------------------
-- Table reserva
-- -----------------------------------------------------

UPDATE reserva re
SET re.cantidadservicios = 
    (
    SELECT COUNT(it.iditemreserva) 
    FROM itemreserva it
    WHERE it.idreserva = idReserva
    )
WHERE re.idreserva = idReserva;
