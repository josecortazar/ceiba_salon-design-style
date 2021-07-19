-- -----------------------------------------------------
-- Table cliente
-- -----------------------------------------------------

SELECT COUNT(1) FROM cliente WHERE idcliente <> :id AND identificacion = :identificacion