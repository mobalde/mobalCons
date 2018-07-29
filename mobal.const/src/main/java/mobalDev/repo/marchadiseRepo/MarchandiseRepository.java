package mobalDev.repo.marchadiseRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import mobalDev.model.MarchandiseEntity;

public interface MarchandiseRepository  extends JpaRepository<MarchandiseEntity, Long>{

}
