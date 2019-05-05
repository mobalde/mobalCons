package mobalDev.logic.utilisateur.mapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mobalDev.logic.SourceDestinationMapper;
import mobalDev.logic.utilisateur.Dao.UtilisateurDao;
import mobalDev.logic.utilisateur.dto.UtilisateurDto;
import mobalDev.model.utilisateur.Role;
import mobalDev.model.utilisateur.User;
import mobalDev.repo.roleRepo.RoleRepository;

@Component
public class UtilisateurMapper implements SourceDestinationMapper<User, UtilisateurDto>{
	
	@Autowired
	private ModelMapper modelMaper;

	@Override
	public UtilisateurDto convertEntityToDto(User entity) {
		UtilisateurDto dto = modelMaper.map(entity, UtilisateurDto.class);
		dto.setEmail(null);
		dto.setPassword(null);
		return dto;
	}

	@Override
	public User convertDtoToEntity(UtilisateurDto dto) {
		return null;
	}
	
}
