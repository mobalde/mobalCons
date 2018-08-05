package mobalDev.logic.utilisateur.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mobalDev.logic.SourceDestinationMapper;
import mobalDev.logic.utilisateur.dto.UtilisateurDto;
import mobalDev.model.User;

@Component
public class UtilisateurMapper implements SourceDestinationMapper<User, UtilisateurDto>{
	
	@Autowired
	private ModelMapper modelMaper;

	@Override
	public UtilisateurDto convertEntityToDto(User entity) {
		UtilisateurDto dto = modelMaper.map(entity, UtilisateurDto.class);
		dto.setEmail(null);
		return dto;
	}

	@Override
	public User convertDtoToEntity(UtilisateurDto dto) {
		return null;
	}

}
