use page_object;

CREATE TABLE IF NOT EXISTS page_info(

p_id INT not null AUTO_INCREMENT PRIMARY key COMMENT '页面id',

p_name VARCHAR(255) COMMENT '包名',

p_object_name VARCHAR(255) COMMENT '页面对象名',

p_value VARCHAR(255) COMMENT '页面对象URL(基路径之后)',

p_desc VARCHAR(255) comment '页面对象中文描述'

)ENGINE = INNODB default charset= 'utf8';



-- 控件对象


CREATE TABLE IF NOT EXISTS locator_info(

l_id INT not null AUTO_INCREMENT PRIMARY key COMMENT '控件id',

l_name VARCHAR(255) COMMENT '元素控件名字',

l_desc VARCHAR(255) COMMENT '元素中文名称',

l_type VARCHAR(255) COMMENT '定位方式',

l_value VARCHAR(255) comment '元素定位信息，如果是id,name,class，linktext直接把网页元素对应的这些属性值写上即可，如果是xpath定位方式，需要填写正确的xpath语法格式',

l_timeout int not null COMMENT '元素加载时间',

p_id int not null COMMENT '页面中空间对象id'

)ENGINE = INNODB default charset= 'utf8';