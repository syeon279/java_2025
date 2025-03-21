# 1. rdb : 관계형 데이터 베이스  - 테이블(Entity)들의 관계(Relationship) 외래키(Attribute)
# 2. 데이터 베이스 언어
# 정의어 DDL - create, alter, drop 
# 조작어 DML - insert, select, update, delete - crud 
# 제어어 DCL - grant, revoke 

# 실습1) insert
use mbasic;
show tables;
desc userinfo;

# 1-1 구조와 순서를 알고 있을 때 
/*
mysql> desc userinfo;
+-------+--------------+------+-----+---------+----------------+
| Field | Type         | Null | Key | Default | Extra          |
+-------+--------------+------+-----+---------+----------------+
| no    | int          | NO   | PRI | NULL    | auto_increment |
| name  | varchar(100) | NO   |     | NULL    |                |
| age   | int          | NO   |     | NULL    |                |
+-------+--------------+------+-----+---------+----------------+
3 rows in set (0.00 sec)
DML : insert, select, update, delete
*/
insert into userinfo values (1, 'first',11);
insert into userinfo values ('second',22,2); # 필드 순서 안맞음 
#Error Code: 1366. Incorrect integer value: 'second' for column 'no' at row 1	0.000 sec
select * from userinfo;

#1-2 원하는 필드만 데이터 입력
insert into userinfo (name, age) values ('second', 22);
#1 row(s) affected
select * from userinfo;

insert into userinfo (age, name) values (33, 'third');
select * from userinfo;

show tables;
select * from emp;
insert into emp values (7369, 'SMITH', 'CLERK', 7902,' 1980-12-17' , 800, 20);
insert into emp (empno, ename, job, mgr, hiredate, sal, deptno) values (7369, 'SMITH', 'CLERK', 7902, '1980-12-17' , 800 , 20);
insert into emp (empno, ename, job, mgr, hiredate, sal, comm, deptno) values ( 7499 , 'ALLEN', 'SALESMAN', 7698 , '1981-02-20' , 1600 ,300, 30);
insert into emp (empno, ename, job, mgr, hiredate, sal, comm, deptno) values ( 7521 , 'WARD', 'SALESMAN', 7698 , '1981-02-22' , 1250, 500, 30);
insert into emp (empno, ename, job, mgr, hiredate, sal, deptno) values ( 7566 , 'JONES', 'MANAGER', 7839 , '1981-04-02' , 2975 , 20);
insert into emp (empno, ename, job, mgr, hiredate, sal, comm, deptno) values ( 7654 , 'MARTIN', 'SALESMAN ', 7698 , '1981-09-28' , 1250, 1400 , 30);
insert into emp (empno, ename, job, mgr, hiredate, sal, deptno) values ( 7698 , 'BLAKE', 'MANAGER ', 7839 , '1981-05-01' , 2850 , 30);
insert into emp (empno, ename, job, mgr, hiredate, sal, deptno) values ( 7782 , ' CLARK', 'MANAGER', 7839 , '1981-06-09' , 2450 , 10 );
insert into emp (empno, ename, job, mgr, hiredate, sal, deptno) values ( 7788 , ' SCOTT', 'ANALYST', 7566 , '1987-04-19' , 3000 , 20 );
desc emp;
select * from emp;
insert into emp (empno, ename, job, hiredate, sal, deptno) values ( 7839 , 'KING', 'PRESIDENT',  '1981-11-17' , 5000 , 10 );
insert into emp (empno, ename, job, mgr, hiredate, sal, comm, deptno) values ( 7844 , 'TURNER', 'SALESMAN', 7698 , '1981-09-08' , 1500 , 0 ,  30);
insert into emp (empno, ename, job, mgr, hiredate, sal, deptno) values ( 7900 , 'JAMES', 'CLERK', 7698 , ' 1981-12-03 ' , 950 , 30 );
insert into emp (empno, ename, job, mgr, hiredate, sal, deptno) values ( 7934 , 'MILLER', 'CLERK', 7782 , ' 1982-01-23 ' , 1300 , 10 );
select * from emp;
select * from dept;
insert into dept values (10,  'ACCOUNTING', ' NEW YORK ');
insert into dept values (20 ,  'RESEARCH    ', ' DALLAS ');
insert into dept values (30,  ' SALES ', ' CHICAGO ');
insert into dept values (40,  ' OPERATIONS ', ' BOSTON');
select * from dept;

select * from salagrade;

insert into salagrade values (  1,   700,  1200);
insert into salagrade values (  2,   1201 , 1400 );
insert into salagrade values (  3,   1401 , 2000 );
insert into salagrade values (  4,   2001 ,  3000 );
insert into salagrade values (  5,  3001 ,  9999 );
select * from salagrade;
select * from emp;

