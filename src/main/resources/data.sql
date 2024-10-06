-- Limpiar las tablas existentes si es necesario
DROP TABLE IF EXISTS roles_users;
DROP TABLE IF EXISTS recetas_ingredientes;
DROP TABLE IF EXISTS ingredientes;
DROP TABLE IF EXISTS recetas;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS proveedores;

-- Crear tabla de proveedores
CREATE TABLE IF NOT EXISTS proveedores (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    contacto VARCHAR(100) NOT NULL
);
-- Insertar datos de proveedores predeterminados
INSERT INTO proveedor (nombre, contacto, direccion, telefono, correo_electronico, categoria) VALUES 
(' INDEX CSS', 'Juan Perez', 'Calle 123', '555-1234', 'juan.perez@correo.com', 'Lácteos'),
(' GIACO SAS', 'Ana Gómez', 'Avenida 45', '555-5678', 'ana.gomez@correo.com', 'Carnes'),
(' F5 ORG', 'Carlos Lopez', 'Calle Falsa 456', '555-8765', 'carlos.lopez@correo.com', 'Vegetales'),
(' MAKRO', 'Luis Martinez', 'Boulevard 89', '555-4321', 'luis.martinez@correo.com', 'Pescado'),
(' WAREHOUSE CHEF SA', 'Laura Sánchez', 'Plaza 25', '555-6543', 'laura.sanchez@correo.com', 'Especias');

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
CREATE TABLE IF NOT EXISTS recetas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    tiempo_preparacion INT NOT NULL,
    tiempo_coccion INT NOT NULL,
    porciones INT NOT NULL,
    dificultad VARCHAR(20) NOT NULL,
    elaboracion TEXT NOT NULL,
    tecnicas_cocina TEXT,
    imagen VARCHAR(255)
);

-- Tabla intermedia para la relación entre recetas e ingredientes
CREATE TABLE IF NOT EXISTS recetas_ingredientes (
    receta_id BIGINT,
    ingrediente_id BIGINT,
    cantidad FLOAT NOT NULL,
    unidad_medida VARCHAR(20) NOT NULL,
    FOREIGN KEY (receta_id) REFERENCES recetas(id),
    FOREIGN KEY (ingrediente_id) REFERENCES ingredientes(id),
    PRIMARY KEY (receta_id, ingrediente_id)
);
-- Insertar recetas
INSERT INTO recetas (nombre, tiempo_preparacion, tiempo_coccion, porciones, dificultad, elaboracion, tecnicas_cocina) VALUES 
('Paella Valenciana', 30, 45, 4, 'Media', 'Sofría el pollo y conejo. Añada verduras y arroz. Agregue caldo y azafrán. Cocine a fuego lento.', 'Sofrito, cocción de arroz'),
('Gazpacho Andaluz', 20, 0, 6, 'Fácil', 'Triture tomates, pimiento, pepino y ajo. Añada aceite de oliva y vinagre. Enfríe antes de servir.', 'Triturado, emulsión'),
('Tortilla de Patatas', 15, 20, 4, 'Fácil', 'Fría las patatas y cebolla. Bata los huevos. Mezcle y cocine en sartén por ambos lados.', 'Fritura, volteo'),
('Cocido Madrileño', 30, 120, 6, 'Media', 'Cocine garbanzos con carnes y verduras. Prepare sopa con el caldo. Sirva en tres vuelcos.', 'Cocción lenta, escalonada'),
('Fabada Asturiana', 20, 180, 4, 'Media', 'Remoje las fabes. Cocine con chorizo, morcilla y lacón. Añada azafrán y pimentón.', 'Cocción lenta, remojo previo'),
('Crema Catalana', 20, 10, 4, 'Media', 'Prepare crema con leche, huevos y canela. Enfríe y caramelice el azúcar por encima.', 'Templado, caramelizado');

-- Insertar relaciones entre recetas e ingredientes (ejemplo para la paella)
INSERT INTO recetas_ingredientes (receta_id, ingrediente_id, cantidad, unidad_medida) VALUES
(1, 1, 2, 'unidades'), -- Cebolla para la paella
(1, 2, 4, 'unidades'), -- Tomate para la paella
(2, 1, 1, 'unidad'),   -- Cebolla para el gazpacho
(2, 2, 6, 'unidades'); -- Tomate para el gazpacho