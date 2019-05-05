package mobalDev.repo.banqueRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mobalDev.model.banque.BanqueEntity;

public interface BanqueRepository extends JpaRepository<BanqueEntity, Long>{
	
	@Query(value = "SELECT b.soldeAnterieur FROM BanqueEntity b WHERE b.venduInBanque.id = :id")
	Double findLastSolde(@Param("id") Long id);

}
