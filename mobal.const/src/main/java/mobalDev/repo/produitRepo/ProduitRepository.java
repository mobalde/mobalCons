package mobalDev.repo.produitRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import mobalDev.model.ProduitEntity;

public interface ProduitRepository extends JpaRepository<ProduitEntity, Long>{

	ProduitEntity findByLibelle(String libelle);
	
}
