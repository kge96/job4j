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
 insert into orders(status, category, comments) values('in_work', 'type-1', 'comments-3');
 insert into orders(status, category, comments) values('ready', 'type-2', 'comments-3');
 insert into orders(status, category, comments) values('in_work', 'type-3', 'comments-3');
 insert into orders(status, category, comments) values('ready', 'type-1', 'comments-3');

insert into users(name, surname, phone) values('Ivan', 'Petrov', 123443);
insert into users(name, surname, phone) values('John', 'Smith', 33232);
insert into users(name, surname, phone) values('Mike', 'Padesky', 97456);
insert into users(name, surname, phone) values('Igor', 'Krust', 13424232);
insert into users(name, surname, phone) values('Klaus', 'Krust', 13424232);
insert into users(name, surname, phone) values('Fridrich', 'Krust', 13424);


insert into role(name, level_access) values('user1', 5);
insert into role(name, level_access) values('user2', 3);
insert into role(name, level_access) values('user3', 7);
insert into role(name, level_access) values('user4', 5);
insert into role(name, level_access) values('user5', 1);
insert into role(name, level_access) values('user6', 8);
insert into role(name, level_access) values('user7', 2);
insert into role(name, level_access) values('user8', 10);

insert into files(name, path, extention) values('Description', 'C:\user', 'docx');
insert into files(name, path, extention) values('Task', 'C:\user\tasks', 'pdf');
insert into files(name, path, extention) values('Sources', 'C:\user\sources', 'java');


select * from users as u where u.surname = 'Krust';
select * from role as r where r.level_access < 6;
select count(*) from users;
select * from orders as o where o.status = 'ready' and o.category = 'type-1';
select * from users as u where u.surname like '%P%';
select * from role as r where r.level_access between 4 and 9;
select * from role as r where r.level_access in(1, 3, 5);

select * from orders as o
inner join users as u on o.id = u.id;

