package mobalDev.logic.venduInBanque;

import java.util.List;

import mobalDev.logic.CrudGenerique;
import mobalDev.logic.venduInBanque.dto.VenduInBanqueDto;

public interface GestionVenduInBanque{
	
	public List<VenduInBanqueDto> listeDeVenteProduitNonDeposer(String libelleProduit);
	
}
