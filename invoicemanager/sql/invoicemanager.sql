/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 6.0.10-alpha-community : Database - invoicemanager
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`invoicemanager` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `invoicemanager`;

/*Table structure for table `pw_extensioku` */

DROP TABLE IF EXISTS `pw_extensioku`;

CREATE TABLE `pw_extensioku` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `invoicetype` int(11) DEFAULT NULL COMMENT '发票种类',
  `billinglimit` decimal(18,2) DEFAULT NULL COMMENT '开票极限',
  `classname` varchar(40) DEFAULT NULL COMMENT '类别名称',
  `startnumber` varchar(8) DEFAULT NULL COMMENT '起始号码',
  `invoicenumber` int(11) DEFAULT NULL COMMENT '发票张数',
  `endnumber` varchar(8) DEFAULT NULL COMMENT '卷终止号',
  `linggoudate` date DEFAULT NULL COMMENT '领购日期',
  `medium` int(11) DEFAULT NULL COMMENT '介质',
  `extensionnumber` int(11) DEFAULT NULL COMMENT '分机号',
  `extensiondate` date DEFAULT NULL COMMENT '分配日期',
  `extensionstatus` int(11) DEFAULT NULL COMMENT '分配状态',
  `ifreturn` tinyint(1) DEFAULT NULL COMMENT '退回否',
  `ifrefund` tinyint(1) DEFAULT NULL COMMENT '退票否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='分机票库';

/*Data for the table `pw_extensioku` */

