-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-03-2015 a las 20:54:36
-- Versión del servidor: 5.5.27
-- Versión de PHP: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `hibernate`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `editorial`
--

CREATE TABLE IF NOT EXISTS `editorial` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) DEFAULT NULL,
  `descripcion` varchar(30) DEFAULT NULL,
  `direccion` varchar(30) DEFAULT NULL,
  `contacto` varchar(30) DEFAULT NULL,
  `tel_contacto` varchar(30) DEFAULT NULL,
  `email_contacto` varchar(30) DEFAULT NULL,
  `actividad` varchar(30) DEFAULT NULL,
  `nro_sucursales` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `editorial`
--

INSERT INTO `editorial` (`id`, `nombre`, `descripcion`, `direccion`, `contacto`, `tel_contacto`, `email_contacto`, `actividad`, `nro_sucursales`) VALUES
(1, 'Norma', 'latinoamerica', 'calle 64 norte # 5b-146', 'edinson muriel', '680 1515', 'emuriel@dicel.com.co', 'publicacióe libros', 1),
(3, 'Planeta', 'Venta de libros', 'Calle 23 # 34-63', 'Maryury', '8967453', 'mary@yahoo.es', 'comercial', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro`
--

CREATE TABLE IF NOT EXISTS `libro` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `editorial` int(11) NOT NULL,
  `autor` varchar(50) NOT NULL,
  `categoria` varchar(50) NOT NULL,
  `precio` int(50) NOT NULL,
  `imagen` varchar(50) NOT NULL,
  `activo` varchar(50) NOT NULL,
  `ano_publicacion` date NOT NULL,
  `edicion` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_libro_editorial_idx` (`editorial`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `libro`
--

INSERT INTO `libro` (`id`, `nombre`, `editorial`, `autor`, `categoria`, `precio`, `imagen`, `activo`, `ano_publicacion`, `edicion`) VALUES
(1, 'cien anios de soledad', 1, 'gabriel garcia marquez', 'realismo magico WTF', 50000, 'ninguna', '1', '2013-12-09', 'vck555'),
(2, 'la hojarasca', 3, 'gabriel garcia marquez', 'novela', 1111111, 'null', '1', '2014-05-28', '2'),
(3, 'mundo matematico 4', 3, 'steven', 'matematicas', 1111111, 'null', '1', '2010-05-28', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `notificaciones`
--

CREATE TABLE IF NOT EXISTS `notificaciones` (
  `notificacion_id` int(11) NOT NULL AUTO_INCREMENT,
  `tarea_id` int(11) NOT NULL,
  PRIMARY KEY (`notificacion_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `notificaciones`
--

INSERT INTO `notificaciones` (`notificacion_id`, `tarea_id`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE IF NOT EXISTS `persona` (
  `Persona_id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(90) NOT NULL,
  `email` varchar(60) NOT NULL,
  PRIMARY KEY (`Persona_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`Persona_id`, `nombre`, `apellido`, `email`) VALUES
(1, 'Ali', 'Baba', 'alibaba@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proyecto`
--

CREATE TABLE IF NOT EXISTS `proyecto` (
  `proyecto_id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(60) NOT NULL,
  `descripcion` text NOT NULL,
  PRIMARY KEY (`proyecto_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `proyecto`
--

INSERT INTO `proyecto` (`proyecto_id`, `nombre`, `descripcion`) VALUES
(1, 'Hibernate', 'hibernate.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tarea`
--

CREATE TABLE IF NOT EXISTS `tarea` (
  `tarea_id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(60) NOT NULL,
  `descripcion` text NOT NULL,
  `fecha` date NOT NULL,
  `ejecucion` int(11) NOT NULL,
  `estado_tarea` tinyint(1) NOT NULL,
  `persona_id` int(11) NOT NULL,
  `proyecto_id` int(11) NOT NULL,
  PRIMARY KEY (`tarea_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `tarea`
--

INSERT INTO `tarea` (`tarea_id`, `nombre`, `descripcion`, `fecha`, `ejecucion`, `estado_tarea`, `persona_id`, `proyecto_id`) VALUES
(1, 'exposicion de ali baba', 'Hablara de hibernet', '2015-03-24', 2, 0, 1, 1);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `libro`
--
ALTER TABLE `libro`
  ADD CONSTRAINT `fk_libro_editorial` FOREIGN KEY (`editorial`) REFERENCES `editorial` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
