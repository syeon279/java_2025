use mbasic;

create table Join_userban(
no int not null primary key auto_increment,
name varchar(20) not null,
ban char(2)
);

desc join_userban;

insert into join_userban values (1, 'first', 'A');
insert into join_userban values (2, 'second', 'B');
insert into join_userban values (3, 'third', 'A');
insert into join_userban values (4, 'fourth', 'C');
insert into join_userban values (5, 'fifth', 'B');
insert into join_userban values (6, 'sixth', 'C');
insert into join_userban values (7, 'fifth', 'B');
insert into join_userban values (8, 'sixth', 'C');

select * from join_userban;
set sql_safe_updates =0;
update join_userban set ban = 'D' where no = 7 and no = 8;

delete from join_userban where no >= 7;

select ban, count(*)
from join_userban
group by ban;

## 데이터베이스 언어 
-- DDL - Create alter drop
-- DCL - revoke, grant
-- DML - insert, select, delete, update

## e(entity 테이블 ) r (relation 관계) 속성: pk, fk
-- join 
-- 두 개 이상의 태이블을 연결해서 데이터를 조회
-- 테이블 간의 연결고리 (pk, fk) 

# 종류 : inner join, outer join
create table join_userinfo(
no int not null,
name varchar(100) not null,
age int not null
);

insert into join_userinfo values (1, 'first', 11);
insert into join_userinfo values (2, 'second', 22);
insert into join_userinfo values (3, 'third', 33);
insert into join_userinfo values (4, 'fourth', 44);

select * from join_userinfo;
-- 1. join
select a.no, a.name, a.age, b.ban
from join_userinfo `a`, join_userban `b`
where a.no = b.no;

-- 2. join on 
select  a.no, a.name, a.age, b.ban
from join_userinfo `a` join join_userban `b` on ( a.no = b.no );

-- 3. join using
select  a.no, a.name, a.age, b.ban
from join_userinfo `a` join join_userban `b` using(no);

-- 4. natural join   natural join 알아서 join 연결할 부위 찾아서 연결해줌 
select no, name, age, ban
from join_userinfo natural join join_userban;


## q2. 
-- 1. join
select  a.no, a.name, a.age, b.ban
from join_userinfo `a`, join_userban `b`
where a.no = b.no and a.age between 20 and 40;

-- 2. join on
select  a.no, a.name, a.age, b.ban
from join_userinfo `a` join join_userban `b` on ( a.no = b.no )
where a.age between 20 and 40;

-- 3. join using 
select  a.no, a.name, a.age, b.ban
from join_userinfo `a` join join_userban `b` using(no)
where a.age between 20 and 40;

-- 4. natural join
select no, name, age, ban
from join_userinfo natural join join_userban
where age between 20 and 40;

## right join 은 오른쪽 값 보장
select a.no, a.name, b.ban, a.age
from join_userinfo `a` right join join_userban `b` on ( a.no = b.no );

## left 테이블위치만 바꾸면 가능
select a.no, a.name, b.ban, a.age
from join_userban `b` left join  join_userinfo`a` on ( a.no = b.no );


## q4.
select b.no, b.name, b.ban, a.age
from join_userinfo a right join join_userban b on ( a.no = b.no );

select b.no, b.name, b.ban, a.age
from join_userban b left join  join_userinfo a on ( a.no = b.no );

-- 1~10
drop table dept;
create table dept (
   deptno int not null  auto_increment primary key,
   dname varchar(20) not null,
   loc varchar(20) not null
);

insert into dept values (10 , 'ACCOUNTING' , 'NEW YORK');
insert into dept values (20 , 'RESEARCH' , 'DALLAS');
insert into dept values (30 , 'SALES' , 'CHICAGO');

select * from dept;
select * from emp, dept order by empno;
-- emp(14) dept(4) 14* 4 = 56 
-- join 시 연결부위 꼭! 

select * 
from emp join dept on (emp.deptno = dept.deptno);

select * 
from emp `E` join dept `D`  on (E.deptno = D.deptno);

