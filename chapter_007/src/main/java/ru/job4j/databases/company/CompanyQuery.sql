insert into person(id, name, company_id) values(1, 'Ivan', 2);
insert into person(id, name, company_id) values(2, 'Fedor', 2);
insert into person(id, name, company_id) values(3, 'Fedor', 1);
insert into person(id, name, company_id) values(4, 'Nick', 3);
insert into person(id, name, company_id) values(5, 'Mike', 2);
insert into person(id, name, company_id) values(6, 'John', 5);
insert into person(id, name, company_id) values(7, 'Kris', 5);

insert into company(id, name) values(1, 'A');
insert into company(id, name) values(2, 'B');
insert into company(id, name) values(3, 'C');
insert into company(id, name) values(4, 'D');
insert into company(id, name) values(5, 'E');

select p.name, c.name
from person
as p left outer join company as c on p.company_id = c.id
where c.id != 5;

select c.name, count(p.name) as c
from person p, company c
where p.company_id = c.id
group by company_id, c.name
order by c desc
limit 1;