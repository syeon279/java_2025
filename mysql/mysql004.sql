-- ■ 1. order by + limit
/*
	select	필드 1, 필드 2 
    from  	테이블명
    where	조건식
    order by	기준필드 [asc(1,2,3 오름차순) | desc(3,2,1 내림차순)]
    limit 	몇개 
*/
-- 1-1 테이블 준비
use mbasic;
show tables;
select * from select_userinfo;
delete from select_userinfo where no = 7;

-- 1-2 정렬
select * from select_userinfo; 
select * from select_userinfo order by age desc ;  -- 내림차순 
select * from select_userinfo order by age asc ; -- 오름차순

-- 나이많은 세 명
select * from select_userinfo order by age desc limit 3;
select * from select_userinfo order by age desc limit 2 ;

-- no가 높은 순으로 4 명
select * from select_userinfo order by no desc limit 4;

-- no가 두 번째로 높은 순으로 2명 ( limit 어디서 부터, 몇 개)
select * from select_userinfo order by no desc limit 0, 2; -- 6, 5
select * from select_userinfo order by no desc limit 1, 2; -- 5, 4

-- 1-3 
select * from select_emp;
select * from select_emp where job = 'SALESMAN';
select ename, mgr, sal from select_emp;
select ename, mgr, sal from select_emp where job = 'SALESMAN';
select * from select_emp order by sal desc;
select * from emp order by job asc, sal desc;
select ename, sal, empno as `select_empno` from select_emp where sal >= 2000 order by select_empno desc;
select distinct job from select_emp;
select empno as `사원번호`, ename as `이름`, job as `담당 업무` from select_emp;
select * from select_emp order by sal asc;
select * from select_emp order by sal desc;
select * from select_emp order by dept asc, sal desc;
select empno`select_empLOYEE_NO`, ename `select_empLOYEE_NAME`, job, mgr `MANAGER`, hiredate, sal `SALARY`, comm `COMMISSION`, dept `DEPARTMENT_NO` 
from select_emp order by dept desc, ename asc;


-- ■ 2. 집계 함수
/*
	select	필드 1, 필드 2 
    from  	테이블명
    where	조건식
    group by	그룹핑 
    having	조건식 
    order by	기준필드 [asc(1,2,3 오름차순) | desc(3,2,1 내림차순)]
    limit 	몇개 
    
    avg(컬럼명) 평균, max 최대값, min 최소값, sum 합계, count 갯수 
    
*/
create table group_userinfo select * from select_userinfo;
desc group_userinfo;
drop table group_userinfo;
alter table group_userinfo add sex char(2);
alter table group_userinfo add kor int, add eng int, add math int;
alter table group_userinfo add ban char(2), add sns char(2);
desc group_userinfo;
alter table group_userinfo modify no int not null auto_increment primary key;

set sql_safe_updates =0;
select * from group_userinfo;
update group_userinfo set kor=100, eng = 100, math = 99, ban = 'A', sns = 'n' where no=1;
update group_userinfo set kor=89, eng = 92, math = 78, ban = 'B', sns = 'y' where no=2;
update group_userinfo set kor=90, eng = 92, math = 91, ban = 'A', sns = 'y' where no=3;
update group_userinfo set kor=40, eng = 42, math = 67, ban = 'C', sns = 'n' where no=4;
update group_userinfo set kor=89, eng = 86, math = 99, ban = 'B', sns = 'y' where no=5;
update group_userinfo set kor=10, eng = 20, math = 44, ban = 'C', sns = 'n' where no=6;
update group_userinfo set sex = 'm' where no=2;
update group_userinfo set sex = 'm' where no=3;
update group_userinfo set sex = 'm' where no=6;
update group_userinfo set sex = 'f' where no=4;
update group_userinfo set sex = 'f' where no=5;


-- 2-2 기본
select @@sql_mode; -- 2. sql mode 확인
set SESSION sql_mode='STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION'
; -- 3. GROUP by 에서 오류나서 빼버림 
select * from group_userinfo group by ban; -- 1.

-- 나이 평균 
select avg(age) from group_userinfo;
select ban, count(*) from group_userinfo group by ban;

-- 반별 국어 영어 수학의 총점
select ban, sum(kor) `국어 총합`, sum(eng) `영어 총합`, sum(math) `수학 총합` 
from group_userinfo 
group by ban;

-- 반별 국 영 수 의 평균 
select ban, avg(kor) `국어 평균`, avg(eng) `영어 평균`, avg(math) `수학 평균` 
from group_userinfo 
group by ban;

