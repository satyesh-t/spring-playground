CREATE TABLE COURSE(
 COURSE_ID INT PRIMARY KEY, NAME VARCHAR(255), STUDENT_COUNT INT, START_DATE DATE);

insert into course(course_id,name,student_count,start_date) values(101,'JavaScript',10,now());
insert into course(course_id,name,student_count,start_date) values(102,'Java',100,now());
insert into course(course_id,name,student_count,start_date) values(103,'Springjdbc',40,now());
insert into course(course_id,name,student_count,start_date) values(104,'Spring-Security',70,now());