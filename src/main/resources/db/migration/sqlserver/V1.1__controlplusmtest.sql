DELETE FROM existencia;
ALTER TABLE existencia DROP UK_f4d28x5t48f3udewc7449tt3j

ALTER TABLE existencia ADD sucursal_id int NOT NULL;
ALTER TABLE existencia ADD CONSTRAINT fk_sucursal_20180126 FOREIGN KEY (sucursal_id) REFERENCES sucursal (id);
ALTER TABLE existencia ADD CONSTRAINT INDEXUK_20180126_existencia UNIQUE (producto_id, sucursal_id)