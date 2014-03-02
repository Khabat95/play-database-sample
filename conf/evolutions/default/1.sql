# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table dbpoker_table (
  name                      varchar(255) not null,
  table_type                integer not null,
  table_limit               integer not null,
  seat_number               integer not null,
  constraint ck_dbpoker_table_table_type check (table_type in (0,1)),
  constraint ck_dbpoker_table_table_limit check (table_limit in (0,1,2)),
  constraint pk_dbpoker_table primary key (name))
;

create table dbuser (
  email                     varchar(255) not null,
  password                  varchar(255) not null,
  poker_table_name          varchar(255),
  constraint pk_dbuser primary key (email))
;

create sequence dbpoker_table_seq;

create sequence dbuser_seq;

alter table dbuser add constraint fk_dbuser_pokerTable_1 foreign key (poker_table_name) references dbpoker_table (name) on delete restrict on update restrict;
create index ix_dbuser_pokerTable_1 on dbuser (poker_table_name);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists dbpoker_table;

drop table if exists dbuser;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists dbpoker_table_seq;

drop sequence if exists dbuser_seq;

