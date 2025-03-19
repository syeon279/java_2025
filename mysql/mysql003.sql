/* ## ■ part001 - 복습문제 
Q1. milk 테이블의 구조는 다음과 같다 
mysql>
mysql> desc milk;
+--------+-------------+------+-----+---------+----------------+
| Field  | Type        | Null | Key | Default | Extra          |
+--------+-------------+------+-----+---------+----------------+
| mno    | int         | NO   | PRI | NULL    | auto_increment |
| mname  | varchar(20) | NO   |     | NULL    |                |
| mprice | int         | NO   |     | NULL    |                |
+--------+-------------+------+-----+---------+----------------+
3 rows in set (0.04 sec)

mysql>
mysql> select * from milk;
+-----+-------+--------+
| mno | mname | mprice |
+-----+-------+--------+
|  1  | white |   1000 |
|  2  | choco |   1200 |
|  3  | banana|   1800 | 
+-----+-------+--------+
6 rows in set (0.03 sec)

  4 , melon ,  5000 데이터를 추가하시오.

 Q2.  no가 4번인 데이터의 mprice를 1500로 변경하시오.

 Q3.  no가 4번이고 name이 melon인데이터를 삭제하시오.

 Q4.  milk 데이터를 출력하시오. 
*/

use mbasic;

create table milk_repeat(mno int not null auto_increment primary key,
mname varchar(20) not null,
mprice int not null
);

show tables;
desc milk;
select * from milk_repeat;

insert into milk_repeat  values (1, 'white', 1000);
insert into milk_repeat values (2, 'choco', 1200);
insert into milk_repeat values (3, 'banana', 1800);
insert into milk_repeat values (4, 'melon', 5000);
## 여러줄 실행 ctrl + shitf + enter
update milk_repeat set mprice=1500 where mno=4;
delete from milk_repeat where mno=4 and mname = 'melon';
select * from milk_repeat;




## ■ part002- 진도 - select basic
## 2-1
show tables;
create table select_userinfo select * from userinfo;
desc select_userinfo;
select * from select_userinfo;
alter table select_userinfo modify no int not null auto_increment primary key;
insert into select_userinfo (name, age) values('first', 55);
insert into select_userinfo (name, age) values('third', 66);

## 2-2
-- 1. 전체 데이터 검색
select * from select_userinfo;
-- 2. 부분검색
select name, age from select_userinfo;
-- 3. 중복제거 
select  distinct name from select_userinfo;
-- 4. 별명 
select name as `이름`, age as `나이` from select_userinfo;
-- 5. where 조건 ( = 같다  !=, <> 다르다 < <= > >=)
select * from select_userinfo where name = 'second';
select * from select_userinfo where name != 'second';
select * from select_userinfo where name <> 'second';

select * from select_userinfo where age <33 ;
select * from select_userinfo where age <=33 ;

select * from select_userinfo where age >33 ;
select * from select_userinfo where age >=33 ;

-- 6. 모든 조건 and, between and /조건 중에  or , in
select * from select_userinfo where age >= 22 and age<=33 ;
select * from select_userinfo where age between 22 and 33;

select * from select_userinfo where age = 22 or age=33;
select * from select_userinfo where age in (22, 33);

alter table select_userinfo modify age int;
desc select_userinfo;

select * from select_userinfo;
insert into select_userinfo (name) values ('seven'); 

-- 7. null 검색 ( is null, is not null, not in, not between) 
## null = 값이 비어있다는 상태를 나타냄 
select * from select_userinfo where age is null;
select * from select_userinfo where age is not null;

select * from select_userinfo where age  not between 22 and 33;

select * from select_userinfo where age not in (22, 33);

-- 8. like 문자열 검색 ( like 'a%' , '%a' , '%a%', '_a%')
select * from select_userinfo where name like 'f%'; -- f로 시작
select * from select_userinfo where name like '%t'; -- t로 끝남
select * from select_userinfo where name like '%i%'; -- i 포함
select * from select_userinfo where name like '_e%'; -- 두번째 글자가 e 

## 연습문제 
create table select_emp select * from emp;
desc select_emp;
alter table select_emp modify empno int not null auto_increment primary key;
alter table select_emp change deptno dept int;

select * from select_emp;
select * from select_emp where dept = 30;
select * from select_emp where dept = 30 and job = 'SALESMAN';
select * from select_emp where dept = 30 or job = 'CLERK';
select * from select_emp where sal*12 = 36000;
select * from select_emp where sal >= 3000;
select * from select_emp where ename >= 'F';
select * from select_emp where ename <= 'FORD';
select * from select_emp where sal != 3000;
select * from select_emp where sal <> 3000;

-- 11~20
select * from select_emp where not sal = 3000;
select * from select_emp where job = 'MANAGER' or job ='SALESMAN' or job='CLERK';
select * from select_emp where job in ( 'MANAGER','SALESMAN','CLERK');
select * from select_emp where job != 'MANAGER' and job !='SALESMAN' and job <> 'CLERK';
select * from select_emp where job not in ('MANAGER','SALESMAN','CLERK');
select * from select_emp where sal >= 2000 and sal <= 3000;
select * from select_emp where sal between 2000 and 3000;
select * from select_emp where sal not between 2000 and 3000;
select * from select_emp where not sal >= 2000 or not sal <= 3000;
select * from select_emp where empno =7499 and dept=30;

-- 21~30
select * from select_emp where dept = 20 or job='SALESMAN';
select * from select_emp where sal >=2500 and job='ANALYST';
select * from select_emp where dept = 20 or dept = 10;
select * from select_emp where dept not in (10, 20);
select * from select_emp where ename like 'S%';
select * from select_emp where ename like '_L%';
select * from select_emp where ename like '%AM%';
select * from select_emp where ename not like  '%AM%';
-- 숫자 + null 계산안됨 
select ename, sal, sal*12 + comm as `ANNSAL`, comm from select_emp where ename like '%AM%';
-- comm 자료형은 int, null 은 값이 없다는 상태를 나타냄. 
select * from select_emp where comm = null;

-- 31~40
select * from select_emp where comm is null;
select * from select_emp where mgr is not null;
select * from select_emp where sal > null;
-- 								null	OR 		TRUE => TRUE
select * from select_emp where sal > null or comm is null;

select * from select_emp where ename like '%S';
select empno, ename, job, sal, dept from select_emp where dept = 30 and job = 'SALESMAN';
select empno, ename, job, sal, dept from select_emp where (dept = 30 or dept =20) and sal > 2000  ;
select empno, ename, job, sal, dept from select_emp where dept in (20, 30) and sal > 2000  ;
select * from select_emp where not sal>=2000 or not sal <= 3000;
select * from select_emp where  sal < 2000 or sal >3000;
select ename, empno, sal, dept from select_emp where dept=30 and ename like '%E%' and sal not between 1000 and 2000;
select * from select_emp where comm is null and mgr is not null and job in ('MANAGER', 'CLERK') and ename not like '_L%'; 

select * from select_emp where comm is null and mgr is not null and job != 'MANAGER' and job != 'CLERK' and ename not like  '_L%';

use mbasic;
desc milk_repeat;
select * from milk_repeat;
select * from milk;

select * from userinfo;
