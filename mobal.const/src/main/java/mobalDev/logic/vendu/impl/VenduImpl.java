package mobalDev.logic.vendu.impl;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mobalDev.logic.vendu.GestionVente;
import mobalDev.logic.vendu.dto.VenduDto;
import mobalDev.logic.vendu.mapper.VenduMapper;
import mobalDev.model.ProduitEntity;
import mobalDev.model.VenduEntity;
import mobalDev.model.VenduInBanqueEntity;
import mobalDev.repo.produitRepo.ProduitRepository;
import mobalDev.repo.venduInBanqueRepo.VenduInBanqueRepository;
import mobalDev.repo.venduRepo.VenduRepository;

@Repository
@Transactional
@Component
public class VenduImpl implements GestionVente{

	@Inject
	VenduRepository venduRepo;
	
	@Inject
	VenduMapper venduMapper;
	
	@Inject
	VenduInBanqueRepository venduInBaRepo;
	
	@Inject
	ProduitRepository produitRepo;;
	
	
	@Override
	public boolean registration(List<VenduDto> list) {
		
		boolean result = false;
		if(list != null && !list.isEmpty()){
			VenduInBanqueEntity venduInB = new VenduInBanqueEntity();
			venduInB.setDepotBanque(false);
			venduInB.setDebutSemaine(list.get(0).getdateVente());
			venduInB.setFinSemaine(list.get(list.size()-1).getdateVente());
			venduInBaRepo.saveAndFlush(venduInB);
			for(VenduDto venduDto : list) {
				Optional<ProduitEntity> produitEnt = this.produitRepo.findById(venduDto.getIdProduit());
				if(produitEnt.isPresent()) {
					VenduEntity venduE = venduMapper.convertDtoToEntity(venduDto);
					venduE.setId(null);
					venduE.setVenduInBanque(venduInB);
					venduE.setProduit(produitEnt.get());
					venduRepo.saveAndFlush(venduE);
					result = true;
				}
			}
		}
		return result;
	}

}
