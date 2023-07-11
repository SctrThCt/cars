--liquibase formatted sql
-- changeset stc:2

create sequence engines_seq;

create table engines
(
    id           bigint primary key default nextval('engines_seq'),
    volume       integer,
    engine_model TEXT,
    type         varchar(255) check (type in ('V8', 'I6', 'I4', 'V6', 'B4'))
);

alter sequence engines_seq owned by engines.id;