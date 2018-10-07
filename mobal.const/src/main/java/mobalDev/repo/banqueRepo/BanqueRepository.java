package mobalDev.repo.banqueRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mobalDev.model.BanqueEntity;

public interface BanqueRepository extends JpaRepository<BanqueEntity, Long>{
	
	@Query(value = "SELECT b.soldeAnterieur, MAX(b.id) FROM BanqueEntity")
	Object[] findLastSolde();

}
