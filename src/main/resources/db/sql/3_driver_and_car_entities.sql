--liquibase formatted sql
-- changeset stc:3

create sequence car_seq;

create table car
(
    id                   bigint primary key default nextval('car_seq'),
    model                varchar(255),
    engine_id            bigint,
    left_front_wheel_id  bigint,
    left_rear_wheel_id   bigint,
    right_front_wheel_id bigint,
    right_rear_wheel_id  bigint,
    foreign key (engine_id) references engines (id),
    foreign key (left_front_wheel_id) references wheel (id),
    foreign key (left_rear_wheel_id) references wheel (id),
    foreign key (right_front_wheel_id) references wheel (id),
    foreign key (right_rear_wheel_id) references wheel (id)
);

alter sequence car_seq owned by car.id;

create sequence driver_seq;

create table driver
(
    id       bigint not null,
    category varchar(255) check (category in ('A', 'B', 'C', 'D', 'E')),
    name     varchar(255),
    primary key (id)
);

alter sequence driver_seq owned by driver.id;

create table driver_cars
(
    car_id    bigint not null unique,
    driver_id bigint not null,
    foreign key (car_id) references car (id),
    foreign key (driver_id) references driver (id)
);

alter table car add
    driver_id bigint;
alter table car add
    foreign key (driver_id) references driver (id);


