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
  
---INSERT INTO cliente (nombre, identificacion, correoelectronico, numtelefono, fechanacimiento)
---VALUES ('Sara Gomez', '1092006352', 'sarag@gmail.com', '3110515120', '1979-09-20 20:05:50');

---INSERT INTO cliente (nombre, identificacion,  correoelectronico, numtelefono, fechanacimiento)
---VALUES ('Laura Torres', '1093012327',  'luato@hotmail.com', '3205815133', '1996-02-20 0:05:50');

-- -----------------------------------------------------
-- Table reserva
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS reserva (
  idreserva INT NOT NULL AUTO_INCREMENT,
  idcliente INT NOT NULL,
  fechacreacion DATETIME NOT NULL,
  fechareserva DATETIME NOT NULL,
  preciototal DOUBLE NOT NULL,
  PRIMARY KEY (idreserva),
  FOREIGN KEY (idcliente) REFERENCES cliente (idcliente)
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
  FOREIGN KEY (idreserva) REFERENCES reserva (idreserva),
  FOREIGN KEY (idservicio) REFERENCES servicio (idservicio)
);