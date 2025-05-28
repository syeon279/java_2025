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
select * from template;

delete from diary where user_id=9;
delete from group_diary where id=3;

update yl3group set current_turn=1 where group_id=1;
update template set template_title="theme" where template_id=1;

SHOW VARIABLES LIKE 'character_set_%';
SHOW VARIABLES LIKE 'collation%';

update goal set start_date='2025-04-28' where goal_id=9;
update yl3group set create_date='2025-03-01' where group_id=4;
delete from user_achiv where goal_id=16;

drop database myBoard2;
create database myBoard2;
use myBoard2;
show tables;
select * from member;
select * from board;
desc member;
desc board;

delete from board where id=1;

update diary set create_date='2025-05-06' where diary_id=4;
update yl3group set last_turn_date='2025-05-07' where group_id=3;
update yl3group set current_turn=1 where group_id=3;

show databases;
create database node_react;

show databases;
use node_react;
show tables;
select * from users;
select * from posts order by id desc;
select * from hashtags;
select * from images;
select * from `like`;
desc comments;
desc users;
select * from comments;
delete from posts;
delete from users;
delete from `like` where postId=56;
