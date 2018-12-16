package mobal.dev.test.config;

public enum LibelleProduit {
	CIMENT("ciment"), //
	BASKET_BALL("basket ball"), //
	SAC_A_MAIN("sac a main");
	
	private String libelle;
	
	private LibelleProduit(String libelle) {
		this.libelle = libelle;
	}

	public String getLibelle() {
		return libelle;
	}
}
