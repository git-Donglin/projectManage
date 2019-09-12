/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50638
Source Host           : 127.0.0.1:3306
Source Database       : dz_item

Target Server Type    : MYSQL
Target Server Version : 50638
File Encoding         : 65001

Date: 2019-09-12 10:48:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for function
-- ----------------------------
DROP TABLE IF EXISTS `function`;
CREATE TABLE `function` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '功能Id',
  `moid` varchar(80) NOT NULL COMMENT 'moid',
  `item_demand_moid` varchar(80) NOT NULL COMMENT '项目moid',
  `state` int(10) DEFAULT NULL COMMENT '功能状态',
  `name` varchar(128) DEFAULT NULL COMMENT '功能名称',
  `affect` varchar(128) DEFAULT NULL COMMENT '功能波及',
  `principal` varchar(128) DEFAULT NULL COMMENT '功能负责人',
  `content` varchar(200) DEFAULT NULL COMMENT '功能完成内容',
  `descc` varchar(200) DEFAULT NULL COMMENT '功能描述',
  `create_time` datetime DEFAULT NULL COMMENT '功能创建时间',
  `period` varchar(128) DEFAULT NULL COMMENT '功能周期',
  `start_data` datetime DEFAULT NULL COMMENT '开始时间',
  `ent_data` datetime DEFAULT NULL COMMENT '结束时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of function
-- ----------------------------
INSERT INTO `function` VALUES ('0000000001', 'c7012603-6be8-4574-8839-b57dc50f724a', '46b747e4-7778-48a7-a605-b9fafcd8902c', '0', '测试', 'service', '孙东林1', '', '0.0', '2019-06-11 16:45:05', '1323', null, null);
INSERT INTO `function` VALUES ('0000000003', '14a63eac-0361-402f-86b0-9236217cb041', '', '3', '排序', 'amc', '孙东林', '', '功能排序', '2019-06-12 17:08:23', '15', null, null);
INSERT INTO `function` VALUES ('0000000004', 'a593d95c-88fd-43b7-b343-19f5fd0ae18b', '', '0', '1', '2', '2', '', '2', '2019-06-12 17:11:37', '2', null, null);
INSERT INTO `function` VALUES ('0000000005', 'bd27d670-a67b-4306-acfd-2f4a02a2c988', '', '1', '1', '1', '1', '', '1', '2019-06-12 17:46:07', '1', null, null);
INSERT INTO `function` VALUES ('0000000006', 'f083787e-44d4-4849-9a96-0e317e59d31c', '3cb6f5ac-7453-4833-8fb8-199b93c36d38', '3', '排序', 'amc', '孙东林', '', '0.0', '2019-06-12 18:00:22', '15', null, null);
INSERT INTO `function` VALUES ('0000000007', '2af2d475-dc3f-4790-8530-9473da0ae60d', '46b747e4-7778-48a7-a605-b9fafcd8902c', '1', '111', '11', '111', '', '111', '2019-09-11 16:49:57', '111', null, null);

-- ----------------------------
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '项目Id',
  `moid` varchar(80) NOT NULL COMMENT '项目Moid',
  `item_name` varchar(128) DEFAULT NULL COMMENT '项目名称',
  `state` int(10) DEFAULT NULL COMMENT '项目状态',
  `address` varchar(128) DEFAULT NULL COMMENT '项目地址',
  `period` int(10) DEFAULT NULL COMMENT '项目周期',
  `principal` varchar(80) DEFAULT NULL COMMENT '项目负责人',
  `content` longtext COMMENT '项目内容',
  `descc` varchar(128) DEFAULT NULL COMMENT '项目描述',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `version` varchar(128) DEFAULT NULL COMMENT '项目版本',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO `item` VALUES ('0000000007', '46b747e4-7778-48a7-a605-b9fafcd8902c', '广西党委', '0', '0000', '0', '孙东林', '', '广西党委\n是的发送到个\nfsdafa\nasfasdasdf\nasdfasdffasfdasd\nafsdfasdfsdafasdfasdfsdfasdfasdf哒哒哒哒哒哒多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多', '2019-06-10 21:59:10', '5.2Sp2');
INSERT INTO `item` VALUES ('0000000008', '3cb6f5ac-7453-4833-8fb8-199b93c36d38', '贵州公安', null, '00000000', null, '孙东林', '', '0.0', '2019-06-12 16:31:22', '5.0Sp3');

-- ----------------------------
-- Table structure for item_demand
-- ----------------------------
DROP TABLE IF EXISTS `item_demand`;
CREATE TABLE `item_demand` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `moid` varchar(80) NOT NULL,
  `item_moid` varchar(80) NOT NULL COMMENT '项目Moid',
  `start_date` datetime DEFAULT NULL COMMENT '开始时间',
  `ent_date` datetime NOT NULL COMMENT '结束时间',
  `principal` varchar(60) NOT NULL COMMENT '需求负责人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `state` int(2) DEFAULT NULL,
  `title` varchar(128) DEFAULT NULL,
  `describe` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of item_demand
-- ----------------------------
INSERT INTO `item_demand` VALUES ('0000000001', '46b747e4-7778-48a7-a605-b9fafcd8902c', '46b747e4-7778-48a7-a605-b9fafcd8902c', '2019-09-09 08:00:00', '2019-09-09 08:00:00', '0', '2019-09-09 00:00:00', '0', '3333', '5555');
INSERT INTO `item_demand` VALUES ('0000000002', 'string', '46b747e4-7778-48a7-a605-b9fafcd8902c', '2019-09-09 13:40:44', '2019-09-09 13:40:44', 'string', '2019-09-09 13:40:44', '0', 'string', 'string');
INSERT INTO `item_demand` VALUES ('0000000003', '', '', '2019-09-23 00:00:00', '2019-09-24 00:00:00', '4145656', null, '0', '123', '1232');
INSERT INTO `item_demand` VALUES ('0000000004', '', '', '2019-09-18 00:00:00', '2019-09-25 00:00:00', '1', null, '0', '123', '1231');
INSERT INTO `item_demand` VALUES ('0000000005', '', '46b747e4-7778-48a7-a605-b9fafcd8902c', '2019-09-18 00:00:00', '2019-09-25 00:00:00', '0', null, '0', '123', '1231');
INSERT INTO `item_demand` VALUES ('0000000006', '', '46b747e4-7778-48a7-a605-b9fafcd8902c', '2019-08-27 00:00:00', '2019-08-27 00:00:00', '1', null, '0', '23423', '123412');
