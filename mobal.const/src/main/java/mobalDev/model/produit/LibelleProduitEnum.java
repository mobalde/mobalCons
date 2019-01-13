package mobalDev.model.produit;

public enum LibelleProduitEnum {
	CIMENT("ciment"), //
	BASKET_BALL("basket ball"), //
	SAC_A_MAIN("sac a main"), //
	AUTRE("autre");
	
	private String libelle;
	
	private LibelleProduitEnum(String libelle) {
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
