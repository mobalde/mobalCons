package mobalDev.repo.utilisateurRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import mobalDev.model.User;

public interface UtilisateurRepository extends JpaRepository<User, Long>{

}
