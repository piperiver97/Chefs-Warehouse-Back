 /* Roles */
INSERT INTO roles (id_role, name) VALUES (default, 'ROLE_USER');
INSERT INTO roles (id_role, name) VALUES (default, 'ROLE_ADMIN');

/* Users */
INSERT INTO users (id_user, username, password) VALUES (default, 'flipo@gmail.com', '$2a$12$dA70.eW4pS9xXcJsws6MsO2w6fq4/pOEfPyplrI/izLxQo1KsIL2C');
INSERT INTO users (id_user, username, password) VALUES (default, 'felipe@gmail.com', '$2a$12$5qYv3hnxxuD5oeu4QxZ3pef90Xkv9l3NOs4t3ap7fBp.YmMsDCgGm');

INSERT INTO roles_users (role_id, user_id) VALUES (1, 1);
INSERT INTO roles_users (role_id, user_id) VALUES (2, 2); 
-- Vegetales (Frío)
INSERT INTO ingrediente (nombre, cantidad, fecha_de_caducidad, almacenamiento, categoria) 
VALUES ('Cebolla', 20, '2024-11-01', 'Ambiente', 'Vegetales');

INSERT INTO ingrediente (nombre, cantidad, fecha_de_caducidad, almacenamiento, categoria) 
VALUES ('Tomate', 15, '2024-10-20', 'Frío', 'Vegetales');

INSERT INTO ingrediente (nombre, cantidad, fecha_de_caducidad, almacenamiento, categoria) 
VALUES ('Pimiento Rojo', 10, '2024-10-25', 'Frío', 'Vegetales');

INSERT INTO ingrediente (nombre, cantidad, fecha_de_caducidad, almacenamiento, categoria) 
VALUES ('Pimiento Verde', 10, '2024-10-25', 'Frío', 'Vegetales');

INSERT INTO ingrediente (nombre, cantidad, fecha_de_caducidad, almacenamiento, categoria) 
VALUES ('Zanahoria', 25, '2024-11-05', 'Frío', 'Vegetales');

INSERT INTO ingrediente (nombre, cantidad, fecha_de_caducidad, almacenamiento, categoria) 
VALUES ('Champiñones', 12, '2024-10-18', 'Frío', 'Vegetales');

INSERT INTO ingrediente (nombre, cantidad, fecha_de_caducidad, almacenamiento, categoria) 
VALUES ('Brócoli', 8, '2024-10-15', 'Frío', 'Vegetales');

INSERT INTO ingrediente (nombre, cantidad, fecha_de_caducidad, almacenamiento, categoria) 
VALUES ('Patata', 30, '2024-12-01', 'Ambiente', 'Vegetales');

INSERT INTO ingrediente (nombre, cantidad, fecha_de_caducidad, almacenamiento, categoria) 
VALUES ('Plátano', 10, '2024-10-12', 'Ambiente', 'Vegetales');

INSERT INTO ingrediente (nombre, cantidad, fecha_de_caducidad, almacenamiento, categoria) 
VALUES ('Berenjena', 5, '2024-10-20', 'Frío', 'Vegetales');

INSERT INTO ingrediente (nombre, cantidad, fecha_de_caducidad, almacenamiento, categoria) 
VALUES ('Calabacín', 10, '2024-10-18', 'Frío', 'Vegetales');

INSERT INTO ingrediente (nombre, cantidad, fecha_de_caducidad, almacenamiento, categoria) 
VALUES ('Puerro', 10, '2024-10-22', 'Frío', 'Vegetales');

-- Granos y Cereales (Ambiente)
INSERT INTO ingrediente (nombre, cantidad, fecha_de_caducidad, almacenamiento, categoria) 
VALUES ('Arroz', 5, '2025-05-01', 'Ambiente', 'Granos y Cereales');

INSERT INTO ingrediente (nombre, cantidad, fecha_de_caducidad, almacenamiento, categoria) 
VALUES ('Harina de Trigo', 10, '2025-03-01', 'Ambiente', 'Granos y Cereales');

