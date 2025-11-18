CREATE DATABASE IF NOT EXISTS hola_mundo CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE hola_mundo;

CREATE TABLE IF NOT EXISTS mensaje (
  id INT AUTO_INCREMENT PRIMARY KEY,
  mensaje VARCHAR(255) NOT NULL
);

INSERT INTO mensaje (mensaje) VALUES ('¡Hola Mundo desde MySQL!');
