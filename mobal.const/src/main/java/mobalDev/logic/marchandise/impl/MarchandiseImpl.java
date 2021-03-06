package mobalDev.logic.marchandise.impl;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mobalDev.logic.marchandise.GestionMarchandise;
import mobalDev.logic.marchandise.dto.MarchandiseDto;
import mobalDev.logic.marchandise.mapper.MarchandisMapper;
import mobalDev.model.marchandise.MarchandiseEntity;
import mobalDev.model.produit.ProduitEntity;
import mobalDev.model.vendu.VenduEntity;
import mobalDev.repo.marchadiseRepo.MarchandiseRepository;
import mobalDev.repo.produitRepo.ProduitRepository;
import mobalDev.repo.venduRepo.VenduRepository;

@Repository
@Transactional
@Component
public class MarchandiseImpl implements GestionMarchandise{
	
	@Inject
	MarchandiseRepository marchandiseRepo;
	
	@Inject
	private MarchandisMapper marchandiseMapper;
	
	@Inject
	private ProduitRepository produitRepo;
	
	@Inject
	private VenduRepository venduRepo;

	@Override
	public MarchandiseDto registration(MarchandiseDto dto) {
		
		MarchandiseEntity marchandiseEntity = this.marchandiseMapper.convertDtoToEntity(dto);
		marchandiseEntity.setId(null);
		Optional<ProduitEntity> produitEntity = this.produitRepo.findById(dto.getProduitDto().getId());
		marchandiseEntity.setProduit(produitEntity.isPresent() ? produitEntity.get() : null);
		this.marchandiseRepo.saveAndFlush(marchandiseEntity);
		if(marchandiseEntity.getId() != null) {
			List<VenduEntity> vendu = this.venduRepo.findByProduit(marchandiseEntity.getProduit().getId());
			vendu.stream().filter(x->x!=null).forEach(x->{
				x.setComptabiliser(true);
				this.venduRepo.saveAndFlush(x);
				// Update quantite_commande in table produit
				if(produitEntity.isPresent()) {
					produitEntity.get().setQuantiteCommande(dto.getTotalSacRestant());
					this.produitRepo.saveAndFlush(produitEntity.get());
				}
			});
		}
		return new MarchandiseDto();
	}

	@Override
	public MarchandiseDto getLastMarchandise() {
		
		MarchandiseDto dto = new MarchandiseDto();
		MarchandiseEntity marchandiseEntity = this.marchandiseRepo.findLastMarchandise();
		if(marchandiseEntity != null){
			dto = this.marchandiseMapper.convertEntityToDto(marchandiseEntity);
		}
		return dto;
	}
	
	@Override
	public void nombreDeSacVendu(MarchandiseDto dto, Long id) {
		
		Integer total = this.venduRepo.calculNombreDeSacVendu(id);
		dto.setNbSacVendu(total != null ? total.intValue() : 0);
	}
}
