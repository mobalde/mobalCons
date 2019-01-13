/**
 * 
 */
package mobalDev.logic.venduInBanque.mapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mobalDev.logic.SourceDestinationMapper;
import mobalDev.logic.banque.dto.BanqueDto;
import mobalDev.logic.banque.mapper.BanqueMapper;
import mobalDev.logic.vendu.dto.VenduDto;
import mobalDev.logic.vendu.mapper.VenduMapper;
import mobalDev.logic.venduInBanque.dto.VenduInBanqueDto;
import mobalDev.model.venduInBanque.VenduInBanqueEntity;
import mobalDev.repo.venduInBanqueRepo.VenduInBanqueRepository;

/**
 * @author balde
 *
 */
@Component
public class VenduInBanqueMapper implements SourceDestinationMapper<VenduInBanqueEntity, VenduInBanqueDto> {
	
	@Autowired
	private ModelMapper modelMaper;
	
	@Inject
	private BanqueMapper banqueMapper;
	
	@Inject
	private VenduMapper venduMapper;
	
	@Inject
	private VenduInBanqueRepository venduInBaRepo;

	@Override
	public VenduInBanqueDto convertEntityToDto(VenduInBanqueEntity entity) {
		
		VenduInBanqueDto dto = new VenduInBanqueDto();
		
		dto.setBanqueDto(entity.getBanque() != null ? this.banqueMapper.convertEntityToDto(entity.getBanque()) : null);
		dto.setDebutSemaine(entity.getDebutSemaine());
		dto.setFinSemaine(entity.getFinSemaine());
		dto.setDepotBanque(entity.isDepotBanque());
		dto.setId(entity.getId());
		
		List<VenduDto> listes = entity.getVenduEntity().stream()
									 .filter(x -> x != null)
									 .map(x -> {
										 VenduDto vDto = this.venduMapper.convertEntityToDto(x);
										 return vDto;
									 }).collect(Collectors.toList());
		dto.setVenduDto(listes);
		dto.setTotalVente(entity.getVenduEntity().stream().filter(x -> x!=null).mapToDouble(x -> x.getTotal()).sum());
		return dto;
	}

	@Override
	public VenduInBanqueEntity convertDtoToEntity(VenduInBanqueDto dto) {
		Optional<VenduInBanqueEntity> entity = this.venduInBaRepo.findById(dto.getId());
		VenduInBanqueEntity v;
		if(entity.isPresent()){
			v = entity.get();
			v.setDepotBanque(dto.isDepotBanque());
		}else{
			v = null;
		}
		return v;
	}

}
