create database request_system;

create table files(
    id serial primary key not null,
    name character(100),
    extention character(100),
    path character(100)
);

create table role(
    id serial primary key not null,
    name character(100),
    level_access integer,
    primary key(id)
);

create table users(
	  id serial primary key not null,
    name character(100),
    surname character(100),
    phone integer,
    user_role_id integer references role(id)
);

create table orders(
    id serial primary key not null,
    user_id integer references users(id),
    files_id integer references files(id),
    status character(100),
    category character(100),
    comments character(100)
);

insert into files(name, path, extention) values('Description', 'C:\user', 'docx');
insert into files(name, path, extention) values('Task', 'C:\user\tasks', 'pdf');
insert into files(name, path, extention) values('Sources', 'C:\user\sources', 'java');

insert into role(name, level_access) values('admin', 5);
insert into role(name, level_access) values('user', 3);
insert into role(name, level_access) values('guest', 7);

insert into users(name, surname, phone, user_role_id) values('Ivan', 'Petrov', 123443, 2);
insert into users(name, surname, phone, user_role_id) values('John', 'Smith', 33232, 2);
insert into users(name, surname, phone, user_role_id) values('Mike', 'Padesky', 97456, 1);
insert into users(name, surname, phone, user_role_id) values('Igor', 'Krust', 13424232, 3);
insert into users(name, surname, phone, user_role_id) values('Klaus', 'Krust', 13424232, 2);
insert into users(name, surname, phone, user_role_id) values('Fridrich', 'Krust', 13424, 3);

insert into orders(user_id, files_id, status, category, comments) values(1, 1,'ready', 'type-1', 'comments-1');
insert into orders(user_id, files_id, status, category, comments) values(2, 2, 'ready', 'type-2', 'comments-2');
insert into orders(user_id, files_id, status, category, comments) values(3, 3, 'in_work', 'type-1', 'comments-3');
insert into orders(status, category, comments) values('ready', 'type-2', 'comments-3');
insert into orders(status, category, comments) values('in_work', 'type-3', 'comments-3');
insert into orders(status, category, comments) values('ready', 'type-1', 'comments-3');


select * from users as u where u.surname = 'Krust';
select * from role as r where r.level_access < 6;
select count(*) from users;
select * from orders as o where o.status = 'ready' and o.category = 'type-1';
select * from users as u where u.surname like '%P%';
select * from role as r where r.level_access between 4 and 9;
select * from role as r where r.level_access in(1, 3, 5);

select * from orders as o
inner join users as u on o.id = u.id;

