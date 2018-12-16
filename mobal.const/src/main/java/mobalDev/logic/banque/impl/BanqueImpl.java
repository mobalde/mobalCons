package mobalDev.logic.banque.impl;

import java.util.Optional;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mobalDev.logic.banque.GestionBanque;
import mobalDev.logic.banque.mapper.BanqueMapper;
import mobalDev.logic.venduInBanque.dto.VenduInBanqueDto;
import mobalDev.logic.venduInBanque.mapper.VenduInBanqueMapper;
import mobalDev.model.BanqueEntity;
import mobalDev.model.VenduInBanqueEntity;
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
		
		BanqueEntity entity = this.banqueMapper.convertDtoToEntity(dto.getBanqueDto());
		entity.setDepot(dto.isDepotBanque());
		entity.setId(null);
		VenduInBanqueEntity v = this.venduInBMapper.convertDtoToEntity(dto);
		entity.setVenduInBanque(v);
		this.venduInBanqRepo.save(v);
		this.banqueRepo.saveAndFlush(entity);
		if(entity.getId() != null) return true;
		else return false;
	}

	@Override
	public Double getSoldeAnterieur(Long id) {
		return this.banqueMapper.getSoldeAnterieur(this.banqueRepo.findLastSolde(id));
	}

}
