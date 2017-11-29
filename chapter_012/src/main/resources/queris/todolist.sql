create TABLE items (
    id serial primary key not null,
    description varchar(100),
    created timestamp not null,
    done boolean not null
    );