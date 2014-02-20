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

--changeset leymouna:9

create table building (
    id          integer     not null primary key auto_increment,
    name        varchar(50) not null,
    description varchar(100) not null
) engine = innodb;

--changeset htmfilho:10

create table organization (
    id          integer      not null primary key auto_increment,
    name        varchar(100) not null,
    description text             null,
    acronym     varchar(20)      null,
    parent      integer          null
) engine = innodb;

alter table building change description description text null;
alter table building add organization integer null;
create index idx_organization_building on building (organization);
alter table building add constraint fk_organization_building foreign key (organization) references organization (id) on delete set null;

alter table room add name varchar(30) not null;
alter table room change description description text null;
alter table room add building integer null;
create index idx_building_room on room (building);
alter table room add constraint fk_building_room foreign key (building) references building (id) on delete set null;