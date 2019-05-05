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
import mobalDev.model.banque.BanqueEntity;
import mobalDev.model.banque.MotifEnum;
import mobalDev.model.commande.CommandeEntity;
import mobalDev.model.produit.LibelleProduitEnum;
import mobalDev.model.produit.MarqueProduitEnum;
import mobalDev.model.produit.ProduitEntity;
import mobalDev.repo.HistoriqueProduitRepo.HistoriqueProduitRepository;
import mobalDev.repo.banqueRepo.BanqueRepository;
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
	
	@Inject
	BanqueRepository banqueRepo;

	@Override
	public boolean registration(ProduitDto dto) {
		boolean result = false;
		if(dto.getType() != null) {
			BanqueEntity banqueEntity = new BanqueEntity();
			CommandeEntity commandeEntity = new CommandeEntity();
			ProduitEntity entity = this.produitRepo.findType(dto.getType());
			ProduitEntity produitEntity = this.produitMapper.convertDtoToEntity(dto);
			if(entity != null) {
				// ----- Create commande
				initCommande(dto,commandeEntity);
				entity.setQuantiteCommande(dto.getQuantiteCommande() + entity.getQuantiteCommande());
				this.produitRepo.save(entity); // update 
				commandeEntity.setProduit(entity);
				result = true;
			} else {
				// ----- init commande
				initCommande(dto,commandeEntity);
				// new produit
				this.produitRepo.saveAndFlush(produitEntity);
				commandeEntity.setProduit(produitEntity);
				result = true;
			}
			this.initBanque(banqueEntity, dto); // create commande & banque
			banqueEntity.setCommande(commandeEntity);
			this.banqueRepo.saveAndFlush(banqueEntity);
			this.histoRepo.saveAndFlush(this.produitMapper.setHistoEntity(produitEntity)); // save produit in table historique
		}
		return result;
	}
	
	private void initCommande(ProduitDto dto, CommandeEntity commandeEntity) {
		
		commandeEntity.setDateAchat(dto.getDateAchat());
		commandeEntity.setMontant(dto.getMontant());
		commandeEntity.setQuantite(dto.getQuantiteCommande());
		
	}
	
	private void initBanque(BanqueEntity entity, ProduitDto dto) {
		
		entity.setAgence("Kipé");
		entity.setDateOperation(dto.getDateAchat());
		entity.setMotif(MotifEnum.ACHAT_MARCHANDISE);
		entity.setNumeroTicket("N/A");
		entity.setSoldeAnterieur(0.0);
		entity.setSomme(0.0);
		entity.setTotal(dto.getMontant());
		entity.setVirement(true);
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
		ProduitEntity entity = this.produitRepo.findType(type);
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
