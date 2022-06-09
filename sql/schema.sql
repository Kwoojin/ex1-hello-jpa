drop table if exists Member CASCADE;
CREATE table Member (
    id bigint not null,
    name varchar(255),
    primary key(id)
);