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
