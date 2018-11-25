package mobalDev.repo.produitRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mobalDev.logic.produit.dto.TypeProduitEnum;
import mobalDev.model.ProduitEntity;

public interface ProduitRepository extends JpaRepository<ProduitEntity, Long>{

	List<ProduitEntity> findByLibelle(String libelle);
	
	ProduitEntity findByLibelleAndQuantiteCommande(String libelle, int quantiteCommande);
	
	ProduitEntity findByType(TypeProduitEnum type);
	
}
