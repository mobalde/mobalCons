package mobalDev.logic.marchandise.impl;

import java.util.Optional;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mobalDev.logic.marchandise.GestionMarchandise;
import mobalDev.logic.marchandise.dto.MarchandiseDto;
import mobalDev.logic.marchandise.mapper.MarchandisMapper;
import mobalDev.model.MarchandiseEntity;
import mobalDev.model.ProduitEntity;
import mobalDev.repo.marchadiseRepo.MarchandiseRepository;
import mobalDev.repo.produitRepo.ProduitRepository;

@Repository
@Transactional
@Component
public class MarchandiseImpl implements GestionMarchandise{
	
	@Autowired
	MarchandiseRepository marchandiseRepo;
	
	@Inject
	private MarchandisMapper marchandiseMapper;
	
	@Inject
	private ProduitRepository produitRepo;

	@Override
	public MarchandiseDto registration(MarchandiseDto dto) {
		
		dto.setNbSacAnterieur(dto.getNbSacAnterieur() == 0 ? dto.getNbSacVendu() : dto.getTotalSacVendu());
		MarchandiseEntity marchandiseEntity = this.marchandiseMapper.convertDtoToEntity(dto);
		marchandiseEntity.setId(null);
		Optional<ProduitEntity> produitEntity = this.produitRepo.findById(dto.getIdProduit());
		marchandiseEntity.setProduit(produitEntity.get());
		this.marchandiseRepo.saveAndFlush(marchandiseEntity);
		dto.setNbSacVendu(0);
		return dto;
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
	
	public int getNbSacAnterieur(){
		
		MarchandiseDto marchandiseDto = this.getLastMarchandise();
		return marchandiseDto.getNbSacAnterieur();
	}
}
