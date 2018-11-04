create table users(
	id BIGSERIAL NOT NULL,
	create_at timestamp without time zone,
	update_at timestamp without time zone,
	modificationcounter integer not null,
	Nom varchar(500) NOT NULL,
	prenom varchar(500) NOT NULL,
	email varchar(500) NOT NULL CONSTRAINT email_unique UNIQUE,
	password varchar(500) NOT NULL,
    enabled boolean,
    PRIMARY KEY(id)
);

create table role(
	id BIGSERIAL NOT NULL,
	create_at timestamp without time zone,
	update_at timestamp without time zone,
	modificationcounter integer not null,
	role varchar(30),
	PRIMARY KEY(id)
);

create table user_roles(
	user_id BIGSERIAL NOT NULL,
	role_id BIGSERIAL NOT NULL,
	PRIMARY KEY(user_id,role_id)
);

Alter table user_roles add CONSTRAINT fk_user_roles FOREIGN KEY(user_id) REFERENCES users(id);
Alter table user_roles add CONSTRAINT fk_role_user FOREIGN KEY(role_id) REFERENCES role(id);

insert into role (id,modificationcounter, role) values (1, 0, 'ROLE_ADMIN'),(2, 0, 'ROLE_DG'),(3, 0, 'ROLE_COMMERCANT');