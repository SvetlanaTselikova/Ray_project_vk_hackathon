create sequence hibernate_sequence start 1 increment 1;

create table pets (
  id int4 not null,
  primary key (id));

create table tasks (
  id int4 not null,
  begin_date timestamp,
  description varchar(255),
  end_date timestamp,
  location varchar(255),
  title varchar(255),
  type varchar(255),
  pet_id int4,
  user_id int8,
  primary key (id));

create table users (
  id int8 not null,
  city varchar(255),
  name varchar(255),
  password varchar(255),
  phone_number varchar(255),
  role int4 not null,
  surname varchar(255),
  primary key (id));


alter table if exists tasks
  add constraint pet_fk
  foreign key (pet_id) references pets;

alter table if exists tasks
  add constraint user_fk
  foreign key (user_id) references users;