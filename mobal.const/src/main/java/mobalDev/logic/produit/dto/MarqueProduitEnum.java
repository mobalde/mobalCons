package mobalDev.logic.produit.dto;

public enum MarqueProduitEnum {

	GI("Ciment GI"), //
	DIAMOND("Ciment DIAMOND"), //
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
