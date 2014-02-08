--liquibase formatted sql

--changeset htmfilho:1

create table user (
    id          integer      not null primary key auto_increment,
    first_name  varchar(50)  not null,
    last_name   varchar(50)  not null,
    email       varchar(100) not null
) engine = innodb;

--changeset vbosman:2

create table person (
    id          Integer      not null primary key auto_increment,
    first_name  Varchar(50)  not null,
    last_name   Varchar(50)  not null,
    birth_date   Date not null
) engine = innodb;


