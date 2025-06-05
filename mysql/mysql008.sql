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
select * from users;
select * from notifications order by id desc;
select * from complains order by id desc;

ALTER TABLE Notifications DROP PRIMARY KEY;
ALTER TABLE Notifications ADD COLUMN id INT NOT NULL AUTO_INCREMENT PRIMARY KEY;

INSERT INTO Users (id, username, email, nickname, password, phonenumber, createdAt, updatedAt)
VALUES
(1, 'catmaster', 'user1@example.com', '고양이짱', 'hashed_pw1', 1012345678, NOW(), NOW()),
(2, 'dogking', 'user2@example.com', '멍멍이왕', 'hashed_pw2', 1023456789, NOW(), NOW()),
(3, 'molegod', 'user3@example.com', '두더지신', 'hashed_pw3', 1034567890, NOW(), NOW()),
(4, 'hamcutie', 'user4@example.com', '햄스터귀요미', 'hashed_pw4', 1045678901, NOW(), NOW());

INSERT INTO `groups` (id, title, content, createdAt, updatedAt)
VALUES
(1, '삼겹살과 함께', '고기 먹고 목표 세우는 모임입니다.', NOW(), NOW()),
(2, '고양이 집사들', '고양이를 사랑하는 사람들의 목표 커뮤니티', NOW(), NOW()),
(3, '미라클 모닝단', '매일 아침 기상 도전 모임', NOW(), NOW());


desc notifications;

delete from notifications;

