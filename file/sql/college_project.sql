/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 50528
 Source Host           : localhost:3306
 Source Schema         : college_project

 Target Server Type    : MySQL
 Target Server Version : 50528
 File Encoding         : 65001

 Date: 28/08/2020 21:49:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `messageId` int(10) NOT NULL AUTO_INCREMENT,
  `messageTitle` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文章标题',
  `messageType` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文章类型',
  `author` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '信息学院' COMMENT '作者',
  `messageContent` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '文章内容',
  `messageAddress` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '地址链接',
  `createDate` timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `formatDate` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '格式化时间',
  `status` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '未审核' COMMENT '审核状态',
  PRIMARY KEY (`messageId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (14, '测试使用', '测试使用', '信息学院', '测试使用', '测试使用', '2020-08-28 19:27:45', '2020-08-28', '未审核');

-- ----------------------------
-- Table structure for party_affairs_organization
-- ----------------------------
DROP TABLE IF EXISTS `party_affairs_organization`;
CREATE TABLE `party_affairs_organization`  (
  `party_ID` int(10) NOT NULL AUTO_INCREMENT,
  `party_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '党支部名称',
  `party_honor` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '党支部荣誉',
  PRIMARY KEY (`party_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of party_affairs_organization
-- ----------------------------
INSERT INTO `party_affairs_organization` VALUES (1, '信息学院教工第一党支部', '');
INSERT INTO `party_affairs_organization` VALUES (2, '信息学院教工第二党支部', NULL);

-- ----------------------------
-- Table structure for party_affairs_organization_member
-- ----------------------------
DROP TABLE IF EXISTS `party_affairs_organization_member`;
CREATE TABLE `party_affairs_organization_member`  (
  `party_member_ID` int(5) NOT NULL AUTO_INCREMENT,
  `party_member_name` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '党支部成员姓名',
  `party_member_title` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '党支部成员职务',
  `belong_to_party` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '所属党支部',
  PRIMARY KEY (`party_member_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of party_affairs_organization_member
-- ----------------------------
INSERT INTO `party_affairs_organization_member` VALUES (1, '胥林', '支部书记', '信息学院教工第一党支部');

-- ----------------------------
-- Table structure for school_leader
-- ----------------------------
DROP TABLE IF EXISTS `school_leader`;
CREATE TABLE `school_leader`  (
  `leader_ID` int(15) NOT NULL AUTO_INCREMENT,
  `leader_name` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '领导姓名',
  `leader_title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '领导职务',
  `leader_work` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '负责工作',
  `leader_contact_unit` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '联系单位',
  `leader_office_location` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '办公地点',
  `leader_phone` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '联系电话',
  `leader_email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '联系邮箱',
  PRIMARY KEY (`leader_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of school_leader
-- ----------------------------
INSERT INTO `school_leader` VALUES (1, '胥林', '院长', '全面主持和负责学院行政工作,负责发展规划、师资队伍、财务、科学研究、设备管理。分管学院党政办公室。', '信息管理与信息系统，光电信息科学与工程专业教研室', '学院楼305', '0817-2641221', 'xulin@swpu.edu.cn');

-- ----------------------------
-- Table structure for school_teacher
-- ----------------------------
DROP TABLE IF EXISTS `school_teacher`;
CREATE TABLE `school_teacher`  (
  `teacherId` int(5) NOT NULL AUTO_INCREMENT,
  `teacherName` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '教师名称',
  `teacherTitle` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '教师职务',
  `teacherHonor` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '教师荣誉',
  `teacherTeam` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '所属教研室',
  `teacherTeamTitle` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '教研室职务',
  PRIMARY KEY (`teacherId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of school_teacher
-- ----------------------------
INSERT INTO `school_teacher` VALUES (1, ' 谢季峰', '专任教师', '暂时未知', '电子与计算机工程教研室', '教研室主任');

-- ----------------------------
-- Table structure for student_affairs_office
-- ----------------------------
DROP TABLE IF EXISTS `student_affairs_office`;
CREATE TABLE `student_affairs_office`  (
  `ID` int(5) NOT NULL AUTO_INCREMENT,
  `name` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学工部_成员姓名',
  `title` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学工部_成员职务',
  `phone` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学工部_办公电话',
  `location` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学工部_办公地点',
  `email` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学工部_成员邮箱',
  `motto` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学工部_带班格言',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of student_affairs_office
-- ----------------------------
INSERT INTO `student_affairs_office` VALUES (1, '胡丹', '团委副书记（学生工作办公室副主任）', '0817-2641231', '完井楼302', '460360381@qq.com', '严管厚爱筑平台，传道解惑助成长');

-- ----------------------------
-- Table structure for web_address
-- ----------------------------
DROP TABLE IF EXISTS `web_address`;
CREATE TABLE `web_address`  (
  `address_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '链接地址名',
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '链接地址',
  `ID` int(5) NOT NULL AUTO_INCREMENT,
  `AddressType` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '链接类型',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `status` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '未审核' COMMENT '审核状态',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of web_address
-- ----------------------------
INSERT INTO `web_address` VALUES ('成都市郫都区统计局关于招聘编外用工人员的启事', 'http://aahz.pidu.gov.cn/pidu/c125561/2020-08/19/content_6dadf61ae7894d2786fd8053c3c43408.shtml', 1, '', '2020-08-24 00:00:00', '未审核');

SET FOREIGN_KEY_CHECKS = 1;