insert  into `pw_extensioku`(`id`,`invoicetype`,`billinglimit`,`classname`,`startnumber`,`invoicenumber`,`endnumber`,`linggoudate`,`medium`,`extensionnumber`,`extensiondate`,`extensionstatus`,`ifreturn`,`ifrefund`) values (1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `pw_invoiceinventory` */

DROP TABLE IF EXISTS `pw_invoiceinventory`;

CREATE TABLE `pw_invoiceinventory` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `invoicetype` int(11) DEFAULT NULL COMMENT '发票种类',
  `billinglimit` decimal(18,2) DEFAULT NULL COMMENT '开票限额',
  `classname` varchar(40) DEFAULT NULL COMMENT '类别名称',
  `startnumber` varchar(8) DEFAULT NULL COMMENT '起始号码',
  `invoicenumber` int(11) DEFAULT NULL COMMENT '发票张数',
  `endnumber` varchar(8) DEFAULT NULL COMMENT '卷终止号',
  `linggoudate` date DEFAULT NULL COMMENT '领购日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

/*Data for the table `pw_invoiceinventory` */

insert  into `pw_invoiceinventory`(`id`,`invoicetype`,`billinglimit`,`classname`,`startnumber`,`invoicenumber`,`endnumber`,`linggoudate`) values (2,1,'9999.99','北京市增值税专用发票','00000012',289,'00000300','2017-03-04'),(3,2,'99999.99','北京市增值税普通发票','00000102',10,'00000111','2017-03-04'),(4,3,'999.99','北京市电子增值税普通发票','00000010',20,'00000029','2017-03-04'),(5,4,'9999.99','北京市增值税普通发票（卷票）','00000023',10,'00000032','2017-03-04'),(8,1,'9999.99','北京市增值税专用发票','00000012',289,'00000300','2017-03-04'),(9,2,'99999.99','北京市增值税普通发票','00000102',10,'00000111','2017-03-04'),(10,3,'999.99','北京市电子增值税普通发票','00000010',20,'00000029','2017-03-04'),(11,4,'9999.99','北京市增值税普通发票（卷票）','00000023',10,'00000032','2017-03-04'),(12,5,'99999.99','北京市货物运输业增值税专用发票','00000087',28,'00000114','2017-03-04'),(13,6,'999.99','北京市机动车销售统一发票','00000134',35,'00000168','2017-03-04'),(14,1,'9999.99','北京市增值税专用发票','00000012',289,'00000300','2017-03-04'),(15,2,'9999.99','北京市增值税普通发票','00000071',30,'00000100','2017-03-04'),(16,3,'9999.99','北京市电子增值税普通发票','00000097',30,'00000126','2017-03-04'),(20,5,'99999.99','北京市货物运输业增值税专用发票','00000087',28,'00000114','2017-03-29'),(21,5,'9999.99','北京市货物运输业增值税专用发票','00000050',30,'00000079','2017-03-29'),(22,6,'9999.99','北京市机动车销售统一发票','00000064',30,'00000093','2017-03-29');

/*Table structure for table `pw_invoiceopen` */

DROP TABLE IF EXISTS `pw_invoiceopen`;

CREATE TABLE `pw_invoiceopen` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `invoicenumber` varchar(8) DEFAULT NULL COMMENT '发票号码',
  `invoicetypeid` int(11) DEFAULT NULL COMMENT '发票类型ID',
  `buyerid` int(11) DEFAULT NULL COMMENT '购买方ID',
  `salyerid` int(11) DEFAULT NULL COMMENT '销售方ID',
  `totalmoney` decimal(18,2) DEFAULT NULL COMMENT '金额',
  `taxmoney` decimal(18,2) DEFAULT NULL COMMENT '税额',
  `passwork` varchar(84) DEFAULT NULL COMMENT '密码',
  `remarks` varchar(100) DEFAULT NULL COMMENT '备注',
  `opendate` date DEFAULT NULL COMMENT '开票日期',
  `receivabler` int(11) DEFAULT NULL COMMENT '收款人',
  `reviewer` int(11) DEFAULT NULL COMMENT '复核人',
  `opener` int(11) DEFAULT NULL COMMENT '开票人',
  `ifinvalid` tinyint(4) DEFAULT NULL COMMENT '作废否',
  `submitstatus` int(11) DEFAULT NULL COMMENT '报送状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='发票填开';

/*Data for the table `pw_invoiceopen` */

/*Table structure for table `pw_invoiceopendetails` */

DROP TABLE IF EXISTS `pw_invoiceopendetails`;

CREATE TABLE `pw_invoiceopendetails` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `invoiceopenid` int(11) DEFAULT NULL COMMENT '发票填开ID',
  `commodityid` int(11) DEFAULT NULL COMMENT '商品ID',
  `number` int(11) DEFAULT NULL COMMENT '数量',
  `comments` varchar(0) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='发票填开明细';

/*Data for the table `pw_invoiceopendetails` */

/*Table structure for table `pw_invoicereceive` */

DROP TABLE IF EXISTS `pw_invoicereceive`;

CREATE TABLE `pw_invoicereceive` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `invoicetype` int(11) DEFAULT NULL COMMENT '发票种类',
  `billinglimit` decimal(18,2) DEFAULT NULL COMMENT '开票限额',
  `startnumber` varchar(8) DEFAULT NULL COMMENT '起始号码',
  `invoicenumber` int(11) DEFAULT NULL COMMENT '发票张数',
  `endnumber` varchar(8) DEFAULT NULL COMMENT '卷终止号',
  `linggoudate` date DEFAULT NULL COMMENT '领购日期',
  `medium` int(11) DEFAULT NULL COMMENT '介质',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='发票领购';

/*Data for the table `pw_invoicereceive` */

insert  into `pw_invoicereceive`(`id`,`invoicetype`,`billinglimit`,`startnumber`,`invoicenumber`,`endnumber`,`linggoudate`,`medium`) values (1,1,'9999.99','00000012',289,'00000300','2017-03-04',15),(2,2,'99999.99','00000102',10,'00000111','2017-03-04',15),(3,3,'999.99','00000010',20,'00000029','2017-03-04',15),(4,4,'9999.99','00000023',10,'00000032','2017-03-04',15),(5,5,'99999.99','00000087',28,'00000114','2017-03-04',15),(6,1,'9999.99','00000012',289,'00000300','2017-03-04',16),(7,2,'9999.99','00000071',30,'00000100','2017-03-04',16),(8,3,'9999.99','00000097',30,'00000126','2017-03-04',16),(9,4,'9999.99','00000068',30,'00000097','2017-03-04',16),(10,5,'9999.99','00000050',30,'00000079','2017-03-04',16),(11,6,'9999.99','00000064',30,'00000093','2017-03-04',16),(13,6,'999.99','00000134',35,'00000168','2017-03-04',15);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `rolename` varchar(42) DEFAULT NULL COMMENT '角色名称',
  `roledescribe` varchar(42) DEFAULT NULL COMMENT '角色描述',
  `creater` int(11) DEFAULT NULL COMMENT '创建人',
  `createtime` date DEFAULT NULL COMMENT '创建时间',
  `f_id` int(11) DEFAULT NULL COMMENT '父级ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`id`,`rolename`,`roledescribe`,`creater`,`createtime`,`f_id`) values (1,'开票员',NULL,2,'2017-02-20',0),(2,'管理员',NULL,1,'2017-02-20',0),(3,'收款人',NULL,1,'2017-02-21',0),(4,'复核人',NULL,2,'2017-02-21',0);

/*Table structure for table `sys_administrativedivision` */

DROP TABLE IF EXISTS `sys_administrativedivision`;

CREATE TABLE `sys_administrativedivision` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(4) DEFAULT NULL COMMENT '编码',
  `name` varchar(40) DEFAULT NULL COMMENT '名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `sys_administrativedivision` */

insert  into `sys_administrativedivision`(`id`,`code`,`name`) values (1,'1100','北京市'),(2,'1101','市辖区'),(3,'1102','属县'),(4,'1200','天津市'),(5,'1201','市辖区'),(6,'1202','属县');

/*Table structure for table `sys_area` */

DROP TABLE IF EXISTS `sys_area`;

CREATE TABLE `sys_area` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `areaname` varchar(20) DEFAULT NULL COMMENT '地区名称',
  `areacode` varchar(20) DEFAULT NULL COMMENT '地区编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='地区表';

/*Data for the table `sys_area` */

insert  into `sys_area`(`id`,`areaname`,`areacode`) values (1,'sa','1');

/*Table structure for table `sys_attribute` */

DROP TABLE IF EXISTS `sys_attribute`;

CREATE TABLE `sys_attribute` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `attributename` varchar(40) DEFAULT NULL COMMENT '属性名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `sys_attribute` */

insert  into `sys_attribute`(`id`,`attributename`) values (1,'车辆类型'),(2,'政策类型'),(3,'报送状态'),(4,'介质类型'),(5,'卡类型'),(6,'分配状态');

/*Table structure for table `sys_attributedetails` */

DROP TABLE IF EXISTS `sys_attributedetails`;

CREATE TABLE `sys_attributedetails` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `attributedetailsname` varchar(40) DEFAULT NULL COMMENT '属性明细名称',
  `attribute` int(11) DEFAULT NULL COMMENT '属性名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `sys_attributedetails` */

insert  into `sys_attributedetails`(`id`,`attributedetailsname`,`attribute`) values (1,'摩托车',1),(2,'汽车',1),(3,'电车',1),(4,'挂车',1),(5,'农业运输车',1),(6,'促进区域协调发展',2),(7,'促进构建社会主义和谐社会',2),(8,'促进资源节约型、环境友好型社会建设',2),(9,'促进科技进步和自主创新',2),(10,'未报送',3),(11,'报送中',3),(12,'报送失败',3),(13,'验签失败',3),(14,'已报送',3),(15,'金税盘',4),(16,'报税盘',4),(17,'非新型金税卡',5),(18,'新型金税卡',5),(19,'已下载',6),(20,'未下载',6);

/*Table structure for table `sys_commodity` */

DROP TABLE IF EXISTS `sys_commodity`;

CREATE TABLE `sys_commodity` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(16) DEFAULT NULL COMMENT '编码',
  `name` varchar(16) DEFAULT NULL COMMENT '名称',
  `simplecode` varchar(16) DEFAULT NULL COMMENT '简码',
  `commoditytax` varchar(16) DEFAULT NULL COMMENT '商品税目',
  `taxrate` varchar(16) DEFAULT NULL COMMENT '税率',
  `price` decimal(18,2) DEFAULT NULL COMMENT '单价',
  `specificationmodel` varchar(40) DEFAULT NULL COMMENT '规格型号',
  `unitofmeasurement` varchar(22) DEFAULT NULL COMMENT '计量单位',
  `taxpricemark` tinyint(1) DEFAULT NULL COMMENT '含税价标志',
  `hiddenflag` tinyint(1) DEFAULT NULL COMMENT '隐藏标志',
  `taxtypecode` varchar(16) DEFAULT NULL COMMENT '税收分类编码',
  `taxtypename` varchar(16) DEFAULT NULL COMMENT '税收分类名称',
  `policytype` int(11) DEFAULT NULL COMMENT '优惠政策类型',
  `enjoypolicies` tinyint(1) DEFAULT NULL COMMENT '享受优惠政策',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `sys_commodity` */

insert  into `sys_commodity`(`id`,`code`,`name`,`simplecode`,`commoditytax`,`taxrate`,`price`,`specificationmodel`,`unitofmeasurement`,`taxpricemark`,`hiddenflag`,`taxtypecode`,`taxtypename`,`policytype`,`enjoypolicies`) values (1,'001','一般货物17%','','','3%',NULL,'','',0,0,'001','大麦',NULL,0),(2,'00101','美达24X CD-ROM','','0101','17%','560.00','24倍速','台',0,0,'001','',NULL,0),(3,'00102','资料','','0101','17%','110.00','PACK','箱',0,0,'001','',NULL,0),(4,'00103','配件','','0102','17%','350.00','NOWELL','套',0,0,'001','',NULL,0),(5,'00104','网络设备','','0102','17%','18000.00','','台',0,0,'001','',NULL,0),(6,'00105','复印机','','0101','17%','500.00','','台',0,0,'001','',NULL,0),(7,'00107','美达24X CD-ROMl1','','0101','17%','560.00','24倍速','台',0,0,'001','',NULL,0),(8,'002','简易征收','','','17%',NULL,'','',0,0,'002','',NULL,0),(9,'00201','信息费6%','','4003','6%',NULL,'','',0,0,'002','',NULL,0),(10,'00202','服务费6%','','4003','6%',NULL,'','',0,0,'002','',NULL,0),(11,'00203','其他业务费4%','','4004','4%',NULL,'','',0,0,'002','',NULL,0),(12,'003','一般商品13%','','','17%',NULL,'','',0,0,'003','',NULL,0),(13,'00301','实用植物油（13%）','','0204','17%','12.00','粮食13','斤',0,0,'003','',NULL,0),(14,'004','代码转换','','','17%',NULL,'','',0,0,'004','',NULL,0),(15,'00401','啤酒（更新税目产品）','','0203','17%','10.00','','',0,0,'004','',NULL,0),(16,'006','劳务','','','17%',NULL,'','',0,0,'006','',NULL,0),(17,'00601','应税劳务','','9001','17%',NULL,'','',0,0,'006','',NULL,0),(18,'00602','视同销售','II','9002','17%',NULL,'','',0,0,'006','',NULL,0);

/*Table structure for table `sys_costitems` */

DROP TABLE IF EXISTS `sys_costitems`;

CREATE TABLE `sys_costitems` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(16) DEFAULT NULL COMMENT '编码',
  `name` varchar(20) DEFAULT NULL COMMENT '名称',
  `simplecode` varchar(6) DEFAULT NULL COMMENT '简码',
  `taxtypecode` varchar(16) DEFAULT NULL COMMENT '税收分类编码',
  `taxtypename` varchar(16) DEFAULT NULL COMMENT '税收分类名称',
  `policytype` int(11) DEFAULT NULL COMMENT '优惠政策类型',
  `enjoypolicies` tinyint(1) DEFAULT NULL COMMENT '享受优惠政策',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `sys_costitems` */

insert  into `sys_costitems`(`id`,`code`,`name`,`simplecode`,`taxtypecode`,`taxtypename`,`policytype`,`enjoypolicies`) values (1,'001','运输费','','','',NULL,0),(2,'002','停车费用','','','',3,1),(3,'003','服务费','','','',NULL,0);

/*Table structure for table `sys_customer` */

DROP TABLE IF EXISTS `sys_customer`;

CREATE TABLE `sys_customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(16) DEFAULT NULL COMMENT '编码',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `simplecode` varchar(6) DEFAULT NULL COMMENT '简码',
  `dutyparagraph` varchar(20) DEFAULT NULL COMMENT '税号',
  `telephone` varchar(18) DEFAULT NULL COMMENT '地址电话',
  `bankaccount` varchar(19) DEFAULT NULL COMMENT '银行账号',
  `mailingaddress` varchar(40) DEFAULT NULL COMMENT '邮件地址',
  `remarks` varchar(200) DEFAULT NULL COMMENT '备注',
  `f_id` int(11) DEFAULT NULL COMMENT '父级编码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `sys_customer` */

insert  into `sys_customer`(`id`,`code`,`name`,`simplecode`,`dutyparagraph`,`telephone`,`bankaccount`,`mailingaddress`,`remarks`,`f_id`) values (1,'001','北京',NULL,NULL,NULL,NULL,NULL,NULL,0),(2,'00101','北京畅联电子有限公司',NULL,'110101251328321','北京市海淀区',NULL,NULL,NULL,1),(3,'002','湖北',NULL,NULL,NULL,NULL,NULL,NULL,0),(4,'00201','湖北锅炉厂','BG','420101ABCDEFGH5','武汉市武昌关山口',NULL,NULL,NULL,3),(5,'004','浙江',NULL,NULL,NULL,NULL,NULL,NULL,0),(6,'00401','宁波开发区甬虹电子有限公司',NULL,'330206251325342','宁波市海南路24号',NULL,NULL,NULL,5),(7,'005','天津','','123','','','','',NULL),(8,'00501','天龙实业有限公司','','210115133842834','天津市望海路12弄','6680124284030','','',NULL),(9,'00502','金诚公司','','220115133842835','天津市望海路12弄9','','','',NULL),(10,'044','深圳','LL','','','','','',NULL),(11,'04403','深圳1公司','SZ','','','','','',NULL),(12,'0440301','深圳2公司','QQ','440301123456789','深圳福条5路','','','',NULL),(13,'0440302','深圳3公司','EE','440309000000000','深圳罗湖南路','','','',NULL);

/*Table structure for table `sys_errorinfor` */

DROP TABLE IF EXISTS `sys_errorinfor`;

CREATE TABLE `sys_errorinfor` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `type` int(11) DEFAULT NULL COMMENT '类别',
  `errorcode` varchar(5) DEFAULT NULL COMMENT '错误事件代码',
  `errordescribe` varchar(200) DEFAULT NULL COMMENT '错误事件描述',
  `reasonsolution` varchar(400) DEFAULT NULL COMMENT '原因及解决方案',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='错误信息表';

/*Data for the table `sys_errorinfor` */

/*Table structure for table `sys_goodsandservicestax` */

DROP TABLE IF EXISTS `sys_goodsandservicestax`;

CREATE TABLE `sys_goodsandservicestax` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(16) DEFAULT NULL COMMENT '编码',
  `mergecoding` varchar(40) DEFAULT NULL COMMENT '合并编码',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `explains` varchar(200) DEFAULT NULL COMMENT '说明',
  `taxrate` decimal(18,2) DEFAULT NULL COMMENT '税率',
  `addedtaxmanagement` int(11) DEFAULT NULL COMMENT '增值税管理',
  `addedtaxpolicy` varchar(800) DEFAULT NULL COMMENT '增值税政策',
  `addedtaxspecial` varchar(10) DEFAULT NULL COMMENT '增值税特殊',
  `consumptiontaxadministration` int(11) DEFAULT NULL COMMENT '消费税管理',
  `consumptiontaxpolicy` varchar(800) DEFAULT NULL COMMENT '消费税政策',
  `specialconsumptiontax` varchar(10) DEFAULT NULL COMMENT '消费税特殊',
  `keyword` varchar(200) DEFAULT NULL COMMENT '关键字',
  `statisticalofficecode` varchar(100) DEFAULT NULL COMMENT '统计局编码',
  `summaryitem` varchar(5) DEFAULT NULL COMMENT '汇总项',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_goodsandservicestax` */

/*Table structure for table `sys_invoicetype` */

DROP TABLE IF EXISTS `sys_invoicetype`;

CREATE TABLE `sys_invoicetype` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `classname` varchar(40) DEFAULT NULL COMMENT '类别名称',
  `classcode` varchar(16) DEFAULT NULL COMMENT '类别代码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `sys_invoicetype` */

insert  into `sys_invoicetype`(`id`,`classname`,`classcode`) values (1,'增值税专用发票','1100044140'),(2,'增值税普通发票','1100111650'),(3,'电子增值税普通发票','111011096356'),(4,'增值税普通发票（卷票）','111011029600'),(5,'货物运输业增值税专用发票','1101107100'),(6,'机动车销售统一发票','111011015600');

/*Table structure for table `sys_originplace` */

DROP TABLE IF EXISTS `sys_originplace`;

CREATE TABLE `sys_originplace` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `placename` varchar(40) DEFAULT NULL COMMENT '产地名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产地';

/*Data for the table `sys_originplace` */

/*Table structure for table `sys_purchaseunits` */

DROP TABLE IF EXISTS `sys_purchaseunits`;

CREATE TABLE `sys_purchaseunits` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(16) DEFAULT NULL COMMENT '编码',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `simplecode` varchar(6) DEFAULT NULL COMMENT '简码',
  `taxpayeridentificationnumber` varchar(20) DEFAULT NULL COMMENT '纳税人识别号',
  `telephone` varchar(18) DEFAULT NULL COMMENT '地址电话',
  `bankaccount` varchar(19) DEFAULT NULL COMMENT '银行账号',
  `organizationcode` varchar(20) DEFAULT NULL COMMENT '身份证号码/组织机构代码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `sys_purchaseunits` */

insert  into `sys_purchaseunits`(`id`,`code`,`name`,`simplecode`,`taxpayeridentificationnumber`,`telephone`,`bankaccount`,`organizationcode`) values (2,'001','北京畅联电子','','110101123123123','海淀区杏石路','',''),(3,'001','北京','','110101234234234','北京市朝阳区','','');

/*Table structure for table `sys_receive` */

DROP TABLE IF EXISTS `sys_receive`;

CREATE TABLE `sys_receive` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(16) DEFAULT NULL COMMENT '编码',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `simplecode` varchar(6) DEFAULT NULL COMMENT '简码',
  `dutyparagraph` varchar(20) DEFAULT NULL COMMENT '税号',
  `telephone` varchar(18) DEFAULT NULL COMMENT '地址电话',
  `bankaccount` varchar(19) DEFAULT NULL COMMENT '银行账号',
  `mailingaddress` varchar(40) DEFAULT NULL COMMENT '邮件地址',
  `remarks` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `sys_receive` */

insert  into `sys_receive`(`id`,`code`,`name`,`simplecode`,`dutyparagraph`,`telephone`,`bankaccount`,`mailingaddress`,`remarks`) values (1,'001','张三',NULL,'110011178103','广州','6680781021035',NULL,NULL);

/*Table structure for table `sys_record` */

DROP TABLE IF EXISTS `sys_record`;

CREATE TABLE `sys_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` int(11) DEFAULT NULL COMMENT '用户ID',
  `operatime` datetime DEFAULT NULL COMMENT '操作时间',
  `operatcontent` varchar(100) DEFAULT NULL COMMENT '操作内容',
  `login_ip` varchar(30) DEFAULT NULL COMMENT '登陆IP',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统日志';

/*Data for the table `sys_record` */

/*Table structure for table `sys_taxauthority` */

DROP TABLE IF EXISTS `sys_taxauthority`;

CREATE TABLE `sys_taxauthority` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `departmentcode` varchar(20) DEFAULT NULL COMMENT '税务机关代码',
  `departmentname` varchar(100) DEFAULT NULL COMMENT '税务机关名称',
  `content` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='税务机关';

/*Data for the table `sys_taxauthority` */

/*Table structure for table `sys_taxitem` */

DROP TABLE IF EXISTS `sys_taxitem`;

CREATE TABLE `sys_taxitem` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `taxcategory` varchar(16) DEFAULT NULL COMMENT '税种',
  `code` varchar(16) DEFAULT NULL COMMENT '编码',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `taxrate` varchar(16) DEFAULT NULL COMMENT '税率',
  `percentagecharges` decimal(18,2) DEFAULT NULL COMMENT '征收率',
  `nonauthorizedmark` tinyint(1) DEFAULT NULL COMMENT '非核定标志',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `sys_taxitem` */

insert  into `sys_taxitem`(`id`,`taxcategory`,`code`,`name`,`taxrate`,`percentagecharges`,`nonauthorizedmark`) values (1,'01','0101','卷烟','17%','0.06',0),(2,'01','0102','雪茄烟','17%','0.06',0),(3,'01','0103','烟丝','17%','0.06',0),(4,'01','0104','烟叶','17%','0.06',0),(5,'01','0109','其他烟草加工业','17%','0.06',0),(6,'01','0201','白酒','17%','0.06',0),(7,'01','0202','黄酒','17%','0.06',0),(8,'01','0203','啤酒','17%','0.06',0),(9,'01','0204','其他酒','17%','0.06',0),(10,'01','0205','酒精','17%','0.06',0),(11,'01','0206','饮料','17%','0.06',0),(12,'01','0207','茶','17%','0.06',0),(13,'01','0301','粮食、饲料','17%','0.06',0),(14,'01','0302','食用植物油','17%','0.06',0),(15,'01','0303','糖','17%','0.06',0);

/*Table structure for table `sys_ticketspecification` */

DROP TABLE IF EXISTS `sys_ticketspecification`;

CREATE TABLE `sys_ticketspecification` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `specifications` varchar(40) DEFAULT NULL COMMENT '卷票规格',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `sys_ticketspecification` */

insert  into `sys_ticketspecification`(`id`,`specifications`) values (1,'76mm*177mm'),(2,'76mm*152mm'),(3,'76mm*127mm'),(4,'57mm*177mm'),(5,'57mm*152mm'),(6,'57mm*127mm'),(7,'76mm*177mm(北京)'),(8,'76mm*177mm(上海)'),(9,'76mm*177mm(黑龙江)');

/*Table structure for table `sys_vehicle` */

DROP TABLE IF EXISTS `sys_vehicle`;

CREATE TABLE `sys_vehicle` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(16) DEFAULT NULL COMMENT '编码',
  `vehicletype` varchar(40) DEFAULT NULL COMMENT '车辆类型',
  `simplecode` varchar(6) DEFAULT NULL COMMENT '简码',
  `brandmodel` varchar(44) DEFAULT NULL COMMENT '厂牌型号',
  `originplace` varchar(32) DEFAULT NULL COMMENT '产地',
  `enterprisename` varchar(80) DEFAULT NULL COMMENT '生产企业名称',
  `taxtypecode` varchar(16) DEFAULT NULL COMMENT '税收分类编码',
  `taxtypename` varchar(16) DEFAULT NULL COMMENT '税收分类名称',
  `policytype` int(11) DEFAULT NULL COMMENT '优惠政策类型',
  `enjoypolicies` tinyint(1) DEFAULT NULL COMMENT '享受优惠政策',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `sys_vehicle` */

insert  into `sys_vehicle`(`id`,`code`,`vehicletype`,`simplecode`,`brandmodel`,`originplace`,`enterprisename`,`taxtypecode`,`taxtypename`,`policytype`,`enjoypolicies`) values (1,'002','摩托车','','','','','109017945','摩托车、排气管',NULL,0);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(32) DEFAULT NULL COMMENT '用户名',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `certificatepassword` varchar(32) DEFAULT NULL COMMENT '证书口令',
  `ifdisable` tinyint(1) DEFAULT NULL COMMENT '禁用否',
  `firstlogin` tinyint(1) DEFAULT NULL COMMENT '首次登录',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`certificatepassword`,`ifdisable`,`firstlogin`) values (1,'admin','123','RGB456',0,1),(2,'sa','123','LGP789',0,1);

