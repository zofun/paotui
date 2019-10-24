/*
Navicat MySQL Data Transfer

Source Server         : phpstudy
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : paotui

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2019-10-23 21:51:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for auth_info
-- ----------------------------
DROP TABLE IF EXISTS `auth_info`;
CREATE TABLE `auth_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `start` int(11) NOT NULL,
  `real_name` varchar(20) NOT NULL,
  `student_id` varchar(20) NOT NULL,
  `time` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for chat
-- ----------------------------
DROP TABLE IF EXISTS `chat`;
CREATE TABLE `chat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sender` varchar(20) NOT NULL,
  `addressee` varchar(20) NOT NULL,
  `time` datetime NOT NULL,
  `info` varchar(255) NOT NULL,
  `status` varchar(4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `char_sender_to_uset_username` (`sender`),
  KEY `chat_addre_to_user_username` (`addressee`),
  CONSTRAINT `char_sender_to_uset_username` FOREIGN KEY (`sender`) REFERENCES `user` (`username`),
  CONSTRAINT `chat_addre_to_user_username` FOREIGN KEY (`addressee`) REFERENCES `user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` varchar(20) NOT NULL,
  `order_id` int(11) NOT NULL,
  `info` varchar(255) NOT NULL,
  `time` datetime NOT NULL,
  `start` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `com_orderid_to_order_id` (`order_id`),
  CONSTRAINT `com_orderid_to_order_id` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titile` varchar(50) NOT NULL,
  `user` varchar(20) NOT NULL,
  `delivery` varchar(20) DEFAULT NULL,
  `begin` varchar(60) NOT NULL,
  `end` varchar(60) NOT NULL,
  `start_Lnglat` varchar(70) DEFAULT NULL,
  `end_lnglat` varchar(70) DEFAULT NULL,
  `reward` varchar(10) NOT NULL,
  `endtime` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `order_user_user` (`user`),
  KEY `order_delivery_to_user_username` (`delivery`),
  CONSTRAINT `order_delivery_to_user_username` FOREIGN KEY (`delivery`) REFERENCES `user` (`username`),
  CONSTRAINT `order_user_to_user_username` FOREIGN KEY (`user`) REFERENCES `user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for status
-- ----------------------------
DROP TABLE IF EXISTS `status`;
CREATE TABLE `status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL,
  `info` varchar(30) NOT NULL,
  `time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `status_orderid_to_order_id` (`order_id`),
  CONSTRAINT `status_orderid_to_order_id` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(20) NOT NULL,
  `password` varchar(50) NOT NULL,
  `name` varchar(10) NOT NULL,
  `auth` int(11) DEFAULT NULL,
  PRIMARY KEY (`username`),
  KEY `user_auth_to_auth_id` (`auth`),
  CONSTRAINT `user_auth_to_auth_id` FOREIGN KEY (`auth`) REFERENCES `auth_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
