package mobalDev.logic.banque.impl;

import java.util.Optional;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mobalDev.logic.banque.GestionBanque;
import mobalDev.logic.banque.mapper.BanqueMapper;
import mobalDev.logic.venduInBanque.dto.VenduInBanqueDto;
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

	@Override
	public void registration(VenduInBanqueDto dto) {
		
		BanqueEntity entity = this.banqueMapper.convertDtoToEntity(dto.getBanqueDto());
		entity.setId(null);
		Optional<VenduInBanqueEntity> venduInBanqEntity = this.venduInBanqRepo.findById(dto.getId());
		entity.setVenduInBanque(venduInBanqEntity.isPresent() ? venduInBanqEntity.get() : null);
		this.banqueRepo.saveAndFlush(entity);
	}

	@Override
	public Double getSoldeAnterieur() {
		return this.banqueMapper.getSoldeAnterieur(this.banqueRepo.findLastSolde());
	}

}
