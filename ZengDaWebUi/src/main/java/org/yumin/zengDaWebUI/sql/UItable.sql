use page_object;

-- ----------------页面对象数据表---------------------------------

CREATE TABLE IF NOT EXISTS page_info(

p_id INT not null AUTO_INCREMENT PRIMARY key COMMENT '页面id',

p_name VARCHAR(255) COMMENT '包名',

p_object_name VARCHAR(255) COMMENT '页面对象名',

p_value VARCHAR(255) COMMENT '页面对象URL(基路径之后)',

p_desc VARCHAR(255) comment '页面对象中文描述',

p_locator_id int not null COMMENT '页面中空间对象id'

)ENGINE = INNODB default charset= 'utf8';



-- ----------------控件对象数据表---------------------------------


CREATE TABLE IF NOT EXISTS locator_info(

l_id INT not null AUTO_INCREMENT PRIMARY key COMMENT '控件id',

l_name VARCHAR(255) COMMENT '元素控件名字',

l_desc VARCHAR(255) COMMENT '元素中文名称',

l_type VARCHAR(255) COMMENT '定位方式',

l_value VARCHAR(255) comment '元素定位信息，如果是id,name,class，linktext直接把网页元素对应的这些属性值写上即可，如果是xpath定位方式，需要填写正确的xpath语法格式',

p_id INT not null COMMENT '页面对象id',

l_timeout int  COMMENT '元素加载时间',

l_function VARCHAR(255) not null COMMENT '控件操作方法'

)ENGINE = INNODB default charset= 'utf8';


-- ----------------用例对象数据表---------------------------------

CREATE TABLE IF NOT EXISTS case_info(

  c_id INT not null AUTO_INCREMENT PRIMARY key COMMENT '用例编号id',

  c_name VARCHAR(255) COMMENT '用例名称',

  c_desc VARCHAR(255) COMMENT '用例中文名称',

  c_checkPort VARCHAR(255) COMMENT '用例的检查点',

  c_precondition VARCHAR(255) comment '用例前置条件',

  p_id INT not null COMMENT '页面对象id',

  c_expected VARCHAR(255)  COMMENT '用例预期结果',

  c_enforcement VARCHAR(255)  COMMENT '用例执行结果'

)ENGINE = INNODB default charset= 'utf8';



-- ----------------模块管理表数据表---------------------------------

CREATE TABLE IF NOT EXISTS model_info(

  m_id INT not null AUTO_INCREMENT PRIMARY key COMMENT '模块ID',

  m_name VARCHAR(255) COMMENT '模块名称',

  m_desc VARCHAR(255) COMMENT '模块中文名称',

  c_id INT not null COMMENT '用例编号id'

)ENGINE = INNODB default charset= 'utf8';


-- ----------------步骤管理数据表---------------------------------

CREATE TABLE IF NOT EXISTS step_info(

  s_id INT not null AUTO_INCREMENT PRIMARY key COMMENT '步骤编号id',

  s_name VARCHAR(255) COMMENT '步骤名称',

  s_date VARCHAR(255) COMMENT '使用数据值',

  c_id  INT NOT NULL COMMENT '用例编号id',

  l_id INT NOT NULL comment '控件编号id',

  s_num INT  COMMENT '步骤排序号'

)ENGINE = INNODB default charset= 'utf8';