create schema photo_shop;

create table user
(
    id int auto_increment,
    firstName varchar(50) not null,
    lastName varchar(50) not null,
    login varchar(50) not null,
    password varchar(20) not null,
    phoneNumber int not null,
    activationCode varchar(50) null,
    role varchar(10) null
);

create unique index user_id_uindex
    on user (id);

create unique index user_login_uindex
    on user (login);

alter table user
    add constraint user_pk
        primary key (id);

