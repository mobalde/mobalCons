package mobalDev.logic.banque.mapper;

import org.springframework.stereotype.Component;

import mobalDev.logic.SourceDestinationMapper;
import mobalDev.logic.banque.dto.BanqueDto;
import mobalDev.model.BanqueEntity;

@Component
public class BanqueMapper implements SourceDestinationMapper<BanqueEntity,BanqueDto>{

	@Override
	public BanqueDto convertEntityToDto(BanqueEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BanqueEntity convertDtoToEntity(BanqueDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
