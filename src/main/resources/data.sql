-- Limpiar las tablas existentes si es necesario
DROP TABLE IF EXISTS roles_users;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS ingredientes;
DROP TABLE IF EXISTS proveedores;

-- Crear tabla de proveedores
CREATE TABLE IF NOT EXISTS proveedores (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    contacto VARCHAR(100) NOT NULL
);

-- Crear tabla de ingredientes
CREATE TABLE IF NOT EXISTS ingredientes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    cantidad_kilos INT DEFAULT 0,
    cantidad_gramos INT DEFAULT 0,
    cantidad_unidades INT DEFAULT 0,
    fecha_de_caducidad DATE NOT NULL,
    almacenamiento VARCHAR(100) NOT NULL,
    categoria VARCHAR(100) NOT NULL,
    imagen VARCHAR(255) DEFAULT NULL,
    proveedor_id BIGINT,
    FOREIGN KEY (proveedor_id) REFERENCES proveedores(id) ON DELETE SET NULL
);

-- Crear tabla de roles
CREATE TABLE IF NOT EXISTS roles (
    id_role BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

-- Crear tabla de usuarios
CREATE TABLE IF NOT EXISTS users (
    id_user BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL
);

-- Crear tabla de roles_users
CREATE TABLE IF NOT EXISTS roles_users (
    role_id BIGINT,
    user_id BIGINT,
    FOREIGN KEY (role_id) REFERENCES roles(id_role),
    FOREIGN KEY (user_id) REFERENCES users(id_user)
);

-- Insertar datos en la tabla de proveedores
INSERT INTO proveedores (nombre, contacto) VALUES
('Proveedor A', 'contactoA@example.com'),
('Proveedor B', 'contactoB@example.com'),
('Proveedor C', 'contactoC@example.com');

-- Insertar datos en la tabla de ingredientes
INSERT INTO ingredientes (nombre, cantidad_kilos, cantidad_gramos, cantidad_unidades, fecha_de_caducidad, almacenamiento, categoria, imagen, proveedor_id) VALUES
('Tomate', 0, 500, 0, '2024-10-10', 'Refrigeración', 'Vegetales', 'tomate.jpg', 1),
('Lechuga', 0, 300, 0, '2024-10-05', 'Refrigeración', 'Vegetales', 'lechuga.jpg', 1),
('Pollo', 1, 0, 0, '2024-10-15', 'Congelado', 'Carnes', 'pollo.jpg', 2),
('Cebolla', 0, 500, 10, '2024-11-01', 'Ambiente', 'Vegetales', 'cebolla.jpg', 3),
('Arroz', 0, 2000, 0, '2025-05-01', 'Ambiente', 'Granos y Cereales', 'arroz.jpg', 1),
('Leche', 0, 1000, 0, '2024-10-10', 'Frío', 'Lácteos', 'leche.jpg', 2),
('Huevos', 0, 0, 12, '2024-10-22', 'Frío', 'Huevos', 'huevos.jpg', 3),
('Sal', 0, 500, 0, '2026-10-01', 'Ambiente', 'Especias', 'sal.jpg', 1);

-- Roles
INSERT INTO roles (name) VALUES ('ROLE_USER');
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');

-- Usuarios
INSERT INTO users (username, password) VALUES ('flipo@gmail.com', '$2a$12$dA70.eW4pS9xXcJsws6MsO2w6fq4/pOEfPyplrI/izLxQo1KsIL2C');
INSERT INTO users (username, password) VALUES ('felipe@gmail.com', '$2a$12$5qYv3hnxxuD5oeu4QxZ3pef90Xkv9l3NOs4t3ap7fBp.YmMsDCgGm');

-- Asignar roles a usuarios
INSERT INTO roles_users (role_id, user_id) VALUES (1, 1);
INSERT INTO roles_users (role_id, user_id) VALUES (2, 2);

-- Insertar más datos en la tabla de ingredientes
INSERT INTO ingredientes (nombre, cantidad_kilos, cantidad_gramos, cantidad_unidades, fecha_de_caducidad, almacenamiento, categoria, imagen, proveedor_id) VALUES
('Cebolla', 0, 0, 20, '2024-11-01', 'Ambiente', 'Vegetales', NULL, 3),
('Tomate', 0, 0, 15, '2024-10-20', 'Frío', 'Vegetales', NULL, 1),
('Pimiento Rojo', 0, 0, 10, '2024-10-25', 'Frío', 'Vegetales', NULL, 1),
('Pimiento Verde', 0, 0, 10, '2024-10-25', 'Frío', 'Vegetales', NULL, 1),
('Zanahoria', 0, 0, 25, '2024-11-05', 'Frío', 'Vegetales', NULL, 1),
('Champiñones', 0, 0, 12, '2024-10-18', 'Frío', 'Vegetales', NULL, 1),
('Brócoli', 0, 0, 8, '2024-10-15', 'Frío', 'Vegetales', NULL, 1),
('Patata', 0, 0, 30, '2024-12-01', 'Ambiente', 'Vegetales', NULL, 1),
('Plátano', 0, 0, 10, '2024-10-12', 'Ambiente', 'Vegetales', NULL, 1),
('Berenjena', 0, 0, 5, '2024-10-20', 'Frío', 'Vegetales', NULL, 1),
('Calabacín', 0, 0, 10, '2024-10-18', 'Frío', 'Vegetales', NULL, 1),
('Puerro', 0, 0, 10, '2024-10-22', 'Frío', 'Vegetales', NULL, 1);

-- Granos y Cereales (Ambiente)
INSERT INTO ingredientes (nombre, cantidad_kilos, cantidad_gramos, cantidad_unidades, fecha_de_caducidad, almacenamiento, categoria, imagen, proveedor_id) VALUES
('Arroz', 0, 0, 5, '2025-05-01', 'Ambiente', 'Granos y Cereales', NULL, 1),
('Harina de Trigo', 0, 0, 10, '2025-03-01', 'Ambiente', 'Granos y Cereales', NULL, 1),
('Pasta', 0, 0, 7, '2025-02-15', 'Ambiente', 'Granos y Cereales', NULL, 1),
('Lentejas', 0, 0, 8, '2025-04-01', 'Ambiente', 'Granos y Cereales', NULL, 1);

-- Carnes (Congelado o Frío)
INSERT INTO ingredientes (nombre, cantidad_kilos, cantidad_gramos, cantidad_unidades, fecha_de_caducidad, almacenamiento, categoria, imagen, proveedor_id) VALUES
('Chorizo', 0, 0, 4, '2024-12-15', 'Congelado', 'Carnes', NULL, 2),
('Jamón Serrano', 0, 0, 3, '2024-12-01', 'Frío', 'Carnes', NULL, 2);

-- Legumbres (Ambiente)
INSERT INTO ingredientes (nombre, cantidad_kilos, cantidad_gramos, cantidad_unidades, fecha_de_caducidad, almacenamiento, categoria, imagen, proveedor_id) VALUES
('Alubias', 0, 0, 6, '2025-03-10', 'Ambiente', 'Legumbres', NULL, 1);

-- Lácteos (Frío)
INSERT INTO ingredientes (nombre, cantidad_kilos, cantidad_gramos, cantidad_unidades, fecha_de_caducidad, almacenamiento, categoria, imagen, proveedor_id) VALUES
('Leche', 0, 0, 12, '2024-10-10', 'Frío', 'Lácteos', NULL, 2),
('Nata para Montar', 0, 0, 6, '2024-10-18', 'Frío', 'Lácteos', NULL, 2),
('Nata para Cocinar', 0, 0, 6, '2024-10-25', 'Frío', 'Lácteos', NULL, 2),
('Mantequilla', 0, 0, 5, '2024-10-20', 'Frío', 'Lácteos', NULL, 2);
