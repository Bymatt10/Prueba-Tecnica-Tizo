create database if not exists reserve;
use reserve;
create table dinner
(
    id_dinner   bigint auto_increment
        primary key,
    description varchar(255) not null,
    name        varchar(255) not null,
    price       double       not null
);

create table menu
(
    id_menu bigint auto_increment
        primary key,
    name    varchar(255) not null,
    price   double       not null,
    state   bit          null
);

create table menu_dinner
(
    id        bigint auto_increment
        primary key,
    id_dinner bigint null,
    id_menu   bigint null,
    constraint fk_id_dinner
        foreign key (id_dinner) references dinner (id_dinner),
    constraint fk_id_menu
        foreign key (id_menu) references menu (id_menu)
);

create table reserve
(
    id_reserve      bigint auto_increment
        primary key,
    customer_name   varchar(255) not null,
    customer_number varchar(255) not null,
    date_reserve    datetime(6)  not null,
    state           bit          null,
    id_menu         bigint       null,
    constraint unique_reserve_id_menu
        unique (id_menu),
    constraint fk_reserve_id_menu
        foreign key (id_menu) references menu (id_menu)
);

