-- MySQL dump 10.13  Distrib 5.5.25, for Win32 (x86)
--
-- Host: localhost    Database: kehu51
-- ------------------------------------------------------
-- Server version	5.5.25

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `authority`
--

DROP TABLE IF EXISTS `authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authority` (
  `id` tinyint(4) NOT NULL,
  `name` char(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL,
  `content` text,
  `commenttime` char(40) DEFAULT NULL,
  `employ_id` int(11) DEFAULT NULL,
  `custom_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `employ_id` (`employ_id`),
  KEY `custom_id` (`custom_id`),
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`employ_id`) REFERENCES `employ` (`id`),
  CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`custom_id`) REFERENCES `custom` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `custom`
--

DROP TABLE IF EXISTS `custom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `custom` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password` varchar(100) NOT NULL,
  `phonenumber` char(11) NOT NULL,
  `email` varchar(40) NOT NULL,
  `birthday` char(20) DEFAULT NULL,
  `registertime` char(40) DEFAULT NULL,
  `queuename` char(100) NOT NULL,
  `employ_id` int(11) DEFAULT NULL,
  `authority_id` tinyint(4) DEFAULT NULL,
  `path` varchar(100) DEFAULT NULL,
  `open` tinyint(4) DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  KEY `employ_id` (`employ_id`),
  KEY `authority_id` (`authority_id`),
  CONSTRAINT `custom_ibfk_1` FOREIGN KEY (`employ_id`) REFERENCES `employ` (`id`) ON DELETE SET NULL,
  CONSTRAINT `custom_ibfk_2` FOREIGN KEY (`authority_id`) REFERENCES `authority` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `id` tinyint(4) NOT NULL AUTO_INCREMENT,
  `name` char(20) NOT NULL,
  `info` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `employ`
--

DROP TABLE IF EXISTS `employ`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employ` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password` varchar(100) NOT NULL,
  `info` varchar(512) DEFAULT NULL,
  `authority_id` tinyint(4) DEFAULT NULL,
  `department_id` tinyint(4) DEFAULT NULL,
  `queuename` char(100) NOT NULL,
  `path` varchar(100) DEFAULT NULL,
  `open` tinyint(4) DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  KEY `authority_id` (`authority_id`),
  KEY `department_id` (`department_id`),
  CONSTRAINT `employ_ibfk_1` FOREIGN KEY (`authority_id`) REFERENCES `authority` (`id`),
  CONSTRAINT `employ_ibfk_2` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `log`
--

DROP TABLE IF EXISTS `log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `content` text,
  `committime` char(40) DEFAULT NULL,
  `employ_id` int(11) DEFAULT NULL,
  `manager_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `employ_id` (`employ_id`),
  KEY `titleIndex` (`title`),
  CONSTRAINT `log_ibfk_1` FOREIGN KEY (`employ_id`) REFERENCES `employ` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu` (
  `id` tinyint(4) NOT NULL AUTO_INCREMENT,
  `name` char(20) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `authority_id` tinyint(4) DEFAULT NULL,
  `parent_id` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `authority_id` (`authority_id`),
  CONSTRAINT `menu_ibfk_1` FOREIGN KEY (`authority_id`) REFERENCES `authority` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `work`
--

DROP TABLE IF EXISTS `work`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `work` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `day` char(20) DEFAULT NULL,
  `employ_id` int(11) DEFAULT NULL,
  `workstart` tinyint(1) DEFAULT '0',
  `workstart_time` char(40) DEFAULT NULL,
  `workend` tinyint(1) DEFAULT '0',
  `workend_time` char(40) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `employ_id` (`employ_id`),
  CONSTRAINT `work_ibfk_1` FOREIGN KEY (`employ_id`) REFERENCES `employ` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-18 13:48:41
