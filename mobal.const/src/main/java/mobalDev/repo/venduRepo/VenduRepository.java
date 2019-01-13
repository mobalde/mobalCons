package mobalDev.repo.venduRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mobalDev.model.vendu.VenduEntity;

public interface VenduRepository extends JpaRepository<VenduEntity, Long>{

	@Query(value = " SELECT SUM(v.quantite) FROM VenduEntity v " //
				 + " INNER JOIN v.produit p	"
				 + " WHERE p.id = :id and v.isComptabiliser = false GROUP BY p.id" //
		  )
	int calculNombreDeSacVendu(@Param("id") Long id);
	
	@Query(value = " SELECT v FROM VenduEntity v " //
				 + " INNER JOIN v.produit p " //
				 + " WHERE p.id = :id and v.isComptabiliser = false" //
		  )
	List<VenduEntity> findByProduit(@Param("id") Long id);
}
