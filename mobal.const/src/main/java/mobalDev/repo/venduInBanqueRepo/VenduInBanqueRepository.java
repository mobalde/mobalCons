package mobalDev.repo.venduInBanqueRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mobalDev.model.VenduInBanqueEntity;


public interface VenduInBanqueRepository extends JpaRepository<VenduInBanqueEntity, Long>{
	
	List<VenduInBanqueEntity> findByIsDepotBanqueTrue();
	
	@Query(value = "SELECT vib from VenduInBanqueEntity vib" // 
				+ " INNER JOIN vib.venduEntity v " //
				+ " INNER JOIN v.produit p"
				+ " WHERE p.libelle = :name")
	List<VenduInBanqueEntity> findAllNotVenduInBanqueForProduit(@Param("name") String name);

}
