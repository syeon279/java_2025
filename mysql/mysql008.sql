show databases;
use myboot;
select * from member;

desc board;
select * from board order by id desc;

select count(*) from board;

create database yoonlee3;

use yoonlee3;

show databases;

show tables;

desc group_has_user;
select * from group_has_user;

desc user;
select * from user;

desc badge;
select * from badge;

insert into badge (badge_title) value ("씨앗");
insert into badge (badge_title) value ("새싹");
insert into badge (badge_title) value ("줄기");
insert into badge (badge_title) value ("떡잎");
insert into badge (badge_title) value ("나무");

insert into open_scope (open_scope_title) value ("나만 보기");
insert into open_scope (open_scope_title) value ("친구 공개");
insert into open_scope (open_scope_title) value ("그룹 공개");
insert into open_scope (open_scope_title) value ("전체 공개");
insert into open_scope (open_scope_title) value ("관리자");

drop database yoonlee3;

desc yl3group;

select * from yl3group;

## 데이터베이스 
drop database yoonlee3;
create database yoonlee3;
use yoonlee3;
show tables;

### 테이블 구조 확인
desc badge;
desc group_badge_history;
desc group_has_user;
desc user;
desc yl3group;
desc goal;
desc goal_status;
desc open_scope;
desc diary;
desc group_diary;
desc likes;
desc user_achiv;

### 각 테이블 확인
select * from user;
select * from yl3group;
select * from group_has_user;
select * from badge;
select * from group_badge_history;
select * from open_scope;
select * from goal;
select * from goal_status;
select * from group_diary;
select * from diary;
select * from user_achiv;

