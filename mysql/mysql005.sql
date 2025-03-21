-- ■ 진도 - function
# 1. Number
# 2. String
# 3. Date
# 4. if / case 
-- -------------------------------------------------------------
--  ■ 1. Number (ceil 올림 , floor 내림 , round 반올림 , mod 나머지 )
-- -------------------------------------------------------------
select ceil(1.1) `올림`, floor(1.9) `내림`, round(1.5) `반올림`, mod(10,3)`나머지`; 

-- 연습문제
select 123.4578, round(123.4578) `ROUND 1`, round(123.4578, -1) `ROUND 2`, 
round(123.4578, 1) `ROUND 3`,round(123.4578, 2) `ROUND 4`;

select 123.4578, ceil(123.4578) `CEIL`, floor(123.4578) `FLOOR`;
-- -------------------------------------------------------
-- ■ 2. String
-- -------------------------------------------------------
-- 2-1. basic
-- 1) length (문자열) - 문자열 갯수 구하기
select length('abc');

-- 2) upper/lower
select 'abc', upper('abc'), lower('abc');

-- 3) instr(in: index, str : string) 위치 -> instr(문자열, 찾을 문자열) 위치, 못찾으면 0 
select instr('abc', 'b') `b의 위치`, instr('abc', 'ab')`ab의 위치`, instr('abc' ,'ac')`ac의 위치`;

-- 4) left, right, substr 문자열 일부분 추출 
select left('abcd', 2) `ab`, right('abcd', 2) `cd`, substr('abcd', 2, 3);

-- 5) 문자열 연결 concat(문자열1, 문자열2)
select concat('hi, ', 'mysql')`concat`;

-- 6) trim
select trim('     abc de f '); -- 공백때기 좌우만. 
select concat('#', trim('  a b c   '), '#')`양쪽 공백` , 
concat('#', ltrim('  a b c   '), '#') `왼쪽 공백`,
concat('#', rtrim('  a b c   '), '#') `오른쪽 공백`
; 

-- 7) replace 
select replace("Hello sally", 'sally', 'Dan') `Hello`;

-- 8) repeat(뭐를, 몇개 반복)
select repeat('hi! ', 5)`hi`;

-- 9) 빈칸채우기 
select lpad('abc', 10, '#'), -- 왼쪽으로 7개
rpad('abc', 10, '#'); -- 오른쪽으로 7개 

select concat('#', concat('abc','#'));

-- 연습문제
show tables;
desc userinfo;
select * from userinfo;
create table select_userinfo2 select * from userinfo;
desc select_userinfo2;
alter table select_userinfo2 add email varchar(20) not null;
alter table select_userinfo2 modify name varchar(20) not null;

select * from select_userinfo2;
set sql_safe_updates =0;
update select_userinfo2 set email = 'aaa@gmail.com' where no = 1;
update select_userinfo2 set name = 'aaa' where no = 1;
update select_userinfo2 set name = 'bbb', email = 'bbb@gmail.com' where no = 2;
update select_userinfo2 set name = 'ccc', email = 'ccc@gmail.com' where no = 3;
update select_userinfo2 set name = 'ddd', email = 'ddd@gmail.com' where no = 4;
insert into select_userinfo2 values ( 5, 'abc', 55, 'abc@gmail.com');
insert into select_userinfo2 values ( 6, 'bca', 66, 'bca@gmail.com');

select name, length(name)
from select_userinfo2;

select name, left(name, 1) `첫번째 글자`, right(name, 1) `두번째 글자`
from select_userinfo2;

select name, replace(name, 'aaa', 'aaa 1등')
from select_userinfo2;

select concat(name, '는 개발자 입니다. ') `직업`
from select_userinfo2;

select upper(name) 
from select_userinfo2;

select lower(name)
from select_userinfo2;

select name, instr(name, 'b')
from select_userinfo2
where age>=40;

select name, instr(name, 'b')
from select_userinfo2
where age>=40
order by age desc
limit 2;

select name, concat(left(name, 1),'*', right(name, 1)) `test`
from select_userinfo2;

create table select_userinfo2_2 select * from select_userinfo2;
select * from select_userinfo2_2;
update select_userinfo2_2 set name = 'aaaa' where no =1;
update select_userinfo2_2 set name = 'bbaab' where no =2;
update select_userinfo2_2 set name = 'ccaac' where no =3;
update select_userinfo2_2 set name = 'daadd' where no =4;
update select_userinfo2_2 set name = 'baaca' where no =6;

select name, concat(left(name, 1), repeat('*',(length(name)-2)), right(name, 1)) `test`
from select_userinfo2_2;

select concat('abc','*','def','*','ghi','*','jklmnop', 11); 






-- -------------------------------------------------------
-- ■ 3. Date
-- -------------------------------------------------------
-- 1) 시스템의 현재 시각 조회 
select now(); -- 2025-03-21 11:59:21
select current_time(); -- 11:59:28

