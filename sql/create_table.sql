-- auto-generated definition
create table user
(
    id          bigint auto_increment comment 'id'
        primary key,
    username    varchar(256)                       null comment '用户名',
    userAccount varchar(256)                       not null comment '账号',
    avatarUrl   varchar(1024)                      null comment '用户头像',
    gender      tinyint                            null comment '性别',
    password    varchar(256)                       not null comment '密码',
    phone       varchar(256)                       null comment '手机号',
    email       varchar(512)                       null comment '邮箱',
    userStatus  int      default 0                 not null comment ' 用户状态 0-正常',
    createTime  datetime default CURRENT_TIMESTAMP null comment '创建时间',
    updateTime  datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete    tinyint  default 0                 not null comment '逻辑删除',
    userRole    int      default 0                 not null comment '用户角色 0-普通用户 1-管理员',
    planetCode  varchar(256)                       null comment '星球编号'
)
    comment '用户表';

