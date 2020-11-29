CREATE DATABASE TODOSERVICE;

CREATE TABLE TODOS(
id int NOT NULL AUTO_INCREMENT ,
name varchar(50) NOT NULL ,
is_finished tinyint(1) NOT NULL ,
is_active tinyint(1) NOT NULL ,
created_at date NOT NULL ,
updated_at date NOT NULL ,
PRIMARY KEY (id) ,
UNIQUE KEY UK_name (name) ,
ENGINE=InnoDB DEFAULT CHARSET=utf8;
)

CREATE TABLE TAGS(
id int NOT NULL AUTO_INCREMENT ,
name varchar(50) NOT NULL ,
is_active tinyint(1) NOT NULL ,
created_at date NOT NULL ,
updated_at date NOT NULL ,
PRIMARY KEY (id) ,
UNIQUE KEY UK_name (name) ,
ENGINE=InnoDB DEFAULT CHARSET=utf8;
)