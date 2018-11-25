package mobalDev.logic.produit;

import java.util.List;

import mobalDev.logic.CrudGenerique;
import mobalDev.logic.produit.dto.ProduitDto;
import mobalDev.logic.produit.dto.TypeProduitEnum;

public interface GestionProduit extends CrudGenerique<ProduitDto>{
	
	public int getQuantiteCommande(String libelle);
	public List<ProduitDto> getProduit(String libelle);
	public List<ProduitDto> getAllProduit();
	public ProduitDto getProduit(TypeProduitEnum type);
	public int getQuantiteCommande(TypeProduitEnum type);
}