-- Error Code: 1052. Column 'deptno' in field list is ambiguous
select empno, ename, deptno, dname, loc  -- 어디 테이블에서 가져올 것인지 규정하지 않아서 오류남
from emp E, dept D
where E.deptno = d.deptno; 

select E.empno, E.ename, E.deptno, D.dname, D.loc  
from emp E, dept D
where E.deptno = d.deptno;

select E.empno, E.ename, E.deptno, D.dname, D.loc  
from emp E join dept D on (E.deptno = d.deptno)
where E.sal >= 3000;

select E.empno, E.ename, E.deptno, D.dname, D.loc  
from emp E join dept D using(deptno) 
where E.sal >= 3000;

select E.empno, E.ename, E.deptno, D.dname, D.loc  
from emp E natural join dept D 
where E.sal >= 3000;

select * from salagrade;
select min(hisal) 
from salagrade
group by hisal;

select * 
from emp `E` , salagrade `S` 
where  E.sal >= S.losal and E.sal <=  S.hisal
order by sal asc;

select E.empno, E.ename, E.mgr, E2.empno `MGR_empno`, E2.ename ` MGR_Ename`
from emp `E`, emp`E2`, salagrade `S` where E.mgr = E2.empno and  E.sal >= S.losal and E.sal <=  S.hisal
order by MGR_empno asc;

select E.empno, E.ename, E.mgr, E2.empno `MGR_empno`, E2.ename ` MGR_Ename`
from emp `E` left join emp`E2` on (E.mgr = E2.empno)
order by E.empno asc;

select E.empno, E.ename, E.mgr, E2.empno `MGR_empno`, E2.ename ` MGR_Ename`
from emp `E` right join emp`E2` on (E.mgr = E2.empno)
order by E.empno asc; -- 오른쪽 테이블을 기준으로 삼아 데이터가 null 값이라도 데이터를 표현함

-- 11~ 10
select * from emp;
select * from dept;
select * from salagrade;

select * from emp natural join dept
order by dname asc;

select empno, ename, job, mgr, hiredate, sal, comm, deptno, dname, loc
from emp join dept using(deptno)
where sal>=3000
order by dname asc;

select * 
from emp join dept on (emp.deptno = dept.deptno)
where sal <= 3000
order by dname asc;

select emp.deptno, dname, empno, ename, sal
from emp join dept on (emp.deptno = dept.deptno)
where sal > 2000;

select emp.deptno, dname, empno, ename, sal
from emp natural join dept 
where sal > 2000;

select emp.deptno, dname, avg(sal) `AVG_SAL`, max(sal), min(sal), count(emp.deptno) `CNT`
from emp, dept 
where emp.deptno = dept.deptno
group by emp.deptno
order by dname asc;

select deptno, dname, avg(sal) `AVG_SAL`, max(sal), min(sal), count(emp.deptno) `CNT`
from emp join dept using(deptno)
group by emp.deptno
order by dname asc;

select deptno, dname, empno, ename, job, sal
from  dept`b` left join emp `a`  using(deptno)
order by deptno asc, ename asc;

select deptno, dname, empno, ename, job, sal
from emp `a` right join dept `b` using(deptno)
order by deptno asc, ename asc;

select e.deptno, dname, e.empno, e.ename, e.mgr, e.sal, e.deptno, losal, hisal, grade, e2.empno `MGR_EMPNO`, e2.ename `MRG_ENAME`
from salagrade `s` join emp `e` join emp `e2` right join  dept `d` on (e.deptno = d.deptno)
where e.mgr = e2.empno and E.sal  between S.losal and S.hisal
order by e.deptno asc, dname asc;

select d.deptno, dname, e.empno, e.ename, e.mgr, e.sal, d.deptno, s.losal, s.hisal, s.grade, e2.empno `MGR_EMPNO`, e2.ename `MRG_ENAME`
from emp e right join  dept d on (e.deptno = d.deptno)
			left join salagrade s on (e.sal between s.losal and s.hisal)
			left join emp e2 on (e.mgr = e2.empno)
order by d.deptno asc;




