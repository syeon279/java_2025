show databases;

use myboot;

show tables;

select * from my_user;

ALTER DATABASE myboot
CHARACTER SET = utf8mb4 
COLLATE = utf8mb4_unicode_ci;

insert into my_user (username, email)  values (❤, 💌);
