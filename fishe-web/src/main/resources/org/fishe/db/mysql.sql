--liquibase formatted sql

--changeset htmfilho:1

create table user (
    id          integer      not null primary key auto_increment,
    first_name  varchar(50)  not null,
    last_name   varchar(50)  not null,
    email       varchar(100) not null
) engine = innodb;

--changeset leguman:2
create table course (
    id          integer     not null primary key auto_increment,
    name        varchar(50) not null,
    description varchar(50) not null
) engine = innodb;