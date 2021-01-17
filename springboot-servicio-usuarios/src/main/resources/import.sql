INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('juan','$2a$10$E5SQ4fA7n54Y798Uibe37OfOmYy23k1Hxm65jjCS.5g4FjrXbffEK',true, 'Andres', 'Guzman','profesor@bolsadeideas.com');
INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('admin','$2a$10$kXSmGlt9JOKJZ56hnhAlVO7PXfNnQSu9ETGKGuPv66ophOdMqezQO',true, 'John', 'Doe','jhon.doe@bolsadeideas.com');

INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (1, 1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2, 2);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2, 1);