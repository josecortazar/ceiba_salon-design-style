-- -----------------------------------------------------
-- Table cliente
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS cliente (
  idcliente INT NOT NULL AUTO_INCREMENT,
  identificacion VARCHAR(50) NOT NULL,
  nombre VARCHAR(100) NOT NULL,
  correoelectronico VARCHAR(100) NOT NULL,
  numtelefono VARCHAR(45) NOT NULL,
  PRIMARY KEY (idcliente)
  );

-- -----------------------------------------------------
-- Table reserva
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS reserva (
  idreserva INT NOT NULL AUTO_INCREMENT,
  fecha DATETIME NOT NULL,
  preciototal DOUBLE NOT NULL,
  idcliente INT NOT NULL,
  PRIMARY KEY (idreserva),
  FOREIGN KEY (idcliente) REFERENCES cliente (idcliente)
);


-- -----------------------------------------------------
-- Table servicio
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS servicio (
  idservicio INT NOT NULL AUTO_INCREMENT,
  descripcion VARCHAR(200) NOT NULL,
  precio DOUBLE NOT NULL,
  imagen VARCHAR(200) NOT NULL,
  PRIMARY KEY (idservicio)
);


-- -----------------------------------------------------
-- Table itemreserva
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS itemreserva (
  iditemreserva INT NOT NULL AUTO_INCREMENT,
  idreserva INT NOT NULL,
  idservicio INT NOT NULL,
  precioparcial DOUBLE NOT NULL,
  PRIMARY KEY (iditemreserva),
  FOREIGN KEY (idreserva) REFERENCES reserva (idreserva),
  FOREIGN KEY (idservicio) REFERENCES servicio (idservicio)
);