select * from userinfo;
insert into userinfo values (4, 'fourth', 44);

# 조작어 DML - insert, select, update
# 실습2) update
/*
update 테이블명
set 필드1= 값, 필드2 = 값
whrer 조건
*/

#2-1 전체데이터 수정
set sql_safe_updates =0;
update userinfo set age=0;
# 0	58	11:09:52	update userinfo set age=0	Error Code: 1175. You are using safe update mode and you tried to update a table without a WHERE that uses a KEY column. 
 # To disable safe mode, toggle the option in Preferences -> SQL Editor and reconnect.	0.000 sec
 
 #2-2. 바꿀 데이터 여러개
 update userinfo set age = 11 where no=1;
 update userinfo set age = 22, name = 'two' where no=2;
 update userinfo set name = 'second' where no=2 and age=22;
 
# - no가 3이고 age가 10인  유저의 이름을 'third' , 나이를 33살로 수정합니다.
# - no가 4이고 name 'first'인  유저의 이름을 'fourth' , 나이를 44살로 수정합니다.
 
 update userinfo set age = 10 where name = 'third';
 update userinfo set name = 'third', age=33 where no=3 and age=10;
 update userinfo set name = 'first' where no =4 and name = 'fourth';
 update userinfo set name = 'fourth', age=44 where no=4 and name='first';
 ## 조건이 맞지 않으면 실행은 되지만 반영되지 않음. 
 
 #2-3 연습문제 
select * from score;
insert into score values (1, 'aaa', 100, 100, 100, 100, null, null, null);
insert into score values (2, 'bbb', 90, 98, 88, 100, null, null, null);
insert into score values (3, 'ccc', 70, 20, 78, 80, null, null, null);
insert into score values (4, 'ddd', 78, 89, 68, 98, null, null, null);
insert into score values (5, 'abc', 89, 98, 69, 77, null, null, null);
# 이름이 ccc인 사람의 sjava = 90, sjsp = 90, sspring=90으로 수정하기
update score set sjava =90, sjsp = 90, sspring=90 where sname = 'ccc';

#모든 학생의 semail의 값을 admin@gmail.com으로 수정하기
set sql_safe_updates =0;
update score set semail='admin@gmail.com';
set sql_safe_updates =1;

#모든 성적의 총합을 계산해서 넣기
update score set sstotal = sjava + sjsp + sspring + sproject;

# 성적의 평균 계산하기 
update score set ssavg = sstotal/4;

# 성적의 평균이 ssavg 100 점인 학생의 email을 first@gamil.com으로 수정하기 
update score set semail='first@gmail.com' where ssavg = 100;

# 이름이 bbb인 학생의 점수를 92, 78 총점, 평균을 수정하기
update score set sjava = 92, sjsp = 78 where sname = 'bbb';
update score set sstotal = sjava + sjsp + sspring + sproject, ssavg= sstotal/4;

# 성적의 평균이 89.5점인 학생의 이메일을 second@gmail.com으로, 이름을 second로 수정하기  
alter table score modify ssavg double;
select * from score;
update score set semail='second@gmail.com', sname = 'second' where ssavg = 89.5;
update score set semail='ccc@gmail.com' where sname = 'ccc';
update score set semail='blackstudent@gmail.com' where sproject <80;
update score set semail='hello@gmail.com' where ssavg = 89.5 and sproject = 98;
## 조건식에 맞는 데이터가 없어서 수정이 안됨. 


# 실습3) delete
/*
delete from 테이블명
where 조건식 
*/
create table userinfo_delete select * from userinfo;
alter table userinfo_delete add primary key(no);
alter table userinfo_delete modify no int not null auto_increment;
desc userinfo_delete;
select * from userinfo_delete;

# 3-1 age가 11인 유저 삭제
delete from userinfo_delete where age=11;
select * from userinfo_delete;

# 이름이 second이고 나이가 22살인 유저 
delete from userinfo_delete where name='second' and age=22;

# 전체 데이터 삭제 
delete from userinfo_delete;

# 3-2 연습 문제
create table emp_del select * from emp;
select * from emp_del;
/*
[001] [TABLE : delete_emp] (직책(JOB)이  'SALESMAN'인 데이터를 삭제하시오.  ) 

[002] [TABLE : delete_emp] (직책(JOB)이  'MANAGER'이고  이름(ENAME)이 'JONES'인 데이터를 삭제하시오.  ) 

[003] [TABLE : delete_emp] (delete_emp 테이블의 모든 데이터를 삭제하시오. ) 
*/
delete from emp_del where job = 'SALESMAN';

delete from emp_del where job='MANAGER' and ename = 'JONES';

delete from emp_del;
