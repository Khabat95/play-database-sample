# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table dbpoker_table (
  name                      varchar(255) not null,
  table_type                integer,
  table_limit               integer,
  seat_number               integer,
  constraint ck_dbpoker_table_table_type check (table_type in (0,1)),
  constraint ck_dbpoker_table_table_limit check (table_limit in (0,1,2)),
  constraint pk_dbpoker_table primary key (name))
;

create table dbuser (
  email                     varchar(255) not null,
  password                  varchar(255),
  constraint pk_dbuser primary key (email))
;

create sequence dbpoker_table_seq;

create sequence dbuser_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists dbpoker_table;

drop table if exists dbuser;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists dbpoker_table_seq;

drop sequence if exists dbuser_seq;

