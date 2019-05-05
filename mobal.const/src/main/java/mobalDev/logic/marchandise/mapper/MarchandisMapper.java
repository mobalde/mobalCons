package mobalDev.logic.marchandise.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mobalDev.logic.SourceDestinationMapper;
import mobalDev.logic.marchandise.dto.MarchandiseDto;
import mobalDev.model.marchandise.MarchandiseEntity;

@Component
public class MarchandisMapper implements SourceDestinationMapper<MarchandiseEntity, MarchandiseDto>{
	
	@Autowired
	private ModelMapper modelMaper;

	@Override
	public MarchandiseDto convertEntityToDto(MarchandiseEntity entity) {
		return this.modelMaper.map(entity, MarchandiseDto.class);
	}

	@Override
	public MarchandiseEntity convertDtoToEntity(MarchandiseDto dto) {
		return this.modelMaper.map(dto, MarchandiseEntity.class);
	}

}
