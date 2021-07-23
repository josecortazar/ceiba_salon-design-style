-- -----------------------------------------------------
-- Table itemreserva
-- -----------------------------------------------------
SELECT iditemreserva, idreserva, idservicio, nombre, valor
FROM itemreserva 
WHERE iditemreserva = :id