-- 2) 요일 ( 0 = Mon , 1=Tue, 6=Sun)
select weekday(now()); -- 금요일=4 
select weekday("2025-03-21"); -- 4

-- 3) 날짜 형식 date_format(날짜 지정, '%Y-%m-%d' )
select date_format("2025-03-21", '%Y-%m-%d' );
select date_format ( now(), '%Y-%m-%d' );
select date_format( now(), '%Y-%m-%d %H:%i:%s' );

-- 4) 100일 전/ 후  date_add
select date_add(now(), Interval -10 day);
select date_add(now(), Interval 10 day);
select date_add(now(), Interval -3 hour);

-- 5) 
select datediff('2025-03-22' , '2025-03-21');
select timestampdiff(second, '2025-03-22' , '2025-03-21');

show tables;
desc userinfo;
create table date_userinfo select * from userinfo;
desc date_userinfo;
alter table date_userinfo modify no int not null;
alter table date_userinfo add date datetime default current_timestamp;

insert into date_userinfo values (1, 'aaa', 11, '2022-12-30');
insert into date_userinfo values (2, 'bbb', 22, '2022-11-30');
insert into date_userinfo values (3, 'ccc', 33, '2022-10-30');
insert into date_userinfo values (4, 'ddd', 44, '2022-09-30');

select * from date_userinfo;

delete from date_userinfo where name='first';
delete from date_userinfo where name='second';
delete from date_userinfo where name='third';
delete from date_userinfo where name='fourth';

select name, date 
from date_userinfo
where date < '2022-11-01';

alter table date_userinfo add event date;

select name, date, date_add(date , Interval 30 day)`event`
from date_userinfo
where date >= '2022-12-01' and date <= '2022-12-31';

select name, date, date_add(date , Interval 30 day)`event`
from date_userinfo
where month(date) = 12;

select name, date_format(date,'%Y년 %m월 %d일' )
from date_userinfo;

select now();

select datediff( now(), '2025-12-25');

select date_add(now(), Interval 5 month);

select date_format ( weekday(6), '%Y-%m-%d');





-- -------------------------------------------------------
-- ■ 4. if / case
-- -------------------------------------------------------
-- 1) if(조건, 참, 거짓)
-- 다형식 
/*
	case 
	when 	조건1	 	then 	상태1
    when	조건2		then	상태2
    else	모든 조건에 해당하지 않을 때, 생략가능
    end

*/ 

create table control (no int);
insert into control values (1), (2), (3);
select * from control;
desc control;

select no, if(no=1, '1 이다', '1 아니다' ) `상태` 
from control;

select no, if( no=2, '2 이다', if( no>2, '2보다 크다', '2보다 작다' ) ) `상태` 
from control;

select no, case
when no=1 then '1 이다'
when no=2 then '2 이다'
when no=3 then '3 이다'
end `state`
from control;

select no, case
when no<2 then '2보다 작다'
when no=2 then '2 이다'
when no>2 then '2보다 크다'
end `state`
from control;

desc userinfo;
create table if_userinfo select * from userinfo;
desc if_userinfo;
alter table if_userinfo modify age int;
alter table if_userinfo modify no int not null auto_increment primary key;
alter table if_userinfo add sex char(1);
alter table if_userinfo add sns char(1);

select * from if_userinfo;
update if_userinfo set sns ='n' where no=1;
update if_userinfo set sns = 'y' , sex='m', age=122 where no=2;
update if_userinfo set sns = 'y' , sex = 'm' where no=3;
update if_userinfo set sns = 'n' , sex = 'f' where no=4;
insert into if_userinfo values(5, 'fifth', 55, 'f', 'y');
insert into if_userinfo values(6, 'sixth', 66, 'm', 'n');

select no, name, age, sex, sns, if(sns='y', '수신 유지', '수신 거부') `수신 여부 상태`
from if_userinfo; 

select no, name , age, sex, sns, if(age <19, '미성년자' , '성인') `성인 여부`
from if_userinfo;

select sns, if( sns='n', 1, null) `SNS 수신 거부 수 `
from if_userinfo; 

select sum(if(sns='n',1,0)) `SNS 수신 거부 수 `
from if_userinfo;

select sns, case 
when sns='n' then count(*)
end `SNS 수신 거부 수 `
from if_userinfo; 

select ename `ENAME`, deptno, case 
when deptno=10 then 'ACCOUNTING'
when deptno=20 then 'RESEARCH'
when deptno=30 then 'SALES'
end `부서 이름`
from emp;

select ename `ENAME`, deptno, case deptno
when 10 then 'ACCOUNTING'
when 20 then 'RESEARCH'
when 30 then 'SALES'
end `부서 이름`
from emp
order by deptno asc;

select ename `ENAME`, job, case 
when job='CLERK' then '판매원'
when job='SALESMAN' then '영업사원'
else '사원'
end `job2`
from emp;