DROP DATABASE IF EXISTS ciencia;
CREATE DATABASE IF NOT EXISTS ciencia CHARACTER SET= utf8mb4 COLLATE= utf8mb4_unicode_ci;
USE ciencia;

CREATE TABLE `cientificos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `cientificos` (nombre) VALUES ('Cientifico 1');
INSERT INTO `cientificos` (nombre) VALUES ('Cientifico 2');
INSERT INTO `cientificos` (nombre) VALUES ('Cientifico 3');

CREATE TABLE `proyectos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `horas` int(11) NOT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `proyectos` (nombre, horas) VALUES ('Proyecto 1', 100);
INSERT INTO `proyectos` (nombre, horas) VALUES ('Proyecto 2', 217);
INSERT INTO `proyectos` (nombre, horas) VALUES ('Proyecto 3', 77);

CREATE TABLE `asignado_a` (
  `id` int(11) not null  AUTO_INCREMENT,
  `cientifico` int(11) NOT NULL,
  `proyecto` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `course_registration_FK` FOREIGN KEY (`id`) REFERENCES `cientificos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `course_registration_FK_1` FOREIGN KEY (`proyecto`) REFERENCES `proyectos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO `asignado_a` (cientifico, proyecto) VALUES (1, 1);
INSERT INTO `asignado_a` (cientifico, proyecto) VALUES (1, 3);
INSERT INTO `asignado_a` (cientifico, proyecto) VALUES (1, 2);