-- -----------------------------------------------------
-- Table cliente
-- -----------------------------------------------------

UPDATE cliente SET 
	identificacion = :identificacion, 
	nombre = :nombre, 
	correoelectronico = :correoElectronico, 
	numtelefono = :numTelefono, 
	fechanacimiento = :fechaNacimiento
WHERE identificacion = :identificacion