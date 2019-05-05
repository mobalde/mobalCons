package mobalDev.model.produit;

import java.util.ArrayList;
import java.util.List;

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
	
	public static List<String> getLibelles(){
		
		List<String> libelles = new ArrayList<String>();
		for(LibelleProduitEnum libelleEnum : LibelleProduitEnum.values()) {
			libelles.add(libelleEnum.getLibelle());
		}
		return libelles;
	}
}
