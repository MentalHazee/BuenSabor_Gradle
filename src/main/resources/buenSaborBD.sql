CREATE DATABASE IF NOT EXISTS BuenSaborBD;
USE BuenSaborBD;

CREATE TABLE Empresa (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(255),
    razonSocial VARCHAR(255),
    cuil INTEGER(15),
    PRIMARY KEY (id)
);

CREATE TABLE Sucursal (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(255),
    horarioApertura date,
    horarioCierre date,
    PRIMARY KEY (id)
);

CREATE TABLE Domicilio (
    id BIGINT NOT NULL AUTO_INCREMENT,
    calle VARCHAR(255),
    numero integer(8),
    cp INTEGER(15),
    PRIMARY KEY (id)
);

CREATE TABLE Localidad (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE Provincia (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE Pais (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE Promocion (
    id BIGINT NOT NULL AUTO_INCREMENT,
    denominacion VARCHAR(255),
    FechaDesde date,
    FechaHasta date,
    HoraDesde date,
    HoraHasta date,
    descripcionDescuento VARCHAR(255),
    precioPromocional float(20),
    tipoPromocion VARCHAR(100),
    PRIMARY KEY (id)
);

CREATE TABLE ArticuloManufacturado (
    id BIGINT NOT NULL AUTO_INCREMENT,
    calle VARCHAR(255),
    numero integer(8),
    cp INTEGER(15),
    PRIMARY KEY (id)
);

CREATE TABLE Categoria (
    id BIGINT NOT NULL AUTO_INCREMENT,
    denominacion VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE Usuario (
    id BIGINT NOT NULL AUTO_INCREMENT,
    auth0Id VARCHAR(255),
    username VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE ArticuloInsumo (
    id BIGINT NOT NULL AUTO_INCREMENT,
    precioCompra float(25),
    stockActual INTEGER(15),
    stockMaximo INTEGER(15),
    esParaElaborar BOOLEAN,
    PRIMARY KEY (id)
);

CREATE TABLE ArticuloManufacturadoDetalle (
id BIGINT NOT NULL AUTO_INCREMENT,
cantidad INTEGER(15),
primary key (id)
);

CREATE TABLE DetallePedido (
    id BIGINT NOT NULL AUTO_INCREMENT,
    cantidad INTEGER(25),
    subTotal FLOAT(15),
    PRIMARY KEY (id)
);

CREATE TABLE Pedido (
    id BIGINT NOT NULL AUTO_INCREMENT,
    horaEstimadaFinalizacion date,
    total FLOAT(20),
    totalCosto FLOAT(20),
    estado VARCHAR(150),
    tipoEnvio VARCHAR(150),
    formaPago VARCHAR(150),
    fechaPedido date,
    PRIMARY KEY (id)
);

CREATE TABLE Cliente (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(150),
    apellido VARCHAR(150),
    telefono VARCHAR(150),
    email VARCHAR(150),
    fechaNacimiento date,
    PRIMARY KEY (id)
);

CREATE TABLE Imagen (
    id BIGINT NOT NULL AUTO_INCREMENT,
    denominacion VARCHAR(150),
    PRIMARY KEY (id)
);

CREATE TABLE Articulo (
    id BIGINT NOT NULL AUTO_INCREMENT,
    denominacion VARCHAR(150),
    precioVenta FLOAT(20),
    PRIMARY KEY (id)
);

CREATE TABLE UnidadMedida (
    id BIGINT NOT NULL AUTO_INCREMENT,
    denominacion VARCHAR(150),
    PRIMARY KEY (id)
);

CREATE TABLE Factura (
    id BIGINT NOT NULL AUTO_INCREMENT,
    fechaFacturacion date,
    mpPaymentId INTEGER(20),
    mpMerchantOrderId INTEGER(20),
    mpPreferenceId VARCHAR(150),
    mpPaymentType VARCHAR(150),
    formaPago VARCHAR(150),
    totalVenta FLOAT(20),
    PRIMARY KEY (id)
);

SELECT * FROM Factura;