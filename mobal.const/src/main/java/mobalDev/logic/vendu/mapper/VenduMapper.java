package mobalDev.logic.vendu.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mobalDev.logic.SourceDestinationMapper;
import mobalDev.logic.vendu.dto.VenduDto;
import mobalDev.model.VenduEntity;

@Component
public class VenduMapper implements SourceDestinationMapper<VenduEntity, VenduDto>{
	
	@Autowired
	private ModelMapper modelMaper;

	@Override
	public VenduDto convertEntityToDto(VenduEntity entity) {
		return this.modelMaper.map(entity, VenduDto.class);
	}

	@Override
	public VenduEntity convertDtoToEntity(VenduDto dto) {
		return this.modelMaper.map(dto, VenduEntity.class);
	}

}
