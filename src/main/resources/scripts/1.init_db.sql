DROP DATABASE IF EXISTS spring_homework;
CREATE DATABASE IF NOT EXISTS spring_homework;
use spring_homework;

CREATE TABLE manufacturer (
                            id int NOT NULL AUTO_INCREMENT,
                            name varchar(100) NOT NULL UNIQUE,
                            PRIMARY KEY (id));

CREATE TABLE product (
                        id int NOT NULL AUTO_INCREMENT,
                        name varchar(100),
                        price decimal NOT NULL,
                        manufacturer_id int not null,
                        PRIMARY KEY (id));

CREATE TABLE user (
                          id int NOT NULL AUTO_INCREMENT,
                          email varchar(30)NOT NULL UNIQUE,
                          password varchar(15) NOT NULL,
                          first_name varchar(15) NOT NULL,
                          last_name varchar(20) NOT NULL,
                          user_role varchar(5)NOT NULL,
                          user_status varchar(10) NOT NULL,
                          PRIMARY KEY (id));


