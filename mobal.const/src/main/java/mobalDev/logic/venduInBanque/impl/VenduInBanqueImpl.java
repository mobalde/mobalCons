/**
 * 
 */
package mobalDev.logic.venduInBanque.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mobalDev.logic.venduInBanque.GestionVenduInBanque;
import mobalDev.logic.venduInBanque.dto.VenduInBanqueDto;
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
	public List<VenduInBanqueDto> listeDeVenteProduitNonDeposer(String libelleProduit) {
		
		List<VenduInBanqueEntity> listVenduInBanque = this.venduInBanqueRepo.findAllNotVenduInBanqueForProduit(libelleProduit);
		List<VenduInBanqueDto> listVenduDto = listVenduInBanque.stream()
												.map(m -> {
													return this.venduInBanqueMapper.convertEntityToDto(m);
												})
												.collect(Collectors.toList());
		
		return listVenduDto;
	}

}
