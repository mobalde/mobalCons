package mobalDev.repo.marchadiseRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import mobalDev.model.marchandise.MarchandiseEntity;

@Transactional
public interface MarchandiseRepository extends JpaRepository<MarchandiseEntity, Long>{
	
	@Query(value = "SELECT m from MarchandiseEntity m where m.id = (SELECT max(m.id) from MarchandiseEntity m)")
	MarchandiseEntity findLastMarchandise();

}
