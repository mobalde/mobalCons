package mobalDev.logic.marchandise;

import mobalDev.logic.marchandise.dto.MarchandiseDto;

public interface GestionMarchandise {

	public boolean registration(MarchandiseDto dto);
	public MarchandiseDto getLastMarchandise();
	public int getNbSacAnterieur();
	
}
