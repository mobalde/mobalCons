package mobalDev.logic.produit.dto;

public enum MarqueProduitEnum {

	GI_32_5("Ciment GI 32.5"), //
	DIAMOND_32_5("Ciment DIAMOND 32.5"), //
	GI_42_5("Ciment GI 42.5"), //
	DIAMOND_42_5("Ciment DIAMOND 42.5"), //
	PUMA("Puma"), //
	AUTRE("Autre");
	
	private String libelle;
	
	private MarqueProduitEnum(String libelle) {
		this.libelle = libelle;
	}

	public String getLibelle() {
		return libelle;
	}
}
