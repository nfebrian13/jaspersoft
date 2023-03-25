create table student
(
   id integer not null,
   name varchar(255) not null,
   passport_number varchar(255) not null,
   primary key(id)
);

create table employee
(
   id integer not null,
   name varchar(255) not null,
   designation varchar(255) not null,
   salary numeric(20,2) not null,
   doj varchar(255) not null,
   primary key(id)
);