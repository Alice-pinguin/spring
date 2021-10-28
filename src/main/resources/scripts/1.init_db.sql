DROP DATABASE IF EXISTS spring_homework;
CREATE DATABASE IF NOT EXISTS spring_homework;
use spring_homework;

CREATE TABLE producer (
                            id int NOT NULL AUTO_INCREMENT,
                            name varchar(100) NOT NULL UNIQUE,
                            PRIMARY KEY (id));

CREATE TABLE product (
                        id int NOT NULL AUTO_INCREMENT,
                        name varchar(100),
                        price decimal NOT NULL,
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


CREATE TABLE producer_products (
                                   id_producer int NOT NULL,
                                   id_product int NOT NULL,
                                   PRIMARY KEY (id_producer, id_product),
                                   FOREIGN KEY (id_producer) REFERENCES producer (id) ON DELETE CASCADE,
                                   FOREIGN KEY (id_product) REFERENCES product (id) ON DELETE CASCADE);
