package mobalDev.model.banque;

import java.util.ArrayList;
import java.util.List;

public enum MotifEnum {

	ACHAT_MARCHANDISE("Achat marchandise"), //
	VENTE_MARCHANDISE("Vente marchandise");
	
	private String libelle;
	
	private MotifEnum(String libelle) {
		this.libelle = libelle;
	}

	public String getLibelle() {
		return libelle;
	}
	
	public static List<String> getLibelles(){
		
		List<String> libelles = new ArrayList<String>();
		for(MotifEnum motif : MotifEnum.values()) {
			libelles.add(motif.getLibelle());
		}
		return libelles;
	}
	
}
