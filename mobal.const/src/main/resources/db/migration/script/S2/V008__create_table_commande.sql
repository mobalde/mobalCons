CREATE table commande(
	id BIGSERIAL NOT NULL,
	create_at timestamp without time zone,
	update_at timestamp without time zone,
	modificationcounter integer not null,
	quantite int not null,
	montant double precision not null,
	date_achat Date not null,
	produit_id BIGSERIAL,
	PRIMARY KEY(id)
);

ALTER TABLE commande ADD CONSTRAINT fk_commande_produit FOREIGN KEY(produit_id) REFERENCES produit(id);

ALTER TABLE banque ADD COLUMN commande_id BIGSERIAL;

ALTER TABLE banque ADD CONSTRAINT fk_banque_commande FOREIGN KEY(commande_id) REFERENCES commande(id);

ALTER TABLE banque ALTER COLUMN vendu_in_banque_id DROP NOT NULL;

ALTER TABLE banque ALTER COLUMN commande_id DROP NOT NULL;