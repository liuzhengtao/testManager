-- --------------------用户管理数据表-----------------------------


CREATE TABLE IF NOT EXISTS `user`(

`id` INT not null AUTO_INCREMENT PRIMARY key COMMENT '用户id',

`name` VARCHAR(255) COMMENT '用户名',

`pwd` VARCHAR(255) COMMENT '用户名密码'

)ENGINE = INNODB default charset= 'utf8' COMMENT '平台用户管理页面';