-- 반별 나이의 총합과 나이 평균 확인 
select ban, sum(age) `나이 총합`, avg(age) `나이 평균` , max(age) `최고 나이`, min(age) `최저 나이` 
from group_userinfo 
group by ban;

-- 반별 국 영 수 의 평균 확인 후 '국어' 평균 점수가 89 이상인 데이터만 고르기
select ban, avg(kor) `국어 평균` 
from group_userinfo 
group by ban
having avg(kor) >= 89;

-- 반별 나이의 총합과 나이 평균 확인 후 그중에서 나이의 평균이 35 세 이상 
select ban, sum(age) `나이 총합`, avg(age) `나이 평균` , max(age) `최고 나이`, min(age) `최저 나이` 
from group_userinfo 
group by ban
having avg(age)>= 35;

-- 반별 나이의 총합과 나이 평균 확인 후 그중에서 나이의 평균이 35 세 이상 내림차순
select ban, sum(age) `나이 총합`, avg(age) `나이 평균` , max(age) `최고 나이`, min(age) `최저 나이` 
from group_userinfo 
group by ban
having avg(age)>= 35
order by avg(age) desc;

-- 연습문제 1~
desc emp;
alter table emp modify ename varchar(20);
select * from emp;

select sum(sal)
from emp;

select sum(comm)
from emp;

select sum(distinct sal), sum(all sal), sum(sal)
from emp;

select count(*) as `데이터 갯수`
from emp;

select count(deptno) as `부서30 직원수`
from emp
where deptno=30;

select count(distinct sal), count(all sal), count(sal)
from emp;

select count(comm) `추가 수당을 받는 사원 수`
from emp;

select count(comm) `추가 수당을 받는 사원 수`
from emp
where comm is not null;

select max(sal) `부서10 최대급여`
from emp
where deptno=10;

select min(sal) `부서10 최소급여`
from emp
where deptno=10;

-- 11~
select hiredate `부서20  최근 입사일`
from emp
where deptno=20
order by hiredate desc
limit 1;

select hiredate `부서20  오래된 입사일`
from emp
where deptno=20
order by hiredate asc
limit 1;

select avg(sal) `부서30 평균 급여` 
from emp
where deptno=30;

select avg(distinct sal) `부서30 중복제거 급여평균`
from emp
where deptno=30;

select deptno, avg(sal) `평균 급여` 
from emp
group by deptno
order by deptno asc;

select deptno, job, avg(sal)`평균 급여`
from emp
group by deptno, job
order by deptno asc;

select deptno, job, avg(sal)`평균 급여`
from emp
group by deptno, job
having avg(sal)>=2000
order by deptno asc;

select deptno, job, avg(sal)
from emp
where avg(sal) >= 2000 -- 조건식은 having으로 작성. 
group by deptno, job
order by deptno, job;

select deptno, job, avg(sal)
from emp
where sal<=3000
group by deptno, job
having avg(sal)>=2000
order by deptno asc;

select deptno, job, count(job) `사원수`, max(sal), sum(sal), avg(sal) `평균급여`
from emp
group by deptno, job
order by deptno asc;

use mbasic;

create table milk_order(
ono int not null auto_increment primary key,
oname varchar(20) not null,
onum int not null,
odate datetime default now(),
oip varchar(100) not null
);

show tables;

desc milk_order;

-- Q1.  milk_order 값삽입.  insert 구문 완성    (oname, onum, oip)     'white' , 2,  '127.0.0.1'
insert into milk_order (oname, onum, oip) values ('white', 2, '127.0.01');
-- Q2.  milk_order no가 1인데이터 조회 
select * from milk_order where ono=1;
-- Q3.  milk_order 전체데이터조회
select * from milk_order;
-- Q4.  milk_order 해당번호의 이름과 갯수 수정
update milk_order set onum=1, oname = 'choco' where ono=1;
select * from milk_order;
-- Q5.  milk_order 해당번호의 데이터 삭제
delete from milk_order;
select * from milk_order;
select ono, oname, count(onum),odate from milk_order group by oname order by odate desc;
select * from milk_order order by ono desc;

use mbasic;
desc emp;
select deptno, job, avg(sal) 
from emp 
where sal<=3000 
group by deptno, job
having avg(sal)>=2000 
order by deptno asc;

select deptno, job, count(*) `사원 수`, max(sal) `최고 급여`, sum(sal) `급여 합` , avg(sal) `평균 급여` 
from emp 
group by deptno, job 
order by deptno asc;

select @@sql_mode;
 -- set SESSION sql_mode = 'STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION'