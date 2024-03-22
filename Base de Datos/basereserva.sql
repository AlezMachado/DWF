-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 16-03-2024 a las 22:01:31
-- Versión del servidor: 8.2.0
-- Versión de PHP: 8.2.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `basereserva`
--

-- --------------------------------------------------------

--
-- Estructura  de tabla para la tabla `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
  `idpersona` int NOT NULL,
  `codigo_cliente` varchar(10) NOT NULL,
  PRIMARY KEY (`idpersona`),
  UNIQUE KEY `codigo_cliente_UNIQUE` (`codigo_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `consumo`
--

DROP TABLE IF EXISTS `consumo`;
CREATE TABLE IF NOT EXISTS `consumo` (
  `idconsumo` int NOT NULL AUTO_INCREMENT,
  `idreserva` int NOT NULL,
  `idproducto` int NOT NULL,
  `cantidad` decimal(7,2) NOT NULL,
  `precio_venta` decimal(7,2) NOT NULL,
  `estado` varchar(15) NOT NULL,
  PRIMARY KEY (`idconsumo`),
  KEY `fk_consumo_producto_idx` (`idproducto`),
  KEY `fk_consumo_reserva_idx` (`idreserva`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `habitacion`
--

DROP TABLE IF EXISTS `habitacion`;
CREATE TABLE IF NOT EXISTS `habitacion` (
  `idhabitacion` int NOT NULL AUTO_INCREMENT,
  `numero` varchar(4) NOT NULL,
  `piso` varchar(2) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `caracteristicas` varchar(512) DEFAULT NULL,
  `precio_diario` decimal(7,2) NOT NULL,
  `estado` varchar(15) NOT NULL,
  `tipo_habitacion` varchar(20) NOT NULL,
  PRIMARY KEY (`idhabitacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pago`
--

DROP TABLE IF EXISTS `pago`;
CREATE TABLE IF NOT EXISTS `pago` (
  `idpago` int NOT NULL AUTO_INCREMENT,
  `idreserva` int NOT NULL,
  `tipo_comprobante` varchar(20) NOT NULL,
  `num_comprobante` varchar(20) NOT NULL,
  `igv` decimal(4,2) NOT NULL,
  `total_pago` decimal(7,2) NOT NULL,
  `fecha_emision` date NOT NULL,
  `fecha_pago` date NOT NULL,
  PRIMARY KEY (`idpago`),
  KEY `fk_pago_reserva_idx` (`idreserva`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

DROP TABLE IF EXISTS `persona`;
CREATE TABLE IF NOT EXISTS `persona` (
  `idpersona` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `apaterno` varchar(20) NOT NULL,
  `amaterno` varchar(20) NOT NULL,
  `tipo_documento` varchar(15) NOT NULL,
  `num_documento` varchar(8) NOT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `telefono` varchar(8) DEFAULT NULL,
  `email` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`idpersona`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `telefono_UNIQUE` (`telefono`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

DROP TABLE IF EXISTS `producto`;
CREATE TABLE IF NOT EXISTS `producto` (
  `idproducto` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `unidad_medida` varchar(20) NOT NULL,
  `precio_venta` decimal(7,2) NOT NULL,
  PRIMARY KEY (`idproducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

DROP TABLE IF EXISTS `reserva`;
CREATE TABLE IF NOT EXISTS `reserva` (
  `idreserva` int NOT NULL AUTO_INCREMENT,
  `idhabitacion` int NOT NULL,
  `idcliente` int NOT NULL,
  `idtrabajador` int NOT NULL,
  `tipo_reserva` varchar(20) NOT NULL,
  `fecha_reserva` date NOT NULL,
  `fecha_ingresa` date NOT NULL,
  `fecha_salida` date NOT NULL,
  `costo_alojamiento` decimal(7,2) NOT NULL,
  `estado` varchar(15) NOT NULL,
  PRIMARY KEY (`idreserva`),
  KEY `fk_reserva_habitacion_idx` (`idhabitacion`),
  KEY `fk_reserva_cliente_idx` (`idcliente`),
  KEY `fk_reserva_trabajador_idx` (`idtrabajador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `trabajador`
--

DROP TABLE IF EXISTS `trabajador`;
CREATE TABLE IF NOT EXISTS `trabajador` (
  `idpersona` int NOT NULL,
  `sueldo` decimal(7,2) NOT NULL,
  `acceso` varchar(15) NOT NULL,
  `login` varchar(15) NOT NULL,
  `password` varchar(20) NOT NULL,
  `estado` varchar(1) NOT NULL,
  PRIMARY KEY (`idpersona`),
  UNIQUE KEY `login_UNIQUE` (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `fk_persona_cliente` FOREIGN KEY (`idpersona`) REFERENCES `persona` (`idpersona`);

--
-- Filtros para la tabla `consumo`
--
ALTER TABLE `consumo`
  ADD CONSTRAINT `fk_consumo_producto` FOREIGN KEY (`idproducto`) REFERENCES `producto` (`idproducto`),
  ADD CONSTRAINT `fk_consumo_reserva` FOREIGN KEY (`idreserva`) REFERENCES `reserva` (`idreserva`);

--
-- Filtros para la tabla `pago`
--
ALTER TABLE `pago`
  ADD CONSTRAINT `fk_pago_reserva` FOREIGN KEY (`idreserva`) REFERENCES `reserva` (`idreserva`);

--
-- Filtros para la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `fk_reserva_cliente` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idpersona`),
  ADD CONSTRAINT `fk_reserva_habitacion` FOREIGN KEY (`idhabitacion`) REFERENCES `habitacion` (`idhabitacion`),
  ADD CONSTRAINT `fk_reserva_trabajador` FOREIGN KEY (`idtrabajador`) REFERENCES `trabajador` (`idpersona`);

--
-- Filtros para la tabla `trabajador`
--
ALTER TABLE `trabajador`
  ADD CONSTRAINT `fk_persona_trabajador` FOREIGN KEY (`idpersona`) REFERENCES `persona` (`idpersona`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
