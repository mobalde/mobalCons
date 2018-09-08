package mobalDev.logic.produit.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mobalDev.logic.SourceDestinationMapper;
import mobalDev.logic.produit.dto.ProduitDto;
import mobalDev.model.ProduitEntity;

@Component
public class ProduitMapper implements SourceDestinationMapper<ProduitEntity, ProduitDto>{
	
	@Autowired
	private ModelMapper modelMaper;

	@Override
	public ProduitDto convertEntityToDto(ProduitEntity entity) {
		return this.modelMaper.map(entity, ProduitDto.class);
	}

	@Override
	public ProduitEntity convertDtoToEntity(ProduitDto dto) {
		return this.modelMaper.map(dto, ProduitEntity.class);
	}

}
