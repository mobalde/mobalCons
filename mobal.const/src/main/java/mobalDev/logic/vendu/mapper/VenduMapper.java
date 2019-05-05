package mobalDev.logic.vendu.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mobalDev.logic.SourceDestinationMapper;
import mobalDev.logic.produit.mapper.ProduitMapper;
import mobalDev.logic.vendu.dto.VenduDto;
import mobalDev.model.vendu.VenduEntity;

@Component
public class VenduMapper implements SourceDestinationMapper<VenduEntity, VenduDto>{
	
	@Autowired
	private ModelMapper modelMaper;
	
	@Autowired
	private ProduitMapper produitMapper;

	@Override
	public VenduDto convertEntityToDto(VenduEntity entity) {
		VenduDto dto = new VenduDto();
		dto.setDateVente(entity.getDateVente());
		dto.setProduit(this.produitMapper.convertEntityToDto(entity.getProduit()));
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
