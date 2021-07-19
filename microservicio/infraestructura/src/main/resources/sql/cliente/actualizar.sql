-- -----------------------------------------------------
-- Table cliente
-- -----------------------------------------------------

UPDATE cliente set 
	nombre = :nombre,
	correoelectronico = :correoElectronico,
	identificacion = :identificacion,
	numtelefono = :numTelefono
WHERE idcliente = :id

