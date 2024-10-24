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
  `credits` double DEFAULT NULL COMMENT '学分',
  `course_type` varchar(255) DEFAULT NULL COMMENT '课程类型',
  `time` json DEFAULT NULL COMMENT '上课时间',
  `place` varchar(20) DEFAULT NULL COMMENT '上课地点',
  `term` int DEFAULT NULL COMMENT '学期',
  `teacher_id` int DEFAULT NULL COMMENT '授课教师',
  PRIMARY KEY (`id`),
  KEY `course_teacher_id_fk` (`teacher_id`),
  CONSTRAINT `course_teacher_id_fk` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='课程表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
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
  PRIMARY KEY (`id`),
  KEY `course_choose_course_id_fk` (`course_id`),
  KEY `course_choose_student_id_fk` (`student_id`),
  CONSTRAINT `course_choose_course_id_fk` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `course_choose_student_id_fk` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='选课表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_choose`
--

LOCK TABLES `course_choose` WRITE;
/*!40000 ALTER TABLE `course_choose` DISABLE KEYS */;
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
  `award` varchar(50) DEFAULT NULL COMMENT '荣誉',
  `competition` varchar(50) DEFAULT NULL COMMENT '竞赛',
  `train` varchar(50) DEFAULT NULL COMMENT '实习经历',
  `scientific` varchar(50) DEFAULT NULL COMMENT '科研成果',
  PRIMARY KEY (`id`),
  KEY `honour_student_id_fk` (`student_id`),
  CONSTRAINT `honour_student_id_fk` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='个人荣誉';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `honour`
--

LOCK TABLES `honour` WRITE;
/*!40000 ALTER TABLE `honour` DISABLE KEYS */;
INSERT INTO `honour` VALUES (1,1,NULL,NULL,NULL,NULL),(2,4,NULL,NULL,NULL,NULL),(3,5,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `honour` ENABLE KEYS */;
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
  `type` char(1) NOT NULL COMMENT '人员类型 0_管理员,1_教师,2_学生',
  `dept` varchar(20) DEFAULT NULL COMMENT '学院',
  `card` varchar(20) DEFAULT NULL COMMENT '身份证号',
  `gender` char(1) DEFAULT '1' COMMENT '性别 1_男,2_女',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `email` varchar(20) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `address` varchar(20) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='人员表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'张三','1','1',NULL,'1',NULL,NULL,NULL,NULL),(10,'张三2','1','1',NULL,'1',NULL,NULL,NULL,NULL),(11,'张三2','1','1',NULL,'1',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
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
  `major` varchar(20) NOT NULL COMMENT '专业',
  `class_name` varchar(20) NOT NULL COMMENT '班级',
  PRIMARY KEY (`id`),
  KEY `student_person_person_id_fk` (`person_id`),
  CONSTRAINT `student_person_person_id_fk` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='学生表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,1,'1','1'),(4,10,'2','2'),(5,11,'2','2');
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='学生详细信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_detail`
--

LOCK TABLES `student_detail` WRITE;
/*!40000 ALTER TABLE `student_detail` DISABLE KEYS */;
INSERT INTO `student_detail` VALUES (1,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,4,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `student_detail` ENABLE KEYS */;
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
  `degree` varchar(20) NOT NULL COMMENT '职称',
  `title` varchar(20) NOT NULL COMMENT '学位',
  PRIMARY KEY (`id`),
  KEY `teacher_person_person_id_fk` (`person_id`),
  CONSTRAINT `teacher_person_person_id_fk` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='教师表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
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
  `education` varchar(100) DEFAULT NULL COMMENT '学历',
  `scientific` varchar(100) DEFAULT NULL COMMENT '科研成果',
  PRIMARY KEY (`id`),
  KEY `teacher_detail_teacher_teacher_id_fk` (`teacher_id`),
  CONSTRAINT `teacher_detail_teacher_teacher_id_fk` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='教师详细信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_detail`
--

LOCK TABLES `teacher_detail` WRITE;
/*!40000 ALTER TABLE `teacher_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `teacher_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `person_id` int DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  KEY `user_person_id_fk` (`person_id`),
  CONSTRAINT `user_person_id_fk` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'3332','23',NULL,NULL,1),(2,'123','123',NULL,NULL,10),(3,'324','42',NULL,NULL,11);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-24 16:02:30
