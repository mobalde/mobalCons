/**
 * 
 */
package mobalDev.logic.venduInBanque.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mobalDev.logic.venduInBanque.GestionVenduInBanque;
import mobalDev.logic.venduInBanque.mapper.VenduInBanqueMapper;
import mobalDev.model.VenduInBanqueEntity;
import mobalDev.repo.venduInBanqueRepo.VenduInBanqueRepository;

/**
 * @author balde
 *
 */
@Repository
@Transactional
@Component
public class VenduInBanqueImpl implements GestionVenduInBanque{
	
	@Inject
	private VenduInBanqueRepository venduInBanqueRepo;
	
	@Inject
	private VenduInBanqueMapper venduInBanqueMapper;
	
	
	@Override
	public <T> void registration(T a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<VenduInBanqueEntity> listeDeVenteProduitNonDeposer(String libelleProduit) {
		
		
		return null;
	}

}