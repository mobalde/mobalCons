package mobal.dev.test.config;

public enum LibelleProduitEnum {
	CIMENT("ciment"), //
	BASKET_BALL("basket ball"), //
	SAC_A_MAIN("sac a main");
	
	private String libelle;
	
	private LibelleProduitEnum(String libelle) {
		this.libelle = libelle;
	}

	public String getLibelle() {
		return libelle;
	}
}
