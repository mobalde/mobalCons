ALTER TABLE banque RENAME date_depot To date_operation;
ALTER TABLE banque RENAME agence_de_depot To agence;
ALTER TABLE banque RENAME argent_depose To somme;
ALTER TABLE banque ADD COLUMN is_virement boolean default false;
ALTER TABLE banque ADD COLUMN motif varchar(12);