/**
 * 
 */
package mobalDev.logic.produit.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import mobalDev.logic.produit.GestionProduit;
import mobalDev.logic.produit.dto.ProduitDto;
import mobalDev.logic.produit.mapper.ProduitMapper;
import mobalDev.model.ProduitEntity;
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

	@SuppressWarnings("hiding")
	@Override
	public <Object> void registration(Object dto) {
		
		ProduitDto produitDto = (ProduitDto) dto;
		ProduitEntity produitEntity = this.produitMapper.convertDtoToEntity(produitDto);
		produitEntity.setId(null);
		this.produitRepo.saveAndFlush(produitEntity);
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

}
