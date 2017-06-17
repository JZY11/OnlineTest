DROP DATABASE IF EXISTS db_onlineTest;
CREATE DATABASE db_onlineTest;

DROP TABLE IF EXISTS db_onlineTest.student;
CREATE TABLE db_onlineTest.student(
  id INT AUTO_INCREMENT PRIMARY KEY COMMENT 'ID PK',
  name VARCHAR(255) NOT NULL COMMENT '学生姓名',
  password VARCHAR(255) COMMENT '密码'
)COMMENT '学生表';

DROP TABLE IF EXISTS db_onlineTest.paper;
CREATE TABLE db_onlineTest.paper(
  id INT AUTO_INCREMENT PRIMARY KEY COMMENT 'ID PK',
  title VARCHAR(255) COMMENT '试卷名称'
)COMMENT '试卷表';

DROP TABLE IF EXISTS db_onlineTest.test;
CREATE TABLE db_onlineTest.test(
  id INT AUTO_INCREMENT PRIMARY KEY COMMENT 'ID PK',
  question VARCHAR(255) COMMENT '题目',
  answer VARCHAR(255) COMMENT '答案',
  score INT COMMENT '分数',
  paperId INT COMMENT 'FK'
)COMMENT '试题表';

DROP TABLE IF EXISTS db_onlineTest.student_test;
CREATE TABLE db_onlineTest.student_test(
  id INT AUTO_INCREMENT PRIMARY KEY COMMENT '',
  studentId INT COMMENT '',
  testId INT COMMENT '',
  
)