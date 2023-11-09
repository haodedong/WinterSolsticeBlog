-- 创建用户表
CREATE TABLE users (
                       id INT PRIMARY KEY AUTO_INCREMENT,
                       username VARCHAR(50) NOT NULL COMMENT '用户名',
                       password VARCHAR(100) NOT NULL COMMENT '密码',
                       email VARCHAR(100) NOT NULL COMMENT '邮箱',
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'
);

-- 创建文章表
CREATE TABLE articles (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          title VARCHAR(200) NOT NULL COMMENT '标题',
                          content TEXT NOT NULL COMMENT '内容',
                          category VARCHAR(50) COMMENT '分类',
                          author_id INT NOT NULL COMMENT '作者ID',
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'
);

-- 创建评论表
CREATE TABLE comments (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          content TEXT NOT NULL COMMENT '内容',
                          article_id INT NOT NULL COMMENT '文章ID',
                          user_id INT NOT NULL COMMENT '用户ID',
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'
);