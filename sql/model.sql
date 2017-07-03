/*
Navicat MySQL Data Transfer

Source Server         : model
Source Server Version : 50718
Source Host           : 123.206.85.204:5306
Source Database       : model

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-07-03 15:04:51
*/

DROP DATABASE If Exists `model`;
CREATE DATABASE If Not Exists  `model` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
use model; 

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(200) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `hobby` varchar(200) DEFAULT NULL,
  `nation` varchar(200) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `age` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '小明', '河南', 'basketball', 'CHINA', '2017-07-03 14:30:28', '12');
INSERT INTO `user` VALUES ('2', '小李', '河南.郑州', 'basketball', 'CHINA', '2017-07-03 14:32:16', '16');
