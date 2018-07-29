package mobalDev.repo.utilisateurRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mobalDev.model.User;

public interface UtilisateurRepository extends JpaRepository<User, Long>{

	User findByEmail(String email);
	
	User findByEmailAndPassword(String email, String password);
}
