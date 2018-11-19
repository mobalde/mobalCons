/**
 * 
 */
package mobalDev.logic.produit.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import mobalDev.logic.produit.GestionProduit;
import mobalDev.logic.produit.dto.ProduitDto;
import mobalDev.logic.produit.mapper.ProduitMapper;
import mobalDev.model.ProduitEntity;
import mobalDev.repo.HistoriqueProduitRepo.HistoriqueProduitRepository;
import mobalDev.repo.produitRepo.ProduitRepository;

/**
 * @author balde
 *
 */
@Component
public class ProduitImpl implements GestionProduit{
	
	@Inject
	private ProduitRepository produitRepo;
	
	@Inject
	ProduitMapper produitMapper;
	
	@Inject
	private HistoriqueProduitRepository histoRepo;

	@Override
	public void registration(ProduitDto dto) {
		
		ProduitEntity entity = this.produitRepo.findByLibelle(dto.getLibelle());
		if(entity != null) {
			// update si dto.quantite != entity.quantite
			if(entity.getQuantiteCommande() != dto.getQuantiteCommande()) {
				this.histoRepo.saveAndFlush(this.produitMapper.setHistoEntity(entity)); // save produit in table historique
				entity.setQuantiteCommande(dto.getQuantiteCommande());
				this.produitRepo.saveAndFlush(entity);
			}
		} else {
			// new produit
			ProduitEntity produitEntity = this.produitMapper.convertDtoToEntity(dto);
			produitEntity.setId(null);
			this.produitRepo.saveAndFlush(entity);
		}
	}

	@Override
	public int getQuantiteCommande(String libelle) {
		ProduitDto produitDto = this.getProduit(libelle);
		return produitDto.getQuantiteCommande();
	}

	@Override
	public ProduitDto getProduit(String libelle) {
		ProduitDto produitDto = new ProduitDto();
		ProduitEntity produitEntity = this.produitRepo.findByLibelle(libelle);
		if(produitEntity != null){
			produitDto = this.produitMapper.convertEntityToDto(produitEntity);
		}
		return produitDto;
	}

	@Override
	public List<ProduitDto> getAllProduit() {
		
		List<ProduitEntity> listProduit = this.produitRepo.findAll();
		List<ProduitDto> listP = listProduit.stream().map(x -> {
			ProduitDto produitDto = this.produitMapper.convertEntityToDto(x);
			return produitDto;
		}).collect(Collectors.toList());
		
		return listP;
	}

}
