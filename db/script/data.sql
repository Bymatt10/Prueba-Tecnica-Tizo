create
    database reserve;
use
    reserve;
create table dinner
(
    id_dinner   int auto_increment
        primary key,
    id_menu     int                  null,
    name        varchar(255)         not null,
    description varchar(255)         not null,
    price       decimal(10, 2)       not null,
    status      boolean default true not null
);

create table menu
(
    id_menu int auto_increment
        primary key,
    name    varchar(255)         not null,
    price   decimal(10, 2)       not null,
    state   boolean default true not null
);

create table menuDinner
(
    id_menu   int auto_increment
        primary key,
    id_dinner int null,
    constraint fk_id_dinner
        foreign key (id_dinner) references dinner (id_dinner),
    constraint fk_id_menu
        foreign key (id_menu) references menu (id_menu)
);

create table reserve
(
    id_reserve      int auto_increment
        primary key,
    customer_name   varchar(255)         not null,
    customer_number varchar(255)         not null,
    date_reserve    date                 not null,
    state           boolean default true not null
        id_menu int null,
    constraint fk_id_menu_reserve
        foreign key (id_menu) references menu (id_menu)
);

