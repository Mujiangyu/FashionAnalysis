/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : fashion_analysis

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2021-11-13 15:45:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tbl_userinfo
-- ----------------------------
DROP DATABASE IF EXISTS fashion_analysis;
CREATE DATABASE fashion_analysis;
USE fashion_analysis;
DROP TABLE IF EXISTS `tbl_userinfo`;
CREATE TABLE `tbl_userinfo` (
  `uid` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(64) NOT NULL,
  `user_password` varchar(64) NOT NULL,
  `birthday` varchar(64) NOT NULL,
  `email` varchar(64) NOT NULL,
  `valid_question` varchar(128) NOT NULL,
  `valid_answer` varchar(128) NOT NULL,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of tbl_userinfo
-- ----------------------------
INSERT INTO `tbl_userinfo` VALUES ('1000', 'root', 'root', '2000-01-01', 'root@root.com', '0', 'root mom');
