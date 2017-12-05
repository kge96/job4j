create table fuel (
    id serial primary key not null,
    type varchar(100)
);

create table engine (
  id serial primary key not null,
  volume varchar(100),
  fuel_id int references fuel(id)
  );

create table transmission (
  id serial primary key not null,
  type varchar(100)
  );

create table body (
  id serial primary key not null,
  type varchar(100)
  );

  create table producer(
    id serial primary key not null,
    mark varchar(100)
  );

create table car (
  id serial primary key not null,
  mark_id int references producer(id),
  engine_id int references engine(id),
  transmission_id int references transmission(id),
  body_id int references body(id)
);

insert into car_body(form) values('sedan');
insert into car_body(form) values('hatchback');
insert into car_body(form) values('wagon');

insert into engine(volume, fuel_type) values('2.0', 'Diesel');
insert into engine(volume, fuel_type) values('1.6', 'Gasoline');
insert into engine(volume, fuel_type) values('1.4', 'Gasoline');
insert into engine(volume, fuel_type) values('1.2', 'Gas');

insert into transmission(type) values('Mechanics');
insert into transmission(type) values('Automatic');
insert into transmission(type) values('Robot');

insert into car (mark, engine_id, transmission_id, carbody_id) values('Lada', 2, 1, 1);
insert into car (mark , engine_id, transmission_id, carbody_id) values('Skoda', 3, 3, 3);
insert into car (mark, engine_id, transmission_id, carbody_id) values('Volkswagen', 1, 1, 3);
insert into car (mark, engine_id, transmission_id, carbody_id) values('UAZ', 4, 1, 3);

select c.mark, e.volume, e.fuel_type from car as c left outer join engine as e on c.engine_id = e.id;
select c.mark, e.volume, e.fuel_type from car as c right outer join engine as e on c.engine_id = e.id;
select c.mark, e.volume, e.fuel_type from car as c right outer join engine as e on c.engine_id = e.id where mark is null;

select c.mark, t.type from car as c left outer join transmission as t on c.transmission_id = t.id;
select c.mark, t.type from car as c right outer join transmission as t on c.transmission_id = t.id;
select c.mark, t.type from car as c right outer join transmission as t on c.transmission_id = t.id where c.mark is null;

select c.id, c.mark, cb.form from car as c left outer join car_body as cb on c.carbody_id = cb.id;
select c.id, c.mark, cb.form from car as c right outer join car_body as cb on c.carbody_id = cb.id;
select c.id, c.mark, cb.form from car as c right outer join car_body as cb on c.carbody_id = cb.id where mark is null;

select c.mark, e.volume, e.fuel_type, t.type, cb.form from car as c
left outer join engine as e on c.engine_id = e.id
left outer join transmission as t on c.transmission_id = t.id
left outer join car_body as cb on c.carbody_id = cb.id;


select c.mark, e.volume, e.fuel_type, t.type, cb.form from car as c
right outer join engine as e on c.engine_id = e.id
right outer join transmission as t on c.transmission_id = t.id
right outer join car_body as cb on c.carbody_id = cb.id where c.mark is null;



 select c.id, b.type, e.volume, t.type, p.mark from car as c
    inner join body as b on c.body_id = b.id
    inner join producer as p on c.mark_id=p.id
    inner join engine as e on c.engine_id=e.id
    inner join transmission as t on c.transmission_id = t.id;
