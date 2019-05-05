package mobalDev.repo.produitRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mobalDev.model.produit.MarqueProduitEnum;
import mobalDev.model.produit.ProduitEntity;

public interface ProduitRepository extends JpaRepository<ProduitEntity, Long>{

	List<ProduitEntity> findByLibelle(String libelle);
	ProduitEntity findByLibelleAndQuantiteCommande(String libelle, int quantiteCommande);
	@Query("SELECT p from ProduitEntity p where p.type = :type")
	ProduitEntity findType(@Param("type") MarqueProduitEnum type);
}
