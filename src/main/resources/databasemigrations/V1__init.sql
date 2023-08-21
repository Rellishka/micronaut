CREATE SEQUENCE IF NOT EXISTS HIBERNATE_SEQUENCE;

create table genre(
    id bigint not null primary key,
    name varchar(255) not null,
    constraint id unique (id),
);
