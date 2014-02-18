--liquibase formatted sql

--changeset htmfilho:1

create table user (
    id          integer      not null primary key auto_increment,
    first_name  varchar(50)  not null,
    last_name   varchar(50)  not null,
    email       varchar(100) not null
) engine = innodb;


--changeset sarace:2

create table academic_year (
    id                              integer     not null primary key auto_increment,
    academic_year                   integer     not null unique,
    registration_start_date         date,
    registration_end_date           date
) engine = innodb;


--changeset leguman:3

create table course (
    id          integer     not null primary key auto_increment,
    name        varchar(50) not null,
    description varchar(50) not null
) engine = innodb;


--changeset axel:4

create table partner (
    id          integer     not null primary key auto_increment,
    name        varchar(50) not null,
    description varchar(100) not null
) engine = innodb;

--changeset vbosman:5

create table person (
    id          Integer      not null primary key auto_increment,
    first_name  Varchar(50)  not null,
    last_name   Varchar(50)  not null,
    birth_date   Date not null
) engine = innodb;

--changeset verpoorten:6

create table room (
    id          integer      not null primary key auto_increment,
    description  varchar(250)  not null
) engine= innodb;

--changeset bruyere:7

create table domain (
    id          integer     not null primary key auto_increment,
    name        varchar(50) not null,
    description varchar(100) not null
) engine = innodb;

--changeset evase:8

create table function (
    id          integer     not null primary key auto_increment,
    name        varchar(50) not null,
    description varchar(100) not null
) engine = innodb;

