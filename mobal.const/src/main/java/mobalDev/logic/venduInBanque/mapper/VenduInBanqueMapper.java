/**
 * 
 */
package mobalDev.logic.venduInBanque.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mobalDev.logic.SourceDestinationMapper;
import mobalDev.logic.venduInBanque.dto.VenduInBanqueDto;
import mobalDev.model.VenduInBanqueEntity;

/**
 * @author balde
 *
 */
@Component
public class VenduInBanqueMapper implements SourceDestinationMapper<VenduInBanqueEntity, VenduInBanqueDto> {
	
	@Autowired
	private ModelMapper modelMaper;

	@Override
	public VenduInBanqueDto convertEntityToDto(VenduInBanqueEntity entity) {
		return this.modelMaper.map(entity, VenduInBanqueDto.class);
	}

	@Override
	public VenduInBanqueEntity convertDtoToEntity(VenduInBanqueDto dto) {
		return this.modelMaper.map(dto, VenduInBanqueEntity.class);
	}

}
