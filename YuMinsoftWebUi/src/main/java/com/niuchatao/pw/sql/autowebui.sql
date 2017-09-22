

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for case_info
-- ----------------------------
DROP TABLE IF EXISTS `case_info`;
CREATE TABLE `case_info` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用例编号id',
  `c_name` varchar(255) DEFAULT NULL COMMENT '用例名称',
  `c_desc` varchar(255) DEFAULT NULL COMMENT '用例中文名称',
  `c_checkPort` varchar(255) DEFAULT NULL COMMENT '用例的检查点',
  `c_precondition` varchar(255) DEFAULT NULL COMMENT '用例前置条件',
  `m_id` int(11) NOT NULL COMMENT '模块对象id',
  `c_expected` varchar(255) DEFAULT NULL COMMENT '用例预期结果',
  `c_enforcement` varchar(255) DEFAULT NULL COMMENT '用例执行结果',
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用例对象数据表';

-- ----------------------------
-- Records of case_info
-- ----------------------------

-- ----------------------------
-- Table structure for locator_info
-- ----------------------------
DROP TABLE IF EXISTS `locator_info`;
CREATE TABLE `locator_info` (
  `l_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '控件id',
  `l_name` varchar(255) DEFAULT NULL COMMENT '元素控件名字',
  `l_desc` varchar(255) DEFAULT NULL COMMENT '元素中文名称',
  `l_type` varchar(255) DEFAULT NULL COMMENT '定位方式',
  `l_value` varchar(255) DEFAULT NULL COMMENT '元素定位信息，如果是id,name,class，linktext直接把网页元素对应的这些属性值写上即可，如果是xpath定位方式，需要填写正确的xpath语法格式',
  `l_timeout` int(11) DEFAULT NULL COMMENT '元素加载时间',
  `p_id` int(11) NOT NULL COMMENT '页面id',
  `l_function` varchar(255) NOT NULL,
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  PRIMARY KEY (`l_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of locator_info
-- ----------------------------
INSERT INTO `locator_info` VALUES ('1', '账户登录', '账户登录', 'xpath', '//a[text()=\'账户登录\']', '3', '1', 'text', null, null);
INSERT INTO `locator_info` VALUES ('2', '用户名输入框', '用户名', 'id', 'username', '3', '1', 'type', null, null);
INSERT INTO `locator_info` VALUES ('3', '密码输入框', '密码', 'id', 'password', '3', '1', 'type', null, null);
INSERT INTO `locator_info` VALUES ('4', '登录按钮', '登录', 'id', 'login_form', '3', '1', 'submit', null, null);
INSERT INTO `locator_info` VALUES ('5', '标题类', '菜单栏', 'id', 'nbiaoqian', '3', '2', 'click', null, null);

-- ----------------------------
-- Table structure for model_info
-- ----------------------------
DROP TABLE IF EXISTS `model_info`;
CREATE TABLE `model_info` (
  `m_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '模块ID',
  `m_name` varchar(255) DEFAULT NULL COMMENT '模块名称',
  `m_desc` varchar(255) DEFAULT NULL COMMENT '模块中文名称',
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  PRIMARY KEY (`m_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='模块管理表数据表';

-- ----------------------------
-- Records of model_info
-- ----------------------------

-- ----------------------------
-- Table structure for page_info
-- ----------------------------
DROP TABLE IF EXISTS `page_info`;
CREATE TABLE `page_info` (
  `p_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '页面id',
  `p_name` varchar(255) DEFAULT NULL COMMENT '包名',
  `p_object_name` varchar(255) DEFAULT NULL COMMENT '页面对象名',
  `p_value` varchar(255) DEFAULT NULL COMMENT '页面对象URL(基路径之后)',
  `p_desc` varchar(255) DEFAULT NULL COMMENT '页面对象中文描述',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `updatetime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of page_info
-- ----------------------------
INSERT INTO `page_info` VALUES ('1', 'org.yumin.zengDaWebUI.pageObject', 'LoginPage', null, '改造录单系统登录页面', '2017-09-21 09:26:32', '2017-09-21 09:26:35');
INSERT INTO `page_info` VALUES ('2', 'org.yumin.zengDaWebUI.pageObject', 'ApplyLoanPage', null, '申请信息页面', '2017-09-21 09:26:40', '2017-09-21 09:26:43');

-- ----------------------------
-- Table structure for step_info
-- ----------------------------
DROP TABLE IF EXISTS `step_info`;
CREATE TABLE `step_info` (
  `s_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '步骤编号id',
  `s_name` varchar(255) DEFAULT NULL COMMENT '步骤名称',
  `s_date` varchar(255) DEFAULT NULL COMMENT '使用数据值',
  `c_id` int(11) NOT NULL COMMENT '用例编号id',
  `p_id` int(11) NOT NULL COMMENT '页面编号id',
  `s_num` int(11) DEFAULT NULL COMMENT '步骤排序号',
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='步骤管理数据表';

-- ----------------------------
-- Records of step_info
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `pwd` varchar(255) DEFAULT NULL COMMENT '用户名密码',
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='平台用户管理页面';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'boby', '1be072a78f3801f2f2b6318125a1175e', null, null);
INSERT INTO `user` VALUES ('2', '刘正涛', '1be072a78f3801f2f2b6318125a1175e', null, null);
INSERT INTO `user` VALUES ('12', 'admin', '21232f297a57a5a743894a0e4a801fc3', null, null);
INSERT INTO `user` VALUES ('13', 'root', '63a9f0ea7bb98050796b649e85481845', null, null);
INSERT INTO `user` VALUES ('15', 'dfere', '240fd687eed3407977069156594db53a', null, null);
