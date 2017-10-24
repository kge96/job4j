create database request_system;

create table public.users(
	  id serial not null,
    name character(100),
    surname character(100),
    phone integer,
    primary key(id)
);

create table role(
    id serial,
    name character(100),
    level_access integer,
    primary key(id)
);

create table orders(
    id serial not null,
    status character(100),
    category character(100),
    comments character(100)
);

create table files(
    id serial not null,
    name character(100),
    extention character(100),
    path character(100)
);

 insert into orders(status, category, comments) values('ready', 'type-1', 'comments-1');
 insert into orders(status, category, comments) values('ready', 'type-2', 'comments-2');
 insert into orders(status, category, comments) values('ready', 'type-3', 'comments-3');

insert into users(name, surname, phone) values('Ivan', 'Petrov', '123443');
insert into users(name, surname, phone) values('John', 'Smith', '33232');
insert into users(name, surname, phone) values('Mike', 'Padesky', '97456');
insert into users(name, surname, phone) values('Igor', 'Krust', '13424');


insert into role(name, level_access) values('user', 5);
insert into role(name, level_access) values('admin', 1);
insert into role(name, level_access) values('guest', 10);

insert into files(name, path, extention) values('Description', 'C:\user', 'docx');
insert into files(name, path, extention) values('Task', 'C:\user\tasks', 'pdf');
insert into files(name, path, extention) values('Sources', 'C:\user\sources', 'java');