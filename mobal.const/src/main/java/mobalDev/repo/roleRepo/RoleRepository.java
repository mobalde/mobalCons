package mobalDev.repo.roleRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import mobalDev.model.Role;
import mobalDev.model.RoleUtilisateurEnum;

public interface RoleRepository extends JpaRepository<Role, Long>{

	Role findByRole(RoleUtilisateurEnum role);
}