/*Table structure for table `user_infor` */

DROP TABLE IF EXISTS `user_infor`;

CREATE TABLE `user_infor` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` int(11) DEFAULT NULL COMMENT '用户ID',
  `businesstax` varchar(15) DEFAULT NULL COMMENT '企业税号',
  `enterprisename` varchar(100) DEFAULT NULL COMMENT '企业名称',
  `billingNo` int(11) DEFAULT NULL COMMENT '开票机号',
  `days` int(11) DEFAULT NULL COMMENT '提前天数',
  `expiredprompt` tinyint(1) DEFAULT NULL COMMENT '过期提示',
  `installversion` varchar(40) DEFAULT NULL COMMENT '安装版本',
  `operationtime` date DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `user_infor` */

insert  into `user_infor`(`id`,`userid`,`businesstax`,`enterprisename`,`billingNo`,`days`,`expiredprompt`,`installversion`,`operationtime`) values (1,1,'1101017102','长沙钢铁厂',0,30,1,'2.0.1.9','2016-10-08'),(2,2,'1101011034','成都高科技产业园',0,20,1,'2.0.7.6','2016-11-08');

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` int(11) DEFAULT NULL COMMENT '用户ID',
  `rid` int(11) DEFAULT NULL COMMENT '权限ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限表';

/*Data for the table `user_role` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
