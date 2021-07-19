-- -----------------------------------------------------
-- Table cliente
-- -----------------------------------------------------

INSERT INTO cliente (idcliente, nombre, identificacion, correoelectronico, numtelefono, fechanacimiento)
VALUES (:id, :nombre, :identificacion, :correoElectronico, :numTelefono, :fechaNacimiento)