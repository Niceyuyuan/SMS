/*
 Navicat Premium Data Transfer

 Source Server         : 阿里云
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : 47.106.180.11:3306
 Source Schema         : sms

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 30/03/2022 16:36:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `admin_id` bigint(0) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '管理员姓名',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '管理员用户名',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '管理员登录密码',
  `departname` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `createdBy` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '创建者',
  `createdDate` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `modifyBy` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '修改者',
  `modifyDate` timestamp(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`admin_id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE,
  INDEX `departname`(`departname`) USING BTREE,
  CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`departname`) REFERENCES `department` (`department_name`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'wyy', 'admin', '123456', 'IT部', 'wyy', '2022-03-30 15:30:35', NULL, NULL);
INSERT INTO `admin` VALUES (2, '瑶瑶', 'yoyo', '123456', '运营部', 'wyy', '2022-03-30 15:30:35', NULL, NULL);

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `department_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '部门号',
  `department_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '部门名称',
  `PrincipalUser` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '部门主管',
  `createdBy` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '创建者',
  `createdDate` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `modifyBy` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '修改者',
  `modifyDate` timestamp(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`department_id`) USING BTREE,
  UNIQUE INDEX `department_name`(`department_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (10, 'IT部', '曾欣蓓', 'wyy', '2022-03-30 15:30:35', NULL, NULL);
INSERT INTO `department` VALUES (11, '运营部', '瑶瑶', 'wyy', '2022-03-30 15:30:35', NULL, NULL);
INSERT INTO `department` VALUES (12, '人事部', '喵喵', 'wyy', '2022-03-30 15:30:35', NULL, NULL);
INSERT INTO `department` VALUES (13, '测试部', '大熊', 'wyy', '2022-03-30 16:25:41', NULL, NULL);

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `employee_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '员工id',
  `employee_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '员工姓名',
  `employee_job` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '员工所属岗位',
  `ed_id` bigint(0) NOT NULL COMMENT '员工所属部门号',
  `gender` int(0) NULL DEFAULT NULL COMMENT '性别（1:女、 2:男）',
  `birthday` date NULL DEFAULT NULL COMMENT '出生日期',
  `phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '手机号',
  `address` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '居住地址',
  `createdBy` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '创建者',
  `createdDate` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `modifyBy` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '修改者',
  `modifyDate` timestamp(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`employee_id`) USING BTREE,
  INDEX `ed_id`(`ed_id`) USING BTREE,
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`ed_id`) REFERENCES `department` (`department_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 10007 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (10001, '曾欣蓓', '后端开发', 10, 1, '1999-01-06', '13537920098', NULL, 'wyy', '2022-03-30 15:30:36', NULL, NULL);
INSERT INTO `employee` VALUES (10002, '陈佳蓓', '前端开发', 10, 2, '1999-01-06', '13537920098', NULL, 'wyy', '2022-03-30 15:30:36', NULL, NULL);
INSERT INTO `employee` VALUES (10003, '小龙虾', '运维', 10, 1, '1999-01-06', '13537920098', NULL, 'wyy', '2022-03-30 15:30:36', NULL, NULL);
INSERT INTO `employee` VALUES (10004, '瑶瑶', '运营经理', 11, 2, '1999-01-06', '13537920098', NULL, 'wyy', '2022-03-30 15:30:36', NULL, NULL);
INSERT INTO `employee` VALUES (10005, '喵喵', 'HR', 12, 1, '1999-01-06', '13537920098', NULL, 'wyy', '2022-03-30 15:30:36', NULL, NULL);
INSERT INTO `employee` VALUES (10006, '琪琪', '后端开发', 10, 1, '1999-01-06', '13537920098', NULL, 'wyy', '2022-03-30 15:30:36', NULL, NULL);
INSERT INTO `employee` VALUES (10007, '大熊', '自动化测试', 13, 1, '2020-02-21', '13537928767', '王者峡谷', 'wyy', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `operator` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '操作者',
  `description` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '操作',
  `time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES (3, 'wyy', '添加了ID为：13的部门', NULL);
INSERT INTO `log` VALUES (4, 'wyy', '添加了ID为：null的员工', NULL);

SET FOREIGN_KEY_CHECKS = 1;
