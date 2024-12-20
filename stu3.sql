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
  `activity_type` varchar(20) NOT NULL COMMENT '活动类型',
  `name` varchar(50) NOT NULL COMMENT '活动名称',
  `organizational_unit` varchar(100) DEFAULT NULL COMMENT '主办单位',
  `approve_status` varchar(10) DEFAULT NULL COMMENT '批准情况',
  `start_data` varchar(30) DEFAULT NULL COMMENT '活动开始时间',
  `end_data` varchar(30) DEFAULT NULL COMMENT '活动结束时间',
  `student_id` int DEFAULT NULL COMMENT '申请活动学生id',
  `teacher_id` int DEFAULT NULL COMMENT '批准活动老师id',
  PRIMARY KEY (`id`),
  KEY `activity_student_id_fk` (`student_id`),
  KEY `activity_teacher_id_fk` (`teacher_id`),
  CONSTRAINT `activity_student_id_fk` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `activity_teacher_id_fk` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='活动表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity`
--

LOCK TABLES `activity` WRITE;
/*!40000 ALTER TABLE `activity` DISABLE KEYS */;
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
  `time` int DEFAULT NULL COMMENT '上课时间',
  `place` varchar(20) DEFAULT NULL COMMENT '上课地点',
  `term` int DEFAULT NULL COMMENT '学期',
  `isopen` int DEFAULT '1',
  `teacher_id` int DEFAULT NULL COMMENT '授课教师',
  `pre1` varchar(20) DEFAULT '50' COMMENT '平时成绩',
  `pre2` varchar(20) DEFAULT '50' COMMENT '作业成绩',
  PRIMARY KEY (`id`),
  KEY `course_teacher_id_fk` (`teacher_id`),
  CONSTRAINT `course_teacher_id_fk` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='课程表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'概率论','C0001','数学学院',32,'2','必修',12,'5-203',3,1,1,'50','50'),(2,'离散数学','C0002','数学学院',16,'2','必修',33,'3-202',4,1,3,'50','50'),(3,'微积分','C0003','数学学院',16,'2','必修',44,'3-201',4,1,3,'50','50'),(5,'web','123','',NULL,'','',NULL,'',NULL,1,NULL,'','');
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
  `score1` int DEFAULT NULL COMMENT '平时成绩',
  `score2` int DEFAULT NULL COMMENT '作业成绩 ',
  `score3` int DEFAULT NULL COMMENT '考试成绩',
  PRIMARY KEY (`id`),
  KEY `course_choose_course_id_fk` (`course_id`),
  KEY `course_choose_student_id_fk` (`student_id`),
  CONSTRAINT `course_choose_course_id_fk` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `course_choose_student_id_fk` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='选课表';
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
  CONSTRAINT `honour_student_id_fk` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='个人荣誉';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `honour`
--

LOCK TABLES `honour` WRITE;
/*!40000 ALTER TABLE `honour` DISABLE KEYS */;
INSERT INTO `honour` VALUES (2,4,NULL,NULL,NULL,NULL),(8,NULL,NULL,NULL,NULL,NULL),(9,NULL,NULL,NULL,NULL,NULL),(10,NULL,NULL,NULL,NULL,NULL),(11,NULL,NULL,NULL,NULL,NULL),(12,NULL,NULL,NULL,NULL,NULL),(13,NULL,NULL,NULL,NULL,NULL),(14,NULL,NULL,NULL,NULL,NULL),(15,NULL,NULL,NULL,NULL,NULL);
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
  `data1` date DEFAULT NULL COMMENT '开始日期',
  `data2` date DEFAULT NULL COMMENT '结束日期',
  `student_id` int DEFAULT NULL COMMENT '学生id',
  PRIMARY KEY (`id`),
  KEY `innovation_student_id_fk` (`student_id`),
  CONSTRAINT `innovation_student_id_fk` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='创新项目表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `innovation`
--

LOCK TABLES `innovation` WRITE;
/*!40000 ALTER TABLE `innovation` DISABLE KEYS */;
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
  PRIMARY KEY (`id`),
  KEY `internship_student_id_fk` (`student_id`),
  CONSTRAINT `internship_student_id_fk` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='校外实习表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `internship`
--

LOCK TABLES `internship` WRITE;
/*!40000 ALTER TABLE `internship` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='人员表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'admin','admin','1','软件学院',NULL,'1',NULL,'无','无','无','123'),(10,'张三','2023003001','3','软件学院',NULL,'1',NULL,'无','无','无','123'),(12,'刘学帅','T0001','2','软件学院',NULL,'1',NULL,'无','无','无','123'),(15,'陈志勇','T0002','2','软件学院',NULL,'1',NULL,'无','无','无','123'),(16,'丁子星','T0003','2','软件学院',NULL,'2',NULL,'无','无','无','123'),(24,'王佳锦','2023003002','3','无','','1',NULL,'无','无','无','123'),(26,'苏北','2023003003','3','无','','1',NULL,'无','无','无','123'),(30,'张学帅','T0004','2','无','','1',NULL,'无','无','无','123');
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
  PRIMARY KEY (`id`),
  KEY `socialpratice_student_id_fk` (`student_id`),
  CONSTRAINT `socialpratice_student_id_fk` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='社会实践表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `socialpratice`
--

LOCK TABLES `socialpratice` WRITE;
/*!40000 ALTER TABLE `socialpratice` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='学生表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (4,10,'软件工程','2'),(12,24,'无','无'),(14,26,'无','无');
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
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='学生详细信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_detail`
--

LOCK TABLES `student_detail` WRITE;
/*!40000 ALTER TABLE `student_detail` DISABLE KEYS */;
INSERT INTO `student_detail` VALUES (2,4,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(10,12,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(12,14,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
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
  PRIMARY KEY (`id`),
  KEY `studentleave_student_id_fk` (`student_id`),
  KEY `studentleave_teacher_id_fk` (`teacher_id`),
  CONSTRAINT `studentleave_student_id_fk` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `studentleave_teacher_id_fk` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='请假表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studentleave`
--

LOCK TABLES `studentleave` WRITE;
/*!40000 ALTER TABLE `studentleave` DISABLE KEYS */;
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
INSERT INTO `teacher` VALUES (1,12,'博士','辅导员'),(3,15,'博士','研究生导师'),(4,16,'研究生','辅导员'),(5,30,'无','无');
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
  `start_data` varchar(30) DEFAULT NULL COMMENT '志愿服务开始时间',
  `end_data` varchar(30) DEFAULT NULL COMMENT '志愿服务结束时间',
  `student_id` int DEFAULT NULL COMMENT '志愿服务学生id',
  `name` varchar(30) DEFAULT NULL COMMENT '志愿服务名称',
  `certifier` varchar(30) DEFAULT NULL COMMENT '证明人',
  `content` varchar(255) DEFAULT NULL COMMENT '志愿服务内容',
  PRIMARY KEY (`id`),
  KEY `volunteer_student_id_fk` (`student_id`),
  CONSTRAINT `volunteer_student_id_fk` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='志愿服务表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `volunteer`
--

LOCK TABLES `volunteer` WRITE;
/*!40000 ALTER TABLE `volunteer` DISABLE KEYS */;
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

-- Dump completed on 2024-12-20 12:53:30
