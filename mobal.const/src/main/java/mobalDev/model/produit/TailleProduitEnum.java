package mobalDev.model.produit;

public enum TailleProduitEnum {
	TRENTE_DEUX_CINQ("32,5"), //
	QUARANTE_DEUX_CINQ("42,5");
	
	private String libelle;
	
	private TailleProduitEnum(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * retourne le libelle du produit
	 * @return
	 */
	public String getLibelle() {
		return libelle;
	}
}
