package mobalDev.repo.roleRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import mobalDev.model.utilisateur.Role;
import mobalDev.model.utilisateur.RoleUtilisateurEnum;

public interface RoleRepository extends JpaRepository<Role, Long>{

	Role findByRole(RoleUtilisateurEnum role);
}
