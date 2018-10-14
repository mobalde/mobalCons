package mobalDev.logic.banque.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mobalDev.logic.SourceDestinationMapper;
import mobalDev.logic.banque.dto.BanqueDto;
import mobalDev.model.BanqueEntity;

@Component
public class BanqueMapper implements SourceDestinationMapper<BanqueEntity,BanqueDto>{
	
	@Autowired
	private ModelMapper modelMaper;

	@Override
	public BanqueDto convertEntityToDto(BanqueEntity entity) {
		return this.modelMaper.map(entity, BanqueDto.class);
	}

	@Override
	public BanqueEntity convertDtoToEntity(BanqueDto dto) {
		return this.modelMaper.map(dto, BanqueEntity.class);
	}
	
	public Double getSoldeAnterieur(Double solde){
		return solde != null ? solde : 0;
	}

}
