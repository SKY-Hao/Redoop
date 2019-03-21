/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : redoop

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2019-03-21 09:59:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for briefing
-- ----------------------------
DROP TABLE IF EXISTS `briefing`;
CREATE TABLE `briefing` (
  `id` varchar(255) NOT NULL,
  `author` varchar(255) DEFAULT NULL,
  `authortime` datetime DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `jumpurl` varchar(255) DEFAULT NULL,
  `outline` varchar(255) DEFAULT NULL,
  `state` int(11) NOT NULL,
  `tablecontents` text,
  `tableid` varchar(255) DEFAULT NULL,
  `tablename` varchar(255) DEFAULT NULL,
  `tabletitle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for component
-- ----------------------------
DROP TABLE IF EXISTS `component`;
CREATE TABLE `component` (
  `id` varchar(255) NOT NULL,
  `adddate` datetime DEFAULT NULL,
  `additive` varchar(255) DEFAULT NULL,
  `alias` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `downloads` int(11) NOT NULL,
  `downurl` varchar(255) DEFAULT NULL,
  `editdate` datetime DEFAULT NULL,
  `memorysize` varchar(255) DEFAULT NULL,
  `mpl` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `open` varchar(255) DEFAULT NULL,
  `picname` varchar(255) DEFAULT NULL,
  `picurl` varchar(255) DEFAULT NULL,
  `showstate` int(11) NOT NULL,
  `subjection` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `version` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` varchar(255) NOT NULL,
  `activatestate` int(11) NOT NULL,
  `companyname` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `logindate` datetime DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phonenumber` varchar(255) DEFAULT NULL,
  `registerdate` datetime DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL COMMENT 'IP',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for download
-- ----------------------------
DROP TABLE IF EXISTS `download`;
CREATE TABLE `download` (
  `id` varchar(255) NOT NULL,
  `chippic` varchar(255) DEFAULT NULL,
  `chippicname` varchar(255) DEFAULT NULL,
  `docudowncount` int(11) NOT NULL,
  `docudownpeople` varchar(255) DEFAULT NULL,
  `documentauthor` varchar(255) DEFAULT NULL,
  `documentname` varchar(255) DEFAULT NULL,
  `documenttype` varchar(255) DEFAULT NULL,
  `documentupload` varchar(255) DEFAULT NULL,
  `documenturl` varchar(255) DEFAULT NULL,
  `platformtype` varchar(255) DEFAULT NULL,
  `producttime` varchar(255) DEFAULT NULL,
  `producttype` varchar(255) DEFAULT NULL,
  `productversion` varchar(255) DEFAULT NULL,
  `systempic` varchar(255) DEFAULT NULL,
  `systempicname` varchar(255) DEFAULT NULL,
  `sysversion` varchar(255) DEFAULT NULL,
  `tag_value` varchar(255) DEFAULT NULL,
  `outline` varchar(255) DEFAULT NULL,
  `see` varchar(255) DEFAULT NULL,
  `content` text,
  `htmlcontent` text,
  PRIMARY KEY (`id`),
  KEY `FKtauxpdx4nfs64n0w4hi1gq0gf` (`tag_value`),
  CONSTRAINT `FKtauxpdx4nfs64n0w4hi1gq0gf` FOREIGN KEY (`tag_value`) REFERENCES `sys_tag` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for license
-- ----------------------------
DROP TABLE IF EXISTS `license`;
CREATE TABLE `license` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `allow_pic` int(11) DEFAULT NULL,
  `code` text,
  `company` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `mac` varchar(255) DEFAULT NULL,
  `node` int(11) DEFAULT NULL,
  `products` varchar(255) DEFAULT NULL,
  `project` varchar(255) DEFAULT NULL,
  `services` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `trials` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `vaild` varchar(255) DEFAULT NULL,
  `vaild_days` int(11) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for mess
-- ----------------------------
DROP TABLE IF EXISTS `mess`;
CREATE TABLE `mess` (
  `id` varchar(255) NOT NULL,
  `author` varchar(255) DEFAULT NULL,
  `authortime` datetime DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `endtime` datetime DEFAULT NULL,
  `outline` varchar(255) DEFAULT NULL,
  `starttime` datetime DEFAULT NULL,
  `state` int(11) NOT NULL,
  `tableid` varchar(255) DEFAULT NULL,
  `tablename` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `contents` text,
  `jumpurl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for partner
-- ----------------------------
DROP TABLE IF EXISTS `partner`;
CREATE TABLE `partner` (
  `id` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `applicationtime` datetime DEFAULT NULL,
  `auditor` varchar(255) DEFAULT NULL,
  `auditoresult` int(11) NOT NULL,
  `auditortime` datetime DEFAULT NULL,
  `authentication` varchar(255) DEFAULT NULL,
  `companyname` varchar(255) DEFAULT NULL,
  `companypic` varchar(255) DEFAULT NULL,
  `companypicname` varchar(255) DEFAULT NULL,
  `companyprofile` varchar(255) DEFAULT NULL,
  `companytel` varchar(255) DEFAULT NULL,
  `companytype` varchar(255) DEFAULT NULL,
  `contactsemail` varchar(255) DEFAULT NULL,
  `contactsname` varchar(255) DEFAULT NULL,
  `contactstel` varchar(255) DEFAULT NULL,
  `industry` varchar(255) DEFAULT NULL,
  `intention` varchar(255) DEFAULT NULL,
  `partnerproduct` varchar(255) DEFAULT NULL,
  `partnertype` varchar(255) DEFAULT NULL,
  `partnerversion` varchar(255) DEFAULT NULL,
  `testcontent` varchar(255) DEFAULT NULL,
  `testnumber` varchar(255) DEFAULT NULL,
  `testresult` varchar(255) DEFAULT NULL,
  `testtime` datetime DEFAULT NULL,
  `testversion` varchar(255) DEFAULT NULL,
  `outline` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for picture
-- ----------------------------
DROP TABLE IF EXISTS `picture`;
CREATE TABLE `picture` (
  `id` varchar(255) NOT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` varchar(255) NOT NULL,
  `productauthor` varchar(255) DEFAULT NULL,
  `productcount` int(11) NOT NULL,
  `productname` varchar(255) DEFAULT NULL,
  `productpeople` varchar(255) DEFAULT NULL,
  `producttime` varchar(255) DEFAULT NULL,
  `producttype` varchar(255) DEFAULT NULL,
  `productupload` varchar(255) DEFAULT NULL,
  `producturl` varchar(255) DEFAULT NULL,
  `protype` varchar(255) DEFAULT NULL,
  `outline` varchar(255) DEFAULT NULL,
  `companyname` varchar(255) DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `useremail` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `usertel` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for service
-- ----------------------------
DROP TABLE IF EXISTS `service`;
CREATE TABLE `service` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for solution
-- ----------------------------
DROP TABLE IF EXISTS `solution`;
CREATE TABLE `solution` (
  `id` varchar(255) NOT NULL,
  `author` varchar(255) DEFAULT NULL,
  `authortime` varchar(255) DEFAULT NULL,
  `content` longtext,
  `intro` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `solutionpic` varchar(255) DEFAULT NULL,
  `state` int(11) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `solutionpicnamne` varchar(255) DEFAULT NULL,
  `outline` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for student0
-- ----------------------------
DROP TABLE IF EXISTS `student0`;
CREATE TABLE `student0` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_news
-- ----------------------------
DROP TABLE IF EXISTS `sys_news`;
CREATE TABLE `sys_news` (
  `id` varchar(255) NOT NULL,
  `content` text,
  `date` datetime DEFAULT NULL,
  `picpath` varchar(255) DEFAULT NULL,
  `publisher` varchar(255) DEFAULT NULL,
  `state` int(11) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `outline` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `source` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descritpion` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `pid` int(11) NOT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_permission_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission_role`;
CREATE TABLE `sys_permission_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_id` int(11) DEFAULT NULL,
  `rid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_role_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE `sys_role_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rid` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_tag
-- ----------------------------
DROP TABLE IF EXISTS `sys_tag`;
CREATE TABLE `sys_tag` (
  `id` varchar(255) NOT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `label` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag` (
  `id` varchar(255) NOT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tea
-- ----------------------------
DROP TABLE IF EXISTS `tea`;
CREATE TABLE `tea` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `air` varchar(255) DEFAULT NULL,
  `environment` varchar(255) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `process` varchar(255) DEFAULT NULL,
  `production` varchar(255) DEFAULT NULL,
  `soil` varchar(255) DEFAULT NULL,
  `water` varchar(255) DEFAULT NULL,
  `weather` varchar(255) DEFAULT NULL,
  `ethhash` varchar(255) DEFAULT NULL,
  `gradeleaf` varchar(255) DEFAULT NULL,
  `gradeodor` varchar(255) DEFAULT NULL,
  `gradeshape` varchar(255) DEFAULT NULL,
  `gradesoupcolor` varchar(255) DEFAULT NULL,
  `gradetime` varchar(255) DEFAULT NULL,
  `sugtaste` varchar(255) DEFAULT NULL,
  `sugtea` varchar(255) DEFAULT NULL,
  `sugwarmcup` varchar(255) DEFAULT NULL,
  `sugwater` varchar(255) DEFAULT NULL,
  `date` timestamp NULL DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `cobalt` varchar(255) DEFAULT NULL,
  `directionfive` varchar(25) DEFAULT NULL,
  `directionfour` varchar(25) DEFAULT NULL,
  `directionone` varchar(25) DEFAULT NULL,
  `directionthen` varchar(25) DEFAULT NULL,
  `directiontwo` varchar(25) DEFAULT NULL,
  `frontone` varchar(25) DEFAULT NULL,
  `fronttwo` varchar(25) DEFAULT NULL,
  `highwdfive` varchar(25) DEFAULT NULL,
  `highwdfour` varchar(25) DEFAULT NULL,
  `highwdone` varchar(25) DEFAULT NULL,
  `highwdthen` varchar(25) DEFAULT NULL,
  `highwdtwo` varchar(25) DEFAULT NULL,
  `imgfive` varchar(255) DEFAULT NULL,
  `imgfour` varchar(255) DEFAULT NULL,
  `imgnightfive` varchar(255) DEFAULT NULL,
  `imgnightfour` varchar(255) DEFAULT NULL,
  `imgnightone` varchar(255) DEFAULT NULL,
  `imgnightthen` varchar(255) DEFAULT NULL,
  `imgnighttwo` varchar(255) DEFAULT NULL,
  `imgone` varchar(255) DEFAULT NULL,
  `imgthen` varchar(255) DEFAULT NULL,
  `imgtwo` varchar(255) DEFAULT NULL,
  `iron` varchar(255) DEFAULT NULL,
  `laterfive` varchar(25) DEFAULT NULL,
  `laterfour` varchar(25) DEFAULT NULL,
  `lead` varchar(255) DEFAULT NULL,
  `lowwdfive` varchar(25) DEFAULT NULL,
  `lowwdfour` varchar(25) DEFAULT NULL,
  `lowwdone` varchar(25) DEFAULT NULL,
  `lowwdthen` varchar(25) DEFAULT NULL,
  `lowwdtwo` varchar(25) DEFAULT NULL,
  `molybdenum` varchar(255) DEFAULT NULL,
  `monthfive` varchar(25) DEFAULT NULL,
  `monthfour` varchar(25) DEFAULT NULL,
  `monthone` varchar(25) DEFAULT NULL,
  `monthtwo` varchar(25) DEFAULT NULL,
  `nickel` varchar(255) DEFAULT NULL,
  `rareearth` varchar(255) DEFAULT NULL,
  `slightly` varchar(255) DEFAULT NULL,
  `statefive` varchar(25) DEFAULT NULL,
  `statefour` varchar(25) DEFAULT NULL,
  `stateone` varchar(25) DEFAULT NULL,
  `statesfive` varchar(25) DEFAULT NULL,
  `statesfour` varchar(25) DEFAULT NULL,
  `statesone` varchar(25) DEFAULT NULL,
  `statesthen` varchar(25) DEFAULT NULL,
  `statestwo` varchar(25) DEFAULT NULL,
  `statetwo` varchar(25) DEFAULT NULL,
  `temperature` varchar(25) DEFAULT NULL,
  `thenbest` varchar(255) DEFAULT NULL,
  `thenday` varchar(255) DEFAULT NULL,
  `thenhumidity` varchar(255) DEFAULT NULL,
  `thenmonth` varchar(255) DEFAULT NULL,
  `thenpress` varchar(255) DEFAULT NULL,
  `thenstate` varchar(255) DEFAULT NULL,
  `thenultraviolet` varchar(255) DEFAULT NULL,
  `thenwind` varchar(255) DEFAULT NULL,
  `winpowerfive` varchar(25) DEFAULT NULL,
  `winpowerfour` varchar(25) DEFAULT NULL,
  `winpowerone` varchar(25) DEFAULT NULL,
  `winpowerthen` varchar(25) DEFAULT NULL,
  `winpowertwo` varchar(25) DEFAULT NULL,
  `zinc` varchar(25) DEFAULT NULL,
  `altitude` varchar(255) DEFAULT NULL,
  `land` varchar(255) DEFAULT NULL,
  `ph` varchar(255) DEFAULT NULL,
  `rainfall` varchar(255) DEFAULT NULL,
  `surroundings` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(20) NOT NULL,
  `username` varchar(10) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
