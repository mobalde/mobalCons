package mobalDev.logic.utilisateur.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import mobalDev.logic.SourceDestinationMapper;
import mobalDev.logic.utilisateur.dto.UtilisateurDto;
import mobalDev.model.RoleUtilisateurEnum;
import mobalDev.model.User;

@Component
public class UtilisateurMapper implements SourceDestinationMapper<User, UtilisateurDto>{

	@Override
	public UtilisateurDto convertEntityToDto(User entity, UtilisateurDto dto) {
		
		List<RoleUtilisateurEnum> roles = new ArrayList<>();
		dto.setEmail(entity.getEmail());
		dto.setNom(entity.getNom());
		dto.setPassword(null);
		dto.setPrenom(entity.getPrenom());
		entity.getRole().stream()
						.map(x->x.getRole())
						.forEach(roles::add);
		dto.setRole(roles);
		return dto;
	}

	@Override
	public User convertDtoToEntity(UtilisateurDto dto, User entity) {
		return null;
	}

}
