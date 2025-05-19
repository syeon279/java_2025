show databases;

use myboot;

show tables;

select * from my_user;

ALTER DATABASE myboot
CHARACTER SET = utf8mb4 
COLLATE = utf8mb4_unicode_ci;

ALTER TABLE my_user MODIFY COLUMN username VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;


insert into my_user (username, email)  values ("💫", "💌@kakao.com");

SHOW VARIABLES LIKE 'character_set_%';
ALTER TABLE my_user CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

