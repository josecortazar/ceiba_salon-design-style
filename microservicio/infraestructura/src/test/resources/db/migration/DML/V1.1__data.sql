INSERT INTO cliente (idcliente, nombre, identificacion, correoelectronico, numtelefono, fechanacimiento)
VALUES ('1','Luisa Gomez', '1094952356','luisa@gmail.com', '3107412596','1994-09-20 20:05:50');

INSERT INTO servicio ( nombre, descripcion, valor, imagen)
VALUES ('Mascarilla Capilar', 'Mascarilla Capilar Mascarilla Capilar', '35000','https://assets.afcdn.com/story/20181217/1321953_w944h530c1cx1056cy703.jpg');

INSERT INTO reserva (idcliente, fechacreacion, fechareserva, preciototal, precioneto, cantidadservicios, esreservademenor)
VALUES ('1', '2021-09-02 12:05:50','2021-09-03 11:05:50', '35000', '35000', '1', '0');