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
-- Current Database: `kehu51`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `kehu51` /*!40100 DEFAULT CHARACTER SET gbk */;

USE `kehu51`;

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
-- Dumping data for table `authority`
--

LOCK TABLES `authority` WRITE;
/*!40000 ALTER TABLE `authority` DISABLE KEYS */;
INSERT INTO `authority` VALUES (1,'客户'),(2,'员工'),(3,'经理'),(4,'管理员');
/*!40000 ALTER TABLE `authority` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (7,'coder','这个员工挺好','2017-10-26 21:57',6,15),(8,'coder','今天这个员工帮了我大忙','2017-11-03 14:59',6,15),(9,'kity','我是kity，这个客服张三，人很好啊，是我表白的对象，我想，我已经爱上他了','2018-01-14 09:54',17,1),(10,'aaa','????????????sb??','2018-01-20 22:14',21,19),(11,'aaa','???????????????????????????????????','2018-01-20 22:15',21,19),(12,'aaa','????????????','2018-01-20 22:18',21,19),(13,'aaa','??????????????????????','2018-01-20 22:23',21,19),(14,'aaa','这是一个sb','2018-01-20 22:32',21,19),(15,'mycustom','这个Test员工很好呀，但是有点小气','2018-01-21 11:59',22,20),(16,'jedis','?????','2018-02-12 17:13',15,11),(17,'jedis','哈哈哈哈哈','2018-02-12 17:16',5,11),(18,'aaa','hello nokia','2018-02-13 20:41',6,19),(19,'aaa','你的额','2018-02-13 20:42',6,19),(20,'aaa','我是aaa员工，测试系统消息与评论','2018-02-23 13:26',6,19),(21,'aaa','我是aaa员工，测试系统消息与评论01','2018-02-23 13:27',6,19),(22,'aaa','employ.getId()employ.getId()employ.getId()employ.getId()','2018-02-23 13:30',6,19),(23,'aaa','我是aaa，今天我测试了','2018-02-26 19:44',5,19),(24,'aaa','今天我学习了css3的新技能，感觉特别棒，我爱死捏','2018-03-18 17:59',5,19),(25,'aaa','大隔断柜','2018-03-18 17:59',5,19),(26,'aaa','这个员工感觉不错，我愿意于这样的员工一起合作，希望咱么的关系越来越好','2018-03-20 19:38',5,19),(27,'aaa','','2018-03-20 19:38',5,19),(28,'aaa','hello world','2018-03-23 09:39',5,19),(29,'aaa','你好员工Employ1，我是你的员工aaa,今天感觉和你相处的很愉快，希望咱么继续合作，谢谢你，一起进步','2018-03-23 22:40',6,19),(30,'aaa','hello，这里是喜马拉雅','2018-03-25 22:04',15,19),(31,'lilian','我是莉莉安，今天测试我的员工丽丽','2018-04-17 17:33',44,26);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `custom`
--

LOCK TABLES `custom` WRITE;
/*!40000 ALTER TABLE `custom` DISABLE KEYS */;
INSERT INTO `custom` VALUES (1,'kity','kity','15235484814','1751336358@qq.com','1995-05-12','2017年10月25日 14点29分','kity',17,1,NULL,1),(2,'tom','tom','15235484814','1751336358@qq.com','1995-05-12','2017年10月25日 14点30分','tom',17,1,NULL,1),(3,'tomcat','tomcat','15235484814','1751336358@qq.com','1995-05-12','2017年10月25日 14点30分','tomcat',15,1,NULL,1),(4,'nginx','nginx','15235484814','1751336358@qq.com','1995-05-12','2017年10月25日 14点31分','nginx',17,1,NULL,1),(5,'redis','redis','15235484814','nicoliuli@163.co','1995-05-12','2017年10月25日 14点31分','redis',17,1,NULL,1),(6,'linux','linux','15235484814','nicoliuli@163.com','2012-01-09','2017年10月25日 14点32分','linux',15,1,NULL,1),(11,'jedis','jedis','15235484814','nicoliuli@163.com','2017-10-03','2017年10月25日 15点30分','jedis',6,1,NULL,1),(12,'mongodb','mongodb','15235484814','nicoliuli@163.com','2017-10-09','2017年10月25日 15点33分','mongodb',5,1,NULL,1),(13,'spring','spring','15235484814','nicoliuli@163.com','2017-10-03','2017年10月25日 16点23分','spring',17,1,NULL,1),(14,'coden','coden','15235484814','1751336358@qq.com','2017-10-09','2017年10月25日 16点35分','coden',15,1,NULL,1),(15,'coder','coder','15235484814','nicoliuli@163.com','2017-10-03','2017年10月25日 16点37分','coder',6,1,NULL,1),(16,'nicoliuli','nicoliuli','15235484814','1751336358@qq.com','1994-06-15','2017年11月03日 15点26分','nicoliuli',6,1,NULL,1),(17,'hello','hello','15235484814','nicoliuli@163.com','2017-01-03','2017年11月03日 15点27分','hello',6,1,NULL,1),(18,'world','world','14913717942','1751336358@qq.com','2017-11-01','2017年11月03日 15点28分','world',6,1,NULL,1),(19,'aaa','aaa','1751336358','nicoliuli@163.com','2018-01-01','2018年01月01日 11点44分','aaa',15,1,NULL,1),(20,'mycustom','mycustom','15235484814','1751336358@qq.com','2018-01-01','2018年01月21日 11点57分','mycustom',22,1,NULL,1),(21,'emp','emp','423534545','1751336358@qq.com','2018-03-14','2018年03月03日 17点20分','emp',5,1,NULL,-1),(22,'www','www','15235484814','1751336358@qq.com','03/03/2018','2018年03月03日 19点22分','www',7,1,NULL,1),(23,'wwww','wwww','15235484814','1751336358@qq.com','03/08/2018','2018年03月03日 19点25分','wwww',21,1,NULL,1),(24,'qqq','qqq','15235484814','1751336358@qq.com','03/03/2018','2018年03月03日 19点30分','qqq',5,1,NULL,-1),(25,'eee','eee','15235484814','1751336358@qq.com','03/15/2018','2018年03月05日 18点48分','eee',7,1,NULL,1),(26,'lilian','lilian','15235484814','1751336358@qq.com','04/16/2018','2018年04月17日 17点32分','lilian',44,1,NULL,1);
/*!40000 ALTER TABLE `custom` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'开发部','我是开发部'),(2,'财务部','我是财务部'),(3,'项目部','我是项目部'),(29,'双体系','开发中心');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `employ`
--

LOCK TABLES `employ` WRITE;
/*!40000 ALTER TABLE `employ` DISABLE KEYS */;
INSERT INTO `employ` VALUES (1,'manager1','manager1','我是manager1',3,1,'manager1',NULL,1),(2,'manager2','manager2','我是manager2',3,2,'manager2',NULL,1),(3,'manager3','manager3','我是manager3',3,3,'manager3',NULL,1),(5,'employ22','employ22','真真晚饭出道百余年',2,1,'employ22',NULL,-1),(6,'employ1','employ1','employ1',2,2,'employ1',NULL,1),(7,'xxx','xxx','我是manage2的员工',2,2,'xxx',NULL,1),(11,'employrr','employrr','我是manage2的员工',2,2,'employrr',NULL,1),(15,'李四','李四','我是李四啊啊啊',2,1,'李四',NULL,1),(17,'张三','张三','我是张三',2,1,'张三',NULL,1),(18,'李伟杰','李伟杰','这个员工有点傻，一愣一愣的傻了吧唧的',2,1,'李伟杰',NULL,-1),(19,'session','session','session',2,1,'session',NULL,1),(20,'order','order','order',2,1,'order',NULL,1),(21,'刘鑫','刘鑫','刘鑫',2,3,'刘鑫',NULL,1),(22,'test','test','修改密码后测试',2,1,'test',NULL,1),(23,'tttt','tttt','ttttt',2,2,'tttt',NULL,1),(25,'vvv','vvv','dvcevfrv',2,2,'vvv',NULL,1),(26,'ttt','ttt','ttt',2,2,'ttt',NULL,1),(27,'ruby','ruby','这是ruby，新员工，来自山西农业大学信息学院的毕业生',2,3,'ruby',NULL,1),(28,'maven','maven','this is maven,plase change password in time.',2,3,'maven',NULL,1),(29,'springcloud','springcloud','this is springcloud,please change password in time;',2,3,'springcloud',NULL,1),(30,'oracle','oracle','this is oracle,welcome to my detartment.',2,3,'oracle',NULL,1),(31,'dobbox','dobbox','my name is dobbox,nice to meet you.',2,3,'dobbox',NULL,1),(43,'liuli','liuli','my name is liuli',3,29,'liuli',NULL,1),(44,'lili','lili','this is lili',2,29,'lili',NULL,1);
/*!40000 ALTER TABLE `employ` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `log`
--

LOCK TABLES `log` WRITE;
/*!40000 ALTER TABLE `log` DISABLE KEYS */;
INSERT INTO `log` VALUES (7,'2017-10-22工作汇报','今天我吃了很多','2017年10月22日 20点26分',17,1),(8,'11111','啊啊啊啊啊啊啊啊啊啊啊啊','2017年10月23日 10点09分',17,1),(9,'22222','版本棒棒棒棒棒棒棒棒棒棒棒棒','2017年10月23日 10点09分',17,1),(10,'33333','成擦擦擦擦擦擦擦擦擦擦车','2017年10月23日 10点09分',17,1),(11,'44444','的顶顶顶顶顶的顶顶顶顶顶大','2017年10月23日 10点09分',17,1),(12,'55555','呃呃呃呃呃呃呃呃呃呃呃呃','2017年10月23日 10点09分',17,1),(13,'66666','凤飞飞凤飞飞凤飞飞凤飞飞凤飞飞凤飞飞','2017年10月23日 10点09分',17,1),(14,'77777','嘎嘎嘎嘎嘎嘎嘎嘎嘎灌灌灌灌灌','2017年10月23日 10点10分',17,1),(15,'88888','嘎嘎嘎嘎嘎嘎嘎嘎嘎灌灌灌灌灌','2017年10月23日 10点10分',17,1),(16,'99999','IIIIIIIIIIIIIIIIII共同或多个v','2017年10月23日 10点10分',17,1),(17,'101010','将建军节建军节建军节建军节建军节','2017年10月23日 10点10分',17,1),(18,'121212','婷婷婷婷婷婷婷婷婷婷婷婷婷婷婷婷挺','2017年10月23日 10点11分',17,1),(19,'131313','亲亲亲亲亲亲亲亲亲亲亲亲亲亲亲亲','2017年10月23日 10点11分',17,1),(20,'1414414','哇哇哇哇哇哇哇哇哇哇哇哇问问','2017年10月23日 10点11分',17,1),(21,'151515','一样一样一样一样一样一样','2017年10月23日 10点11分',17,1),(22,'161616','啧啧啧啧啧啧啧啧啧啧啧啧','2017年10月23日 10点11分',17,1),(23,'171717','正想着象征性正在下载行政中心','2017年10月23日 10点11分',17,1),(24,'2017-10-25工作汇报','今天上完最后一节课','2017年10月25日 14点01分',17,1),(25,'我的世界','今天天气好晴朗，处处好风光','2017年10月25日 21点42分',17,1),(26,'2017-11-3工作汇报','今天完成两个面试','2017年11月03日 15点45分',6,2),(27,'2017-11-3工作汇报','今天完成两个面试','2017年11月03日 15点54分',6,2),(28,'text','1、将JDK的压缩包解压到/usr下（/usr/jdk8） tar -zxvf  文件名\r\n2、将解压后的文件mv到/usr目录下并重命名为jdk8\r\n3、在/home/user/.bash_profile文件中，添加如下变量\r\nPATH=$PATH:$HOME/bin\r\nJAVA_HOME=/usr/jdk8\r\nPATH=$JAVA_HOME/bin:$PATH\r\nCLASS_PATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar\r\nexport JAVA_HOME\r\nexport PATH\r\nexport CLASS_PATH\r\n\r\n4、source .bash_profile加载文件\r\n5、Java、javac 配置成功','2017年11月04日 10点34分',6,2),(29,'张三的歌','1、将JDK的压缩包解压到/usr下（/usr/jdk8） tar -zxvf  文件名\r\n2、将解压后的文件mv到/usr目录下并重命名为jdk8\r\n3、在/home/user/.bash_profile文件中，添加如下变量\r\nPATH=$PATH:$HOME/bin\r\nJAVA_HOME=/usr/jdk8\r\nPATH=$JAVA_HOME/bin:$PATH\r\nCLASS_PATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar\r\nexport JAVA_HOME\r\nexport PATH\r\nexport CLASS_PATH\r\n\r\n4、source .bash_profile加载文件\r\n5、Java、javac 配置成功','2017年11月04日 10点36分',17,1),(30,'2018-1-14的工作内容','今天周日，但是我加班','2018年01月14日 09点49分',17,1),(31,'李四，新的一天','今天，我自己搭了一个分布式的架构，将用户的session信息存储到redis数据库中，但是貌似速度变慢了','2018年01月20日 21点45分',15,1),(32,'2018-01-12','test用户测试分布式session','2018年01月21日 11点55分',22,1),(33,'测试pre','http://www.redis.cn/commands.html	中文文档\r\nttl key\r\nexpire key second\r\nBit\r\n	setbit key offset value\r\n	bitcount key\r\n	getbit key offset\r\n	bitop op key3 key1 key2\r\nList\r\n	LPUSH key value [value..]\r\n	RPUSH key value	[value..]\r\n	LPOP key\r\n	RPOP key\r\n	RPOPLPUSH source destination\r\n	LRANGE key start end\r\n	LINDEX key index\r\n	LSET key index value\r\n	LLEN key\r\n	LREM key count value\r\n		count>0:从表头向表尾搜索，删除与value值相等的元素count次\r\n		count<0:从表尾向表头搜索，删除与value值相等的元素count次\r\n		count=0:移除list中所有与value相等的元素\r\n	LTRIM key start stop\r\n\r\n		删除start之前和stop之后的元素（不包含start和stop），只留下[start-stop]之间的元素\r\n	LINSERT key before|after pivot value\r\n		在list中某个存在的值pivot前或后插入value，如果key和pivot不存在，则不进行任何操作\r\n		\r\nHash\r\n	HSET key field value\r\n	HSETNX key field value(如果filed不存在时才操作)\r\n	HMSET key field value [field value]\r\n	HGET key field\r\n	HMGET key field [field..]\r\n	HGETALL key	//返回所有的键值对\r\n	HKEYS key	//返回所有的filed名\r\n	HVALS key	//返回所有的value\r\n	HLEN key\r\n	HEXISTS key field(判断filed是否存在，返回1或0)\r\n	HDEL key field [field..]\r\n	HINCRBY key field intNum(对field的值做加法，不支持减法)\r\n	HINCRBYFLOAT key field floatNum(对field的值做浮点运算，不支持减法)','2018年02月12日 13点18分',17,1),(34,'我是李伟杰','logging.file=F:\\springboot.txt','2018年02月12日 13点39分',18,1),(37,'测试redis','测试redis存储request请求','2018年02月13日 20点40分',6,2),(38,'测试日志消息01','测试日志消息标记为已读状态','2018年02月20日 16点44分',6,2),(39,'过年第一天上班','今天是过年后第一个工作日，新的一年，努力工作，','2018年02月23日 10点16分',6,2),(40,'测试日志发送消息01','测试日志发送消息01测试日志发送消息01测试日志发送消息01测试日志发送消息01测试日志发送消息01测试日志发送消息01测试日志发送消息01测试日志发送消息01测试日志发送消息01','2018年02月23日 11点34分',6,2),(41,'测试日志','今 |         0 |\r\n|  6 | 个人主页     | updateinfo     |            1 |         0 |\r\n|  7 | 员工管理     | getemploy      |            1 |         0 |\r\n| 12 | 添加员工     | addemploy      |            3 | |         0 |\r\n|  6 | 个人主页     | updateinfo     |            1 |         0 |\r\n|  7 | 员工管理     | getemploy      |            1 |         0 |\r\n| 12 | 添加员工     | addemploy      |            3 |','2018年02月23日 13点22分',6,2),(42,'ghngh','tghtrhrt','2018年03月09日 13点55分',6,2),(43,'aaa','aaa','2018年03月09日 14点09分',6,2),(44,'支经理','今天我把任务多线程入队完成','2018年03月23日 22点37分',6,2),(45,'凤凰股份','给的覆盖','2018年03月23日 23点13分',6,2),(48,'哈哈哈','和今天眼睛','2018年03月23日 23点18分',6,2),(53,'覆盖','丰东股份','2018年03月23日 23点22分',6,2),(54,'2018-04-06工作内容','今天的任务完成情况很好，客户基本满意，销量提高，代码已经提交上去了','2018年04月06日 14点34分',6,2),(55,'2018-04-05工作内容','tar -xf mongodb-linux-i686-1.8.2.tar.gz\r\n	mkdir mongodb_simple\r\n	cd mongodb_simple\r\n	mkdir data	#存放mongodb数据\r\n	mkdir conf	#存放配置文件\r\n	mkdir bin	#存放二进制文件\r\n	mkdir log	#存放日志文件\r\n	方便起见，将解压目录的bin中所有文件cp到mongodb_simple/bin中,这样的步骤可以省略(主要是为了方便)','2018年04月06日 14点36分',6,2),(56,'2018-04-07','今天的工作内容是写完论文和毕业设计','2018年04月07日 21点43分',6,2),(57,'20180407','测试日志发送功能','2018年04月07日 21点57分',6,2),(58,'dsugfvydvusdyfc','红烧冬瓜汇丰银行施工方我义无反顾','2018年04月07日 22点08分',6,2),(59,'订购人发给过','看风景辜负个人河谷','2018年04月07日 22点08分',6,2),(60,'二份核桃仁合同号','热个人合同号热歌五个认同和','2018年04月07日 22点09分',6,2),(61,'测试版是和用法的v油施工从三个','是得分v基地是否GV我有的功夫','2018年04月07日 22点09分',6,2),(62,'复古风格吧大夫给的','地方改机发过火说个话访问的','2018年04月07日 22点10分',6,2);
/*!40000 ALTER TABLE `log` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,'员工管理','employmanage',3,0),(2,'日志管理','logmanage',3,0),(3,'考勤管理','workmanage',3,0),(4,'工作管理','mywork',2,0),(5,'客户管理','custommanage',2,0),(6,'个人中心','updateinfo',1,0),(7,'员工管理','getemploy',1,0),(12,'添加员工','addemploy',3,1),(15,'查看日志','getlogs',3,2),(16,'查看考勤','getworks',3,3),(17,'我的员工','getallemploy',3,1),(18,'签到签退','workstartend',2,4),(20,'留言','writelog',2,4),(21,'修改个人信息','changeinfo',2,31),(22,'修改个人信息','changemyinfo',1,6),(23,'查看个人信息','showmyinfo',1,6),(24,'更换员工','changeemploy',1,7),(25,'员工信息','showemployinfo',1,7),(26,'查看客户','getallcustom',2,5),(27,'评论我的','mycomment',2,5),(31,'个人中心','myinfo4employ',2,0),(32,'部门管理','departmentmanage',4,0),(33,'添加部门','gotoAddDepartment',4,32),(34,'部门列表','departmentlist',4,32),(35,'员工管理','employmanager',4,0),(36,'员工列表','gotoEmployList',4,35);
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Dumping data for table `work`
--

LOCK TABLES `work` WRITE;
/*!40000 ALTER TABLE `work` DISABLE KEYS */;
INSERT INTO `work` VALUES (3,'2017-10-22',17,1,'2017年10月22日 20点25分',1,'2017年10月22日 20点25分'),(4,'2017-10-23',17,1,'2017年10月23日 12点54分',1,'2017年10月23日 12点54分'),(5,'2017-10-01',17,1,'2017年10月01日 20点25分',1,'2017年10月01日 12点54分'),(6,'2017-10-02',17,1,'2017年10月02日 20点25分',1,'2017年10月02日 12点54分'),(7,'2017-10-03',17,1,'2017年10月03日 20点25分',1,'2017年10月03日 12点54分'),(8,'2017-10-04',17,1,'2017年10月04日 20点25分',1,'2017年10月04日 12点54分'),(9,'2017-10-05',17,1,'2017年10月05日 20点25分',1,'2017年10月05日 12点54分'),(10,'2017-10-06',17,1,'2017年10月06日 20点25分',1,'2017年10月06日 12点54分'),(11,'2017-10-07',17,1,'2017年10月07日 20点25分',1,'2017年10月07日 12点54分'),(12,'2017-10-08',17,1,'2017年10月08日 20点25分',1,'2017年10月08日 12点54分'),(13,'2017-10-09',17,1,'2017年10月09日 20点25分',1,'2017年10月09日 12点54分'),(14,'2017-10-10',17,1,'2017年10月10日 20点25分',1,'2017年10月10日 12点54分'),(15,'2017-10-11',17,1,'2017年10月11日 20点25分',1,'2017年10月11日 12点54分'),(16,'2017-10-12',17,1,'2017年10月12日 20点25分',1,'2017年10月12日 12点54分'),(17,'2017-10-13',17,1,'2017年10月13日 20点25分',1,'2017年10月13日 12点54分'),(18,'2017-10-14',17,1,'2017年10月14日 20点25分',1,'2017年10月14日 12点54分'),(19,'2017-10-15',17,1,'2017年10月15日 20点25分',1,'2017年10月15日 12点54分'),(20,'2017-10-16',17,1,'2017年10月16日 20点25分',1,'2017年10月16日 12点54分'),(21,'2017-10-17',17,1,'2017年10月17日 20点25分',1,'2017年10月17日 12点54分'),(22,'2017-10-18',17,1,'2017年10月18日 20点25分',1,'2017年10月18日 12点54分'),(23,'2017-10-19',17,1,'2017年10月19日 20点25分',1,'2017年10月19日 12点54分'),(24,'2017-10-20',17,1,'2017年10月20日 20点25分',1,'2017年10月20日 12点54分'),(25,'2017-10-21',17,1,'2017年10月21日 20点25分',1,'2017年10月21日 12点54分'),(26,'2017-10-23',15,1,'2017年10月23日 18点00分',1,'2017年10月23日 18点00分'),(27,'2017-10-23',5,1,'2017年10月23日 18点00分',1,'2017年10月23日 18点00分'),(29,'2017-10-24',17,1,'2017年10月24日 11点56分',1,'2017年10月24日 11点56分'),(30,'2017-10-25',17,1,'2017年10月25日 14点00分',1,'2017年10月25日 14点00分'),(31,'2017-10-26',17,1,'2017年10月26日 10点12分',1,'2017年10月26日 10点12分'),(32,'2017-10-28',17,1,'2017年10月28日 09点44分',1,'2017年10月28日 09点44分'),(33,'2017-11-03',6,1,'2017年11月03日 15点17分',1,'2017年11月03日 15点17分'),(34,'2017-11-04',6,1,'2017年11月04日 09点07分',1,'2017年11月04日 09点07分'),(36,'2018-01-14',17,1,'2018年01月14日 09点49分',1,'2018年01月14日 09点56分'),(37,'2018-01-20',15,1,'2018年01月20日 21点43分',1,'2018年01月20日 21点43分'),(38,'2018-01-20',21,1,'2018年01月20日 22点12分',1,'2018年01月20日 22点12分'),(39,'2018-01-21',22,1,'2018年01月21日 11点55分',1,'2018年01月21日 11点55分'),(40,'2018-02-12',17,1,'2018年02月12日 13点17分',1,'2018年02月12日 13点17分'),(41,'2018-02-12',15,1,'2018年02月12日 13点29分',1,'2018年02月12日 13点29分'),(42,'2018-02-12',18,1,'2018年02月12日 13点37分',1,'2018年02月12日 13点37分'),(43,'2018-02-12',6,1,'2018年02月12日 17点17分',1,'2018年02月12日 17点17分'),(44,'2018-02-13',17,1,'2018年02月13日 20点39分',1,'2018年02月13日 20点39分'),(45,'2018-02-13',6,1,'2018年02月13日 20点40分',1,'2018年02月13日 20点40分'),(46,'2018-02-14',6,1,'2018年02月14日 09点37分',1,'2018年02月14日 09点37分'),(47,'2018-02-14',5,1,'2018年02月14日 20点28分',1,'2018年02月14日 20点28分'),(48,'2018-02-15',6,1,'2018年02月15日 09点48分',1,'2018年02月15日 09点49分'),(49,'2018-02-16',6,1,'2018年02月16日 11点05分',1,'2018年02月16日 11点05分'),(50,'2018-02-17',5,1,'2018年02月17日 21点30分',1,'2018年02月17日 21点30分'),(51,'2018-02-20',15,1,'2018年02月20日 21点43分',1,'2018年02月20日 21点43分'),(52,'2018-02-20',6,1,'2018年02月20日 21点51分',1,'2018年02月20日 21点53分'),(53,'2018-02-06',6,1,'2018年02月06日 09点00分',1,'2018年02月06日 18点30分'),(54,'2018-02-01',6,1,'2018年02月01日 09点00分',1,'2018年02月01日 18点30分'),(55,'2018-02-02',6,1,'2018年02月02日 09点00分',1,'2018年02月02日 18点30分'),(56,'2018-02-04',6,1,'2018年02月04日 09点00分',1,'2018年02月04日 18点30分'),(57,'2018-02-26',6,1,'2018年02月26日 19点41分',1,'2018年02月26日 19点41分'),(58,'2018-03-02',6,1,'2018年03月02日 09点00分',1,'2018年03月02日 18点30分'),(59,'2018-03-08',6,1,'2018年03月08日 18点56分',1,'2018年03月08日 18点30分'),(60,'2018-03-17',6,1,'2018年03月17日 17点18分',1,'2018年03月17日 17点18分'),(61,'2018-03-18',6,1,'2018年03月18日 18点07分',1,'2018年03月18日 18点07分'),(62,'2018-03-20',6,1,'2018年03月20日 19点36分',1,'2018年03月20日 19点36分'),(63,'2018-03-20',6,1,'2018年03月20日 09点00分',0,NULL),(64,'2018-03-25',6,1,'2018年03月25日 21点46分',1,'2018年03月25日 21点48分'),(65,'2018-04-02',6,1,'2018年04月02日 11点04分',1,'2018年04月02日 11点04分'),(66,'2018-03-30',6,1,'2018年03月30日 09点00分',0,NULL),(67,'2018-04-06',6,1,'2018年04月06日 14点36分',0,NULL),(68,'2018-04-07',6,1,'2018年04月07日 21点42分',1,'2018年04月07日 21点42分'),(69,'2018-04-18',6,1,'2018年04月18日 11点04分',1,'2018年04月18日 11点04分');
/*!40000 ALTER TABLE `work` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-18 13:46:10
