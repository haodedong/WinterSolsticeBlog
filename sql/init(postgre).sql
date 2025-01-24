create table if not exists article
(
    id          serial
    primary key,
    title       varchar(200)                       not null,
    content     text                               not null,
    summary     varchar(100)                       null,
    category_id int                                null,
    author_id   int                                not null,
    created_at  timestamp default CURRENT_TIMESTAMP null,
    updated_at  timestamp default CURRENT_TIMESTAMP null
    );

comment on table article is '博客文章表';
comment on column article.title is '标题';
comment on column article.content is '内容';
comment on column article.summary is '博客摘要，如为传递，则中正文中截取开头一段';
comment on column article.category_id is '分类ID,一篇文章只允许属于一个分类';
comment on column article.author_id is '作者ID';
comment on column article.created_at is '创建时间';
comment on column article.updated_at is '更新时间';

create table if not exists article_tag
(
    id         serial
    primary key,
    article_id int not null,
    tag_id     int not null,
    constraint article_id_tag_id_index
    unique (article_id, tag_id)
    );

comment on table article_tag is '文章与标签关联关系表';
comment on column article_tag.article_id is '文章ID';
comment on column article_tag.tag_id is '标签ID';

create table if not exists category
(
    id          serial
    primary key,
    name        varchar(60)  not null,
    description varchar(100) null
    );

comment on table category is '博客分类表';
comment on column category.id is '分类ID';
comment on column category.name is '分类名称';
comment on column category.description is '分类描述';

create table if not exists comment
(
    id         serial
    primary key,
    content    text                                not null,
    article_id int                                 not null,
    user_id    int                                 not null,
    created_at timestamp default CURRENT_TIMESTAMP null
);

comment on table comment is '博客评论表';
comment on column comment.content is '内容';
comment on column comment.article_id is '文章ID';
comment on column comment.user_id is '用户ID';
comment on column comment.created_at is '创建时间';

create table if not exists tag
(
    id       serial
    primary key,
    tag_name varchar(20) null,
    constraint id
    unique (id)
    );

comment on table tag is '博客标签表';
comment on column tag.tag_name is '标签名称';

create table if not exists "user"
(
    id         serial
    primary key,
    username   varchar(50)                         not null,
    password   varchar(100)                        not null,
    email      varchar(100)                        not null,
    created_at timestamp default CURRENT_TIMESTAMP null
    );

comment on table "user" is '用户表';
comment on column "user".username is '用户名';
comment on column "user".password is '密码';
comment on column "user".email is '邮箱';
comment on column "user".created_at is '创建时间';