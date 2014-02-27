# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table poker_table (
  name                      varchar(255) not null,
  table_type                integer,
  table_limit               integer,
  seat_number               integer,
  constraint ck_poker_table_table_type check (table_type in (0,1)),
  constraint ck_poker_table_table_limit check (table_limit in (0,1,2)),
  constraint pk_poker_table primary key (name))
;

create table user (
  email                     varchar(255) not null,
  password                  varchar(255),
  constraint pk_user primary key (email))
;

create sequence poker_table_seq;

create sequence user_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists poker_table;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists poker_table_seq;

drop sequence if exists user_seq;

