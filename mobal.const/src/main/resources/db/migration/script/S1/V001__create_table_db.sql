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

create table prix(
	id BIGSERIAL NOT NULL,
	create_at timestamp without time zone,
	update_at timestamp without time zone,
	modificationcounter integer not null,
	prix double precision not null,
	PRIMARY KEY(id)
);

create table produit(
	id BIGSERIAL NOT NULL,
	create_at timestamp without time zone,
	update_at timestamp without time zone,
	modificationcounter integer not null,
	libelle varchar(500) not null,
	PRIMARY KEY(id)
);

create table vendu(
	id BIGSERIAL NOT NULL,
	create_at timestamp without time zone,
	update_at timestamp without time zone,
	modificationcounter integer not null,
	date_debut date not null,
	date_fin date not null,
	quantite integer not null,
	total double precision,
	produit_id BIGSERIAL,
	prix_id BIGSERIAL,
	PRIMARY KEY(id)
);

alter table vendu add CONSTRAINT fk_produit_vendu FOREIGN KEY(produit_id) REFERENCES produit(id);
alter table vendu add CONSTRAINT fk_prix_vendu FOREIGN KEY(prix_id) REFERENCES prix(id);

create table banque(
	id BIGSERIAL NOT NULL,
	create_at timestamp without time zone,
	update_at timestamp without time zone,
	modificationcounter integer not null,
	date_depot date not null,
	agence_de_depot varchar(500),
	numero_ticket varchar(1000) not null,
	montant double precision,
	is_depot boolean,
	is_retrait boolean,
	vendu_id BIGSERIAL,
	PRIMARY KEY(id)
);

Alter table banque add CONSTRAINT fk_vendu_banque FOREIGN KEY(vendu_id) REFERENCES vendu(id);

create table user_roles(
	user_id BIGSERIAL NOT NULL,
	role_id BIGSERIAL NOT NULL,
	PRIMARY KEY(user_id,role_id)
);

Alter table user_roles add CONSTRAINT fk_user_roles FOREIGN KEY(user_id) REFERENCES users(id);
Alter table user_roles add CONSTRAINT fk_role_user FOREIGN KEY(role_id) REFERENCES role(id);

insert into role (id,modificationcounter, role) values (1, 0, 'ROLE_ADMIN'),(2, 0, 'ROLE_DG'),(3, 0, 'ROLE_COMMERCANT');