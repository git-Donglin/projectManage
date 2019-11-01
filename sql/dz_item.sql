/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50638
Source Host           : 127.0.0.1:3306
Source Database       : dz_item

Target Server Type    : MYSQL
Target Server Version : 50638
File Encoding         : 65001

Date: 2019-11-01 16:38:09
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of function
-- ----------------------------
INSERT INTO `function` VALUES ('0000000001', '542ae0b9-ea34-42e4-9ddc-45a35492bd31', 'd9c479d6-cf53-4e93-aaef-80057e2125f9', '3', '数据同步', 'amc、amcapi', '孙东林', '', '数据同步', '2019-10-22 16:00:09', '30', null, null);
INSERT INTO `function` VALUES ('0000000002', '8eb369bf-b4a9-4823-9fcb-52e7e4384889', '46b747e4-7778-48a7-a605-b9fafcd8902c', '0', '1232', '1312', '123', '', '12312', '2019-10-22 16:06:26', '3213', null, null);
INSERT INTO `function` VALUES ('0000000003', '47d7ce07-c586-4a16-9313-25874bf85311', '1c4a6007-57ef-456b-99c3-c042bb6d7e73', '0', '34534', '435', '345', '', '3453', '2019-10-22 16:07:43', '345', null, null);
INSERT INTO `function` VALUES ('0000000004', 'b4955cb3-ad9f-48fe-9dd9-1779139caf4d', '44f03240-ba82-4209-bd46-cef0d50fc644', '3', 'yyy', '1', '1', '', '1', '2019-10-22 16:10:31', '1', null, null);
INSERT INTO `function` VALUES ('0000000005', '26cfe19c-bb51-4c87-91bc-d66abb30eb7e', '', '1', 'gg', '77', '7', '', '7', '2019-10-22 16:10:43', '7', null, null);
INSERT INTO `function` VALUES ('0000000006', 'c890e8e8-348c-493e-868b-b3a9fe1e974c', 'd9c479d6-cf53-4e93-aaef-80057e2125f9', '0', '22', '2', '2', '', '2', '2019-10-22 16:11:59', '2', null, null);
INSERT INTO `function` VALUES ('0000000007', 'c7ce96f0-061c-435f-acf7-908b1956b6e4', 'd9c479d6-cf53-4e93-aaef-80057e2125f9', '3', '2312', '312', '3123', '', '123', '2019-10-22 17:05:42', '312', null, null);
INSERT INTO `function` VALUES ('0000000008', '38cce7a8-5a7c-454e-a6c6-5629924fe3aa', 'd9c479d6-cf53-4e93-aaef-80057e2125f9', '3', '99', '99', '99', '', '99', '2019-10-22 17:07:00', '999', null, null);
INSERT INTO `function` VALUES ('0000000009', 'c285fb48-3f19-4c3a-84a5-af8a28d38978', 'd9c479d6-cf53-4e93-aaef-80057e2125f9', '3', '666', '66', '6', '', '66', '2019-10-22 17:12:10', '66', null, null);

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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO `item` VALUES ('0000000007', '46b747e4-7778-48a7-a605-b9fafcd8902c', '广东公安', '0', 'http://172.16.6.121/svn/platform/branches/20181009_Mustang_V5R2_SP2_GDGA', '0', '王也', '', '', '2019-06-10 21:59:10', '5.2Sp2');
INSERT INTO `item` VALUES ('0000000011', '1c4a6007-57ef-456b-99c3-c042bb6d7e73', '福建政务云', null, 'http://172.16.6.121/svn/platform/branches/20181113_Mustang_V5R2_SP2_FJZWY', null, '王也', '', '', '2019-10-12 17:02:23', '5.2Sp2');
INSERT INTO `item` VALUES ('0000000012', '643b7312-7785-42df-a90e-52afe8f1cbe7', '湖北气象厅', null, 'http://172.16.6.121/svn/platform/branches/20181016_Mustang_V5R1_SP3_SXJY', null, '王也', '', '', '2019-10-12 17:03:01', '5.1Sp3');
INSERT INTO `item` VALUES ('0000000013', '44f03240-ba82-4209-bd46-cef0d50fc644', '河南省委', null, 'http://doc.kedacom.com/svn/KDV_Platform_doc/部门文件/项目定制组/项目跟踪/河南省委卫士通对接', null, '孙东林', '', '', '2019-10-12 17:04:07', '5.0Sp3');
INSERT INTO `item` VALUES ('0000000014', 'bc8e5d83-b9a4-4fd3-b460-691ff03cdbea', '贵州公安', null, 'http://172.16.6.121/svn/platform/branches/20180730_Platform_V5R2_SP2_GZGA/30-webplatform', null, '王也', '', '', '2019-10-12 17:04:34', '5.2Sp2');

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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of item_demand
-- ----------------------------
INSERT INTO `item_demand` VALUES ('0000000001', '46b747e4-7778-48a7-a605-b9fafcd8902c', '46b747e4-7778-48a7-a605-b9fafcd8902c', '2019-09-09 08:00:00', '2019-09-09 08:00:00', '0', '2019-09-09 00:00:00', '0', '3333', '5555');
INSERT INTO `item_demand` VALUES ('0000000002', 'string', '46b747e4-7778-48a7-a605-b9fafcd8902c', '2019-09-09 13:40:44', '2019-09-09 13:40:44', 'string', '2019-09-09 13:40:44', '0', 'string', 'string');
INSERT INTO `item_demand` VALUES ('0000000003', '', '', '2019-09-23 00:00:00', '2019-09-24 00:00:00', '4145656', null, '0', '123', '1232');
INSERT INTO `item_demand` VALUES ('0000000004', '', '', '2019-09-18 00:00:00', '2019-09-25 00:00:00', '1', null, '0', '123', '1231');
INSERT INTO `item_demand` VALUES ('0000000005', '', '46b747e4-7778-48a7-a605-b9fafcd8902c', '2019-09-18 00:00:00', '2019-09-25 00:00:00', '0', null, '0', '123', '1231');
INSERT INTO `item_demand` VALUES ('0000000006', '', '46b747e4-7778-48a7-a605-b9fafcd8902c', '2019-08-27 00:00:00', '2019-08-27 00:00:00', '1', null, '0', '23423', '123412');
INSERT INTO `item_demand` VALUES ('0000000007', '', '', '2019-10-08 00:00:00', '2019-10-24 00:00:00', '0', null, '2', '111', '111');
INSERT INTO `item_demand` VALUES ('0000000008', '', '', '2019-10-09 00:00:00', '2019-10-01 00:00:00', '0', null, '2', '6666', '66666');
INSERT INTO `item_demand` VALUES ('0000000009', '', '', '2019-10-14 00:00:00', '2019-10-29 00:00:00', '0', null, '2', '44', '2222');
INSERT INTO `item_demand` VALUES ('0000000010', '', '', '2019-10-15 00:00:00', '2019-10-22 00:00:00', '0', null, null, '444', '');
INSERT INTO `item_demand` VALUES ('0000000013', 'd9c479d6-cf53-4e93-aaef-80057e2125f9', '44f03240-ba82-4209-bd46-cef0d50fc644', '2019-10-01 08:00:00', '2019-10-25 08:00:00', 's5,s3', '2019-10-22 14:33:53', '2', '数据同步', '数据同步');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `name` varchar(60) DEFAULT NULL COMMENT '用户姓名',
  `moid` varchar(60) DEFAULT NULL COMMENT '用户Moid',
  `account` varchar(60) DEFAULT NULL COMMENT '账号',
  `e164` varchar(60) DEFAULT NULL COMMENT 'E164',
  `password` varchar(60) DEFAULT NULL COMMENT '密码',
  `email` varchar(60) DEFAULT NULL COMMENT '邮箱',
  `age` int(2) DEFAULT NULL COMMENT '性别',
  `enable` int(2) DEFAULT NULL COMMENT '是否启用',
  `isdelete` int(2) DEFAULT NULL COMMENT '是否删除',
  `create_time` varchar(60) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('0000000003', '孙东林', '23e47e2b-f305-4604-9fc0-d1e7f558abff', '孙东林', '0512121887498', '67104d4ff55a8aa6b35b333210f3e034', 'sundonglin@kedacom.com', null, null, null, '2019-10-29');
