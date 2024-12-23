-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: stu
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `activity`
--

DROP TABLE IF EXISTS `activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `activity` (
  `id` int NOT NULL AUTO_INCREMENT,
  `activity_type` varchar(20) DEFAULT NULL COMMENT '活动类型',
  `name` varchar(50) DEFAULT NULL COMMENT '活动名称',
  `organizational_unit` varchar(100) DEFAULT NULL COMMENT '主办单位',
  `approve_status` varchar(10) DEFAULT NULL COMMENT '批准情况',
  `start_data` varchar(30) DEFAULT NULL COMMENT '活动开始时间',
  `end_data` varchar(30) DEFAULT NULL COMMENT '活动结束时间',
  `student_id` int DEFAULT NULL COMMENT '申请活动学生id',
  `teacher_id` int DEFAULT NULL COMMENT '批准活动老师id',
  `student_num` varchar(20) DEFAULT NULL COMMENT '学生学号',
  `student_name` varchar(20) DEFAULT NULL COMMENT '学生姓名',
  `teacher_num` varchar(20) DEFAULT NULL COMMENT '学生学号',
  `teacher_name` varchar(20) DEFAULT NULL COMMENT '学生姓名',
  `num` varchar(20) NOT NULL COMMENT '活动序号',
  PRIMARY KEY (`id`),
  KEY `activity_student_id_fk` (`student_id`),
  KEY `activity_teacher_id_fk` (`teacher_id`),
  CONSTRAINT `activity_student_id_fk` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `activity_teacher_id_fk` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='活动表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity`
--

