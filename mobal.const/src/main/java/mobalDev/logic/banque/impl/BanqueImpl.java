package mobalDev.logic.banque.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mobalDev.logic.banque.GestionBanque;
import mobalDev.logic.banque.dto.BanqueDto;
import mobalDev.logic.banque.mapper.BanqueMapper;
import mobalDev.logic.venduInBanque.dto.VenduInBanqueDto;
import mobalDev.logic.venduInBanque.mapper.VenduInBanqueMapper;
import mobalDev.model.banque.BanqueEntity;
import mobalDev.model.banque.MotifEnum;
import mobalDev.model.venduInBanque.VenduInBanqueEntity;
import mobalDev.repo.banqueRepo.BanqueRepository;
import mobalDev.repo.venduInBanqueRepo.VenduInBanqueRepository;

@Repository
@Transactional
@Component
public class BanqueImpl implements GestionBanque{
	
	@Inject
	private BanqueMapper banqueMapper;
	
	@Inject
	private BanqueRepository banqueRepo;
	
	@Inject 
	private VenduInBanqueRepository venduInBanqRepo;
	
	@Inject
	private VenduInBanqueMapper venduInBMapper;

	@Override
	public boolean registration(VenduInBanqueDto dto) {
		BanqueDto banqueDto = dto.getBanqueDto();
		boolean result = false;
		BanqueEntity entity = this.banqueMapper.convertDtoToEntity(banqueDto);
		if(entity != null) {
			entity.setId(null);
			if(MotifEnum.VENTE_MARCHANDISE.equals(banqueDto.getMotif())) {
				VenduInBanqueEntity v = this.venduInBMapper.convertDtoToEntity(dto);
				entity.setDepot(dto.isDepotBanque());
				entity.setVenduInBanque(v);
				this.venduInBanqRepo.save(v);
			} else {
				entity.setSoldeAnterieur(0.0);
				if(entity.getTotal() == null) entity.setTotal(entity.getSomme());
			}
			this.banqueRepo.saveAndFlush(entity);
			if(entity.getId() != null) result = true;
		}
		return result;
	}

	@Override
	public Double getSoldeAnterieur(Long id) {
		return this.banqueMapper.getSoldeAnterieur(this.banqueRepo.findLastSolde(id));
	}

}
