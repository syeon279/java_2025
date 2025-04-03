show databases;

use mbasic;

show tables;

desc userinfo;
create table sub_userinfo select * from userinfo;
desc sub_userinfo;
alter table sub_userinfo add sex char(2);
alter table sub_userinfo add kor int;
alter table sub_userinfo add eng int;
alter table sub_userinfo add math int;
alter table sub_userinfo add ban char(2);
alter table sub_userinfo add sns char(2);
alter table sub_userinfo modify sns char(2) default 'y';

select * from sub_userinfo;
set SQL_SAFE_UPDATES = 0; 
update sub_userinfo  set kor=100, eng=100, math = 99, ban ='A', sns='n' where no = 1;
update sub_userinfo  set sex='m', kor=89, eng=92, math = 78, ban ='B', sns='y' where no = 2;
update sub_userinfo  set sex='m', kor=90, eng=92, math = 97, ban ='A', sns='y' where no = 3;
update sub_userinfo  set sex='f', kor=40, eng=42, math = 67, ban ='C', sns='n' where no = 4;
insert  into sub_userinfo (no, name, age, sex, kor, eng,  math, ban, sns) values (5, 'fifth', 55, 'f', 40, 42, 67, 'C', 'n' );
insert  into sub_userinfo (no, name, age, sex, kor, eng,  math, ban, sns) values (6, 'sixth', 66, 'm', 10, 20, 44, 'C', 'n' );


## 1. 서브 쿼리
-- select 구문안에 select 구문
-- 서브쿼리 결과가 하나 이상이 반환시 in, any, all 사용 

## 2. 형식
-- select 컬럼 from table명 where 컬럼 in (select 문) ;

/*
-- BASIC1. 평균나이 이상인 레코드를 추출하시오.
+----+--------+-----+------+------+------+------+------+------+
| no | name   | age | sex  | kor  | eng  | math | ban  | sns  |
+----+--------+-----+------+------+------+------+------+------+
|  4 | fourth |  44 | f    |   40 |   42 |   67 | C    | n    |
|  5 | fifth  |  55 | f    |   89 |   86 |   99 | B    | y    |
|  6 | sixth  |  66 | m    |   10 |   20 |   44 | C    | n    |
+----+--------+-----+------+------+------+------+------+------+
3 rows in set (0.02 sec)
*/
# 1-1. 평균 나이 이상인 레코드를 추출
-- select * from sub_userinfo where age >= 평균나이
# 1-2. 평균나이 
-- select avg(age) from sub_userinfo;
# 1-3. 1+2 합치기 
select * from sub_userinfo where age >= (select avg(age) from sub_userinfo);

select ban, name, kor, eng, math 
from sub_userinfo 
where ban = (select ban from sub_userinfo where name = 'first');

/*
-- BASIC3. first와 같은반친구들의  국어평균점수, 영어평균점수, 수학평균점수를 추출하시오.
+------+---------+---------+---------+
| ban  | kor     | eng     | math    |
+------+---------+---------+---------+
| A    | 95.0000 | 96.0000 | 98.0000 |
+------+---------+---------+---------+
*/
select ban, avg(kor) `kor`, avg(eng) `eng`, avg(math) `math`
from sub_userinfo 
where ban = (select ban from sub_userinfo where name = 'first')
group by ban;

-- 연습문제 
select * from emp;

select sal from emp where ename = 'JONES';

select * from emp where sal > 2975;

select * from emp where sal > (select sal from emp where ename = 'JONES');

select * from emp where hiredate < (select hiredate from emp where ename = 'SCOTT');

select empno, ename, job, sal, deptno, dname, loc 
from emp join dept using(deptno)
where deptno = 20 and sal > ( select avg(sal) from emp)
order by empno desc;

select * from emp where deptno in ( 20 , 30);

select deptno, max(sal) from emp
group by deptno
order by max(sal) desc;

select *
from emp
where sal in ( select max(sal) from emp group by deptno )
;

select * 
from emp
group by deptno
having sal = ( select max(sal) from emp group by deptno);
-- = 하나일 때 만 사용 

## 1. 다중행 연산자 
-- in, any(some), all, 
## 2. in : 서브 쿼리의 결과가 하나라도 일치하면 true 를 반환
## 3. any : 서브 쿼리의 결과가 하나 이상이면 true 
## 4. all : 서브 쿼리의 결과가 모두 만족하면 true 

-- 2. any : 하나라도 일치하면 참 
-- 칼럼명 < any (1, 2, 3)  = 최대값 보다 작으면 true
-- 칼럼명 > any (1, 2, 3)  = 최소값 보다 크면 true 

-- 3. all : 모두 일치하면 참  
-- 칼럼명 < all(1, 2, 3)     1	2	3 	= 최소값 보다 작으면 true
-- 칼럼명 > all(1, 2, 3)  	1	2	3	= 최대값 보다 크면 true 


create table atest as 		  select 1 num from dual
					union all select 2     from dual
					union all select 3 		from dual
					union all select 4 		from dual
					union all select 5 		from dual
					union all select 6 		from dual;

select * from atest;

select num from atest where num < any( select num from atest where num in(3, 4, 5)) order by num;
-- 최대값 보다 작다: 5보다 작다 : 4, 3, 2, 1
select num from atest where num > any( select num from atest where num in(3, 4, 5)) order by num;
-- 최소값 보다 크다 : 3보다 크다 : 4,5,6
select num from atest where num < all ( select num from atest where num in(3, 4, 5)) order by num;
-- 최소값 보다 작다 : 3보다 작다: 1,2
select num from atest where num > all ( select num from atest where num in(3, 4, 5)) order by num;
-- 최대값 보다 크다: 5보다 크다 : 6


-- 연습문제
select * from emp
where sal = any (select max(sal) from emp group by deptno);

select * from emp
where sal = some (select max(sal) from emp group by deptno);

select sal from emp
where deptno = 30;

select * from emp
where sal < all ( select max(sal) from emp group by deptno)
order by sal;


select * from emp
where sal > any ( select min(sal) from emp where deptno = 30)
order by sal desc;

use mbasic;
create table member(
no int not null primary key auto_increment,
name varchar(100) not null,
pass varchar(50) not null
);

insert into member values (1, 'first', '11'); 
insert into member values (2, 'second', '22'); 
insert into member values (3, 'third', '33'); 
insert into member values (4, 'fourth', '44'); 

select * from member;
select name, pass from member where name='first' and pass='11';

use mbasic;

create table sboard(
bno int not null auto_increment primary key,
bname varchar(100) not null,
btitle varchar(1000) not null,
bcontent text not null,
bdate timestamp not null default now(),
bhit int not null default 0,
bip varchar(50) not null 
);

desc board;
select * from board;

select * from board;

alter table board add bpass varchar(50) not null;

use mbasic;
show tables;

desc userinfo;

select * from userinfo;

desc board;

select * from board;

create table sboard select * from board;

desc sboard;
select * from sboard order by bno desc;
drop table sboard;
alter table sboard add bpass varchar(50) not null;

select * from member;
