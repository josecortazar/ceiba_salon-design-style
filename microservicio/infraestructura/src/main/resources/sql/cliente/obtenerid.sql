-- -----------------------------------------------------
-- Table cliente
-- -----------------------------------------------------
SELECT idcliente,nombre,identificacion,correoelectronico,numtelefono,fechanacimiento 

FROM cliente WHERE idcliente = :id