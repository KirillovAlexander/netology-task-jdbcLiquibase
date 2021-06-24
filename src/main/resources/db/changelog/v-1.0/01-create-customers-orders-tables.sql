CREATE TABLE IF NOT EXISTS CUSTOMERS
(
    id           int PRIMARY KEY,
    name         varchar(50) not null,
    surname      varchar(50) not null,
    age          int         not null,
    phone_number varchar(20)
);

CREATE TABLE IF NOT EXISTS ORDERS
(
    id           int PRIMARY KEY,
    date         date         not null,
    customer_id  int          not null,
    product_name varchar(150) not null,
    amount       int          not null,
    CONSTRAINT fk_orders foreign key (customer_id) references CUSTOMERS (id)
);