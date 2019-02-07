package mobalDev.logic.produit;

import java.util.List;

import mobalDev.logic.CrudGenerique;
import mobalDev.logic.produit.dto.ProduitDto;
import mobalDev.model.produit.MarqueProduitEnum;

public interface GestionProduit extends CrudGenerique<ProduitDto>{
	
	public int getQuantiteCommande(String libelle);
	public List<ProduitDto> getProduit(String libelle);
	public List<ProduitDto> getAllProduit();
	public ProduitDto getProduit(MarqueProduitEnum type);
	public int getQuantiteCommande(MarqueProduitEnum type);
}
