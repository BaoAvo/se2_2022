CREATE DATABASE bookdb;

USE bookdb;

CREATE TABLE book(
id INT PRIMARY KEY AUTO_INCREMENT,
title VARCHAR(50) NOT NULL,
author VARCHAR(50) NOT NULL,
price FLOAT NOT NULL
);

INSERT INTO book(title,author,price)
VALUES("Java Web","John",100),("Spring Boot","David",120);