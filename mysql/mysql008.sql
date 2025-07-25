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
select * from comments order by id desc;
delete from posts;
delete from users;
delete from `like` where postId=56;

select * from follow;
drop database node_react;

create database ssdam;
drop database ssdam;
use ssdam;
show tables;
desc complains;

select * from complains;
select * from `groups`;
select * from posts;
select * from comments;
select * from users;
select * from notifications order by id desc;
select * from complains order by id desc;

SELECT id, nickname, isAdmin FROM Users WHERE id = 1; -- or 관리자 id
SELECT * FROM Posts WHERE UserId = 1; -- 관리자 id

desc notifications;

INSERT INTO categories (id, content, createdAt, updatedAt) VALUES
(1, '강아지', now(), now()),
(2, '고양이', now(), now()),
(3, '햄스터', now(), now()),
(4, '파충류', now(), now());

select * from friends;

delete from notifications;
select * from animals;
desc groupmember;

select * from comments;
desc complains;
desc users;
UPDATE Users
SET isAdmin = true
WHERE email = '1'; 

select * from openscopes;
desc openscopes;
select * from prizes;
select * from myprizes;
desc myprizes;
select * from notificationSettings;
select * from categories;
desc `groups`;
select * from `groups`;
desc groupcategory;
select * from groupcategory;
select * from postcategory;
SELECT * FROM categories;
select * from posts order by id desc;
select * from animals;
select * from friends;
select * from groupmembers;
select * from grouprequests;
select * from follow;
select * from notificationSettings;
select * from posts;
ALTER TABLE Calendars ADD COLUMN totaldays INT;
ALTER TABLE Calendars ADD COLUMN currentdays INT;
select * from blacklists;
select * from block;
desc blacklists;

drop database ssdam;
create database ssdam;
use ssdam;

desc complains;

select * from issuedrandomboxes;


show databases;
create database node_react_test;
use node_react_test;
show tables;
drop database node_react_test;

desc users;
select * from users;
select * from posts;

create database review;
use mbasic;
show tables;
select * from emp;
select * from emp where job='clerk';


create table users (userid  varchar(50) not null  , userpw  varchar(100) not null, enabled  char(1) , primary key(userid) );  
create table authorities (userid  varchar(50) not null  , auth   varchar(50) not null );  

insert into users (userid, userpw ) values ('first', '1111');
insert into users (userid, userpw ) values ('second', '2222');

insert into authorities (userid, auth) values ('first', 'ADMIN');
insert into authorities (userid, auth) values ('first', 'MEMBER');
insert into authorities (userid, auth) values ('second', 'MEMBER');

create database thejoa;
use thejoa;
show tables;
select * from board order by id desc;
select * from member; 
select * from member_board;
desc member;
