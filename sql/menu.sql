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
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,'员工管理','employmanage',3,0),(2,'日志管理','logmanage',3,0),(3,'考勤管理','workmanage',3,0),(4,'工作管理','mywork',2,0),(5,'客户管理','custommanage',2,0),(6,'个人中心','updateinfo',1,0),(7,'员工管理','getemploy',1,0),(12,'添加员工','addemploy',3,1),(15,'查看日志','getlogs',3,2),(16,'查看考勤','getworks',3,3),(17,'我的员工','getallemploy',3,1),(18,'签到签退','workstartend',2,4),(20,'留言','writelog',2,4),(21,'修改个人信息','changeinfo',2,31),(22,'修改个人信息','changemyinfo',1,6),(23,'查看个人信息','showmyinfo',1,6),(24,'更换员工','changeemploy',1,7),(25,'员工信息','showemployinfo',1,7),(26,'查看客户','getallcustom',2,5),(27,'评论我的','mycomment',2,5),(31,'个人中心','myinfo4employ',2,0);
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-07 21:08:40
