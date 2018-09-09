package mobalDev.repo.banqueRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import mobalDev.model.BanqueEntity;

public interface BanqueRepository extends JpaRepository<BanqueEntity, Long>{

}
