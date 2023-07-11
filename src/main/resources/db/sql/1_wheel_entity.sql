--liquibase formatted sql
-- changeset stc:1

create sequence wheel_seq;
create table wheel
(
    id      bigint primary key default nextval('wheel_seq'),
    profile integer,
    radius  integer,
    type    varchar(255) check (type in ('OFFROAD', 'HIGHWAY'))
);
alter sequence wheel_seq owned by wheel.id;

