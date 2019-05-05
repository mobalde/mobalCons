create table historique_produit(
	id BIGSERIAL NOT NULL,
	create_at timestamp without time zone,
	update_at timestamp without time zone,
	modificationcounter integer not null,
	libelle varchar(500) not null,
	quantite integer not null,
	PRIMARY KEY(id)
);
