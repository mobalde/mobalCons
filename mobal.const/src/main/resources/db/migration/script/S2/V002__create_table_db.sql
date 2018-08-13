create table produit(
	id BIGSERIAL NOT NULL,
	create_at timestamp without time zone,
	update_at timestamp without time zone,
	modificationcounter integer not null,
	libelle varchar(500) not null,
	quantite_commande integer not null,
	PRIMARY KEY(id)
);

create table vendu_in_banque(
	id BIGSERIAL NOT NULL,
	create_at timestamp without time zone,
	update_at timestamp without time zone,
	modificationcounter integer not null,
	is_depot_banque boolean default false,
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
	prix_unitaire double precision,
	total double precision,
	produit_id BIGSERIAL,
	vendu_in_banque_id BIGSERIAL,
	PRIMARY KEY(id)
);

alter table vendu add CONSTRAINT fk_produit_vendu FOREIGN KEY(produit_id) REFERENCES produit(id);
alter table vendu add CONSTRAINT fk_vendu_in_banque_vendu FOREIGN KEY(vendu_in_banque_id) REFERENCES vendu_in_banque(id);

create table banque(
	id BIGSERIAL NOT NULL,
	create_at timestamp without time zone,
	update_at timestamp without time zone,
	modificationcounter integer not null,
	date_depot date not null,
	agence_de_depot varchar(500),
	numero_ticket varchar(1000) not null,
	argent_depose double precision not null,
	solde_anterieur double precision not null,
	total double precision,
	is_depot boolean,
	is_retrait boolean,
	vendu_in_banque_id BIGSERIAL,
	PRIMARY KEY(id)
);

alter table banque add CONSTRAINT fk_vendu_in_banque_banque FOREIGN KEY(vendu_in_banque_id) REFERENCES vendu_in_banque(id);

create table marchandise(
	id BIGSERIAL NOT NULL,
	create_at timestamp without time zone,
	update_at timestamp without time zone,
	modificationcounter integer not null,
	date_debut date not null,
	date_fin date not null,
	nb_sac_vendu int not null,
	nb_sac_anterieur int not null default 0,
	total_sac_vendu int not null,
	total_sac_marchandise int not null,
	total_marchandise_restant int not null,
	produit_id BIGSERIAL,
	PRIMARY KEY(id)
);

alter table marchandise add CONSTRAINT fk_produit_marchandise FOREIGN KEY(produit_id) REFERENCES produit(id);
