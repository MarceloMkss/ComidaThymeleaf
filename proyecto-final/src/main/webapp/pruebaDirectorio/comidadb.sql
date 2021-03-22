CREATE DATABASE  IF NOT EXISTS `comidadb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `comidadb`;
-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: comidadb
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorias` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` VALUES (1,'Entrantes'),(2,'Primero plato'),(3,'Segundo plato'),(4,'Postres');
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `platos`
--

DROP TABLE IF EXISTS `platos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `platos` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `categoria_id` bigint DEFAULT NULL,
  `procedencia_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1q3vxt814ymgxp8hlnspb8phc` (`categoria_id`),
  KEY `FKsrikhj7w49965jiufdiwo762t` (`procedencia_id`),
  CONSTRAINT `FK1q3vxt814ymgxp8hlnspb8phc` FOREIGN KEY (`categoria_id`) REFERENCES `categorias` (`id`),
  CONSTRAINT `FKsrikhj7w49965jiufdiwo762t` FOREIGN KEY (`procedencia_id`) REFERENCES `procedencias` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `platos`
--

LOCK TABLES `platos` WRITE;
/*!40000 ALTER TABLE `platos` DISABLE KEYS */;
INSERT INTO `platos` VALUES (1,'Paella ',2,1),(2,'patatas riojana',2,1),(3,'cuscus',2,3),(4,'merluza en salsa verde',3,1),(5,'solomillo de ternera',3,1);
/*!40000 ALTER TABLE `platos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `procedencias`
--

DROP TABLE IF EXISTS `procedencias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `procedencias` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `procedencias`
--

LOCK TABLES `procedencias` WRITE;
/*!40000 ALTER TABLE `procedencias` DISABLE KEYS */;
INSERT INTO `procedencias` VALUES (1,'españa'),(2,'China'),(3,'Marruecos'),(4,'Brasil'),(5,'Francia'),(6,'Japon');
/*!40000 ALTER TABLE `procedencias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'comidadb'
--

--
-- Dumping routines for database 'comidadb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-22 10:35:58
