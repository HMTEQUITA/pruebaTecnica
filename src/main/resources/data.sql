INSERT INTO autor (primer_apellido, segundo_apellido, primer_nombre, segundo_nombre) VALUES ('Borges','','Jorge','Luis');
INSERT INTO autor (primer_apellido, segundo_apellido, primer_nombre, segundo_nombre) VALUES ('Marquez','','Gabriel','Garcia');
INSERT INTO autor (primer_apellido, segundo_apellido, primer_nombre, segundo_nombre) VALUES ('Vargas','Llosa','Mario','');
INSERT INTO autor (primer_apellido, segundo_apellido, primer_nombre, segundo_nombre) VALUES ('Cortazar','','Julio','');

INSERT INTO categoria(categoria_nombre) VALUES ('Novela fantástica');
INSERT INTO categoria(categoria_nombre) VALUES ('Novela Aventuras');
INSERT INTO categoria(categoria_nombre) VALUES ('Novela Policial');
INSERT INTO categoria(categoria_nombre) VALUES ('Novela Contemporánea');

INSERT INTO rol(rol_nombre) VALUES ('ROLE_ADMIN');
INSERT INTO rol(rol_nombre) VALUES ('ROLE_USER');

INSERT INTO tarifa(nombre, valor_tarifa) VALUES ('Tarifa 1', 5000);
INSERT INTO tarifa(nombre, valor_tarifa) VALUES ('Tarifa 2', 3500);
INSERT INTO tarifa(nombre, valor_tarifa) VALUES ('Tarifa 3', 2500);
INSERT INTO tarifa(nombre, valor_tarifa) VALUES ('Tarifa 4', 6000);
INSERT INTO tarifa(nombre, valor_tarifa) VALUES ('Tarifa 5', 1500);

INSERT INTO libro(nombre, categoria_id, autor_id, tarifa_id, cantidad_disponible, cantidad_reservada) VALUES('El amor en los tiempos del cólera', 1, 2, 4, 0, 0);
INSERT INTO libro(nombre, categoria_id, autor_id, tarifa_id, cantidad_disponible, cantidad_reservada) VALUES('Cien años de soledad', 1, 2, 1, 15, 0);
INSERT INTO libro(nombre, categoria_id, autor_id, tarifa_id, cantidad_disponible, cantidad_reservada) VALUES('El coronel no tiene quien le escriba', 1, 2, 5, 5, 0);

INSERT INTO libro(nombre, categoria_id, autor_id, tarifa_id, cantidad_disponible, cantidad_reservada) VALUES('Ficciones', 1, 1, 5, 10, 0);
INSERT INTO libro(nombre, categoria_id, autor_id, tarifa_id, cantidad_disponible, cantidad_reservada) VALUES('Los mejores cuentos policiales', 3, 1, 3, 9, 0);
INSERT INTO libro(nombre, categoria_id, autor_id, tarifa_id, cantidad_disponible, cantidad_reservada) VALUES('La muerte y la brújula', 4, 1, 2, 3, 0);

INSERT INTO libro(nombre, categoria_id, autor_id, tarifa_id, cantidad_disponible, cantidad_reservada) VALUES('El hablador', 4, 3, 5, 4, 0);
INSERT INTO libro(nombre, categoria_id, autor_id, tarifa_id, cantidad_disponible, cantidad_reservada) VALUES('La guerra del fin del mundo', 2, 3, 3, 10, 0);
INSERT INTO libro(nombre, categoria_id, autor_id, tarifa_id, cantidad_disponible, cantidad_reservada) VALUES('Travesuras de la niña mala', 4, 3, 3, 7, 0);

INSERT INTO libro(nombre, categoria_id, autor_id, tarifa_id, cantidad_disponible, cantidad_reservada) VALUES('Rayuela', 1, 4, 1, 12, 0);
INSERT INTO libro(nombre, categoria_id, autor_id, tarifa_id, cantidad_disponible, cantidad_reservada) VALUES('Bestiario', 2, 4, 1, 8, 0);
INSERT INTO libro(nombre, categoria_id, autor_id, tarifa_id, cantidad_disponible, cantidad_reservada) VALUES('Los autonautas de la cosmopista', 1, 4, 2, 10, 0);

INSERT INTO usuario(correo, primer_apellido, segundo_apellido, primer_nombre, segundo_nombre, direccion, telefono, password) VALUES ('admin@gmail.com', 'Tequita','Robayo','Hector','Mauricio', 'Calle 1a N 4b-40', '3057044821', '$2a$10$vRDiuGBgNWOye6AItnOcmeXNR83LrJetx2YpWalnV6I6D7LcOMn8q');
INSERT INTO usuario_rol(usuario_id, rol_id) VALUES (1,1);
	
INSERT INTO usuario(correo, primer_apellido, segundo_apellido, primer_nombre, segundo_nombre, direccion, telefono, password) VALUES ('cliente@gmail.com', 'Tequita','Robayo','Hector','Mauricio', 'Calle 1a N 4b-40', '3057044821', '$2a$10$vRDiuGBgNWOye6AItnOcmeXNR83LrJetx2YpWalnV6I6D7LcOMn8q');
INSERT INTO usuario_rol(usuario_id, rol_id) VALUES (2,2);
