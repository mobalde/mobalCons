package mobalDev.logic.banque.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mobalDev.logic.banque.GestionBanque;
import mobalDev.logic.banque.mapper.BanqueMapper;
import mobalDev.logic.venduInBanque.dto.VenduInBanqueDto;
import mobalDev.logic.venduInBanque.mapper.VenduInBanqueMapper;
import mobalDev.model.banque.BanqueEntity;
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
		
		boolean result = false;
		BanqueEntity entity = this.banqueMapper.convertDtoToEntity(dto.getBanqueDto());
		if(entity != null) {
			entity.setDepot(dto.isDepotBanque());
			entity.setId(null);
			VenduInBanqueEntity v = this.venduInBMapper.convertDtoToEntity(dto);
			entity.setVenduInBanque(v);
			this.venduInBanqRepo.save(v);
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
