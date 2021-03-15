DROP DATABASE IF EXISTS test;
CREATE DATABASE test;

USE test;

CREATE TABLE person(
person_id INTEGER AUTO_INCREMENT NOT NULL,
reference_id VARCHAR(20) NOT NULL,
title VARCHAR(15),
first_name VARCHAR(60) NOT NULL,
second_name VARCHAR(60) NOT NULL,
first_last_name VARCHAR(40) NOT NULL,
second_last_name VARCHAR(40) NOT NULL,
birth_date DATE NOT NULL,
gender VARCHAR(1) NOT NULL,
rfc VARCHAR(14) NOT NULL,
homoclave VARCHAR(4),
ssn VARCHAR(20),
curp VARCHAR(20),
blood_type VARCHAR(10),
person_status TINYINT UNSIGNED NOT NULL DEFAULT 0,
PRIMARY KEY(person_id)
);

CREATE TABLE demographic(
reference_id VARCHAR(20) NOT NULL,
street VARCHAR(60) NOT NULL,
ext_num VARCHAR(30),
int_num VARCHAR(30),
suburb VARCHAR(60),
municipality VARCHAR(60),
city VARCHAR(60) NOT NULL,
state VARCHAR(40) NOT NULL,
zip_code MEDIUMINT NOT NULL,
country VARCHAR(60) NOT NULL
);

CREATE USER IF NOT EXISTS 'testUser'@'%' IDENTIFIED WITH mysql_native_password BY '94Zo5DwTFaO0lVuL';

GRANT SELECT, INSERT, UPDATE, DELETE ON `test`.* TO 'testUser'@'%'; 
