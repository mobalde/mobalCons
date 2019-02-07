package mobalDev.model.produit;

import java.util.ArrayList;
import java.util.List;

public enum MarqueProduitEnum {

	GI_32_5("Ciment GI 32.5"), //
	DIAMOND_32_5("Ciment DIAMOND 32.5"), //
	GI_42_5("Ciment GI 42.5"), //
	DIAMOND_42_5("Ciment DIAMOND 42.5"), //
	PUMA("basket ball Puma"), //
	AUTRE("Autre");
	
	private String libelle;
	
	private MarqueProduitEnum(String libelle) {
		this.libelle = libelle;
	}

	public String getLibelle() {
		return libelle;
	}
	
	public static List<String> getLibelles(){
		
		List<String> libelles = new ArrayList<String>();
		for(MarqueProduitEnum marqueEnum : MarqueProduitEnum.values()) {
			libelles.add(marqueEnum.getLibelle());
		}
		return libelles;
	}
}
