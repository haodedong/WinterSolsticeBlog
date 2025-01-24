create table if not exists article
(
    id          int auto_increment
    primary key,
    title       varchar(200)                       not null comment '标题',
    content     text                               not null comment '内容',
    summary     varchar(100)                       null comment '博客摘要，如为传递，则中正文中截取开头一段',
    category_id int                                null comment '分类ID,一篇文章只允许属于一个分类',
    author_id   int                                not null comment '作者ID',
    created_at  datetime default CURRENT_TIMESTAMP null comment '创建时间',
    updated_at  datetime default CURRENT_TIMESTAMP null comment '更新时间'
    )
    comment '博客文章表';

create table if not exists article_tag
(
    id         int auto_increment
    primary key,
    article_id int not null comment '文章ID',
    tag_id     int not null comment '标签ID',
    constraint article_id_tag_id_index
    unique (article_id, tag_id)
    )
    comment '文章与标签关联关系表';

create table if not exists category
(
    id          int auto_increment comment '分类ID'
    primary key,
    name        varchar(60)  not null comment '分类名称',
    description varchar(100) null comment '分类描述'
    )
    comment '博客分类表';

create table if not exists comment
(
    id         int auto_increment
    primary key,
    content    text                                not null comment '内容',
    article_id int                                 not null comment '文章ID',
    user_id    int                                 not null comment '用户ID',
    created_at timestamp default CURRENT_TIMESTAMP null comment '创建时间'
)
    comment '博客评论表';

create table if not exists tag
(
    id       int auto_increment
    primary key,
    tag_name varchar(20) null comment '标签名称',
    constraint id
    unique (id)
    )
    comment '博客标签表';

create table if not exists user
(
    id         int auto_increment
    primary key,
    username   varchar(50)                         not null comment '用户名',
    password   varchar(100)                        not null comment '密码',
    email      varchar(100)                        not null comment '邮箱',
    created_at timestamp default CURRENT_TIMESTAMP null comment '创建时间'
    )
    comment '用户表';

