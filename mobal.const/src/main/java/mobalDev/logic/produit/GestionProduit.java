package mobalDev.logic.produit;

import mobalDev.logic.CrudGenerique;
import mobalDev.logic.produit.dto.ProduitDto;

public interface GestionProduit extends CrudGenerique{
	
	public int getQuantiteCommande(String libelle);
	public ProduitDto getProduit(String libelle);
}
