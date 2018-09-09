package mobalDev.logic.banque.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mobalDev.logic.banque.GestionBanque;
import mobalDev.logic.banque.dto.BanqueDto;
import mobalDev.logic.banque.mapper.BanqueMapper;
import mobalDev.model.BanqueEntity;
import mobalDev.repo.banqueRepo.BanqueRepository;

@Repository
@Transactional
@Component
public class BanqueImpl implements GestionBanque{
	
	@Inject
	private BanqueMapper banqueMapper;
	
	@Inject
	private BanqueRepository banqueRepo;

	@Override
	public void registration(BanqueDto dto) {
		
		BanqueEntity entity = this.banqueMapper.convertDtoToEntity(dto);
		entity.setId(null);
		this.banqueRepo.saveAndFlush(entity);
	}

}
