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
		VenduDto dto = new VenduDto();
		dto.setdateVente(entity.getDateVente());
		dto.setIdProduit(entity.getProduit().getId());
		dto.setPrixUnitaire(entity.getPrixUnitaire());
		dto.setQuantite(entity.getQuantite());
		dto.setTotal(entity.getTotal());
		return dto;
	}

	@Override
	public VenduEntity convertDtoToEntity(VenduDto dto) {
		return this.modelMaper.map(dto, VenduEntity.class);
	}

}
