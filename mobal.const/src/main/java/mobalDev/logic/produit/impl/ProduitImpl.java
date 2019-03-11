/**
 * 
 */
package mobalDev.logic.produit.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import mobalDev.logic.produit.GestionProduit;
import mobalDev.logic.produit.dto.ProduitDto;
import mobalDev.logic.produit.mapper.ProduitMapper;
import mobalDev.model.produit.LibelleProduitEnum;
import mobalDev.model.produit.MarqueProduitEnum;
import mobalDev.model.produit.ProduitEntity;
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
	
//	private LibelleProduitEnum libelleProduitEnum;
//	
//	private MarqueProduitEnum marqueProduitEnum;

	@Override
	public boolean registration(ProduitDto dto) {
		boolean result = false;
		if(dto.getType() != null) {
			ProduitEntity entity = this.produitRepo.findByType(dto.getType());
			ProduitEntity produitEntity = this.produitMapper.convertDtoToEntity(dto);
			if(entity != null) {
				entity.setQuantiteCommande(dto.getQuantiteCommande() + entity.getQuantiteCommande());
				this.produitRepo.saveAndFlush(entity);
				result = true;
			} else {
				// new produit
				this.produitRepo.saveAndFlush(produitEntity);
				result = true;
			}
			this.histoRepo.saveAndFlush(this.produitMapper.setHistoEntity(produitEntity)); // save produit in table historique
		}
		return result;
	}

	@Override
	public int getQuantiteCommande(String libelle) {
		List<ProduitDto> produitDto = this.getProduit(libelle);
		int quantite = 0;
		if(produitDto != null && !produitDto.isEmpty()) {
			quantite = produitDto.stream().mapToInt(x -> x.getQuantiteCommande()).sum();
		}
		return quantite;
	}

	@Override
	public List<ProduitDto> getProduit(String libelle) {
		List<ProduitDto> dto = new ArrayList<>();
		List<ProduitEntity> produitEntity = this.produitRepo.findByLibelle(libelle);
		if(produitEntity != null){
			dto = produitEntity.stream().filter(x->x!=null)
							   .map(x->{
								  return this.produitMapper.convertEntityToDto(x);
							   }).collect(Collectors.toList());
		}
		return dto;
	}
	
	@Override
	public List<ProduitDto> getAllProduit() {
		
		List<ProduitDto> listP = new ArrayList<>();
		List<ProduitEntity> listProduit = this.produitRepo.findAll();
		if(listProduit != null) {
			listP = listProduit.stream().map(x -> {
				return this.produitMapper.convertEntityToDto(x);
			}).collect(Collectors.toList());
		}
		return listP;
	}

	@Override
	public ProduitDto getProduit(MarqueProduitEnum type) {
		ProduitEntity entity = this.produitRepo.findByType(type);
		ProduitDto dto = new ProduitDto();
		if(entity != null) {
			dto = this.produitMapper.convertEntityToDto(entity);
		}
		return dto;
	}

	@Override
	public int getQuantiteCommande(MarqueProduitEnum type) {
		ProduitDto dto = this.getProduit(type);
		return dto != null ? dto.getQuantiteCommande() : 0;
	}

	@Override
	public List<String> getLibelleAll() {
		
		return LibelleProduitEnum.getLibelles();
	}

	@Override
	public List<String> getMarqueAll() {
		
		return MarqueProduitEnum.getLibelles();
	}

}
