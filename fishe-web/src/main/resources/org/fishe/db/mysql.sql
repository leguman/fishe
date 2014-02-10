--liquibase formatted sql

--changeset htmfilho:1

create table user (
    id          integer      not null primary key auto_increment,
    first_name  varchar(50)  not null,
    last_name   varchar(50)  not null,
    email       varchar(100) not null
) engine = innodb;

--changeset verpoorten:2

create table room (
    id          integer      not null primary key auto_increment,
    description  varchar(250)  not null
) engine= innodb;