package mobalDev.logic.banque;

import mobalDev.logic.CrudGenerique;
import mobalDev.logic.banque.dto.BanqueDto;
import mobalDev.logic.venduInBanque.dto.VenduInBanqueDto;

public interface GestionBanque extends CrudGenerique<VenduInBanqueDto>{
	
	public Double getSoldeAnterieur();
}
