package mobalDev.logic.produit.dto;

public enum TypeProduitEnum {

	GI("Ciment GI"), //
	DIAMOND("Ciment DIAMOND"), //
	AUTRE("Autre");
	
	private String libelle;
	
	private TypeProduitEnum(String libelle) {
		this.libelle = libelle;
	}

	public String getLibelle() {
		return libelle;
	}
}