INSERT INTO ingrediente (nombre, cantidad, fecha_de_caducidad, almacenamiento, categoria) 
VALUES ('Pasta', 7, '2025-02-15', 'Ambiente', 'Granos y Cereales');

INSERT INTO ingrediente (nombre, cantidad, fecha_de_caducidad, almacenamiento, categoria) 
VALUES ('Lentejas', 8, '2025-04-01', 'Ambiente', 'Granos y Cereales');

-- Carnes (Congelado o Frío)
INSERT INTO ingrediente (nombre, cantidad, fecha_de_caducidad, almacenamiento, categoria) 
VALUES ('Chorizo', 4, '2024-12-15', 'Congelado', 'Carnes');

INSERT INTO ingrediente (nombre, cantidad, fecha_de_caducidad, almacenamiento, categoria) 
VALUES ('Jamón Serrano', 3, '2024-12-01', 'Frío', 'Carnes');

-- Legumbres (Ambiente)
INSERT INTO ingrediente (nombre, cantidad, fecha_de_caducidad, almacenamiento, categoria) 
VALUES ('Alubias', 6, '2025-03-10', 'Ambiente', 'Legumbres');

-- Lácteos (Frío)
INSERT INTO ingrediente (nombre, cantidad, fecha_de_caducidad, almacenamiento, categoria) 
VALUES ('Leche', 12, '2024-10-10', 'Frío', 'Lácteos');

INSERT INTO ingrediente (nombre, cantidad, fecha_de_caducidad, almacenamiento, categoria) 
VALUES ('Nata para Montar', 6, '2024-10-18', 'Frío', 'Lácteos');

INSERT INTO ingrediente (nombre, cantidad, fecha_de_caducidad, almacenamiento, categoria) 
VALUES ('Nata para Cocinar', 6, '2024-10-25', 'Frío', 'Lácteos');

INSERT INTO ingrediente (nombre, cantidad, fecha_de_caducidad, almacenamiento, categoria) 
VALUES ('Mantequilla', 5, '2024-12-01', 'Frío', 'Lácteos');

-- Huevos (Frío)
INSERT INTO ingrediente (nombre, cantidad, fecha_de_caducidad, almacenamiento, categoria) 
VALUES ('Huevos', 24, '2024-10-22', 'Frío', 'Huevos');

-- Especias (Ambiente)
INSERT INTO ingrediente (nombre, cantidad, fecha_de_caducidad, almacenamiento, categoria) 
VALUES ('Sal', 2, '2026-10-01', 'Ambiente', 'Especias');

INSERT INTO ingrediente (nombre, cantidad, fecha_de_caducidad, almacenamiento, categoria) 
VALUES ('Pimienta', 1, '2025-09-01', 'Ambiente', 'Especias');

INSERT INTO ingrediente (nombre, cantidad, fecha_de_caducidad, almacenamiento, categoria) 
VALUES ('Comino', 1, '2025-07-01', 'Ambiente', 'Especias');

INSERT INTO ingrediente (nombre, cantidad, fecha_de_caducidad, almacenamiento, categoria) 
VALUES ('Tomillo', 1, '2025-06-01', 'Ambiente', 'Especias');

INSERT INTO ingrediente (nombre, cantidad, fecha_de_caducidad, almacenamiento, categoria) 
VALUES ('Laurel', 1, '2025-08-01', 'Ambiente', 'Especias');

-- Otros ingredientes (Ambiente)
INSERT INTO ingrediente (nombre, cantidad, fecha_de_caducidad, almacenamiento, categoria) 
VALUES ('Ajo', 15, '2024-11-01', 'Ambiente', 'Otros');

INSERT INTO ingrediente (nombre, cantidad, fecha_de_caducidad, almacenamiento, categoria) 
VALUES ('Azúcar', 10, '2025-12-01', 'Ambiente', 'Otros');

INSERT INTO ingrediente (nombre, cantidad, fecha_de_caducidad, almacenamiento, categoria) 
VALUES ('Aceite', 4, '2026-01-01', 'Ambiente', 'Otros');


