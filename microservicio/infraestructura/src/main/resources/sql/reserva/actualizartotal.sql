-- -----------------------------------------------------
-- Table reserva
-- -----------------------------------------------------

UPDATE reserva re
SET re.precioneto = 
    (
    SELECT SUM(it.valor) 
    FROM itemreserva it
    WHERE it.idreserva = :idReserva
    )
WHERE re.idreserva = :idReserva;