LOCK TABLES `activity` WRITE;
/*!40000 ALTER TABLE `activity` DISABLE KEYS */;
INSERT INTO `activity` VALUES (2,'体育活动','篮球赛','软件学院','已批准',NULL,NULL,12,1,NULL,NULL,NULL,NULL,'A0001'),(3,'体育活动','篮球赛','软件学院','未批准',NULL,NULL,12,1,NULL,NULL,NULL,NULL,'A0001'),(4,'体育活动','羽毛球赛','软件学院','已批准',NULL,NULL,14,1,NULL,NULL,NULL,NULL,'A0002'),(5,'体育活动','羽毛球赛','软件学院','已批准',NULL,NULL,14,1,NULL,NULL,NULL,NULL,'A0002'),(6,'体育活动','羽毛球赛','软件学院','已批准',NULL,NULL,14,1,NULL,NULL,NULL,NULL,'A0002'),(7,'体育活动','乒乓球赛','软件学院','未批准',NULL,NULL,14,1,NULL,NULL,NULL,NULL,'A0003'),(8,'体育活动','乒乓球赛','软件学院','未批准',NULL,NULL,14,1,NULL,NULL,NULL,NULL,'A0003'),(15,'科技','web课设','软件学院','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'A0004'),(16,'12','111','12',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'A0007'),(25,'体育活动','篮球赛','软件学院','未批准',NULL,NULL,4,NULL,NULL,NULL,NULL,NULL,'A0001'),(26,'体育活动','羽毛球赛','软件学院','未批准',NULL,NULL,4,NULL,NULL,NULL,NULL,NULL,'A0002'),(27,'体育活动','乒乓球赛','软件学院','未批准',NULL,NULL,4,NULL,NULL,NULL,NULL,NULL,'A0003'),(28,'文娱活动','寻宝大赛','软件学院学生会',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'A0012');
/*!40000 ALTER TABLE `activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contest`
--

DROP TABLE IF EXISTS `contest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contest` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '竞赛名称',
  `award` varchar(255) NOT NULL COMMENT '奖项',
  `organizational_unit` varchar(50) DEFAULT NULL COMMENT '举办单位',
  `time` date DEFAULT NULL COMMENT '竞赛时间',
  `student_id` int DEFAULT NULL COMMENT '学生id',
  PRIMARY KEY (`id`),
  KEY `contest_student_id_fk` (`student_id`),
  CONSTRAINT `contest_student_id_fk` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='竞赛项目表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contest`
--

LOCK TABLES `contest` WRITE;
/*!40000 ALTER TABLE `contest` DISABLE KEYS */;
/*!40000 ALTER TABLE `contest` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `id` int NOT NULL AUTO_INCREMENT,
  `course_name` varchar(255) DEFAULT NULL COMMENT '课程名称',
  `course_num` varchar(255) NOT NULL COMMENT '课序号',
  `opening_unit` varchar(255) DEFAULT NULL COMMENT '开课单位',
  `total_hours` int DEFAULT NULL COMMENT '总学时',
  `credits` varchar(20) DEFAULT NULL COMMENT '学分',
  `course_type` varchar(255) DEFAULT NULL COMMENT '课程类型',
  `time` varchar(10) DEFAULT NULL COMMENT '上课时间',
  `place` varchar(20) DEFAULT NULL COMMENT '上课地点',
  `term` varchar(10) DEFAULT NULL COMMENT '学期',
  `isopen` int DEFAULT '1',
  `teacher_id` int DEFAULT NULL COMMENT '授课教师',
  `pre1` varchar(20) DEFAULT '50' COMMENT '平时成绩',
  `pre2` varchar(20) DEFAULT '50' COMMENT '作业成绩',
  PRIMARY KEY (`id`),
  KEY `course_teacher_id_fk` (`teacher_id`),
  CONSTRAINT `course_teacher_id_fk` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='课程表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'概率论','C0001','数学学院',32,'3','必修','22','1-101','',1,1,'50','50'),(2,'离散数学','C0002','数学学院',16,'2','必修','33','3-202','4',1,3,'50','50'),(3,'微积分','C0003','数学学院',16,'2','选修','44','3-201','4',1,3,'50','50'),(6,'linux程序设计','110','集成电路学院',100,'0','选修','31','2-101','',1,NULL,'40','60'),(11,'线性代数','C0011','数学学院',4,'2','选修','23','2-102','',1,NULL,'15','85'),(12,'传统英语','C3412','外国语学院',13,'2','选修','52','2-302','',1,NULL,'49','51'),(13,'周易','C1548','软件学院',13,'4','必修','11','4-102','',1,NULL,'45','55'),(14,'领读今典','c1002','外国语学院',32,'5.5','选修','33','4-201','',1,NULL,'20','80'),(15,'计算机组成原理','c1900','软件学院',32,'4','必修','55','1-303','',1,NULL,'20','80');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_choose`
--

DROP TABLE IF EXISTS `course_choose`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_choose` (
  `id` int NOT NULL AUTO_INCREMENT,
  `student_id` int DEFAULT NULL,
  `course_id` int DEFAULT NULL,
  `score1` int DEFAULT '0' COMMENT '平时成绩',
  `score2` int DEFAULT '0' COMMENT '作业成绩 ',
  `score3` int DEFAULT '0' COMMENT '考试成绩',
  PRIMARY KEY (`id`),
  KEY `course_choose_course_id_fk` (`course_id`),
  KEY `course_choose_student_id_fk` (`student_id`),
  CONSTRAINT `course_choose_course_id_fk` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `course_choose_student_id_fk` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='选课表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_choose`
--

LOCK TABLES `course_choose` WRITE;
/*!40000 ALTER TABLE `course_choose` DISABLE KEYS */;
INSERT INTO `course_choose` VALUES (35,4,1,100,99,99),(54,29,15,0,0,0),(59,29,2,0,0,0),(60,29,6,0,0,0),(61,29,11,0,0,0),(62,29,13,0,0,0),(63,12,1,78,78,78),(64,14,1,60,99,79),(65,18,1,78,33,55),(66,19,1,0,0,0),(69,4,2,90,80,85),(70,4,6,88,70,77),(71,4,13,67,88,78),(72,4,3,0,0,0),(73,4,12,0,0,0),(74,4,11,0,0,0);
/*!40000 ALTER TABLE `course_choose` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `honour`
--

DROP TABLE IF EXISTS `honour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `honour` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `student_id` int DEFAULT NULL COMMENT '学生id',
  `name` varchar(50) DEFAULT NULL COMMENT '荣誉名称',
  `honor_level` varchar(50) DEFAULT NULL COMMENT '荣誉等级',
  `time` varchar(50) DEFAULT NULL COMMENT '获得日期',
  `student_num` varchar(20) NOT NULL COMMENT '学生学号',
  `student_name` varchar(20) NOT NULL COMMENT '学生姓名',
  PRIMARY KEY (`id`),
  KEY `honour_student_id_fk` (`student_id`),
  CONSTRAINT `honour_student_id_fk` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='个人荣誉';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `honour`
--

LOCK TABLES `honour` WRITE;
/*!40000 ALTER TABLE `honour` DISABLE KEYS */;
INSERT INTO `honour` VALUES (16,4,'寻宝大赛优胜奖','院级','2024-12-19','2023003001','张三'),(17,4,'\"山大杯\"羽毛球赛四强','校级','2024-10-18','2023003001','张三'),(18,4,'蓝桥杯省级三等奖','省级','2024-06-13','2023003001','张三'),(19,4,'山大杯羽毛球冠军','校级','2024-12-19','2023003001','张三');
/*!40000 ALTER TABLE `honour` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `innovation`
--

DROP TABLE IF EXISTS `innovation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `innovation` (
  `id` int NOT NULL AUTO_INCREMENT,
  `project` varchar(255) NOT NULL COMMENT '项目名称',
  `content` varchar(255) NOT NULL COMMENT '项目内容',
  `tutor` varchar(50) DEFAULT NULL COMMENT '指导教师',
  `data1` varchar(50) DEFAULT NULL COMMENT '开始日期',
  `data2` varchar(50) DEFAULT NULL COMMENT '结束日期',
  `student_id` int DEFAULT NULL COMMENT '学生id',
  `student_num` varchar(20) NOT NULL COMMENT '学生学号',
  `student_name` varchar(20) NOT NULL COMMENT '学生姓名',
  PRIMARY KEY (`id`),
  KEY `innovation_student_id_fk` (`student_id`),
  CONSTRAINT `innovation_student_id_fk` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='创新项目表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `innovation`
--

LOCK TABLES `innovation` WRITE;
/*!40000 ALTER TABLE `innovation` DISABLE KEYS */;
INSERT INTO `innovation` VALUES (1,'学生管理系统','通过Springboot和vue','连莉','2024-09-30','2024-12-22',4,'2023003001','张三'),(2,'网络安全','实现web项目的安全测试','徐延宁','2024-10-15','2024-12-21',4,'2023003001','张三');
/*!40000 ALTER TABLE `innovation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `internship`
--

DROP TABLE IF EXISTS `internship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `internship` (
  `id` int NOT NULL AUTO_INCREMENT,
  `unit` varchar(50) NOT NULL COMMENT '单位',
  `post` varchar(50) NOT NULL COMMENT '岗位',
  `evaluate` varchar(255) DEFAULT NULL COMMENT '实习期间评价情况',
  `start_data` varchar(30) DEFAULT NULL COMMENT '实习开始时间',
  `end_data` varchar(30) DEFAULT NULL COMMENT '实习结束时间',
  `student_id` int DEFAULT NULL COMMENT '实习学生id',
  `certifier` varchar(30) DEFAULT NULL COMMENT '证明人',
  `student_num` varchar(20) NOT NULL COMMENT '学生学号',
  `student_name` varchar(20) NOT NULL COMMENT '学生姓名',
  PRIMARY KEY (`id`),
  KEY `internship_student_id_fk` (`student_id`),
  CONSTRAINT `internship_student_id_fk` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='校外实习表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `internship`
--

LOCK TABLES `internship` WRITE;
/*!40000 ALTER TABLE `internship` DISABLE KEYS */;
INSERT INTO `internship` VALUES (1,'山大地委','软件工程师','非常棒','2024-09-11','2024-12-02',4,'徐延宁','2023003001','张三'),(2,'齐鲁医院','档案管理员','工作认真,细致','2024-01-10','2024-05-15',4,'颜宁','2023003001','张三'),(3,'美团公司','外卖员','实习期间认真完成任务,态度良好','2024-07-10','2024-08-25',14,'王兴','2023003003','苏北'),(4,'百度公司','软件开发师','工作认真细致','2024-12-17','2024-12-21',4,'李彦宏','2023003001','张三');
/*!40000 ALTER TABLE `internship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '人员id',
  `name` varchar(20) NOT NULL COMMENT '人员姓名',
  `username` varchar(20) NOT NULL,
  `type` char(1) NOT NULL COMMENT '人员类型 0_管理员,1_教师,2_学生',
  `dept` varchar(20) DEFAULT '无' COMMENT '学院',
  `card` varchar(20) DEFAULT NULL COMMENT '身份证号',
  `gender` char(1) DEFAULT '1' COMMENT '性别 1_男,2_女',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `email` varchar(20) DEFAULT '无' COMMENT '邮箱',
  `phone` varchar(20) DEFAULT '无' COMMENT '电话',
  `address` varchar(20) DEFAULT '无' COMMENT '地址',
  `password` varchar(20) DEFAULT '123',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='人员表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'admin','admin','1','软件学院',NULL,'1',NULL,'无','无','无','123'),(10,'张三','2023003001','3','软件学院',NULL,'1',NULL,'无','无','无','123'),(12,'刘学帅','T0001','2','软件学院',NULL,'1',NULL,'无','无','无','123'),(15,'陈志勇','T0002','2','软件学院',NULL,'1',NULL,'无','无','无','123'),(16,'丁子星','T0003','2','软件学院',NULL,'2',NULL,'无','无','无','123'),(24,'王佳锦','2023003002','3','无','','1',NULL,'无','无','无','123'),(26,'苏北','2023003003','3','无','','1',NULL,'无','无','无','123'),(30,'张学帅','T0004','2','无','','1',NULL,'无','无','无','123'),(31,'魏宏','2023003009','3','集成电路学院','','1',NULL,'无','无','无','123'),(32,'张飞','20230030058','3','软件学院','','1',NULL,'无','无','无','123'),(34,'猪猪侠','2022005008','3','软件学院','','1',NULL,'无','无','无','123'),(35,'菲菲公主','2023006009','3','软件学院','','1',NULL,'无','无','无','123'),(36,'图图大耳朵','2022001008','3','集成电路学院','1','1',NULL,'无','无','无','123'),(37,'张小丽','20190552845','3','集成电路学院','','1',NULL,'无','无','无','123'),(39,'李梅','2023003019','3','外国语学院','','2',NULL,'无','无','无','123'),(40,'张帆','2023003088','3','软件学院','','1',NULL,'无','无','无','123'),(41,'刘大伟','2023003023','3','软件学院','','1',NULL,'无','无','无','123'),(42,'李约瑟','202301','3','软件学院','140602200509020000','1','2005-09-01','1213037975@qq.com','18234967903','济南高新区舜华路软件学院','123'),(43,'李约瑟','202302','3','软件学院','140602200509020000','1','2005-09-01','1213037975@qq.com','18234967903','济南高新区舜华路软件学院','123'),(44,'阿道夫','202303','3','集成电路学院','140602200509020000','2','2005-09-01','1213037975@qq.com','18234967903','济南高新区舜华路软件学院','123'),(45,'阿道夫','202304','3','集成电路学院','140602200509020000','2','2005-09-01','1213037975@qq.com','18234967903','济南高新区舜华路软件学院','123'),(47,'123','123','3','无',NULL,'1',NULL,'无','无','无','123'),(48,'里的回复','2023003010','3','无',NULL,'1',NULL,'无','无','无','123'),(49,'罗迪克','2023004001','3','集成电路学院','140602200507080964','1','2020-12-08','1213098@qq.com','152637844959','山东大学软件园校区','123'),(50,'拉客户','2023005001','3','集成电路学院','140602200506070567','1','2021-12-06','12384795@qq.com','123784348913','山东大学软件园校区','123'),(51,'苏海','2023003217','3','无',NULL,'1',NULL,'无','无','无','123'),(52,'章章','2023003559','3','软件学院','371324200903049593','1','2024-12-16','suhao1827@163.com','1654789326','山东大学软件学院','123'),(53,'刘海','2023003859','3','无',NULL,'1',NULL,'无','无','无','123');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `socialpratice`
--

DROP TABLE IF EXISTS `socialpratice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `socialpratice` (
  `id` int NOT NULL AUTO_INCREMENT,
  `unit` varchar(50) NOT NULL COMMENT '实践单位',
  `evaluate` varchar(255) DEFAULT NULL COMMENT '实践期间评价情况',
  `start_data` varchar(30) DEFAULT NULL COMMENT '社会实践开始时间',
  `end_data` varchar(30) DEFAULT NULL COMMENT '社会实践结束时间',
  `student_id` int DEFAULT NULL COMMENT '实践学生id',
  `name` varchar(30) DEFAULT NULL COMMENT '实践活动名称',
  `certifier` varchar(30) DEFAULT NULL COMMENT '证明人',
  `content` varchar(255) DEFAULT NULL COMMENT '实践工作内容',
  `student_num` varchar(20) NOT NULL COMMENT '学生学号',
  `student_name` varchar(20) NOT NULL COMMENT '学生姓名',
  PRIMARY KEY (`id`),
  KEY `socialpratice_student_id_fk` (`student_id`),
  CONSTRAINT `socialpratice_student_id_fk` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='社会实践表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `socialpratice`
--

LOCK TABLES `socialpratice` WRITE;
/*!40000 ALTER TABLE `socialpratice` DISABLE KEYS */;
INSERT INTO `socialpratice` VALUES (1,'沂蒙话剧团','非常好','2024-07-08','2024-07-26',4,'追寻红色基因','杜远迎','出演红色的话剧','2023003001','张三');
/*!40000 ALTER TABLE `socialpratice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '学生id',
  `person_id` int DEFAULT NULL,
  `major` varchar(20) DEFAULT '无' COMMENT '专业',
  `class_name` varchar(20) DEFAULT '无' COMMENT '班级',
  PRIMARY KEY (`id`),
  KEY `student_person_person_id_fk` (`person_id`),
  CONSTRAINT `student_person_person_id_fk` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='学生表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (4,10,'软件工程','2'),(12,24,'无','无'),(14,26,'无','无'),(18,31,'2','1'),(19,32,'工业软件','1'),(21,34,'软件工程','2'),(22,35,'工业软件','2'),(23,36,'1','2'),(24,37,'2','1'),(26,39,'阿拉伯语','一班'),(27,40,'软件工程','二班'),(28,41,'数字媒体与技术','二班'),(29,42,'工业软件','菁英班'),(30,43,'工业软件','菁英班'),(31,44,'微电子','一班'),(32,45,'微电子','一班'),(34,47,'无','无'),(35,48,'无','无'),(36,49,'微电子','二班'),(37,50,'集成电路','二班'),(38,51,'无','无'),(39,52,'工业软件','三班'),(40,53,'无','无');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_detail`
--

DROP TABLE IF EXISTS `student_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_detail` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '学生详细信息id',
  `student_id` int DEFAULT NULL COMMENT '学生id',
  `address` varchar(255) DEFAULT NULL COMMENT '学生地址',
  `policy_face` varchar(20) DEFAULT NULL COMMENT '政治面貌',
  `group` varchar(20) DEFAULT NULL COMMENT '民族',
  `high_school` varchar(20) DEFAULT NULL COMMENT '高中',
  `middle_school` varchar(20) DEFAULT NULL COMMENT '初中',
  `father` varchar(20) DEFAULT NULL COMMENT '父亲姓名',
  `father_phone` varchar(20) DEFAULT NULL COMMENT '父亲电话',
  `mother` varchar(20) DEFAULT NULL COMMENT '母亲姓名',
  `mother_phone` varchar(20) DEFAULT NULL COMMENT '母亲电话',
  PRIMARY KEY (`id`),
  KEY `student_detail_student_student_id_fk` (`student_id`),
  CONSTRAINT `student_detail_student_student_id_fk` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='学生详细信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_detail`
--

LOCK TABLES `student_detail` WRITE;
/*!40000 ALTER TABLE `student_detail` DISABLE KEYS */;
INSERT INTO `student_detail` VALUES (2,4,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(10,12,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(12,14,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(16,18,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(17,19,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(19,21,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(20,22,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(21,23,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(22,24,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(24,26,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(25,27,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(26,28,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(27,29,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(28,30,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(29,31,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(30,32,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(31,34,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(32,35,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(33,36,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(34,37,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(35,38,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(36,39,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(37,40,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `student_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studentleave`
--

DROP TABLE IF EXISTS `studentleave`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `studentleave` (
  `id` int NOT NULL AUTO_INCREMENT,
  `studentleave_type` varchar(20) NOT NULL COMMENT '请假类型',
  `studentleave_reason` varchar(50) NOT NULL COMMENT '请假原因',
  `approve_status` varchar(10) DEFAULT NULL COMMENT '批准情况',
  `start_data` varchar(30) DEFAULT NULL COMMENT '请假开始时间',
  `end_data` varchar(30) DEFAULT NULL COMMENT '请假结束时间',
  `student_id` int DEFAULT NULL COMMENT '学生id',
  `teacher_id` int DEFAULT NULL COMMENT '批准老师id',
  `student_name` varchar(20) NOT NULL COMMENT '学生姓名',
  `teacher_name` varchar(20) NOT NULL COMMENT '老师姓名',
  `student_num` varchar(20) NOT NULL COMMENT '学生学号',
  `teacher_num` varchar(20) NOT NULL COMMENT '老师工号',
  PRIMARY KEY (`id`),
  KEY `studentleave_student_id_fk` (`student_id`),
  KEY `studentleave_teacher_id_fk` (`teacher_id`),
  CONSTRAINT `studentleave_student_id_fk` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `studentleave_teacher_id_fk` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='请假表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studentleave`
--

LOCK TABLES `studentleave` WRITE;
/*!40000 ALTER TABLE `studentleave` DISABLE KEYS */;
INSERT INTO `studentleave` VALUES (1,'病假','拔智齿','批准失败','2024-12-12T01:00:00.000Z','2024-12-12T07:00:00.000Z',4,NULL,'张三','刘学帅','2023003001','T0001'),(2,'事假','哥哥结婚','批准失败','2024-12-24T00:00:00.000Z','2024-12-26T03:00:00.000Z',4,NULL,'张三','刘学帅','2023003001','T0001'),(3,'病假','腿疼','未批准','2024-12-25T00:00:00.000Z','2024-12-26T00:00:00.000Z',4,NULL,'张三','刘学帅','2023003001','T0001');
/*!40000 ALTER TABLE `studentleave` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '教师id',
  `person_id` int DEFAULT NULL,
  `degree` varchar(20) DEFAULT '无' COMMENT '职称',
  `title` varchar(20) DEFAULT '无' COMMENT '学位',
  PRIMARY KEY (`id`),
  KEY `teacher_person_person_id_fk` (`person_id`),
  CONSTRAINT `teacher_person_person_id_fk` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='教师表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1,12,'博士','辅导员'),(3,15,'博士','研究生导师'),(4,16,'研究生','辅导员'),(5,30,'博士后','无');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_detail`
--

DROP TABLE IF EXISTS `teacher_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher_detail` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '教师详细信息id',
  `teacher_id` int DEFAULT NULL COMMENT '教师id',
  `group` varchar(20) DEFAULT NULL COMMENT '民族',
  `address` varchar(50) DEFAULT NULL COMMENT '籍贯',
  `policy_face` varchar(20) DEFAULT NULL COMMENT '政治面貌',
  `scientific` varchar(100) DEFAULT NULL COMMENT '科研成果',
  PRIMARY KEY (`id`),
  KEY `teacher_detail_teacher_teacher_id_fk` (`teacher_id`),
  CONSTRAINT `teacher_detail_teacher_teacher_id_fk` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='教师详细信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_detail`
--

LOCK TABLES `teacher_detail` WRITE;
/*!40000 ALTER TABLE `teacher_detail` DISABLE KEYS */;
INSERT INTO `teacher_detail` VALUES (1,1,'汉族',NULL,'党员',NULL),(2,3,'汉族',NULL,'党员',NULL),(3,4,'汉族',NULL,'党员',NULL),(4,5,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `teacher_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `volunteer`
--

DROP TABLE IF EXISTS `volunteer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `volunteer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `unit` varchar(50) NOT NULL COMMENT '志愿服务组织',
  `evaluate` varchar(255) DEFAULT NULL COMMENT '志愿服务评价情况',
  `hour` varchar(20) NOT NULL COMMENT '志愿服务时长',
  `date` varchar(40) NOT NULL COMMENT '志愿服务日期',
  `student_id` int DEFAULT NULL COMMENT '志愿服务学生id',
  `name` varchar(30) DEFAULT NULL COMMENT '志愿服务名称',
  `certifier` varchar(30) DEFAULT NULL COMMENT '证明人',
  `content` varchar(255) DEFAULT NULL COMMENT '志愿服务内容',
  `student_num` varchar(50) NOT NULL COMMENT '学生学号',
  `student_name` varchar(20) NOT NULL COMMENT '学生姓名',
  PRIMARY KEY (`id`),
  KEY `volunteer_student_id_fk` (`student_id`),
  CONSTRAINT `volunteer_student_id_fk` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='志愿服务表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `volunteer`
--

LOCK TABLES `volunteer` WRITE;
/*!40000 ALTER TABLE `volunteer` DISABLE KEYS */;
INSERT INTO `volunteer` VALUES (1,'泰山足球队','非常好','10','2024-11-26',4,'泰山足球队','罗加号','帮助检票','2023003001','张三'),(2,'软件学院','认真负责','5','2024-12-20',4,'锦绣护林','丁子星','为校园的树木进行浇水','2023003001','张三');
/*!40000 ALTER TABLE `volunteer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-23 23:50:53
