package mobalDev.logic.venduInBanque;

import java.util.List;

import mobalDev.logic.CrudGenerique;
import mobalDev.model.VenduInBanqueEntity;

public interface GestionVenduInBanque extends CrudGenerique{
	
	public List<VenduInBanqueEntity> listeDeVenteProduitNonDeposer(String libelleProduit);
}
