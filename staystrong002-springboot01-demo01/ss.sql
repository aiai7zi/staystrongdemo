create table t_user(
  user_id int(10)  not null  primary key auto_increment,
  username varchar(50) not null unique comment '用户名',
  `password` varchar(50) not null comment '密码',
   salt  varchar(50) comment '盐'
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
create table t_role(
   role_id int(10)  not null  primary key auto_increment,
   role_name varchar(50) not null comment '角色名'

)ENGINE=InnoDB DEFAULT CHARSET=utf8;
create table t_permission(
   permission_id int(10)  not null  primary key auto_increment,
   permission_name varchar(50) not null comment '权限名'
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
create table user_role(
  user_id int(10) not null  comment '用户id',
  role_id int(10) not null  comment '角色id',
  primary key(user_id,role_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
create table role_permission(
   role_id int(10) not null  comment '角色id',
   permission_id int(10) not null comment '权限id',
   primary key(role_id,permission_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;