INSERT INTO `user_info` VALUES ('0000000004', '孙东林', '23e47e2b-f305-4604-9fc0-d1e7f558abff', '孙东林', '0512121887498', '67104d4ff55a8aa6b35b333210f3e034', 'sundonglin@kedacom.com', null, null, null, '2019-10-29');
INSERT INTO `user_info` VALUES ('0000000005', '孙东林', '23e47e2b-f305-4604-9fc0-d1e7f558abff', '孙东林', '0512121887498', '67104d4ff55a8aa6b35b333210f3e034', 'sundonglin@kedacom.com', null, null, null, '2019-10-29');
INSERT INTO `user_info` VALUES ('0000000006', '孙东林', '23e47e2b-f305-4604-9fc0-d1e7f558abff', '孙东林', '0512121887498', '67104d4ff55a8aa6b35b333210f3e034', 'sundonglin@kedacom.com', null, null, null, '2019-10-29');
INSERT INTO `user_info` VALUES ('0000000007', '孙东林', '23e47e2b-f305-4604-9fc0-d1e7f558abff', '孙东林', '0512121887498', '67104d4ff55a8aa6b35b333210f3e034', 'sundonglin@kedacom.com', null, null, null, '2019-10-29');
INSERT INTO `user_info` VALUES ('0000000008', '孙东林', '23e47e2b-f305-4604-9fc0-d1e7f558abff', '孙东林', '0512121887498', '67104d4ff55a8aa6b35b333210f3e034', 'sundonglin@kedacom.com', null, null, null, '2019-10-29');
INSERT INTO `user_info` VALUES ('0000000009', '孙东林', '23e47e2b-f305-4604-9fc0-d1e7f558abff', '孙东林', '0512121887498', '67104d4ff55a8aa6b35b333210f3e034', 'sundonglin@kedacom.com', null, null, null, '2019-10-29');
INSERT INTO `user_info` VALUES ('0000000010', '孙东林', '23e47e2b-f305-4604-9fc0-d1e7f558abff', '孙东林', '0512121887498', '67104d4ff55a8aa6b35b333210f3e034', 'sundonglin@kedacom.com', null, null, null, '2019-10-29');
INSERT INTO `user_info` VALUES ('0000000011', '孙东林', '23e47e2b-f305-4604-9fc0-d1e7f558abff', '孙东林', '0512121887498', '67104d4ff55a8aa6b35b333210f3e034', 'sundonglin@kedacom.com', null, null, null, '2019-10-29');
INSERT INTO `user_info` VALUES ('0000000012', '孙东林', '23e47e2b-f305-4604-9fc0-d1e7f558abff', '孙东林', '0512121887498', '67104d4ff55a8aa6b35b333210f3e034', 'sundonglin@kedacom.com', null, null, null, '2019-10-29');
INSERT INTO `user_info` VALUES ('0000000013', '孙东林', '23e47e2b-f305-4604-9fc0-d1e7f558abff', '孙东林', '0512121887498', '67104d4ff55a8aa6b35b333210f3e034', 'sundonglin@kedacom.com', null, null, null, '2019-10-29');
INSERT INTO `user_info` VALUES ('0000000014', '孙东林', '23e47e2b-f305-4604-9fc0-d1e7f558abff', '孙东林', '0512121887498', '67104d4ff55a8aa6b35b333210f3e034', 'sundonglin@kedacom.com', null, null, null, '2019-10-29');
INSERT INTO `user_info` VALUES ('0000000015', '孙东林', '23e47e2b-f305-4604-9fc0-d1e7f558abff', '孙东林', '0512121887498', '67104d4ff55a8aa6b35b333210f3e034', 'sundonglin@kedacom.com', null, null, null, '2019-10-29');
INSERT INTO `user_info` VALUES ('0000000016', '孙东林', '23e47e2b-f305-4604-9fc0-d1e7f558abff', '孙东林', '0512121887498', '67104d4ff55a8aa6b35b333210f3e034', 'sundonglin@kedacom.com', null, null, null, '2019-10-29');
INSERT INTO `user_info` VALUES ('0000000017', '孙东林', '23e47e2b-f305-4604-9fc0-d1e7f558abff', '孙东林', '0512121887498', '67104d4ff55a8aa6b35b333210f3e034', 'sundonglin@kedacom.com', null, null, null, '2019-10-29');
INSERT INTO `user_info` VALUES ('0000000018', '孙东林', '23e47e2b-f305-4604-9fc0-d1e7f558abff', '孙东林', '0512121887498', '67104d4ff55a8aa6b35b333210f3e034', 'sundonglin@kedacom.com', null, null, null, '2019-10-29');
INSERT INTO `user_info` VALUES ('0000000019', '孙东林', '23e47e2b-f305-4604-9fc0-d1e7f558abff', '孙东林', '0512121887498', '67104d4ff55a8aa6b35b333210f3e034', 'sundonglin@kedacom.com', null, null, null, '2019-10-29');
INSERT INTO `user_info` VALUES ('0000000020', '孙东林', '23e47e2b-f305-4604-9fc0-d1e7f558abff', '孙东林', '0512121887498', '67104d4ff55a8aa6b35b333210f3e034', 'sundonglin@kedacom.com', null, null, null, '2019-10-29');
INSERT INTO `user_info` VALUES ('0000000021', '孙东林', '23e47e2b-f305-4604-9fc0-d1e7f558abff', '孙东林', '0512121887498', '67104d4ff55a8aa6b35b333210f3e034', 'sundonglin@kedacom.com', null, null, null, '2019-10-29');
INSERT INTO `user_info` VALUES ('0000000022', '孙东林', '23e47e2b-f305-4604-9fc0-d1e7f558abff', '孙东林', '0512121887498', '67104d4ff55a8aa6b35b333210f3e034', 'sundonglin@kedacom.com', null, null, null, '2019-10-29');
INSERT INTO `user_info` VALUES ('0000000023', '孙东林', '23e47e2b-f305-4604-9fc0-d1e7f558abff', '孙东林', '0512121887498', '67104d4ff55a8aa6b35b333210f3e034', 'sundonglin@kedacom.com', null, null, null, '2019-10-29');
INSERT INTO `user_info` VALUES ('0000000024', '孙东林', '23e47e2b-f305-4604-9fc0-d1e7f558abff', '孙东林', '0512121887498', '67104d4ff55a8aa6b35b333210f3e034', 'sundonglin@kedacom.com', null, null, null, '2019-10-29');
INSERT INTO `user_info` VALUES ('0000000025', '孙东林', '23e47e2b-f305-4604-9fc0-d1e7f558abff', '孙东林', '0512121887498', '67104d4ff55a8aa6b35b333210f3e034', 'sundonglin@kedacom.com', null, null, null, '2019-10-30');
INSERT INTO `user_info` VALUES ('0000000026', '孙东林', '23e47e2b-f305-4604-9fc0-d1e7f558abff', '孙东林', '0512121887498', '67104d4ff55a8aa6b35b333210f3e034', 'sundonglin@kedacom.com', null, null, null, '2019-10-30');
INSERT INTO `user_info` VALUES ('0000000027', '孙东林', '23e47e2b-f305-4604-9fc0-d1e7f558abff', '孙东林', '0512121887498', '67104d4ff55a8aa6b35b333210f3e034', 'sundonglin@kedacom.com', null, null, null, '2019-10-30');
INSERT INTO `user_info` VALUES ('0000000028', '孙东林', '23e47e2b-f305-4604-9fc0-d1e7f558abff', '孙东林', '0512121887498', '67104d4ff55a8aa6b35b333210f3e034', 'sundonglin@kedacom.com', null, null, null, '2019-10-30');
INSERT INTO `user_info` VALUES ('0000000029', '孙东林', '23e47e2b-f305-4604-9fc0-d1e7f558abff', '孙东林', '0512121887498', '67104d4ff55a8aa6b35b333210f3e034', 'sundonglin@kedacom.com', null, null, null, '2019-10-30');
INSERT INTO `user_info` VALUES ('0000000030', '孙东林', '23e47e2b-f305-4604-9fc0-d1e7f558abff', '孙东林', '0512121887498', '67104d4ff55a8aa6b35b333210f3e034', 'sundonglin@kedacom.com', null, null, null, '2019-10-31');
INSERT INTO `user_info` VALUES ('0000000031', '孙东林', '23e47e2b-f305-4604-9fc0-d1e7f558abff', '孙东林', '0512121887498', '67104d4ff55a8aa6b35b333210f3e034', 'sundonglin@kedacom.com', null, null, null, '2019-10-31');
INSERT INTO `user_info` VALUES ('0000000032', '孙东林', '23e47e2b-f305-4604-9fc0-d1e7f558abff', '孙东林', '0512121887498', '67104d4ff55a8aa6b35b333210f3e034', 'sundonglin@kedacom.com', null, null, null, '2019-10-31');
INSERT INTO `user_info` VALUES ('0000000033', '孙东林', '23e47e2b-f305-4604-9fc0-d1e7f558abff', '孙东林', '0512121887498', '67104d4ff55a8aa6b35b333210f3e034', 'sundonglin@kedacom.com', null, null, null, '2019-10-31');
INSERT INTO `user_info` VALUES ('0000000034', '孙东林', '23e47e2b-f305-4604-9fc0-d1e7f558abff', '孙东林', '0512121887498', '67104d4ff55a8aa6b35b333210f3e034', 'sundonglin@kedacom.com', null, null, null, '2019-10-31');
INSERT INTO `user_info` VALUES ('0000000035', '孙东林', '23e47e2b-f305-4604-9fc0-d1e7f558abff', '孙东林', '0512121887498', '67104d4ff55a8aa6b35b333210f3e034', 'sundonglin@kedacom.com', null, null, null, '2019-10-31');
INSERT INTO `user_info` VALUES ('0000000036', '孙东林', '23e47e2b-f305-4604-9fc0-d1e7f558abff', '孙东林', '0512121887498', '67104d4ff55a8aa6b35b333210f3e034', 'sundonglin@kedacom.com', null, null, null, '2019-10-31');
INSERT INTO `user_info` VALUES ('0000000037', '孙东林', '23e47e2b-f305-4604-9fc0-d1e7f558abff', '孙东林', '0512121887498', '67104d4ff55a8aa6b35b333210f3e034', 'sundonglin@kedacom.com', null, null, null, '2019-10-31');
INSERT INTO `user_info` VALUES ('0000000038', '孙东林', '23e47e2b-f305-4604-9fc0-d1e7f558abff', '孙东林', '0512121887498', '67104d4ff55a8aa6b35b333210f3e034', 'sundonglin@kedacom.com', null, null, null, '2019-10-31');
INSERT INTO `user_info` VALUES ('0000000039', '孙东林', '23e47e2b-f305-4604-9fc0-d1e7f558abff', '孙东林', '0512121887498', '67104d4ff55a8aa6b35b333210f3e034', 'sundonglin@kedacom.com', null, null, null, '2019-10-31');
INSERT INTO `user_info` VALUES ('0000000040', '孙东林', '23e47e2b-f305-4604-9fc0-d1e7f558abff', '孙东林', '0512121887498', '67104d4ff55a8aa6b35b333210f3e034', 'sundonglin@kedacom.com', null, null, null, '2019-10-31');
INSERT INTO `user_info` VALUES ('0000000041', '孙东林', '23e47e2b-f305-4604-9fc0-d1e7f558abff', '孙东林', '0512121887498', '67104d4ff55a8aa6b35b333210f3e034', 'sundonglin@kedacom.com', null, null, null, '2019-10-31');
INSERT INTO `user_info` VALUES ('0000000042', '孙东林', '23e47e2b-f305-4604-9fc0-d1e7f558abff', '孙东林', '0512121887498', '67104d4ff55a8aa6b35b333210f3e034', 'sundonglin@kedacom.com', null, null, null, '2019-11-01');
