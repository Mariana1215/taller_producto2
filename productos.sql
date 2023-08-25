-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-08-2023 a las 15:49:39
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tallerproductos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `codigo` varchar(20) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `precio` double NOT NULL,
  `distribuidor` varchar(20) NOT NULL,
  `categoria` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`codigo`, `nombre`, `precio`, `distribuidor`, `categoria`) VALUES
('123', 'leche', 6000, 'colanta', 'lacteos'),
('124', 'yogurt fresa', 3000, 'alpina', 'lacteos'),
('125', 'queso', 7000, 'colanta', 'lacteos'),
('126', 'kumis', 7000, 'colanta', 'lacteos'),
('222', 'papas naturales', 2000, 'margarita', 'frituras'),
('223', 'rosquillas', 3000, 'margarita', 'frituras'),
('224', 'platanitos', 2000, 'margarita', 'frituras'),
('225', 'papas de limon', 2000, 'margarita', 'frituras'),
('226', 'papas de pollo', 2000, 'margarita', 'frituras'),
('333', 'gaseosa', 5000, 'hit', 'bebidas'),
('334', 'jugo de lulo', 3000, 'hit', 'bebidas'),
('335', 'jugo de mora', 3000, 'hit', 'bebidas'),
('336', 'energizante', 3000, 'hit', 'bebidas'),
('337', 'jugo de mango', 3000, 'hit', 'bebidas'),
('338', 'agua', 2000, 'hit', 'bebidas'),
('339', 'agua con gas', 2000, 'hit', 'bebidas');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`codigo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
