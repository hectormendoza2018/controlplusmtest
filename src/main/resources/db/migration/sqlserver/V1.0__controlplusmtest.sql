CREATE TABLE sucursal (
    id int IDENTITY(1,1) PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    direccion VARCHAR(255) NOT NULL,
    telefono VARCHAR(255) NOT NULL
);

CREATE TABLE categoria (
    id int IDENTITY(1,1) PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
);

CREATE TABLE producto (
    id int IDENTITY(1,1) PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    activo bit NOT NULL,
    cup VARCHAR(255) NOT NULL,
    precio NUMERIC(19,2) NOT NULL,
    categoria_id int NOT NULL,
    CONSTRAINT fk_categoria_20180110 FOREIGN KEY (categoria_id) REFERENCES categoria (id)
);

CREATE TABLE existencia (
    id int IDENTITY(1,1) PRIMARY KEY,
    unidades int NOT NULL,
    producto_id int NOT NULL,
    CONSTRAINT fk_producto_20180110 FOREIGN KEY (producto_id) REFERENCES producto (id)
);

ALTER TABLE existencia ADD CONSTRAINT UK_f4d28x5t48f3udewc7449tt3j UNIQUE (producto_id)