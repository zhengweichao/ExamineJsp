/*
Navicat MySQL Data Transfer

Source Server         : aa
Source Server Version : 50547
Source Host           : localhost:3306
Source Database       : examine

Target Server Type    : MYSQL
Target Server Version : 50547
File Encoding         : 65001

Date: 2018-11-20 23:20:47
*/

CREATE DATABASE IF NOT EXISTS examine default charset utf8 COLLATE utf8_general_ci;

use examine;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tbl_grade
-- ----------------------------
DROP TABLE IF EXISTS `tbl_grade`;
CREATE TABLE `tbl_grade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `grade` varchar(255) DEFAULT NULL,
  `usetime` varchar(0) DEFAULT NULL,
  `endtime` varchar(0) DEFAULT NULL,
  `kind` varchar(255) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tbl_grade
-- ----------------------------
INSERT INTO `tbl_grade` VALUES ('4', '001', '20', '', '', 'english', '5');

-- ----------------------------
-- Table structure for tbl_question
-- ----------------------------
DROP TABLE IF EXISTS `tbl_question`;
CREATE TABLE `tbl_question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `q_type` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `optionA` varchar(255) DEFAULT NULL,
  `optionB` varchar(255) DEFAULT NULL,
  `optionC` varchar(255) DEFAULT NULL,
  `optionD` varchar(255) DEFAULT NULL,
  `tips` varchar(255) DEFAULT NULL,
  `answer` varchar(255) DEFAULT NULL,
  `explain` varchar(255) DEFAULT NULL,
  `kind` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tbl_question
