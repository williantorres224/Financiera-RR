-- Financiera R&R
-- Script de creación de base de datos
-- Autor: Willian Torres

CREATE DATABASE IF NOT EXISTS financiera;

USE financiera;

CREATE TABLE IF NOT EXISTS usuarios (

    id INT PRIMARY KEY AUTO_INCREMENT,

    nombre VARCHAR(100) NOT NULL,

    apellido_paterno VARCHAR(100) NOT NULL,

    apellido_materno VARCHAR(100) NOT NULL,

    dni VARCHAR(8) NOT NULL UNIQUE,

    clave VARCHAR(255) NOT NULL,

    foto VARCHAR(255)

);

CREATE TABLE IF NOT EXISTS cuentas (

    id INT PRIMARY KEY AUTO_INCREMENT,

    numero_cuenta VARCHAR(30) NOT NULL UNIQUE,

    saldo DOUBLE NOT NULL DEFAULT 0,

    id_usuario INT NOT NULL,

    FOREIGN KEY(id_usuario)
    REFERENCES usuarios(id)

);

CREATE TABLE IF NOT EXISTS movimientos (

    id INT PRIMARY KEY AUTO_INCREMENT,

    id_usuario INT NOT NULL,

    tipo VARCHAR(50) NOT NULL,

    monto DOUBLE NOT NULL,

    fecha DATETIME DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY(id_usuario)
    REFERENCES usuarios(id)

);