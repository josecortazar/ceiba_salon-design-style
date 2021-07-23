-- -----------------------------------------------------
-- Table itemreserva
-- -----------------------------------------------------

UPDATE itemreserva SET  
	idservicio = :idServicio, 
	nombre = :nombre,
	valor = :valor
WHERE iditemreserva = :id