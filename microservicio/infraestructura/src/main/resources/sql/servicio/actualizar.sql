-- -----------------------------------------------------
-- Table servicio
-- -----------------------------------------------------

UPDATE servicio SET  
	nombre = :nombre, 
	descripcion = :descripcion, 
	valor = :valor, 
	imagen = :imagen
WHERE idservicio = :id