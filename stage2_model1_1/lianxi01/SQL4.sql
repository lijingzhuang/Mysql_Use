CREATE DATABASE lianxi02 DEFAULT CHARACTER SET utf8;
/*讲师表
		讲师ID 主键 int类型
		讲师姓名 VARCHAR类型
		讲师简介 VARCHAR类型
		讲师级别 char类型 高级讲师&首席讲师
		为讲师姓名添加索引
*/
CREATE TABLE teacher(
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(20),
	intro VARCHAR(50),
	LEVEL CHAR(20)
);
ALTER TABLE teacher DEFAULT CHARACTER SET utf8;		
ALTER TABLE teacher ADD INDEX index_teacher_name(NAME);
INSERT INTO teacher(id,NAME,intro,LEVEL) VALUES (1, '刘德华', '毕业于清华大学，主攻前端技术,授课风格生动活泼,深受学员喜爱', '高级讲师');
INSERT INTO teacher(id,NAME,intro,LEVEL) VALUES (2, '郭富城', '毕业于北京大学，多年的IT经验，研发多项Java课题,授课经验丰富', '首席讲师'); 
/*
课程分类表
		课程分类ID 主键 int类型
		课程分类名称 VARCHAR类型 比如前端开发 后端开发 数据库DBA......
		课程分类描述 VARCHAR类型 
		创建时间 datetime类型
		更新时间 datetime类型
		
*/
CREATE TABLE lagou_subject(
	subject_id INT PRIMARY KEY AUTO_INCREMENT,
	subject_name VARCHAR(50),
	subject_descp VARCHAR(50),
	create_time DATETIME,
	update_time DATETIME
);
INSERT INTO lagou_subject VALUES (1, '后端开发', '后端课程包括 Java PHP Python', '2020-03-27 00:44:04', '2020-03-27 00:44:04');
INSERT INTO lagou_subject VALUES (2, '前端开发', '前端课程包括 JQuery VUE angularJS', '2020-02-27 10:00:04', '2020-02-27 18:44:04');
/*课程表
		课程ID 主键 int类型
		课程讲师ID 外键 用于描述课程的授课老师
		课程分类ID 外键 用于描述课程所属的分类 比如 Java课程就属于后端分类
		课程标题 VARCHAR类型 比如Java VUE PHP ......
		总课时 int类型 
		浏览数量 bigint类型
		课程状态 char 类型,  0 未发布(默认)  1 已发布
		为 课程标题字段添加索引
		为 teacher_id & subject_id,添加外键约束
*/
CREATE TABLE lagou_course(
	course_id INT PRIMARY KEY AUTO_INCREMENT,
	teacher_id INT,
	subject_id INT,
	course_title VARCHAR(50),
	all_class INT,
	browse_num BIGINT,
	course_sta CHAR(2)
);
ALTER TABLE lagou_course ADD fk_course_teacher FOREIGN KEY(teacher_id) REFERENCES teacher(id);
ALTER TABLE lagou_course ADD fk_course_subject FOREIGN KEY(subject_id) REFERENCES SUBJECT(subject_id);

INSERT INTO lagou_course VALUES (1,1,1 ,'Java', 300,250000, '1');
INSERT INTO lagou_course VALUES (2,2,2, 'VUE', 400,200000,'1');

#查询刘德华老师所教的课程属于哪个课程分类
SELECT 
	*
FROM lagou_course
WHERE(SELECT NAME FROM teacher WHERE NAME = '刘德华');
