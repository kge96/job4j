create database request_system;

create table public.users
(
    id serial not null,
    name character(100),
    age integer,
    login character(100),
    password character(100),
    primary key(id)
);

create table public.role (
    id serial,
    name character(100),
    access character(100),
     primary key(id)
);

create table public.request(
	id serial not null,
    level character(100),
    comment character(100),
    primary key(id)
);

create table public.files(
	id serial not null,
   	name character(100),
    path character(100),
    type character(100),
    primary key(id)
);

insert into users(name, age, login, password) values('Ivan', 25, 'ivan26', '1234');
insert into users(name, age, login, password) values('John', 22, 'john22', 'dsfsef');
insert into users(name, age, login, password) values('Pet', 27, 'pet27', 'rge45fdh');

insert into role(name, access) values('user', 'user');
insert into role(name, access) values('admin', 'admin');
insert into role(name, access) values('guest', 'guest');

insert into request(level, comment) values('1', 'higher level access');
insert into request(level, comment) values('5', 'middle level access');
insert into request(level, comment) values('10', 'lower level access');

insert into files(name, path, type) values('Description', 'C:\user', 'docx');
insert into files(name, path, type) values('Task', 'C:\user\tasks', 'pdf');
insert into files(name, path, type) values('Sources', 'C:\user\sources', 'java');