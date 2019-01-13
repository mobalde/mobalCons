package mobalDev.logic.marchandise;

import javax.validation.constraints.NotNull;

import mobalDev.logic.marchandise.dto.MarchandiseDto;

public interface GestionMarchandise {

	public MarchandiseDto registration(MarchandiseDto dto);
	public MarchandiseDto getLastMarchandise();
	public int getNbSacAnterieur();
	public void nombreDeSacVendu(MarchandiseDto dto, @NotNull Long idProduit);
	
}
