# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table db_poker_table (
  name                      varchar(255) not null,
  table_type                integer not null,
  table_limit               integer not null,
  seat_number               integer not null,
  constraint ck_db_poker_table_table_type check (table_type in (0,1)),
  constraint ck_db_poker_table_table_limit check (table_limit in (0,1,2)),
  constraint pk_db_poker_table primary key (name))
;

create table db_user (
  email                     varchar(255) not null,
  password                  varchar(255) not null,
  poker_table_name          varchar(255),
  constraint pk_db_user primary key (email))
;

create sequence db_poker_table_seq;

create sequence db_user_seq;

alter table db_user add constraint fk_db_user_pokerTable_1 foreign key (poker_table_name) references db_poker_table (name) on delete restrict on update restrict;
create index ix_db_user_pokerTable_1 on db_user (poker_table_name);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists db_poker_table;

drop table if exists db_user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists db_poker_table_seq;

drop sequence if exists db_user_seq;

