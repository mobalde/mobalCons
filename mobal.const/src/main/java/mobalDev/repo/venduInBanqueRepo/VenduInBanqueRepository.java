package mobalDev.repo.venduInBanqueRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mobalDev.model.produit.LibelleProduitEnum;
import mobalDev.model.venduInBanque.VenduInBanqueEntity;


public interface VenduInBanqueRepository extends JpaRepository<VenduInBanqueEntity, Long>{
	
	List<VenduInBanqueEntity> findByIsDepotBanqueTrue();
	
	@Query(value = "SELECT DISTINCT vib from VenduEntity v" // 
				+ " INNER JOIN v.venduInBanque vib " //
				+ " INNER JOIN v.produit p"
				+ " WHERE p.libelleEnum = :name and vib.isDepotBanque = false")
	List<VenduInBanqueEntity> findAllNotVenduInBanqueForProduit(@Param("name") LibelleProduitEnum name);

}
