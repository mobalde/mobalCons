package mobalDev.logic.banque;

import javax.validation.constraints.NotNull;

import mobalDev.logic.CrudGenerique;
import mobalDev.logic.venduInBanque.dto.VenduInBanqueDto;

public interface GestionBanque extends CrudGenerique<VenduInBanqueDto>{
	
	public Double getSoldeAnterieur(@NotNull Long id);
}
