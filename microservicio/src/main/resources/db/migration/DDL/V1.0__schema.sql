-- -----------------------------------------------------
-- Table cliente
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS cliente (
  idcliente INT NOT NULL AUTO_INCREMENT,
  identificacion VARCHAR(50) NOT NULL,
  nombre VARCHAR(100) NOT NULL,
  correoelectronico VARCHAR(100) NOT NULL,
  numtelefono VARCHAR(45) NOT NULL,
  fechanacimiento DATETIME NOT NULL,
  PRIMARY KEY (idcliente)
  );
  

-- -----------------------------------------------------
-- Table reserva
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS reserva (
  idreserva INT NOT NULL AUTO_INCREMENT,
  idcliente INT NOT NULL,
  fechacreacion DATETIME NOT NULL,
  fechareserva DATETIME NOT NULL,
  preciototal DOUBLE NOT NULL,
  precioneto DOUBLE NOT NULL,
  cantidadservicios INT NOT NULL,
  esreservademenor TINYINT NOT NULL,
  PRIMARY KEY (idreserva),
  FOREIGN KEY (idcliente) REFERENCES cliente (idcliente) ON DELETE CASCADE
);


-- -----------------------------------------------------
-- Table servicio
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS servicio (
  idservicio INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(50) NOT NULL,
  descripcion VARCHAR(200) NOT NULL,
  valor DOUBLE NOT NULL,
  imagen VARCHAR(220) NOT NULL,
  PRIMARY KEY (idservicio)
);


-- -----------------------------------------------------
-- Table itemreserva
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS itemreserva (
  iditemreserva INT NOT NULL AUTO_INCREMENT,
  idreserva INT NOT NULL,
  idservicio INT NOT NULL,
  nombre VARCHAR(50) NOT NULL,
  valor DOUBLE NOT NULL,
  PRIMARY KEY (iditemreserva),
  FOREIGN KEY (idreserva) REFERENCES reserva (idreserva) ON DELETE CASCADE,
  FOREIGN KEY (idservicio) REFERENCES servicio (idservicio)
);