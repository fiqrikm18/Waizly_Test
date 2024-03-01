create
or replace table orders
(
    id           binary(16)  not null primary key,
    created_at   datetime(6) null,
    deleted_at   datetime(6) null,
    updated_at   datetime(6) null,
    order_status tinyint     null,
    adm_fee      int         null,
    tax          int         null,
    total        int         null
);

create
or replace table products
(
    id         binary(16)   not null primary key,
    created_at datetime(6)  null,
    deleted_at datetime(6)  null,
    updated_at datetime(6)  null,name       varchar(255) null,
    summary    varchar(255) null
discount   int          null,
    price      int          null
       );

create
or replace table order_items
(
    id         binary(16)  not null primary key,
    created_at datetime(6) null,
    deleted_at datetime(6) null,
    updated_at datetime(6) null,
       order_id   binary(16)  null,
    product_id binary(16)  null,
    price      int         null,
    qty        int         null,
       constraint FKbioxgbv59vetrxe0ejfubep1w
        foreign key (order_id) references orders (id),
    constraint FKocimc7dtr037rh4ls4l95nlfi
        foreign key (product_id) references products (id)
);

create
or replace table products_order_item
(
    order_item_id binary(16) not null,
    product_id    binary(16) not null,
    constraint UK_cp301f03gv8wfud5w1iq1qut8
        unique (order_item_id),
    constraint FKlt8mmbyk4wl5g98g2gxjd6y36
        foreign key (product_id) references products (id),
    constraint FKqdxon7f0s2e67p17xkklhd027
        foreign key (order_item_id) references order_items (id)
);

create
or replace table users
(
    role     tinyint      null,
    id       binary(16)   not null
        primary key,
    password varchar(255) null,
    username varchar(255) null
);

INSERT INTO waizly.users (role, id, password, username)
VALUES (0, 0x7B3C71E00CE043C3912D78FE1D2120B8, '$2a$10$0Y/HbpANdW6YC7Pi7J/uE.Rgu/vnQc9WFQHgofQnPbFrn7SNOC2V2', 'admin');


