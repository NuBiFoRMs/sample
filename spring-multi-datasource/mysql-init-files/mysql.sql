set @@global.sql_mode = "";

CREATE DATABASE `multi` CHARACTER SET utf8;

USE `multi`;

set global time_zone = 'Asia/Seoul';
set time_zone = 'Asia/Seoul';

SELECT @@global.sql_mode;

CREATE USER `readonly`;
ALTER USER `readonly` IDENTIFIED WITH mysql_native_password BY 'readonly';
GRANT SELECT ON *.* TO `readonly`;

CREATE USER `write`;
ALTER USER `write` IDENTIFIED WITH mysql_native_password BY 'write';
GRANT SELECT, INSERT, UPDATE, DELETE ON *.* TO `write`;