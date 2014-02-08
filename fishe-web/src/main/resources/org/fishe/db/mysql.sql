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