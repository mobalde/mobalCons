package mobalDev.repo.commandeRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import mobalDev.model.commande.CommandeEntity;

public interface CommandeRepository extends JpaRepository<CommandeEntity, Long>{

}