-- ----------------------------
INSERT INTO `tbl_question` VALUES ('1', '1', '下面哪个国际标准不是关于现场总线的', 'IEC61158', 'IEC62026', 'ISO11898', 'IEC1158', 'tips11', 'D', 'explain11', 'english');
INSERT INTO `tbl_question` VALUES ('2', '1', '下列哪种现场总线是建筑业国际公认的现场总线标准？', 'Lonworks', 'HART', 'CC-Link', 'Sensoplex2', 'tips22', 'A', 'explain22', 'chinese');
INSERT INTO `tbl_question` VALUES ('3', '1', '双绞线按规则螺旋结构排列的目的是', '使各线对之间易于区别', '使各线对之间的电磁干扰最小', '使各线对的韧性更强', '以上皆不是', '选项D33', 'B', 'answer33', 'chinese');
INSERT INTO `tbl_question` VALUES ('4', '1', 'SJA1000是：', 'CAN控制器接口芯片', 'CAN控制器驱动芯片', '在片CAN控制器芯片', '独立CAN控制器芯片', 'tips44', 'D', 'explain44', 'chinese');
INSERT INTO `tbl_question` VALUES ('5', '1', 'CAN总线使用的数据编码是：', '归零码（RZ）', '非归零码（NRZ）', '曼彻斯特编码', '差分曼彻斯特编码	', 'tips', 'B', 'explain55', 'math');
INSERT INTO `tbl_question` VALUES ('6', '2', '负责组织和管理基金会现场总线的国际组织是：FF', 'AAA', 'BBB', 'CCC', 'DDD', 'tips66', '对', 'explain66', 'chinese');
INSERT INTO `tbl_question` VALUES ('7', '2', '多模光纤性能优于单模光纤。', 'AAA', 'BBB', 'CCC', 'DDD', 'tips77', '错', 'explain77', 'english');
INSERT INTO `tbl_question` VALUES ('8', '2', 'DeviceNet不使用曼彻斯特编码。', 'AAA', 'BBB', 'CCC', 'DDD', 'tips88', '对', 'explain88', 'math');
INSERT INTO `tbl_question` VALUES ('9', '2', '在DeviceNet现场总线中，组3报文ID值7无效，不被使用。', 'A99', 'B99', 'C99', 'D99', 'tips99', '对', 'explain99', 'english');
INSERT INTO `tbl_question` VALUES ('10', '2', '光纤不受外界电磁干扰与噪声的影响', 'AAA', 'BBB', 'CCC', 'DDD', 'tips10', '对', 'explain10', 'chinese');
INSERT INTO `tbl_question` VALUES ('11', '2', 'title10', 'AAA', 'BBB', 'CCC', 'DDD', 'tips10', 'AB', 'explain10', 'chinese');
INSERT INTO `tbl_question` VALUES ('12', '2', 'title10', 'AAA', 'BBB', 'CCC', 'DDD', 'tips10', 'AB', 'explain10', 'english');
INSERT INTO `tbl_question` VALUES ('13', '2', 'title10', 'AAA', 'BBB', 'CCC', 'DDD', 'tips10', 'AB', 'explain10', 'math');
INSERT INTO `tbl_question` VALUES ('14', '2', 'title10', 'AAA', 'BBB', 'CCC', 'DDD', 'tips10', 'AB', 'explain10', 'english');
INSERT INTO `tbl_question` VALUES ('15', '2', 'title10', 'AAA', 'BBB', 'CCC', 'DDD', 'tips10', 'AB', 'explain10', 'math');
INSERT INTO `tbl_question` VALUES ('16', '3', '简述现场总线的技术特点', null, null, null, null, 'aaaa', '（1）现场总线是现场通信网络；（2）现场总线是数字通信网络；（3）现场总线是开放互连网络；（4）现场总线是现场设备互连网络；（5）现场总线是结构与功能高度分散的系统；（6）现场设备的互操作性与互换性。', null, '');
INSERT INTO `tbl_question` VALUES ('17', '3', '简述现场总线的优点。', '', '', '', '', 'aaaa', '（1）导线和连接附件大量减少；（2）仪表和输入／输出转换器（卡件）大量减少；（3）设计、安装和调试费用大大降低；（4）维护开销大幅度下降；（5）系统可靠性提高；（6）系统测量与控制精度提高；（7）系统具有优异的远程监控功能；（8）系统具有强大的（远程）故障诊断功能；（9）设备配置、网络组态和系统集成方便自由；（10）现场设备更换和系统扩展更为方便；（11）为企业信息系统的构建创造了重要条件。', '', null);
INSERT INTO `tbl_question` VALUES ('18', '3', '简述宽带网与基带网的主要区别。', '', '', '', '', 'aaaa', '一是数据传输速率不同，基带网的数据速率范围为0～10 Mb/s，宽带网可达0～400 Mb/s；二是宽带网可划分为多条基带信道，提供良好的通信路径。', '', null);
INSERT INTO `tbl_question` VALUES ('19', '3', '简述CAN总线的非破坏性逐位仲裁机制。', '', '', '', '', 'aaaa', '当多个节点同时开始向总线发送报文时，通过逐一比较发送位与监听到的位，发送较低优先级报文的节点会主动停止发送，而发送最高优先级报文的节点不受任何影响地继续发送报文。', '', null);
INSERT INTO `tbl_question` VALUES ('20', '3', '简述ControlNet现场总线中的生产者/消费者模型。', '', '', '', '', 'aaaa', '生产者/消费者模型允许一个发送设备（生产者）与多个接收设备（消费者）之间交换时间紧要的应用信息，而不需将发往多个目的的数据发送多次，这可通过将每条正被生产并发往网络媒体上的应用信息附加上一个唯一的标识符来完成。任何需要一条特定应用信息的设备仅通过相应的标识符对网络媒体上的数据进行过滤。多个设备可接收来自一个生产设备所生产的相同的应用信息。', '', null);

-- ----------------------------
-- Table structure for tbl_user_info
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user_info`;
CREATE TABLE `tbl_user_info` (
  `id` int(11) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `perssion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tbl_user_info
-- ----------------------------
INSERT INTO `tbl_user_info` VALUES ('1', '001', 'aa', '1');
