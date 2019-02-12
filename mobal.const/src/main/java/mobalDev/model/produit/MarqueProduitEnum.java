package mobalDev.model.produit;

import java.util.ArrayList;
import java.util.List;

public enum MarqueProduitEnum {

	GI_32_5("ciment GI 32.5"), //
	DIAMOND_32_5("ciment DIAMOND 32.5"), //
	GI_42_5("ciment GI 42.5"), //
	DIAMOND_42_5("ciment DIAMOND 42.5"), //
	PUMA("basket ball Puma"), //
	AUTRE("autre");
	
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
