package mobalDev.logic.venduInBanque;

import java.util.List;

import mobalDev.logic.CrudGenerique;
import mobalDev.logic.venduInBanque.dto.VenduInBanqueDto;
import mobalDev.model.produit.LibelleProduitEnum;

public interface GestionVenduInBanque{
	
	public List<VenduInBanqueDto> listeDeVenteProduitNonDeposer(LibelleProduitEnum libelleProduit);
	
}
